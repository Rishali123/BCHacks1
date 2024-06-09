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
    private List<YourModel> dataList;
    Koloda koloda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        koloda = findViewById(R.id.koloda);

        // Initialize dataList with different data
        dataList = new ArrayList<>();
        dataList.add(new YourModel("John Doe", "Software Developer", R.drawable.investor));
        dataList.add(new YourModel("Jane Smith", "Graphic Designer", R.drawable.investor1));
        dataList.add(new YourModel("Lily Smith", "Baker", R.drawable.investor2));
        dataList.add(new YourModel("Dhanasri Prabhu", "Loser", R.drawable.investor3));
        dataList.add(new YourModel("Aisha Rana", "Project Manager", R.drawable.investor4));
        dataList.add(new YourModel("Bob Furgerson", "Data Analyst", R.drawable.investor5));
        dataList.add(new YourModel("Jeff Bezoz", "CEO", R.drawable.investor6));
        dataList.add(new YourModel("Rohana Joshi", "Software Developer", R.drawable.investor));

        // Add more data as needed

        adapter = new SwipeAdapter(this, dataList);
        koloda.setAdapter(adapter);
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
>>>>>>> 3620c09f5d877334cd803beda3d2c7363e7ebb5e
    }
}
