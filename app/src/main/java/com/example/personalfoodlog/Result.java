package com.example.personalfoodlog;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.HashMap;

public class Result extends AppCompatActivity {
    Button click,save,see,Logout;
    Bitmap bitmap;
    ImageView img;
    HashMap<Integer,Integer> calorieMap = new HashMap<>();
    HashMap<Integer,Integer> weightMap = new HashMap<>();
    Uri selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        calorieMap.put(1,100);
        calorieMap.put(2,250);
        calorieMap.put(3,300);
        weightMap.put(1,110);
        weightMap.put(2,200);
        weightMap.put(3,350);
        click=(Button) findViewById(R.id.click);
       // save=(Button) findViewById(R.id.save);
        see=(Button) findViewById(R.id.view);
        Logout=(Button) findViewById(R.id.share);
        img=(ImageView)findViewById(R.id.imageView) ;
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,3);


            }
        });


        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Result.this,Intro.class);
                startActivity(intent);
            }
        });

        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Result.this,Meal.class);
                Log.d("ResultselectedImage",selectedImage.toString());
                intent.putExtra("selectedImage",selectedImage.toString());
                intent.putExtra("mealName","Apple");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    if (resultCode==RESULT_OK && data!=null)
    {
       selectedImage=data.getData();
        img.setImageURI(selectedImage);
        DbHelper dbHelper = DbHelper.getInstance(this.getApplicationContext());
        dbHelper.insertcalorie(1,calorieMap.get(1),weightMap.get(1),"Apple");
    }


    }
}