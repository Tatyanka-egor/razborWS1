package com.example.razborws1.common;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppData {
    //синглтон для данных и очереди запросов
    private static AppData instance;

    public static AppData getInstance(Context context) {
        if (instance == null)
            instance = new AppData(context.getApplicationContext());
        return instance;
    }


    public RequestQueue queue;// проверь подключение библиотеки
    public AppData(Context context ){
        queue= Volley.newRequestQueue(context);


    }
}
