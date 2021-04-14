package com.example.razborws1.screens.LaunchScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.razborws1.R;
import com.example.razborws1.screens.SignIn;
import com.example.razborws1.screens.SignUp;

public class launch_screen extends AppCompatActivity {
Intent intent;
//здесь происходит запуск приложения
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);

        SharedPreferences sharedPreferences=getSharedPreferences("Loaded", Context.MODE_PRIVATE);

        boolean firstLoaded=sharedPreferences.getBoolean("firstLoaded",true);
        if(firstLoaded){
            SharedPreferences.Editor e=sharedPreferences.edit();
            e.putBoolean("Loaded",false);
            e.apply();
            intent=new Intent(launch_screen.this,SignUp.class);
        }
        else intent=new Intent(launch_screen.this,SignIn.class);




        new Handler().postAtTime(new Runnable(){
            @Override
            public void run()
            {
               // Intent intent=new Intent(launch_screen.this, SignIn.class);
                startActivity(intent);
                finish();
            }


            }, 2000);
        }
        //переход с задержкой заставка на рабочий экран порядок появления меняем в манифесте
}

