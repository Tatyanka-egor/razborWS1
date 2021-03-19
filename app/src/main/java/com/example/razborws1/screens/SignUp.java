package com.example.razborws1.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.razborws1.R;
import com.example.razborws1.databinding.ActivitySignUpBinding;

public class SignUp extends AppCompatActivity {

    ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
    }
}