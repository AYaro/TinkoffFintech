package com.example.homeworkweek1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    MyReceiver myReceiver;
    public static final String ACTION_KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    private void setMyReceiver(){
        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_KEY);

        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onStart(){
        setMyReceiver();

        Intent i = new Intent(this, MyIntentService.class);
        startService(i);

        super.onStart();
    }

    public void ResultMessage(String Message){
        Intent i = new Intent();
        i.putExtra("Message", Message);
        setResult(RESULT_OK, i);
        finish();
    }

    @Override
    protected void onStop(){
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver);
        super.onStop();
    }

    private class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
           String message = intent.getStringExtra("Message");
           ResultMessage(message);
        }
    }
}
