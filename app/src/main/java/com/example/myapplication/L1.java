package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class L1 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CustomAdapterR adapter;
    private List<ItemModelR> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l1);

        // Inizializza la lista degli elementi
        itemList = new ArrayList<>();
        itemList.add(new ItemModelR("3337614679", "Matteo Panaia","ct009053@medisaet.it","matteo.panaia@luteh.it"));
        itemList.add(new ItemModelR("3930946112", "Nicolas Filippi","ct009354@medisaet.it","nicolas.filippi@lutech.it"));
        itemList.add(new ItemModelR("3665769580", "Alessandro Bosio","ct008866@medisaet.it","alessandro.bosio@lutech.it"));
        itemList.add(new ItemModelR("3474840338", "Franco Gandi Dino","ct008864@medisaet.it","franco.gangidino@lutech.it"));
        itemList.add(new ItemModelR("3339666420", "Luigi Strummiello","ct008869@medisaet.it","luigi.strummiello@lutechit"));
        itemList.add(new ItemModelR("3474106454", "Gabriele Marinoni","ct008865@medisaet.it","gabriele.marinoni@lutech.it"));
        itemList.add(new ItemModelR("3341542552", "Marco Spada","ct008868@medisaet.it","marco.spada@lutech.it"));
        itemList.add(new ItemModelR("3486168393", "Mattia Berardi","ct009438@medisaet.it","mattia.berardi@lutech.it"));
        itemList.add(new ItemModelR("33314523662", "Maurizio Papa","ct009052@medisaet.it","maurizio.papa@lutech.it"));
        itemList.add(new ItemModelR("3896829880", "Gianluca Re","ct009356@medisaet.it","gianluca.re@lutech.it"));
        itemList.add(new ItemModelR("3914916346", "Alessandro Crespi","ct009355@medisaet.it","alessandro.crespi@lutech.it"));
        itemList.add(new ItemModelR("3272904267", "Eridano Bellinelli","ct01145@medisaet.it","eridano.bellinelli@rpctech.it"));
        itemList.add(new ItemModelR("3388277651", "Stefano Sidoti","ct009103@medisaet.it","stefano.sidoti@rpctech.it"));
        // Aggiungi altri elementi se necessario

        // Inizializza il RecyclerView
        recyclerView = findViewById(R.id.rectangles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapterR(itemList, this);
        recyclerView.setAdapter(adapter);
    }
}