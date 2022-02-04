package com.example.personalfoodlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Intro extends AppCompatActivity {
    TextView tv;
    ImageView img;
    Button btn;
//LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        tv=(TextView) findViewById(R.id.textView);
        img=(ImageView) findViewById(R.id.imageView2);
        btn=(Button)findViewById(R.id.button) ;
       // lottie=(LottieAnimationView) findViewById(R.id.abc);

        tv.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
      //  img.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
      //  lottie.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(Intro.this,MainActivity.class);
               startActivity(i);
           }
       });

    }
}