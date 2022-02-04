package com.example.personalfoodlog;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Meal extends AppCompatActivity {

    TextView t1,t2,t3;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        String selectedImage = this.getIntent().getStringExtra("selectedImage");
        String mealName = this.getIntent().getStringExtra("mealName");
        Log.d("selectedImage" , selectedImage);
        Uri imageUri = Uri.parse(selectedImage);
        t1=(TextView) findViewById(R.id.textView5);
        t2=(TextView) findViewById(R.id.textweight);
        t3=(TextView) findViewById(R.id.textcalorie);
        iv=(ImageView) findViewById(R.id.mealitem);
        iv.setImageURI(imageUri);
        DbHelper dbHelper=DbHelper.getInstance(this.getApplicationContext());
        MealModel mealModel = dbHelper.fetchdata(mealName);
        t1.setText("Meal: " + mealModel.getMeal());
        t2.setText("Weight(gm): " + String.valueOf(mealModel.getWeight()));
        t3.setText("Calorie(kcl): " +String.valueOf(mealModel.getCalorie()));
    }
}