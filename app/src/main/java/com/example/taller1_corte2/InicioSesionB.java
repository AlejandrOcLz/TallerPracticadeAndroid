package com.example.taller1_corte2;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.taller1_corte2.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.taller1_corte2.databinding.ActivityInicioSesionBBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InicioSesionB extends AppCompatActivity {

    private ActivityInicioSesionBBinding binding;

    public String name;

    static final int REQUEST_TAKE_PHOTO = 1;
    static final int TAKE_PHOTO = 101;
    static final int REQUEST_PERMISSION_CAMERA= 1;
    String currentPhotoPath;

    FloatingActionButton kj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInicioSesionBBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle dato = getIntent().getExtras();
        name = dato.getString("name");

        dato.putString("name", name );
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(dato);

        SharedPreferences userDetails = getApplicationContext().getSharedPreferences("name", MODE_PRIVATE);
        SharedPreferences.Editor edit = userDetails.edit();
        edit.clear();
        edit.putString("name", name);

        kj = findViewById(R.id.floatingActionButton);

        kj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               checkPermi();
            }
        });

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_inicio_sesion_b);
        navController.navigate(R.id.navigation_home,dato);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == TAKE_PHOTO){
            if(resultCode == Activity.RESULT_OK && data != null){

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_PERMISSION_CAMERA){
            if(permissions.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                takePicture();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void checkPermi() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                takePicture();
            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},REQUEST_PERMISSION_CAMERA);
            }
        }else{
            takePicture();
        }
    }

    private void takePicture(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(intent, TAKE_PHOTO);
        }
    }


}