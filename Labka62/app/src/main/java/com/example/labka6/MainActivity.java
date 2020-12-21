package com.example.labka6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v) {
        Intent service =new Intent(this, MyService.class);
        if (v.getId()==R.id.start) {
            text = (TextView) findViewById(R.id.textView);
            text.setText("service start");
            startService(service);
        }
        else {
            text = (TextView) findViewById(R.id.textView);
            text.setText("service stop");
            stopService(service);
        }
    }
}
