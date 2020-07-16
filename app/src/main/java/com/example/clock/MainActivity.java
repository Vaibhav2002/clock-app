package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Animation anim;
    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialization
        t1=findViewById(R.id.textClock);
        t2=findViewById(R.id.textApp);
        anim= AnimationUtils.loadAnimation(this,R.anim.fade_anim);
        //initialization
        //setting animation
        t1.setAnimation(anim);
        t2.setAnimation(anim);
        //setting animation
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(MainActivity.this,stopwatch_screen.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}