package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate");

        setContentView(R.layout.activity_main);
        button= (Button)findViewById(R.id.make_call);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCall();
            }
        });
        button2= (Button)findViewById(R.id.sms);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSms();
            }
        });
        button3= (Button)findViewById(R.id.intcall);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInternationalCall();
            }
        });
    }
    // Class name for Log tag.

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }
    @Override
    protected void onPause() {
        super.onPause();
    //    try {
       //     Thread.sleep(10000);
       // } catch (InterruptedException e) {
        //    throw new RuntimeException(e);
       // }
        Log.d(LOG_TAG, "onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    public void openCall(){
        Intent intent= new Intent(this,call.class);
        startActivity(intent);
    }
    public void openSms(){
        Intent intent= new Intent(this,sms.class);
        startActivity(intent);
    }

    public void openInternationalCall(){
        Intent intent= new Intent(this, International.class);
        startActivity(intent);
    }


}