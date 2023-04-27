package com.nlc.basicrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> data = new ArrayList<>();
        RecyclerView basicRv = findViewById(R.id.basicRv);
        FloatingActionButton rvManager = findViewById(R.id.rvManager);
        Adapter adapter = new Adapter(data,this);

        rvManager.setOnClickListener(v -> {
            if(data.isEmpty()){
                data.add("1");
                adapter.notifyItemInserted(0);
            }else{
                data.add(String.valueOf(data.size()+1));
                adapter.notifyItemInserted(data.size()-1);
            }
        });

        basicRv.setAdapter(adapter);
    }
}