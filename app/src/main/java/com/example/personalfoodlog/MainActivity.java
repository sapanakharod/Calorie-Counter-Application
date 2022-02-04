package com.example.personalfoodlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    Button b1,b2;
    EditText user,pass;
    DbHelper Db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView) findViewById(R.id.txt);
        b1=(Button) findViewById(R.id.button2);
        b2=(Button) findViewById(R.id.button3);
        user=(EditText) findViewById(R.id.editTextTextPersonName);
        pass=(EditText) findViewById(R.id.editTextTextPassword);

        Db= DbHelper.getInstance(this);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(MainActivity.this,RegistrationPage.class);
                startActivity(i2);
            }


        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user1=user.getText().toString();
                String psw1=pass.getText().toString();
               if(user.equals("")||pass.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please enter required details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkuserpass=Db.checkusernamepassword(user1,psw1);
                    if(checkuserpass==true)
                    {
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent i3=new Intent(MainActivity.this,Takepicture.class);
                        MainActivity.this.startActivity(i3);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Signin fail", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}