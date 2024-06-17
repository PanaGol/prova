package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class  Refresh extends AppCompatActivity {

    private static final int SPLASH_TIMEOUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Rimuovi la richiesta della barra delle azioni (ActionBar) dall'attività
//requestWindowFeature(Window.FEATURE_NO_TITLE);

// Imposta l'applicazione a schermo intero
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        setContentView(R.layout.refresh);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Refresh.this, MainActivity.class);
                startActivity(intent); // Utilizza startActivity invece di startActivities
            }
        }, SPLASH_TIMEOUT);
    }

}
