package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Documentazione extends AppCompatActivity {

    Button formazione,soluzione, sharepoint;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.documentazione);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView freccia = findViewById(R.id.imageView6);
        freccia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Chiude l'Activity corrente e torna alla precedente
            }
        });


        formazione = findViewById(R.id.button8);
        formazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PdfActivity.class);
                startActivity(intent);
            }
        });
        sharepoint = findViewById(R.id.button7);
        sharepoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // URL della pagina web da aprire
                String url = "https://mediasetgroup.sharepoint.com/sites/dirtecops/OperationTV/Forms/AllItems.aspx?e=5%3A98412d2acdd14d04837615d40d8deccd&at=9&CT=1707302237444&OR=OWA%2DNT&CID=57b17a9a%2D87c6%2Dba56%2D265f%2D8367c95a04a1&FolderCTID=0x0120002129B4C2A4AD1A41B5F57159B951A635&WSL=1&viewid=f28c9cb8%2Dcb11%2D4e79%2D8919%2Df4821c50bbd5";

                // Crea un intento per aprire la pagina web
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));

                // Avvia l'attività per aprire la pagina web
                startActivity(intent);
            }
        });


        soluzione = findViewById(R.id.button9);
        soluzione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PdfActivity2.class);
                startActivity(intent);
            }
        });
    }
}


