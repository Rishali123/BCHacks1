package com.example.bchacks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.yalantis.library.Koloda;

import java.util.ArrayList;
import java.util.List;

public class SwipeActivity extends AppCompatActivity {

    private SwipeAdapter adapter;
    private List<Integer> list;
    Koloda koloda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        Log.i("Swipe", "Check 1");

        koloda = findViewById(R.id.koloda);
        Log.i("Swipe", "Check 2");
        list = new ArrayList<>();
        Log.i("Swipe", "Check 3");
        adapter = new SwipeAdapter(this, list);
        Log.i("Swipe", "Check 4");
        koloda.setAdapter(adapter);
        Log.i("Swipe", "Check 5");
    }
}