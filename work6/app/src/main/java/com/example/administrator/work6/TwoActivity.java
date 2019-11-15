package com.example.administrator.work6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class TwoActivity extends AppCompatActivity {
    String string;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Button button = (Button)findViewById(R.id.button);
        final EditText edittext1 = (EditText)findViewById(R.id.et1);
        final EditText edittext2 = (EditText)findViewById(R.id.et2);
        final EditText edittext3 = (EditText)findViewById(R.id.et3);
        final EditText edittext4 = (EditText)findViewById(R.id.et4);

        final TextView textview1 = (TextView)findViewById(R.id.tv1);
        final TextView textview2 = (TextView)findViewById(R.id.tv2);
        final TextView textview3 = (TextView)findViewById(R.id.tv3);
        final TextView textview4 = (TextView)findViewById(R.id.tv4);
        final String str1 = textview1.getText().toString();
        final String str2 = textview2.getText().toString();
        final String str3 = textview3.getText().toString();
        final String str4 = textview4.getText().toString();

        Intent intent = getIntent();
        Bundle bundles = intent.getExtras();
        string = bundles.getString("string");




        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str5 = edittext1.getText().toString();
                String str6 = edittext2.getText().toString();
                String str7 = edittext3.getText().toString();
                String str8 = edittext4.getText().toString();
                String TotalString = string  +str1+str5+ "\n" +str2+str6+ "\n" +str3+str7+ "\n" +str4+str8 ;

                Intent intent = new Intent();
                intent.setClass(TwoActivity.this, ThreeActivity.class);
                intent.putExtra("string",TotalString);
                startActivity(intent);
            }
        });
    }
}
