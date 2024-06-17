package com.example.myapplication;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Produzioni extends AppCompatActivity implements View.OnTouchListener {
    private ImageView imageView;
    private Matrix matrix = new Matrix();
    private Matrix savedMatrix = new Matrix();
    private PointF startPoint = new PointF();
    private PointF midPoint = new PointF();
    private float oldDist = 1f;
    private static final int NONE = 0;
    private static final int DRAG = 1;
    private static final int ZOOM = 2;
    private int mode = NONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produzioni);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView freccia = findViewById(R.id.imageView6);
        freccia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Chiude l'Activity corrente e torna alla precedente
            }
        });
        imageView = findViewById(R.id.imageView5);
        imageView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                savedMatrix.set(matrix);
                startPoint.set(event.getX(), event.getY());
                mode = DRAG;
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                oldDist = spacing(event);
                if (oldDist > 10f) {
                    savedMatrix.set(matrix);
                    midPoint(midPoint, event);
                    mode = ZOOM;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (mode == DRAG) {
                    matrix.set(savedMatrix);
                    matrix.postTranslate(event.getX() - startPoint.x, event.getY() - startPoint.y);
                } else if (mode == ZOOM) {
                    float newDist = spacing(event);
                    if (newDist > 10f) {
                        matrix.set(savedMatrix);
                        float scale = newDist / oldDist;
                        matrix.postScale(scale, scale, midPoint.x, midPoint.y);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                mode = NONE;
                break;
        }

        // Calcola la traslazione per centrare l'ImageView nella visualizzazione
        centerImageView();

        imageView.setImageMatrix(matrix);
        return true;
    }

    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }

    private void midPoint(PointF point, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2, y / 2);
    }

    private void centerImageView() {
        // Calcola le dimensioni dell'ImageView
        int imageViewWidth = imageView.getWidth();
        int imageViewHeight = imageView.getHeight();

// Calcola le dimensioni dell'immagine
        Drawable drawable = imageView.getDrawable();
        if (drawable == null) {
            return; // Assicurati che l'ImageView abbia un'immagine impostata
        }
        int drawableWidth = drawable.getIntrinsicWidth();
        int drawableHeight = drawable.getIntrinsicHeight();

// Calcola le traslazioni necessarie per centrare l'immagine
        float translationX = (imageViewWidth - drawableWidth) / 2f;
        float translationY = (imageViewHeight - drawableHeight) / 2f;

// Inizializza la matrice e imposta le traslazioni
        Matrix matrix = new Matrix();
        matrix.postTranslate(translationX, translationY);

// Imposta la matrice sull'ImageView
        imageView.setImageMatrix(matrix);
    }
}
