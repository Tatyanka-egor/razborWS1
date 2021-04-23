package com.example.razborws1.screens.MainScreen.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.razborws1.R;
import com.example.razborws1.common.AppData;
import com.example.razborws1.common.CheckData;
import com.example.razborws1.common.URLs;
import com.example.razborws1.databinding.FragmentHomeBinding;

import org.json.JSONException;
import org.json.JSONObject;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    FragmentHomeBinding fragmentHomeBinding;
    AppData appData;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fragmentHomeBinding=FragmentHomeBinding.inflate(inflater,container,false);
        return fragmentHomeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appData=AppData.getInstance(getContext());
        loadCoverInfo();

    }



    private void initTabsMovie(){
        //нет прокрутке за юзера
        fragmentHomeBinding.moviePager.setUserInputEnable(false);//где чертов метод
        //устанавливаем адаптер
        fragmentHomeBinding.moviePager.setAdapter(new FragmentMovieAdapter(this));
        //настраиваем отображения вкладок
        new TabLayoutMediator(fragmentHomeBinding.movieTabs,fragmentHomeBinding.moviePager,(int position) {//что происходит
            String flag;
            switch(position){
                case 0;
                flag="Новое";
                break;
                case 1;
                    flag="В тренде";
                    break;
                default 2;
                    flag="Для вас";

            }
        })
    }



    String coverId=null;

    private void loadCoverInfo() {
        fragmentHomeBinding.withCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//можно обьяснение?
                CheckData.openMovie(getActivity(),coverId);
            }
        });
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(URLs.COVER, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String backgroundImage = response.getString("backgroundImage");
                    String foregroundImage = response.getString("backgroundImage");
                    coverId = response.getString("movieId");

                    appData.loadImage(backgroundImage,fragmentHomeBinding.coverBackImage);
                    appData.loadImage(foregroundImage,fragmentHomeBinding.coverFrontImage);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //подгрузка изображения



            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }


    });
    }

    private class FragmentMovieAdapter extends FragmentStateAdapter {
        public FragmentMovieAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            String filter;
            switch (position){
                case 0:
                    filter="new";
                    break;
                case 1:
                    filter="inTrend";
                    break;
                default:
                    filter="forMe";
            }
            return new MovieWithFilterFragment(filter);
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}