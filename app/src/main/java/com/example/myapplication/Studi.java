package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Studi extends AppCompatActivity {
    Button regia, produzione,impieghi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studi);

        impieghi = findViewById(R.id.button20);
        impieghi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // URL della pagina web da aprire
                String url = "https://mediasetgroup.sharepoint.com/sites/dirtecops/OperationTV/Forms/AllItems.aspx?e=5%3A98412d2acdd14d04837615d40d8deccd&at=9&CT=1707820935662&OR=OWA%2DNT&CID=a942930b%2De880%2D72ef%2Dbea7%2D52172ef86e95&FolderCTID=0x0120002129B4C2A4AD1A41B5F57159B951A635&WSL=1&id=%2Fsites%2Fdirtecops%2FOperationTV%2FImpegni%20Studi%2FMILANO&viewid=f28c9cb8%2Dcb11%2D4e79%2D8919%2Df4821c50bbd5";

                // Crea un intento per aprire la pagina web
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));

                // Avvia l'attività per aprire la pagina web
                startActivity(intent);
            }
        });

        regia = findViewById(R.id.button10);
        regia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Studi.this, Regia.class);
                startActivity(intent); // Utilizza startActivity invece di startActivities

            }
        });

        produzione = findViewById(R.id.button11);
        produzione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Studi.this, Produzioni.class);
                startActivity(intent); // Utilizza startActivity invece di startActivities

            }
        });

        ImageView freccia = findViewById(R.id.imageView6);
        freccia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Chiude l'Activity corrente e torna alla precedente
            }
        });


    }
}

