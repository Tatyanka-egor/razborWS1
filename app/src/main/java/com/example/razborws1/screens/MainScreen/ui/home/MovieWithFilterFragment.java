package com.example.razborws1.screens.MainScreen.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.razborws1.R;
import com.example.razborws1.databinding.FragmentMovieWithFilterBinding;


public class MovieWithFilterFragment extends Fragment {

private String filter;
public MovieWithFilterFragment(String filter){
    this.filter=filter;
}

FragmentMovieWithFilterBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentMovieWithFilterBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }
}