package com.example.razborws1.screens.MainScreen.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.razborws1.R;
import com.example.razborws1.common.AppData;
import com.example.razborws1.common.URLs;
import com.example.razborws1.common.entity.MovieItem;
import com.example.razborws1.databinding.FragmentMovieWithFilterBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MovieWithFilterFragment extends Fragment {


private String filter;
public MovieWithFilterFragment(String filter){
    this.filter=filter;
}

FragmentMovieWithFilterBinding binding;

AppData appData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentMovieWithFilterBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPosters();
        appData=AppData.getInstance(getContext());
    }

    private void initPosters() {
        JsonArrayRequest arrayRequest=new JsonArrayRequest(URLs.MOVIE_WITH_FILTER+filter,
                new Response.Listener<JSONArray>(){
            public void onResponse(JSONArray response){
                initMovies(response);
            }
                },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppData.getInstance(getContext()).queue .add(arrayRequest);

    }
    List<MovieItem>movieItems=new ArrayList<>();
    private void initMovies(JSONArray response){
        for (int i=0;i<response.length();i++){
            try {
                movieItems.add(new MovieItem(JSONObject)response.get(i));
            }
            catch (JSONException e){e.printStackTrace();
            }
        }
        binding.moviesView.setAdapter(new PosterAdapter);
    }

    private class PosterAdapter extends RecyclerView.Adapter<PosterAdapter.ViewHolder> {
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ItemMoviePosterBinding itemMoviePosterBinding;
            public ViewHolder(@NonNull View itemView) {
                super(itemMoviePosterBinding.getRoot());
                this.itemMoviePosterBinding=itemMoviePosterBinding;
            }
        }
    }
}


