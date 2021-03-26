package com.example.razborws1.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.razborws1.R;
import com.example.razborws1.common.CheckData;
import com.example.razborws1.databinding.ActivitySignInBinding;

public class SignIn extends AppCompatActivity {

    ActivitySignInBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }

    public void SignInBut(View view) {
        if(
                !binding.emailView.getText().toString().equals("")&&
                        !binding.PassView.getText().toString().equals("")
        ){
            if(CheckData.checkMail(binding.emailView.getText().toString())){
                CheckData.autoConfirmed(SignIn.this, binding.emailView.getText().toString(),
                        binding.PassView.getText().toString());
            }
            else {CheckData.makeMessege("неправильная почта",this);
            }
        }
        else {
            CheckData.makeMessege("неправильный пароль",this);
        }
    }

    public void GoSignUp(View view) {
        Intent signUp=new Intent(SignIn.this,SignUp.class);
        startActivity(signUp);
        finish();
    }
}