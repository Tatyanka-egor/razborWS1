package com.example.razborws1.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.razborws1.R;
import com.example.razborws1.common.CheckData;
import com.example.razborws1.databinding.ActivitySignInBinding;
import com.example.razborws1.screens.MainScreen.MainScreen;

public class SignIn extends AppCompatActivity {

    ActivitySignInBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void SignInBut(View view) {
        if(
                !binding.emailView.getText().toString().equals("")&&
                        !binding.PassView.getText().toString().equals("")
        )//первая проверка на маил и пароль
        {
            if(CheckData.checkMail(binding.emailView.getText().toString())){
                CheckData.autoConfirmed(SignIn.this,
                        binding.emailView.getText().toString(),
                        binding.PassView.getText().toString());
            }//если почта правильная
            else {CheckData.makeMessege("неправильная почта",this);
            }
        }
        else {
            CheckData.makeMessege("есть пустые поля",this);
        }
        Intent signIn=new Intent(SignIn.this, MainScreen.class);
        startActivity(signIn);
        finish();

    }

    public void GoSignUp(View view) {
        Intent signUp=new Intent(SignIn.this,SignUp.class);
        startActivity(signUp);
        finish();
    }
}