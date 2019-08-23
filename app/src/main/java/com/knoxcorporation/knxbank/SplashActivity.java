package com.knoxcorporation.knxbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
private ImageView logo;
private TextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo = findViewById(R.id.knxLogo);
        welcome = findViewById(R.id.welcomeMessage);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_transition);
        logo.startAnimation(animation);
        welcome.startAnimation(animation);
        final Intent toLogin = new Intent(getApplicationContext(), RegisterActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(toLogin);
                    finish();
                }
            }
        };
        timer.start();
    }
}
