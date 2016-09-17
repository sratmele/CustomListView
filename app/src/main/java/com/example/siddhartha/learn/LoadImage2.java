package com.example.siddhartha.learn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class LoadImage2 extends AppCompatActivity {

    NetworkImageView networkImageView;
    ImageLoader imageLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image2);
        networkImageView = (NetworkImageView)findViewById(R.id.nivLoad);
        imageLoader = CustomVolleyRequestQueue.getInstance(getApplicationContext()).getImageLoader();
        networkImageView.setImageUrl("http://i.imgur.com/7spzG.png",imageLoader);
    }
}
