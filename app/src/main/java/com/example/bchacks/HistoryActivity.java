package com.example.bchacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.bchacks.databinding.ActivityHistoryBinding;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ActivityHistoryBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {R.drawable.investor, R.drawable.investor, R.drawable.investor, R.drawable.investor, R.drawable.investor, R.drawable.investor, R.drawable.investor};
        int[] ingredientList = {R.string.pastaIngredients, R.string.maggiIngredients,R.string.cakeIngredients,R.string.pancakeIngredients,R.string.pizzaIngredients, R.string.burgerIngredients, R.string.friesIngredients};
        int[] descList = {R.string.pastaDesc, R.string.maggieDesc, R.string.cakeDesc,R.string.pancakeDesc,R.string.pizzaDesc, R.string.burgerDesc, R.string.friesDesc};
        String[] nameList = {"Pasta", "Maggi", "Cake", "Pancake", "Pizza","Burgers", "Fries"};
        String[] timeList = {"30 mins", "2 mins", "45 mins","10 mins", "60 mins", "45 mins", "30 mins"};

        for (int i = 0; i < imageList.length; i++){
            listData = new ListData(nameList[i], timeList[i], ingredientList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(HistoryActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HistoryActivity.this, SmallBusiness.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                Log.i("cool", "Yay!" + intent);
                startActivity(intent);
            }
        });
    }
}