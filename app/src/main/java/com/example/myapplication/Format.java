package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Format extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.format);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView freccia = findViewById(R.id.imageView6);
        freccia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Chiude l'Activity corrente e torna alla precedente
            }
        });

        EditText nameEditText = findViewById(R.id.names);
        EditText currentWeightEditText = findViewById(R.id.ora);
        EditText heightEditText = findViewById(R.id.descrizione);
        EditText goalWeightEditText = findViewById(R.id.risoluzione);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioButton radioButton1 = findViewById(R.id.radioButton2);
        RadioButton radioButton2 = findViewById(R.id.radioButton4);


        Button invio = findViewById(R.id.invia);
        invio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String currentWeight = currentWeightEditText.getText().toString();
                String height = heightEditText.getText().toString();
                String goalWeight = goalWeightEditText.getText().toString();

                int selectedId = radioGroup.getCheckedRadioButtonId(); // Ottieni l'ID del RadioButton selezionato
                RadioButton selectedRadioButton = findViewById(selectedId); // Trova il RadioButton selezionato

                String selectedAns = "niente selezionato";
                if (selectedRadioButton != null) {
                    selectedAns = selectedRadioButton.getText().toString();
                }


                String message = "Studio/Produzione: " + name + "\nData/Ora: " + currentWeight + "\nDescrizione: " + height +
                        "\nRisoluzione: " + goalWeight + "\nCondition 1: " + selectedAns;

                sendMessageToTeams(message);
            }
        });
    }


    private void sendMessageToTeams(String message) {
        // URL dell'endpoint per inviare un messaggio in una chat di Teams
       // String url = "https://graph.microsoft.com/v1.0/teams/{team-id}/channels/{channel-id}/messages";
        String teamId = "0d60088a-40f5-4600-bf78-83124b1d3985";
        String channelId = "19:f16c6fcd1bb040dc953a28375ae51ee1@thread.tacv2";
        String url = "https://graph.microsoft.com/v1.0/teams/" + teamId + "/channels/" + channelId + "/messages";

        // Costruisci il corpo del messaggio JSON
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("body", new JSONObject().put("content", message));
        } catch (JSONException e) {
            e.printStackTrace();
        }


        // Crea una richiesta HTTP POST con OkHttp
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonBody.toString());
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "Bearer " + "EwBwA8l6BAAUbDba3x2OMJElkF7gJ4z/VbCPEz0AASAhW4UA/uGWgNBQAF3RIntyQVEA7TIUfR77aTLNz9vs2i57iI7TZf9Js5oKzbf87Onl3Q5geGd7MsXrjlfra9UZuYQ2O1mSY1N2aaJazIXo0Li6y75w2m51ATcWxUH4pJENoQ5ZUVaX9kgCHj7WU8g815Y7lFmQGNNz94yn77KXoSJvnPJUoe+Xyu8CF3eVSHQ25z5x0LxRlwN2A7d5Tt2nDAn4S3JgrMG8svs+xhq9t4BhQwy6uNZbL8E6zOaGS/4L9Qe3lnW/iBmQIFI8owwBvbwp/1L98GIAqRvguWd3gHHR4AlXgTRUV9VAdF0fNBW/Mw70PcAxDXIL7eNKXwYDZgAACIfO1ragAwk+QAJPcEzK2H6yM1bN8TdaP3+lLk9EIHv+QfaFFbnaRaWw3juTCrHJKYR7emqWohKmg5PQLKrapR69izXo7pEnc+wbGahAdKnElVnTKuUmOR3VZfBFZWISTpHF2mIDhq9tgbRqg97iUcY1dn6UOQyz0FtNqcGt1Vwpnlo8aWCH+rStjymWRVBxCCtx3K1MM4Y9IARTDYBHOEEps9MLAYgnSa0+qI0x55Y1/uyeu1PQ1jY99DgB+fpWDNik2khScWSLffZqJaRiA2vvuO17y7k6lYPBTV5/DX1wBQ22vilM5yAsc0G+oCOwijgiJRL05WwmgmsdcXpMUU+t2JIiGfh+PfATBPosG30Om3CVSZStFVlTu+27g2jWRqPahr7H0MqLvyKHBd7C0sc/gsXZlhnfNwFNH/Tg0EMfDsXcEeBUOeDFshciIbqYZHb9Cb4SFosJJMnswcpenOgl+8+ph19NXl5TzwyhBlGbuNNCy/Hw2xrQWnv1VPRtBr6zgp1QGiZnX7+gMz7XLrutTSHVP07vsqv//0AfKkapNMO4XMKWyQ7OGlvKf05VvUG+p6TYDuuGI14BYjPzPCNvvbsnM6uf2eX2vUZmqTKOSOIvAYypd046FqWhFtwVZ9FCdVRJNLbaZNxVa6YgavKOPqCE/lpDtQTnZk5bhCly3F13IL+CFcKejzbcfy/OkJEKHLYkEIZ/dD0yeWtSzIlI5sw8fRe0ZxqVJm/U49AW8w/HIQSMThtqii2p8DYGyABVHoM6PAL3/K+CAg==")
                .header("Content-Type", "application/json")
                .post(requestBody)
                .build();

        // Esegui la richiesta in modo asincrono
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Gestisci eventuali errori di rete
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // All'interno di onResponse
                if (response.isSuccessful()) {
                    Log.d("SendMessageToTeams", "Messaggio inviato con successo");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Format.this, "Messaggio inviato con successo", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Log.e("SendMessageToTeams", "Errore nell'invio del messaggio: " + response.code() + " - " + response.message());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Format.this, "Errore nell'invio: " + response.message(), Toast.LENGTH_LONG).show();
                        }
                    });
                }

            }
        });
    }

}
