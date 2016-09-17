package com.example.siddhartha.learn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView)findViewById(R.id.customList);
        List<Map<String, String>> table = new ArrayList<>();
        Map<String, String> row;
        String titles[] = "Learning by trying CustomViews using SimpleAdapter class".split(" ");
        int imgId[] = {R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.g};
        for (int i=0;i<titles.length;i++) {
            row = new HashMap<>();
            row.put("heading", titles[i]);
            row.put("image", String.valueOf(imgId[i]));
            row.put("description", "This text here is a description of the image or something about" +
                    " what's written in the heading.\nIt an also contains line-breaks.");
            table.add(i,row);
        }
        String from[] = {"heading", "image", "description"};
        int to[] = {R.id.tvHeading, R.id.ivImage, R.id.tvDescription};
        CustomAdapter customAdapter = new CustomAdapter(this, table, R.id.customcard, from, to);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent a = new Intent(MainActivity.this,LoadImage.class);
                startActivity(a);
            }
        });
    }
}
