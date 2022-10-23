package com.example.copyui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class search extends AppCompatActivity {
    private Button btn_back;
    private Button btn_clear;
    private EditText et_adr;
    private ListView list;
    private Button btn_search_adr;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        list = (ListView)findViewById(R.id.list);
        List<String> data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);

        data.add("무시무시한스무디");
        data.add("홍드로이드");
        data.add("안드로이드");
        data.add("맥");
        data.add("사과");
        adapter.notifyDataSetChanged();

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent1 = new Intent(search.this,MainActivity.class);
                startActivity(intent1); // 액티비티 이동.
                overridePendingTransition(0, 0);
            }
        });

        et_adr = findViewById(R.id.et_adr);
        btn_clear = findViewById(R.id.btn_clear);

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_adr.setText("");
            }
        });

        btn_search_adr = findViewById(R.id.btn_search_adr);
        btn_search_adr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = et_adr.getText().toString();
                data.add(str);
                adapter.notifyDataSetChanged();
                et_adr.setText("");
            }
        });

    }
}

