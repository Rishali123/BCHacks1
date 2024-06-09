package com.example.bchacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
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
<<<<<<< HEAD
<<<<<<< HEAD

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.Home);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.Home) {// Do nothing if already in home
                return true;
            } else if (itemId == R.id.Profile) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                finish();
                return true;
            } else if (itemId == R.id.History) {
                startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
                finish();
                return true;
            }
            return false;
        });
=======
        Log.i("Swipe", "Check 5");
>>>>>>> parent of 3620c09 (Merge branch 'main' of https://github.com/Rishali123/BCHacks1)
=======
        Log.i("Swipe", "Check 5");
>>>>>>> parent of 3620c09 (Merge branch 'main' of https://github.com/Rishali123/BCHacks1)
    }
}