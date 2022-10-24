package com.example.copyui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

        HomeFragment homeFragment;
        InfoFragment infoFragment;
        SettingFragment settingFragment;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            homeFragment = new HomeFragment();
            infoFragment = new InfoFragment();
            settingFragment = new SettingFragment();

            getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFragment).commit();

            NavigationBarView navigationBarView = findViewById(R.id.bottom_navigationview);
            navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch(item.getItemId()){
                        case R.id.home:
                            getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFragment).commit();
                            return true;
                        case R.id.setting:
                            getSupportFragmentManager().beginTransaction().replace(R.id.containers, settingFragment).commit();
                            return true;
                        case R.id.info:
                            getSupportFragmentManager().beginTransaction().replace(R.id.containers, infoFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}