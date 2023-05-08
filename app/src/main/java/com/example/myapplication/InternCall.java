package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class InternCall extends AppCompatActivity {
    public static final String EXTRA_REPLY="prefix";
    private Button button;
    private boolean checked=false;
    private String prefix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intern_call);
        button= (Button)findViewById(R.id.select);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntern(view);
            }
        });
    }
    public void openIntern(View v){
        if (checked) {
// Create an intent
            Intent replyIntent = new Intent();
// Put the data to return into the extra
            replyIntent.putExtra(EXTRA_REPLY, prefix);
// Set the activity's result to RESULT_OK
            setResult(RESULT_OK, replyIntent);
// Finish the current activity
            finish();

        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "Select a Prefix to Continue";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void Prefix(View v) {
        checked = ((RadioButton) v).isChecked();
        Log.i("","checked: "+ checked);
        prefix= String.valueOf(((RadioButton) v).getText());
        Log.i("checked: ",""+ prefix);


    }
    public void openWeb(View v){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/List_of_international_call_prefixes"));
        startActivity(browserIntent);
    }
}