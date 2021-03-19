package com.example.razborws1.screens.LaunchScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.razborws1.R;
import com.example.razborws1.screens.SignIn;
import com.example.razborws1.screens.SignUp;

public class launch_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);



        new Handler().postAtTime(new Runnable(){
            @Override
            public void run(){
                Intent intent=new Intent(launch_screen.this, SignIn.class);
                startActivity(intent);
                finish();}


            }, 2000);
        }
        //переход с задержкой заставка на рабочий экран порядок появления меняем в манифесте



}

