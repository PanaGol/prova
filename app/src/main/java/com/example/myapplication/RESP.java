package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RESP extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CustomAdapterR adapter;
    private List<ItemModelR> itemList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resp);

        // Inizializza la lista degli elementi
        itemList = new ArrayList<>();
        itemList.add(new ItemModelR("3402257199", "Maurizio Broglia","maurizio.broglia@medisaet.it",""));
        itemList.add(new ItemModelR("3357655867", "Michele Sartor","michele.sartor@medisaet.it",""));
        itemList.add(new ItemModelR("3456227702", "Silvano De Vecchi","silvano.devecchi@medisaet.it",""));
        itemList.add(new ItemModelR("3455688118", "Alfredo Lovino","alfredo.lovino@medisaet.it",""));
        itemList.add(new ItemModelR("3311739481", "Fabrizio Campesan","fabrizio.campesan@medisaet.it",""));
        itemList.add(new ItemModelR("3346982083", "Luigi Creamaschi","luigi.cremsachi@medisaet.it",""));
        itemList.add(new ItemModelR("3346656400", "Alberto Sozzani","alberto.sozzani@mediaset.it",""));
        itemList.add(new ItemModelR("3386412567", "Roberto Ferrari","roberto.ferrari@medisaet.it",""));
        itemList.add(new ItemModelR("3371686717", "Cristiano Brienza","cristiano.brienza@medisaet.it",""));
        itemList.add(new ItemModelR("3666780450", "Marco De Gol","Marco.DeGol@medisaet.it",""));
        itemList.add(new ItemModelR("3386620067", "Fulvio Cantalupo","fulvio.cantalupo@medisaet.it",""));
        itemList.add(new ItemModelR("3468681762", "Raffaello Manigrasso","raffaello.manigrasso@medisaet.it",""));
        itemList.add(new ItemModelR("3492696575", "Mattia Barone","mattia.barone@medisaet.it",""));
        // Aggiungi altri elementi se necessario

        // Inizializza il RecyclerView
        recyclerView = findViewById(R.id.rectangles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapterR(itemList, this);
        recyclerView.setAdapter(adapter);
    }
}
