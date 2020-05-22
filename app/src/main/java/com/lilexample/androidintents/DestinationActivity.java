package com.lilexample.androidintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.net.URL;

public class DestinationActivity extends AppCompatActivity {
    URL url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        TextView values = (TextView) findViewById(R.id.txtValues);

        // TODO: extract any data passed by the caller
//        Intent intent = getIntent();
//        String name = intent.getStringExtra(MainActivity.NAME_EXTRA);
//        int rollno = intent.getIntExtra(MainActivity.ROLL_NO, -1);
//        values.setText(name + "\n" + rollno) ;

        Uri data = getIntent().getData();
        Log.d("mytag", data.toString());
//        url = new URL(data.getScheme(), data.getHost(), data.getPath());
    }
}
