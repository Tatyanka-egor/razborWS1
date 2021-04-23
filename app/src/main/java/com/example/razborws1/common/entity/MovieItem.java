package com.example.razborws1.common.entity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MovieItem {
    public final static String MOVIE_ID="movieId";
    public final static String POSTER="poster";
    public final static String NAME="name";
    public String movieId;
    public String poster;
    public String name;
    public MovieItem(JSONObject movieJson) throws JSONException{
        movieId=movieJson.getString(MOVIE_ID);
        poster=movieJson.getString(POSTER);
        name=movieJson.getString(NAME);
    }

}
