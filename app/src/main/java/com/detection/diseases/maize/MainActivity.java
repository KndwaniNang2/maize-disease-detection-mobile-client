package com.detection.diseases.maize;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.io.OptionalDataException;

public class MainActivity extends AppCompatActivity {
private static final int PERMISSION_CODE = 10000;
    ImageView image;
    ImageView capture;
Integer REQUEST_CAMERA=1, SELECT_FILE=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        image = findViewById(R.id.galler);
        capture = findViewById(R.id.cap);
        capture.setOnClickListener(new View.OnClickListener() {
            private OptionalDataException grantResults;

            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_DENIED ||
                            checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                                    == PackageManager.PERMISSION_DENIED){
                        String [] permission = {Manifest.permission.CAMERA,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE};
                       requestPermissions(permission, PERMISSION_CODE);

                    };
                }else {
                    openCamera();
                }
            }

            private void openCamera() {
            }

            @Override
            public int hashCode() {
                return super.hashCode();


            }

            public void onRequestPermissionsResult(int requestCode, @NonNull String[] permission) {

            }
        });
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

}