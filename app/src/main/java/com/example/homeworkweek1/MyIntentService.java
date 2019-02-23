package com.example.homeworkweek1;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String message = "Success!";
        intent.setAction(SecondActivity.ACTION_KEY);
        intent.putExtra("Message", message);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
