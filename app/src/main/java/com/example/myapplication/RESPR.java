package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RESPR extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CustomAdapterR adapter;
    private List<ItemModelR> itemList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.respr);

        // Inizializza la lista degli elementi
        itemList = new ArrayList<>();
        itemList.add(new ItemModelR("3288222351", " Daniele Scapigliati","daniele.scapigliati@mediaset.it",""));
        itemList.add(new ItemModelR("3477624831", "Franco Cifrodelli","franco.cifrodelli@medisaet.it",""));
        itemList.add(new ItemModelR("3453567585", "Antonio Accorinti","antonio.accorinti@mediaset.it",""));
        itemList.add(new ItemModelR("3491549217", "Luca Di Bisceglia","luca.bidisceglia@mediaset.it",""));
        itemList.add(new ItemModelR("3468665805", "Giorgio Sepe","giorgio.sepe@mediaset.it",""));
        itemList.add(new ItemModelR("3371358376", "Roberto Di Maulo","roberto.dimaulo@medisaet.it",""));
        itemList.add(new ItemModelR("3355842750", "Maurizio Rava","maurizio.rava@mediaset.it",""));
        itemList.add(new ItemModelR("3382305654", "Mauro Chiappa","mauro.chiappa@medisaet.it",""));
        // Aggiungi altri elementi se necessario

        // Inizializza il RecyclerView
        recyclerView = findViewById(R.id.rectangles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapterR(itemList, this);
        recyclerView.setAdapter(adapter);
    }
}
