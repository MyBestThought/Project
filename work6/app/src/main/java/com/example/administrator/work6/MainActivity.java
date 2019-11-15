package com.example.administrator.work6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= (Button)findViewById(R.id.button);
        final EditText edittext1 = (EditText)findViewById(R.id.et1);
        final EditText edittext2 = (EditText)findViewById(R.id.et2);
        final TextView textview1 = (TextView)findViewById(R.id.tv1);
        final TextView textview2 = (TextView)findViewById(R.id.tv2);
        button.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                String str1 = edittext1.getText().toString();
                String str2 = edittext2.getText().toString();
                String str3 = textview1.getText().toString();
                String str4 = textview2.getText().toString();
                String TotalString = str3+str1 +"\n"+ str4+str2+"\n";
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, TwoActivity.class);
                intent.putExtra("string",TotalString);
                startActivity(intent);
            }
        });
    }
}

