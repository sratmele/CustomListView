package com.example.siddhartha.learn;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class LoadImage extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);
        imageView = (ImageView)findViewById(R.id.ivLoad);
        String url = "http://i.imgur.com/7spzG.png";
        RequestQueue requestQueue = Volley.newRequestQueue(LoadImage.this);
        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        imageView.setImageBitmap(response);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("=======>", error.toString());
                        Toast.makeText(LoadImage.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        requestQueue.add(request);
    }
}
