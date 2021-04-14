package com.example.razborws1.common;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.content.Context;
import android.media.Image;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

public class AppData {
    //синглтон для данных и очереди запросов
    private static AppData instance;
    private final RequestManager glide;

    public static AppData getInstance(Context context) {
        if (instance == null)
            instance = new AppData(context.getApplicationContext());
        return instance;
    }


    public RequestQueue queue;// проверь подключение библиотеки
    public AppData(Context context ){
        queue= Volley.newRequestQueue(context);
        glide= Glide.with(context);
    }
    public void loadImage(String url, ImageView imageView)
    {
        glide.load(URLs.IMAGE+url).into(imageView);
    }
}
