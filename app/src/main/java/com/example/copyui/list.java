package com.example.copyui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class list extends AppCompatActivity {

    private ImageButton btn_homerd;
    private ImageButton btn_my;
    private ListView list1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list1 = (ListView)findViewById(R.id.list1);
        List<String> data = new ArrayList<>();
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_2,data);
        list1.setAdapter(adapter1);

        btn_homerd = findViewById(R.id.btn_homerd);
        btn_homerd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(list.this, MainActivity.class);
                startActivity(intent); // 액티비티 이동.
                overridePendingTransition(0, 0);
            }
        });

        btn_my = findViewById(R.id.btn_my);
        btn_my.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(list.this, mypage.class);
                startActivity(intent); // 액티비티 이동.
                overridePendingTransition(0, 0);
            }
        });

    }
}