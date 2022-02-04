package com.example.personalfoodlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Takepicture extends AppCompatActivity {
    Button tkpic,acc,report,logout,unsub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takepicture);
        tkpic=(Button) findViewById(R.id.takepic);
        acc=(Button) findViewById(R.id.Accsetting);
        report=(Button) findViewById(R.id.Report);
        logout=(Button)findViewById(R.id.lo);
        unsub=(Button)findViewById(R.id.unsub);
        unsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Takepicture.this,Intro.class);
                Toast.makeText(getApplicationContext(),"Unsubscription done",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Takepicture.this,Intro.class);
                startActivity(intent);
            }
        });
        tkpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Takepicture.this,Result.class);
                startActivity(i);
            }
        });
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Takepicture.this,Report.class);
                startActivity(in);
            }
        });
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Takepicture.this,Weightandheight.class);
                startActivity(in);
            }
        });

    }
}