package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private EditText ed, ed1, ed2, ed3;
    private RadioButton rb1, rb2;
    private TextView tv, tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8;
    private Button bt;
    private boolean x = false;
    private  String sec_name, name, pat, age, sex;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        ed = (EditText) findViewById((R.id.editTextTextPersonName));
        ed1 = (EditText) findViewById((R.id.editTextTextPersonName2));
        ed2 = (EditText) findViewById((R.id.editTextTextPersonName3));
        ed3 = (EditText) findViewById((R.id.editTextTextPersonName4));
        rb1 = (RadioButton) findViewById((R.id.radioButton3));
        rb2 = (RadioButton) findViewById((R.id.radioButton));
        tv = (TextView) findViewById((R.id.textView));
        tv1 = (TextView) findViewById((R.id.textView2));
        tv2 = (TextView) findViewById((R.id.textView3));
        tv3 = (TextView) findViewById((R.id.textView4));
        tv4 = (TextView) findViewById((R.id.textView5));
        tv5 = (TextView) findViewById((R.id.textView6));
        tv6 = (TextView) findViewById((R.id.textView7));
        tv7 = (TextView) findViewById((R.id.textView8));
        tv8 = (TextView) findViewById((R.id.textView9));
        bt = (Button) findViewById((R.id.button));

        rb1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                x = true;
                rb2.setVisibility(View.INVISIBLE);
            }

        });

        rb2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                x = false;
                rb1.setVisibility(View.INVISIBLE);
            }

        });

        bt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sec_name = ed.getText().toString();
                name = ed1.getText().toString();
                pat = ed2.getText().toString();
                age = ed3.getText().toString();
                if(x == true)
                {
                    sex = "Женский";
                }
                else
                {
                    sex = "Мужской";
                }
                ed.setVisibility(View.INVISIBLE);
                ed1.setVisibility(View.INVISIBLE);
                ed2.setVisibility(View.INVISIBLE);
                ed3.setVisibility(View.INVISIBLE);
                rb1.setVisibility(View.INVISIBLE);
                rb2.setVisibility(View.INVISIBLE);
                tv.setVisibility(View.INVISIBLE);
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                bt.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.VISIBLE);
                tv6.setVisibility(View.VISIBLE);
                tv7.setVisibility(View.VISIBLE);
                tv8.setVisibility(View.VISIBLE);
                tv5.setText("Добро пожаловать " + sec_name + " " + name + " " + pat);
                tv6.setText("Особенности:");
                tv7.setText("Ваш пол: " + sex);
                tv8.setText("Ваш возраст: " + age);
            }

        });


    }
}