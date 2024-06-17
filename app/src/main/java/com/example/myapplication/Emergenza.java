package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Emergenza extends AppCompatActivity {
    private Spinner personSpinner;
    private Button callButton,prova;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergenza);

        ImageView freccia = findViewById(R.id.imageView6);
        freccia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Chiude l'Activity corrente e torna alla precedente
            }
        });

        Button teams = findViewById(R.id.teams);
        teams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica se l'app Teams è installata sul dispositivo
                if (isTeamsInstalled()) {
                    // Avvia l'app Teams
                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.microsoft.teams");
                    startActivity(intent);
                } else {
                    // Se Teams non è installato, apri il link al Play Store per scaricarlo
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.microsoft.teams"));
                    startActivity(intent);
                }
            }
        });

        prova = findViewById(R.id.button23);
        prova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emergenza.this, Format.class);
                startActivity(intent); // Utilizza startActivity invece di startActivities

            }
        });

        personSpinner = findViewById(R.id.spinner);
        callButton = findViewById(R.id.button13);

        // Popola lo Spinner con i nomi delle persone
        List<String> people = new ArrayList<>();
        people.add("Emergenza");
        people.add("Emergenza Dalet Francia");
        people.add("Emergenza Dalet NY");
        people.add("Viktor Damyanov");
        people.add("L2 Broadcast Mediaset");
        people.add("Vigilanza/Impianti Cologno");
        people.add("Vigilanza/Impianti Roma");

        // Aggiungi altri nomi se necessario
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, people);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        personSpinner.setAdapter(adapter);

        // Gestisci il click sul pulsante di chiamata
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ottieni il numero associato alla persona selezionata
                String selectedPerson = personSpinner.getSelectedItem().toString();
                String phoneNumber = getPhoneNumber(selectedPerson);
                // Effettua la chiamata
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }
        });
    }

    private boolean isTeamsInstalled() {
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.microsoft.teams");
        return intent != null;
    }


    // Metodo per ottenere il numero associato al nome della persona
    private String getPhoneNumber(String person) {
        // Implementa la logica per ottenere il numero telefonico in base al nome della persona
        // Qui potresti utilizzare un'istanza di ItemModel per associare i nomi alle persone
        // e ottenere il numero di telefono in base al nome della persona selezionata
        // In questo esempio, restituiamo un numero fittizio
        if (person.equals("Emergenza Dalet Francia")) {
            return "+33141276747";
        } else if (person.equals("Emergenza Dalet NY")) {
            return "+12122696707";
        } else if (person.equals("Viktor Damyanov")) {
            return "359895664449";
        } else if (person.equals("L2 Broadcast Mediaset")) {
            return "0225145200";
        } else if (person.equals("Vigilanza/Impianti Cologno")) {
            return "0225148383";
        } else if (person.equals("Vigilanza/Impianti Roma")) {
            return "065778644";
        } else {
            return ""; // Se la persona non è trovata, restituisci una stringa vuota
        }

    }
}