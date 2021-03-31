package com.example.razborws1.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.razborws1.common.entity.User;
import com.example.razborws1.databinding.ActivitySignUpBinding;
import com.example.razborws1.screens.LaunchScreen.MainScreen;
import com.example.razborws1.screens.SignUp;

import org.json.JSONException;
import org.json.JSONObject;

public class CheckData {


    public static boolean checkMail(String mail){
        return mail.matches("[a-z0-9]+@[a-z0-9]+.[a-z]{1,3}");//проверка формата записи

    }

    public static void makeMessege(String messege, Context context){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("ошибка");
        builder.setMessage(messege);
        builder.show();
        //сообщение об ошибке

    }
    public static void autoConfirmed(final Activity activity,String login,String pass){
        final JSONObject user=new JSONObject();
        try {
            user.put(User.EMAIL,login);
            user.put(User.PASSWORD,pass);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        // запрос входа
        final JsonObjectRequest logonRequest=new JsonObjectRequest(Request.Method.POST,
                URLs.LOGON,user, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    User.getCurrentUser().setToken(response.getLong("token"));
                    Intent intent = new Intent(activity, MainScreen.class);
                    activity.startActivity(intent);
                    activity.finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                makeMessege(error.getMessage(),activity);
            }
        });

        AppData.getInstance(activity).queue.add(logonRequest);

       // JsonObjectRequest signUpReqest=new JsonObjectRequest(Request.Method.POST, URLs.REGISTER, user,
             //   new Response.Listener<JSONObject>() {
                    //@Override
                  //  public void onResponse(JSONObject response) {

                    //    CheckData.autoConfirmed(SignUp.this
                   //     );
                 //   }
               // })



    }

}
