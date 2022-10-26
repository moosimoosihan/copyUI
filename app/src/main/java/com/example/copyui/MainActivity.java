package com.example.copyui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

        HomeFragment homeFragment;
        InfoFragment infoFragment;
        SettingFragment settingFragment;
        adr_Search adr_searchFragment;

        @Nullable
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            homeFragment = new HomeFragment();
            infoFragment = new InfoFragment();
            settingFragment = new SettingFragment();
            adr_searchFragment = new  adr_Search();

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

    }//onCreate

    public void onFragmentChange(int index){
        if(index == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.containers,adr_searchFragment).commit();
        } else if (index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.containers,homeFragment).commit();
        }
    }
}