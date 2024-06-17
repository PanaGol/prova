package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Monitoria extends AppCompatActivity {

    Button nagios,news,ddn,ddna,dash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monitoria);
        PopupUtils.showSimplePopup(this, "Ricordati", "Per accedere, devi essere sotto dominio Mediaset");


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView freccia = findViewById(R.id.imageView6);
        freccia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Chiude l'Activity corrente e torna alla precedente
            }
        });

        dash = findViewById(R.id.button17);
        dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // URL della pagina web da aprire
                String url = "https://10.51.1.188/nagiosxi/dashboards/index.php?";
                // Crea un intento per aprire la pagina web
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                // Avvia l'attività per aprire la pagina web
                startActivity(intent);
            }
        });


        ddna = findViewById(R.id.button16);
        ddna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // URL della pagina web da aprire
                String url = "https://10.101.99.27";
                // Crea un intento per aprire la pagina web
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                // Avvia l'attività per aprire la pagina web
                startActivity(intent);
            }
        });


        ddn = findViewById(R.id.button15);
        ddn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // URL della pagina web da aprire
                String url = "https://10.101.99.13/";
                // Crea un intento per aprire la pagina web
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                // Avvia l'attività per aprire la pagina web
                startActivity(intent);
            }
        });


        news = findViewById(R.id.button14);
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // URL della pagina web da aprire
                String url = "http://10.101.96.10/NagiosNews/omd/";
                // Crea un intento per aprire la pagina web
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                // Avvia l'attività per aprire la pagina web
                startActivity(intent);
            }
        });

        nagios = findViewById(R.id.button12);
        nagios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // URL della pagina web da aprire
                String url = "http://157.29.197.16/NagiosCM_Studi/omd/";
                // Crea un intento per aprire la pagina web
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                // Avvia l'attività per aprire la pagina web
                startActivity(intent);
            }
        });

    }
    public static class PopupUtils {
        public static void showSimplePopup(Context context, String title, String message) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(title)
                    .setMessage(message)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Azione da eseguire quando viene premuto il pulsante OK
                            dialog.dismiss(); // Chiudi il pop-up
                        }
                    })
                    .setCancelable(false); // Impedisce di chiudere il pop-up cliccando al di fuori di esso

            // Mostra il pop-up
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
}
