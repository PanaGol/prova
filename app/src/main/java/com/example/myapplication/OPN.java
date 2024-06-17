package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OPN extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CustomAdapterR adapter;
    private List<ItemModelR> itemList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opn);

        // Inizializza la lista degli elementi
        itemList = new ArrayList<>();
        itemList.add(new ItemModelR("3357311441", "Alessandro Negri","alessandro.negri@medisaet.it",""));
        itemList.add(new ItemModelR("3356120889", "Roberto Cuccu","roberto.cuccu@medisaet.it",""));
        itemList.add(new ItemModelR("3357203862", "Roberto Gasparini","roberto.gasparini@mediaset.it",""));
        itemList.add(new ItemModelR("3469423815", "Antonio Oliva","antonio.oliva@mediaset.it",""));
        itemList.add(new ItemModelR("3346948240", "Luca Cattaneo","luca.cattaneo@mediaset.it",""));
        itemList.add(new ItemModelR("3357311565", "Giuseppe Fusi","giuseppe.fusi@medisaet.it",""));
        itemList.add(new ItemModelR("0221022335", "Stefano Rimoldi","stafano.rimoldi@mediaset.it",""));
        // Aggiungi altri elementi se necessario

        // Inizializza il RecyclerView
        recyclerView = findViewById(R.id.rectangles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapterR(itemList, this);
        recyclerView.setAdapter(adapter);
    }
}
