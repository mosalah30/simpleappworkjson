package com.mosalah.simpleappworkjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<model> models = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


    }


    public void parse(View view) {
        String url = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=6ba7df004b6846989b72984297bd7e70";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray xc = object.getJSONArray("articles");

                    for (int i = 0; i < xc.length(); i++) {
                        JSONObject gg = xc.getJSONObject(i);
                        String title = gg.getString("title");
                        String des = gg.getString("description");
                        String time = gg.getString("publishedAt");
                        String url = gg.getString("url");
                        String img = gg.getString("urlToImage");
                        model m = new model(title, time, des, img, url);
                        models.add(m);
                        adapter = new recyclerviewclass(models);
                        recyclerView.setAdapter(adapter);
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "please make sure internet is available", Toast.LENGTH_SHORT).show();
                    }
                });
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);

    }

}




