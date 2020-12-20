package com.example.labka6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v) {
        Intent service =new Intent(this, MyService.class);
        if (v.getId()==R.id.start) {
            startService(service);
        }
        else {
            stopService(service);
        }
    }
}
