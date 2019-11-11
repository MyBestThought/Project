package com.example.administrator.hobby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button, reset;
    private EditText name, work;
    private RadioButton male, female, yes, no ;
    private String status;
    //private String hobby;
    private CheckBox football, basketball, bastball, cycling, yumao, pingpang, fishing, traveling, wudao, yingshi, run, swim, dengshan,bicycle, kala;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.submit);//提交按钮
        reset = (Button)findViewById(R.id.reset);
        name = (EditText)findViewById(R.id.name);//获取姓名
        work = (EditText)findViewById(R.id.work);//获取职业

        male = (RadioButton)findViewById(R.id.male);
        female = (RadioButton)findViewById(R.id.female);

        yes = (RadioButton)findViewById(R.id.yes);
        no = (RadioButton)findViewById(R.id.no);

        football = (CheckBox)findViewById(R.id.football);
        basketball = (CheckBox)findViewById(R.id.basketball);
        bastball= (CheckBox)findViewById(R.id.bastball);
        cycling = (CheckBox)findViewById(R.id.cycling);
        yumao = (CheckBox)findViewById(R.id.yumao);
        pingpang = (CheckBox)findViewById(R.id.pingpang);
        fishing = (CheckBox)findViewById(R.id.fishing);
        traveling = (CheckBox)findViewById(R.id.traveling);
        wudao = (CheckBox)findViewById(R.id.wudao) ;
        yingshi= (CheckBox)findViewById(R.id.yingshi);
        run = (CheckBox)findViewById(R.id.run);
        swim = (CheckBox)findViewById(R.id.swim);
        dengshan = (CheckBox)findViewById(R.id.dengshan);
        bicycle = (CheckBox)findViewById(R.id.bicycle);
        kala = (CheckBox)findViewById(R.id.kala);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                //传输姓名和职业
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("work", work.getText().toString());
                //判断当前性别
                if(male.isChecked()){
                    intent.putExtra("sex", male.getText().toString());
                }
                if(female.isChecked()){
                    intent.putExtra("sex", female.getText().toString());
                }
                //判断婚姻状况
                if(yes.isChecked()){
                    status = "已婚";
                    intent.putExtra("status", status);
                }
                if(no.isChecked()){
                    status = "未婚";
                    intent.putExtra("status", status);
                }

                String hobby = "";
                if(football.isChecked()){
                    hobby += football.getText().toString() + " ";
                }
                if(basketball.isChecked()){
                    hobby += basketball.getText().toString() + " ";
                }
                if(bastball.isChecked()){
                    hobby += bastball.getText().toString() + " ";
                }
                if(cycling.isChecked()){
                    hobby += cycling.getText().toString() + " ";
                }
                if(yumao.isChecked()){
                    hobby += football.getText().toString() + " ";
                }
                if(pingpang.isChecked()){
                    hobby += basketball.getText().toString() + " ";
                }
                if(fishing.isChecked()){
                    hobby += bastball.getText().toString() + " ";
                }
                if(traveling.isChecked()){
                    hobby += cycling.getText().toString() + " ";
                }

                if(wudao.isChecked()){
                    hobby += wudao.getText().toString() + " ";
                }
                if(yingshi.isChecked()){
                    hobby += yingshi.getText().toString() + " ";
                }
                if(run.isChecked()){
                    hobby += run.getText().toString() + " ";
                }
                if(swim.isChecked()){
                    hobby += swim.getText().toString() + " ";
                }
                if(dengshan.isChecked()){
                    hobby += dengshan.getText().toString() + " ";
                }
                if(bicycle.isChecked()){
                    hobby += bicycle.getText().toString() + " ";
                }
                if(kala.isChecked()){
                    hobby += kala.getText().toString() + " ";
                }


                intent.putExtra("hobby" , hobby);

                startActivity(intent);
            }

        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(" ");
                work.setText(" ");
                male.setChecked(false);
                female.setChecked(false);
                yes.setChecked(false);
                no.setChecked(false);
                football.setChecked(false);
                basketball.setChecked(false);
                bastball.setChecked(false);
                cycling.setChecked(false);
                yumao.setChecked(false);
                pingpang.setChecked(false);
                fishing.setChecked(false);
                traveling.setChecked(false);
                wudao.setChecked(false);
                yingshi.setChecked(false);
                run.setChecked(false);
                swim.setChecked(false);
                dengshan.setChecked(false);
                bicycle.setChecked(false);
                kala.setChecked(false);
            }
        });
    }
}
