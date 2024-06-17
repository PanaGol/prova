package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class EmergenzaR  extends AppCompatActivity {
    private Spinner personSpinner;
    private Button callButton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergenzar);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView freccia = findViewById(R.id.imageView6);
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
        personSpinner = findViewById(R.id.spinner);
        callButton = findViewById(R.id.button13);

        // Popola lo Spinner con i nomi delle persone
        List<String> people = new ArrayList<>();
        people.add("Emergenza Dalet Francia");
        people.add("REmergenza Dalet NY");
        people.add("Viktor Damyanov");
        people.add("L2 Broadcast");
        people.add("Dalet Roma");
        people.add("Dalet Milan");
        people.add("MEmergenze impianti");

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

    // Metodo per verificare se l'app Teams è installata sul dispositivo


    // Metodo per ottenere il numero associato al nome della persona
    private String getPhoneNumber(String person) {
        // Implementa la logica per ottenere il numero telefonico in base al nome della persona
        // Qui potresti utilizzare un'istanza di ItemModel per associare i nomi alle persone
        // e ottenere il numero di telefono in base al nome della persona selezionata
        // In questo esempio, restituiamo un numero fittizio
        if (person.equals("Emergenza Dalet Francia")) {
            return "33141276747";
        } else if (person.equals("Emergenza Dalet NY")) {
            return "+1(212)269-6707";
        } else if (person.equals("Viktor Damyanov")) {
            return "359895664449";
        } else if (person.equals("L2 Broadcast")) {
            return "0225145200";
        } else if (person.equals("Dalet Roma")) {
            return "0657786100";
        } else if (person.equals("Dalet Milan")) {
            return "0657788100";
        } else if (person.equals("Emergenze impianti")) {
            return "0225148383";
        } else {
            return ""; // Se la persona non è trovata, restituisci una stringa vuota
        }

    }
}
