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
        dataList.add(new YourModel("Arber Plant Care", "Agriculture", R.drawable.arberplantcare));
        dataList.add(new YourModel("Cafe Con Leche", "Food, Service", R.drawable.cafeconleche));
        dataList.add(new YourModel("Lily's Dental Hygiene", "Personal Health", R.drawable.flauselectricflosser));
        dataList.add(new YourModel("Glove Wrap", "Sports, Merchandise", R.drawable.glovewrap));
        dataList.add(new YourModel("Lego Vaccum", "Cleaning Supplies", R.drawable.legovaccum));
        dataList.add(new YourModel("Nut Milk Maker", "Food Machinery", R.drawable.nutrnutmilkmachine));
        dataList.add(new YourModel("Pie Sodas", "Beverages", R.drawable.piewineforpizza));
        dataList.add(new YourModel("Proven Cosmetics", "Skincare and Beauty", R.drawable.provenskincare));

        // Add more data as needed

        adapter = new SwipeAdapter(this, dataList);
        koloda.setAdapter(adapter);

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
    }
}
