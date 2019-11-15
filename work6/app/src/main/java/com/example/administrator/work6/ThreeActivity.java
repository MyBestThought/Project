package com.example.administrator.work6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/10/31 0031.
 */

public class ThreeActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        TextView textview = (TextView)findViewById(R.id.tv) ;
        Button button = (Button)findViewById(R.id.button);

        Intent intent = getIntent();
        Bundle bundles = intent.getExtras();
        final String string = bundles.getString("string");
        textview.setText(string);



        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent("com.example.administrator.work6");
                intent.putExtra("message",string);
                sendBroadcast(intent);
            }
        });
    }

}

