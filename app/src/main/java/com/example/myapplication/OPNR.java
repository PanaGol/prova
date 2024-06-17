package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OPNR extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CustomAdapterR adapter;
    private List<ItemModelR> itemList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opnr);


        // Inizializza la lista degli elementi
        itemList = new ArrayList<>();
        itemList.add(new ItemModelR("34529225802", " Dario Martino","dario.martino@medisaet.it",""));
        itemList.add(new ItemModelR("3357900498", "Luciano mattarino","luciano.mattarino@medisaet.it",""));
        itemList.add(new ItemModelR("3356103165", "Katia Attiani","katia.attiani@mediaset.it",""));
        itemList.add(new ItemModelR("3453499550", "Vincenzo Campolongo","vincenzo.campolongo@medisaet.it",""));
        itemList.add(new ItemModelR("3343722979", "Gianluca Ruggiero","gianluca.ruggiero@mediaset.it",""));
        itemList.add(new ItemModelR("0225145200", "Reperibile","",""));

        // Aggiungi altri elementi se necessario

        // Inizializza il RecyclerView
        recyclerView = findViewById(R.id.rectangles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapterR(itemList, this);
        recyclerView.setAdapter(adapter);
    }
}
