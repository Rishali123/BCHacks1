package com.example.bchacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.bchacks.databinding.SmallBusinessBinding;


public class SmallBusiness extends AppCompatActivity {

    SmallBusinessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("yooo", "Yay!");
        super.onCreate(savedInstanceState);
        binding = SmallBusinessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

<<<<<<< HEAD
        Log.i("History", "Entered");

=======
        Log.i("Listssss", "Yay!");
>>>>>>> 3620c09f5d877334cd803beda3d2c7363e7ebb5e
        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String time = intent.getStringExtra("time");
            int ingredients = intent.getIntExtra("ingredients", R.string.maggiIngredients);
            int desc = intent.getIntExtra("desc", R.string.maggieDesc);
            int image = intent.getIntExtra("image", R.drawable.investor);

            binding.detailName.setText(name);
            binding.detailTime.setText(time);
            binding.detailDesc.setText(desc);
            binding.detailIngredients.setText(ingredients);
            binding.detailImage.setImageResource(image);
            //
        }
    }
}