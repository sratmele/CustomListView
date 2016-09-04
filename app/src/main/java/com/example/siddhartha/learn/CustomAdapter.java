package com.example.siddhartha.learn;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomAdapter extends SimpleAdapter {

    Activity context;
    List<? extends Map<String, String>> table;
    Map<String, String> row;

    public CustomAdapter(Activity context, List<? extends Map<String, String>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
        this.table = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.customcard, null, true);

        row = table.get(position);

        TextView tHeading = (TextView)rowView.findViewById(R.id.tvHeading);
        tHeading.setText(String.valueOf(row.get("heading")));

        ImageView imageView = (ImageView)rowView.findViewById(R.id.ivImage);
        imageView.setImageResource(Integer.parseInt(String.valueOf(row.get("image"))));

        TextView tDescription = (TextView)rowView.findViewById(R.id.tvDescription);
        tDescription.setText(String.valueOf(row.get("description")));

        return rowView;
    }
}
