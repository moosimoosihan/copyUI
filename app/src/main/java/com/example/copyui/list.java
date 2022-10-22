package com.example.copyui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class list extends AppCompatActivity {

    private ImageButton btn_homerd;
    private ImageButton btn_my;
    private ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = (ListView)findViewById(R.id.list);
        List<String> data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);

        data.add("무시무시한스무디");
        data.add("홍드로이드");
        data.add("안드로이드");
        data.add("맥");
        data.add("사과");
        adapter.notifyDataSetChanged();

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