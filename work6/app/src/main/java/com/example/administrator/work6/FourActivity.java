package com.example.administrator.work6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


public class FourActivity extends  BroadcastReceiver{
    public void onReceive(Context context, Intent intent){
        String msg = intent.getStringExtra("message");
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
