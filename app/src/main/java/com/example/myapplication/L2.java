package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class L2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CustomAdapterR adapter;
    private List<ItemModelR> itemList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l2);

        // Inizializza la lista degli elementi
        itemList = new ArrayList<>();
        itemList.add(new ItemModelR("3459070503", "Godwin Jacob","gjacob@dalet.com",""));
        itemList.add(new ItemModelR("3420503245", "Lorenzo Lamedica","llamedica@dalet.com",""));
        itemList.add(new ItemModelR("3386846790", "Ivano Siringo","isiringo@dalet.com",""));


        // Inizializza il RecyclerView
        recyclerView = findViewById(R.id.rectangles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapterR(itemList, this);
        recyclerView.setAdapter(adapter);
    }
}
