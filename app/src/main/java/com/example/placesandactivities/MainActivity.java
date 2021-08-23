package com.example.placesandactivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    static final String BUNDLE_SAVE_INDEX="BUNDLE_SAVE_INDEX";
    private ImageView imageView;
    private ImageButton rightbt, leftbt;
    private int counter1 = -1;
    private Random mrandom;
    private Drawable imagedrawable;

    private int[] array = {
            R.drawable.beach,
            R.drawable.bike,
            R.drawable.football,
            R.drawable.museum,
            R.drawable.park,
            R.drawable.restaurant,
            R.drawable.running,
            R.drawable.shop,
            R.drawable.swimming,
            R.drawable.walking
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        rightbt = findViewById(R.id.rightbt);
        leftbt = findViewById(R.id.leftbt);
        mrandom = new Random();

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(BUNDLE_SAVE_INDEX,counter1);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null){
            counter1=savedInstanceState.getInt(BUNDLE_SAVE_INDEX);
            if(counter1!=-1){
                imagedrawable = ContextCompat.getDrawable(this, array[counter1]);
                imageView.setImageDrawable(imagedrawable);
            }
        }
    }

    public void random(View view) {
        counter1 = mrandom.nextInt(array.length);
        imagedrawable = ContextCompat.getDrawable(this, array[counter1]);
        imageView.setImageDrawable(imagedrawable);

    }

    public void rightClick(View v) {
        if (counter1 < array.length - 1) {
            ++counter1;
            imagedrawable = ContextCompat.getDrawable(this, array[counter1]);
            imageView.setImageDrawable(imagedrawable);

        } else {
            Toast.makeText(this, "The End", Toast.LENGTH_LONG).show();
        }
    }

    public void laftClick(View c) {
        if (counter1 > 0) {
            imagedrawable = ContextCompat.getDrawable(this, array[--counter1]);
            imageView.setImageDrawable(imagedrawable);
        } else {
            Toast.makeText(this, "The End", Toast.LENGTH_LONG).show();
        }
    }

}





