package com.example.karachinews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    TextView text;
    Button dos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text =findViewById(R.id.uno);
        dos = findViewById(R.id.dos);
        getWeatherData();
        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Experiment.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void getWeatherData(){
        String url = "http://api.openweathermap.org/data/2.5/weather?q=islamabad,pakistan&appid=7bc4e550ef1ecb0543e1cda9ab83073e";
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject jo = response.getJSONObject("main");
                    JSONArray jr = response.getJSONArray("weather");
                    JSONObject object = jr.getJSONObject(0);

//                    JSONObject name = response.getJSONObject("name");
                    Log.d("TAG", object.toString());
//                    Log.d("TAG@",name.toString());
                    String city = response.getString("name");
                    String description = object.getString("description");
                    Log.d("DESC",city);
                    text.setText(city);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
             });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);
    }
}