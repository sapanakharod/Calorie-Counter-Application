package com.example.personalfoodlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {
    Button back ;
    EditText username,psw,repsw,email;
    DbHelper Db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        back=(Button) findViewById(R.id.goback);
        username=(EditText)findViewById(R.id.e2);
        psw=(EditText)findViewById(R.id.e3);
        repsw=(EditText) findViewById(R.id.e4);
        email = (EditText) findViewById(R.id.email);

        Db= DbHelper.getInstance(this);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String password=psw.getText().toString();
                String reenterpsw=repsw.getText().toString();
                String emailValue = email.getText().toString();
                if(user.equals("")||password.equals("")||reenterpsw.equals("")||emailValue.equals("")) {
                    Toast.makeText(RegistrationPage.this, "Please enter required details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(password.equals(reenterpsw))
                    {
                        int userid =Db.checkuser(user);
                        Log.d("UserId" , "" + userid);
                        if(userid < 0)
                        {
                            Boolean insert=Db.insertData(emailValue,user,password);
                            if (insert==true)
                            {
                                Toast.makeText(RegistrationPage.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(RegistrationPage.this,MainActivity.class);
                                startActivity(intent);

                            }
                            else
                            {
                                Toast.makeText(RegistrationPage.this, "Registration fail", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(RegistrationPage.this, "User already exist please sign in", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else
                    {
                        Toast.makeText(RegistrationPage.this, "Password Mismactch", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}