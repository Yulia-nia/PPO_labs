package com.example.labka4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ListView myList;
    ArrayList<String> things = new ArrayList<String>();
    ArrayList<String> someList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        Collections.addAll(things, "Шоколад", "Набор конфет", "Съедобные открытки", "Халва", "Желе", "Карамель", "Попкорн", "Зефир");

        myList = (ListView) findViewById(R.id.mylist);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, things);
        myList.setAdapter(adapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int item, long id)
            {
                String user = adapter.getItem(item);
                if(myList.isItemChecked(item))
                    someList.add(user);
                else
                    someList.remove(user);
            }
        });
    }
    
    public void remove_item(View view){
        for(int item = 0; item < someList.size(); item++){
            adapter.remove(someList.get(item));
        }
        myList.clearChoices();
        someList.clear();
        adapter.notifyDataSetChanged();
    }

    public void add_item(View view){
        EditText title = (EditText) findViewById(R.id.myname);
        String user = title.getText().toString();
        if(!user.isEmpty()){
            adapter.add(user);
            title.setText("");
            adapter.notifyDataSetChanged();
        }
    }
}