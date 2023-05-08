package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class International extends AppCompatActivity {
    private Button button;
    private Button button2;
    public static final int prefix = 1;
    public static final int number = 2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international);

        TextView prefixText = findViewById(R.id.TextView);

        button= (Button)findViewById(R.id.choose_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefix();
            }
        });
        button2= (Button)findViewById(R.id.choose_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number();
            }
        });
    }
    public void compose (View v) {
        EditText edn =(EditText) findViewById(R.id.editTextPhone3);
        TextView prefix= (TextView) findViewById(R.id.TextView);
        Intent intentImplicit=new Intent(Intent.ACTION_DIAL);

        String uri="tel:"+prefix.getText().toString()+edn.getText().toString();
        intentImplicit.setData(Uri.parse(uri));
        startActivity(intentImplicit);
    }
    public void makeCall (View v)
    {
        EditText edn =(EditText)findViewById(R.id.editTextPhone3);
        TextView prefix= (TextView) findViewById(R.id.TextView);
        Intent intentImplicit=new Intent(Intent.ACTION_CALL);
        String uri="tel:"+prefix.getText().toString()+edn.getText().toString();;
        intentImplicit.setData(Uri.parse(uri));
        try {
            startActivity(intentImplicit);
        } catch (SecurityException e) {
            ActivityCompat.requestPermissions(
                    International.this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    1);
        }
        return;
    }

    public void prefix(){
// create the intent
        Intent intent = new Intent(this, InternCall.class);
// start the activity
        startActivityForResult(intent, prefix);
    }

    public void number(){
        // create the intent
        Intent intent = new Intent(this, tell.class);
        // start the activity
        startActivityForResult(intent, number);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == prefix) { // Identify activity
            if (resultCode == RESULT_OK) { // Activity succeeded
                String reply = data.getStringExtra(InternCall.EXTRA_REPLY);// … do something with the data
                ((TextView)findViewById(R.id.TextView)).setText(reply);
            }
        }
        if (requestCode == number) { // Identify activity
            if (resultCode == RESULT_OK) { // Activity succeeded
                String reply = data.getStringExtra(tell.EXTRA_REPLY2);// … do something with the data
                ((EditText)findViewById(R.id.editTextPhone3)).setText(reply);
            }
        }
    }

}