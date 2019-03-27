package com.example.salati;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, MainPage.class);


        textIntro = findViewById(R.id.textIntro);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.intro_animaion);
        textIntro.startAnimation(animation);


        Thread myThread = new Thread(){
            public void run() {
                try {
                    sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        myThread.start();
    }
}
