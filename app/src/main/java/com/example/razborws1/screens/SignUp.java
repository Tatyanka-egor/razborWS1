package com.example.razborws1.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.razborws1.common.CheckData;
import com.example.razborws1.common.URLs;
import com.example.razborws1.common.entity.User;
import com.example.razborws1.databinding.ActivitySignUpBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class SignUp extends AppCompatActivity {

    ActivitySignUpBinding binding;//придумывать ничего ненадо подключи библиотеку buildFeatures


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }




    public void SignUp(View view) {//событие клика на кнопку зарегистрироваться
        if(
                !binding.NameView.getText().toString().equals("")&&//проверяем поля на заполненость
            !binding.SecondnView.getText().toString().equals("")&&
                !binding.EmailView.getText().toString().equals("")&&
                !binding.wordView.getText().toString().equals("")
        )

        {
            if(CheckData.checkMail(binding.EmailView.getText().toString()))
            {
                if(binding.wordView.getText().toString().equals(binding.passduoView.getText().toString())){
                    JSONObject user =new JSONObject();
                    JsonObjectRequest signUpRequest=new JsonObjectRequest(Request.Method.POST, URLs.REGISTER, user, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            CheckData.autoConfirmed(SignUp.this,binding.EmailView.getText().toString(),
                                    binding.wordView.getText().toString());

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            if(Objects.requireNonNull(error.getMessage()).contains("успешная")){
                                CheckData.autoConfirmed(SignUp.this,
                                        binding.EmailView.getText().toString(),
                                        binding.wordView.getText().toString());

                            }
                            else
                            CheckData.makeMessege("проблема регистрации",SignUp.this);
                        }
                    }
                    );
                    try {
                        user.put(User.EMAIL,binding.EmailView.getText().toString());
                        user.put(User.PASSWORD,binding.wordView.getText().toString());
                        user.put(User.FIRST_NAME,binding.NameView.getText().toString());
                        user.put(User.LAST_NAME,binding.SecondnView.getText().toString());

                    }catch (JSONException e)
                    {
                        e.printStackTrace();
                    }

                }
                else {
                    CheckData.makeMessege("пароли не совпадают",this);
                }
            }
            else {
                CheckData.makeMessege("маил не совпадает",this);
            }


        }
        else {
            CheckData.makeMessege("Есть пустые поля",this);
        }

    }

    ;
    public void CanSign(View view) {
        Intent Signin=new Intent(SignUp.this,SignIn.class);
        startActivity(Signin);
        finish();
    }
}