package com.example.bchacks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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

        koloda = findViewById(R.id.koloda);
        list = new ArrayList<>();
        adapter = new SwipeAdapter(this, list);
        koloda.setAdapter(adapter);
    }
}