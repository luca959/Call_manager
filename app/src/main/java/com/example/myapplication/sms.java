package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class sms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
    }
    public void sendSms (View v)
    {
        EditText edn =(EditText) findViewById(R.id.editTextPhone2);
        EditText edn2 =(EditText) findViewById(R.id.message);

        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms",edn.getText().toString(),null));
        intent.putExtra("sms_body",edn2.getText().toString());
        startActivity(intent);
    }
}