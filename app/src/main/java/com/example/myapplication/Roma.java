package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Roma  extends AppCompatActivity {

    Button emergenza,contatti,turni, studi, documentazione, monitoria;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Rimuovi la richiesta della barra delle azioni (ActionBar) dall'attività
//requestWindowFeature(Window.FEATURE_NO_TITLE);

// Imposta l'applicazione a schermo intero



        setContentView(R.layout.roma);



        contatti = findViewById(R.id.button2);
        contatti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Roma.this, ContattiR.class);
                startActivity(intent); // Utilizza startActivity invece di startActivities

            }
        });

       /* emergenza = findViewById(R.id.button);
        emergenza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Roma.this, EmergenzaR.class);
                startActivity(intent); // Utilizza startActivity invece di startActivities

            }
        });*/

        turni = findViewById(R.id.button3);
        turni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // URL della pagina web da aprire
                String url = "https://www.dropbox.com/s/mwu9i06jgmcak7o/Turni%20Dalet%20Supporto%20L1%20Operation%20TV.xlsx?e=1&dl=0";

                // Crea un intento per aprire la pagina web
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));

                // Avvia l'attività per aprire la pagina web
                startActivity(intent);

            }
        });

        documentazione = findViewById(R.id.button4);
        documentazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Roma.this, DocumentazioneR.class);
                startActivity(intent); // Utilizza startActivity invece di startActivities

            }
        });

        studi = findViewById(R.id.button6);
        studi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Roma.this, StudiR.class);
                startActivity(intent); // Utilizza startActivity invece di startActivities

            }
        });

        monitoria = findViewById(R.id.button5);
        monitoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Roma.this, MonitoriaR.class);
                startActivity(intent); // Utilizza startActivity invece di startActivities

            }
        });

    }
}


