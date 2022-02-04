package com.example.personalfoodlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Weightandheight extends AppCompatActivity {
    EditText height,weight,f_name,l_name;
    Button navigate, edit;
    RadioGroup Rg;
    RadioButton m,f;
    DbHelper Db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weightandheight);
        f_name=(EditText)findViewById(R.id.Firstname);
        l_name=(EditText)findViewById(R.id.Lastname);
        height=(EditText)findViewById(R.id.editTextHeight);
        weight=(EditText)findViewById(R.id.editTextweight);
        Rg=(RadioGroup)findViewById(R.id.radioSex);
        m=(RadioButton)findViewById(R.id.radioMale);
        f=(RadioButton)findViewById(R.id.radioFemale);
        navigate=(Button) findViewById(R.id.next);
        edit=(Button) findViewById(R.id.editdetails);
        Db=DbHelper.getInstance(this);


        Rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });
       edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String First=f_name.getText().toString();
                String last = l_name.getText().toString();
                int h=Integer.parseInt(height.getText().toString());
                int w=Integer.parseInt(weight.getText().toString());
                String gender = "male";
                int selectedId = Rg.getCheckedRadioButtonId();
                if(selectedId == m.getId())
                    gender = "male";
                else
                    gender = "female";
                int user_id = 10;
                Db.updatedata(user_id,First,last,h,w,gender);
                Intent i =new Intent(Weightandheight.this,Takepicture.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Edited successfully",Toast.LENGTH_LONG).show();
            }
        });

        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String First=f_name.getText().toString();
                String last = l_name.getText().toString();
                int h=Integer.parseInt(height.getText().toString());
                int w=Integer.parseInt(weight.getText().toString());
                String gender = "male";
                int selectedId = Rg.getCheckedRadioButtonId();
                if(selectedId == m.getId())
                    gender = "male";
                else
                    gender = "female";
                int user_id = 10;
                Db.updatedata(user_id,First,last,h,w,gender);
                Intent i =new Intent(Weightandheight.this,Takepicture.class);
                startActivity(i);
            }
        });
    }
}