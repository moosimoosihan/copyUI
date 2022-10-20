package com.example.copyui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class mypage extends AppCompatActivity {

    private ImageButton btn_homerd;
    private ImageButton btn_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        btn_homerd = findViewById(R.id.btn_homerd);
        btn_homerd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(mypage.this, MainActivity.class);
                startActivity(intent); // 액티비티 이동.
                overridePendingTransition(0, 0);
            }
        });

        btn_list = findViewById(R.id.btn_list);
        btn_list.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(mypage.this, list.class);
                startActivity(intent); // 액티비티 이동.
                overridePendingTransition(0, 0);
            }
        });
    }
}