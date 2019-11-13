package com.example.administrator.searchcontact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private ISearchContact mService;
    private static Handler handler = new Handler();
    public static void UpdateGUI(String text)
    {
        displayText = text;
        handler.post(RefreshLable);
    }

    //更新UI
    private static Runnable RefreshLable = new Runnable()
    {
        @Override
        public void run()
        {
            label.setText(displayText);
        }
    };
    private ServiceConnection mConnection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            mService = ISearchContact.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            mService = null;
        }
    };
    //查询电话
    private Runnable backgroundWork = new Runnable()
    {
        @Override
        public void run()
        {

            name = edit.getText().toString();

            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS)
                    != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            }
            else
            {

                MyContact mc = null;
                try
                {
                    mc = mService.SearchContact(name);
                } catch (RemoteException e)
                {
                    e.printStackTrace();
                }
                String text = "姓名 ：" + mc.Name + "\n"
                        +"电话 ：" + mc.Phone;


                MainActivity.UpdateGUI(text);

            }
        }
    };

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        switch (requestCode)
        {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    MyContact mc = null;
                    try
                    {
                        mc = mService.SearchContact(name);
                    } catch (RemoteException e)
                    {
                        e.printStackTrace();
                    }
                    String text = "姓名 ：" + mc.Name + "\n"
                            +"电话 ：" + mc.Phone;


                    MainActivity.UpdateGUI(text);

                } else
                {
                    Toast.makeText(this, "权限请求失败", Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                break;
        }

    }

    private EditText edit;
    private Button button;
    private static TextView label;
    private Thread thread;
    private String name;
    private static String displayText;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText) findViewById(R.id.edit);
        button = (Button)findViewById(R.id.button);
        label = (TextView) findViewById(R.id.label);

        final Intent serviceIntent = new Intent(MainActivity.this , MyService.class);
        serviceIntent.setAction("com.example.myapplication.MyService");
        bindService(serviceIntent , mConnection , Context.BIND_AUTO_CREATE);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                thread = new Thread(null , backgroundWork , "BackGroundWork");
                thread.start();
            }
        });

    }
}
