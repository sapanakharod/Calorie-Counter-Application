package com.example.personalfoodlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Report extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        list=(ListView) findViewById(R.id.listsearch);
        ArrayList<String>  arrayList=new ArrayList<>();
        arrayList.add("Meal 1: Apple  100gm  100kcl  10 nov 2021 11.49");
        arrayList.add("Meal 2: Soup  100gm  cilantro: 10gm   green onion 10 grm  160kcl 10 nov 2021 20.12");
        arrayList.add("Meal 3: Pizza Pie  1piece  cilantro: 10gm   green onion 10 grm  cheese 20grm  460kcl  11 nov 2021 12:00");
      //  arrayList.add("Meal 4: Apple  100gm  100kcl 12 nov 2021 13:00");
       // arrayList.add("Meal 5: Soup  100gm  cilantro: 10gm   green onion 10 grm  160kcl 13 nov 2021 14:00");
       // arrayList.add("Meal 6: Pizza Pie  1piece  cilantro: 10gm   green onion 10 grm  cheese 20grm  460kcl 14 nov 2021 15:00");


        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent intent=new Intent(Report.this,AppleCalorieReport.class);
                    startActivity(intent);
                }
                else if(position==1)
                {
                    Intent intent=new Intent(Report.this,Soupcalorie.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent(Report.this,Pizza.class);
                    startActivity(intent);

                }
            }
        });


    }
}