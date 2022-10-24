package com.example.copyui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

//    private Button btn_searchbar;
//    private ImageButton btn_my;
//    private ImageButton btn_list;

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
//
//        btn_searchbar = findViewById(R.id.btn_searchbar);
//        btn_searchbar.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent intent = new Intent(MainActivity.this, search.class);
//                startActivity(intent); // 액티비티 이동.
//                overridePendingTransition(0, 0);
//            }
//        });
//
//        btn_my = findViewById(R.id.btn_my);
//        btn_my.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent intent = new Intent(MainActivity.this, mypage.class);
//                startActivity(intent); // 액티비티 이동.
//                overridePendingTransition(0, 0);
//            }
//        });
//
//        btn_list = findViewById(R.id.btn_list);
//        btn_list.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent intent = new Intent(MainActivity.this, list.class);
//                startActivity(intent); // 액티비티 이동.
//                overridePendingTransition(0, 0);
//            }
//        });
//
//    }