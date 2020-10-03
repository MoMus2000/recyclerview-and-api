package com.example.karachinews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Experiment extends AppCompatActivity {
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager  layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerViewAdapter.RecyclerViewClickListener recyclerViewClickListener;
    int arr[]= {R.drawable.ic_launcher_background,R.drawable.mazar_e_quaid,R.drawable.ic_launcher_background,R.drawable.mazar_e_quaid,
            R.drawable.ic_launcher_background,R.drawable.mazar_e_quaid,R.drawable.ic_launcher_background,R.drawable.mazar_e_quaid};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment);
        setOnClickListener();
        recyclerView = findViewById(R.id.Recycler);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(arr,recyclerViewClickListener);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void setOnClickListener() {
        recyclerViewClickListener = new RecyclerViewAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(),"This is image number " +position,Toast.LENGTH_LONG).show();
            }
        };
    }
}