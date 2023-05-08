package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class call extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

    }
    public void compose (View v)
    {
        EditText edn =(EditText) findViewById(R.id.editTextPhone);
        Intent intentImplicit=new Intent(Intent.ACTION_DIAL);
        String uri="tel:"+edn.getText().toString();
        intentImplicit.setData(Uri.parse(uri));
        startActivity(intentImplicit);
    }
    public void makeCall (View v)
    {
        EditText edn =(EditText)findViewById(R.id.editTextPhone);
        Intent intentImplicit=new Intent(Intent.ACTION_CALL);
        String uri="tel:"+edn.getText().toString();;
        intentImplicit.setData(Uri.parse(uri));
        try {
            startActivity(intentImplicit);
        } catch (SecurityException e) {
            ActivityCompat.requestPermissions(
                    call.this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    1);
        }
        return;
    }
}