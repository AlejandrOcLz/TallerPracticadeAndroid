package com.example.taller1_corte2.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.taller1_corte2.InicioSesionB;
import com.example.taller1_corte2.databinding.ActivityFragmenInicioBinding;
import com.example.taller1_corte2.databinding.FragmentHomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.IOException;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    FloatingActionButton cambiarImg;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        super.onCreate(savedInstanceState);

        InicioSesionB is = (InicioSesionB) getActivity();


        String name = is.name;

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView user = binding.textView;


        user.setText(name);


       // user.setText();

       // final TextView textView = binding.textHome;
       // homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}