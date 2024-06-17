package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class L1R extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CustomAdapterR adapter;
    private List<ItemModelR> itemList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l1r);

        // Inizializza la lista degli elementi
        itemList = new ArrayList<>();
        itemList.add(new ItemModelR("3665714569", "Massimiliano Martusciello","ct008878@mediaset.it","massimiliano.martusciello@lutech.it"));
        itemList.add(new ItemModelR("3365767057", "Paolo Rauco","ct008880@mediaset.it","paolo.rauco@lutech.it"));
        itemList.add(new ItemModelR("3357264642", "Fabrizio Silvi","ct008841@mediaset.it","fabrizio.silvi@lutech.it"));
        itemList.add(new ItemModelR("3921757600", "Luca Rossi","ct008763@mediaset.it","luca.rosi@lutech.it"));
        itemList.add(new ItemModelR("3348311366", "Giuseppe Bertoloni","ct009284@mediaset.it","giuseppe.bertolonimeli@lutech.it"));
        itemList.add(new ItemModelR("3453514532", "Dario Schembari","ct009428@mediaset.it","dario.schembari@lutech.it"));
        itemList.add(new ItemModelR("3404108949", "Julian Verardi","ct009796@mediaset.it","julian.verardinichi@lutech.it"));
        itemList.add(new ItemModelR("3395248958", "Ismaele Piparo","ct009514@mediaset.it","ismaele.piparo@lutech.it"));
        itemList.add(new ItemModelR("3395248958", "Paolo Ruta","ct009986@mediaset.it","paolo.ruta@lutech.it"));
        itemList.add(new ItemModelR("3808939899", "Fausto Boshoff","","fausto.boshoff@lutech.it"));
        itemList.add(new ItemModelR("3481194534", "Ignazo Ligani","","ignazio.ligani@lutech.it\t"));


        // Aggiungi altri elementi se necessario

        // Inizializza il RecyclerView
        recyclerView = findViewById(R.id.rectangles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapterR(itemList, this);
        recyclerView.setAdapter(adapter);
    }
}