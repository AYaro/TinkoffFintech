package com.example.homeworkweek1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static int CONFIRMATION_REQUEST_CODE = 1;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
    }

    @Override
    protected void  onStart(){
        super.onStart();
        Intent i = new Intent(this, SecondActivity.class);
        startActivityForResult(i, CONFIRMATION_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (data == null) {return;}
        String message = data.getStringExtra("Message");
        tv.setText("Message from app2 is: " + message);
    }
}
