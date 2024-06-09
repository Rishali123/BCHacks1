package com.example.bchacks;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private List<YourModel> items = new ArrayList<>();

    public CardAdapter(List<YourModel> items) {
        this.items = items;
    }
    public CardAdapter() {
        items = new ArrayList<>();
        items.add(new YourModel("Glass View Luxury Glamping", "Seattle, Wa", 2, "$5,000", "$500,000", "Accelerator", "Non Equity, Seed, Venture", "Glassview is a luxury glamping resort concept that offers fully furnished, mirrored-glass cabins situated in beautiful, natural locations.",  "Glassview is a luxury glamping resort concept that offers fully furnished, mirrored-glass cabins situated in beautiful, natural locations. Glassview’s value proposition aims to provide a unique and immersive outdoor experience!\n The Business\n Glassview is poised to enhance the luxury glamping experience. the glamping business model captures the upside of premium hotel pricing without the higher costs associated with resort operations. Glassview also owns the land it operates on, allowing us to capture the additional upside through appreciation and asset backed valuations.", R.drawable.glass_view_glamping, "(425) 999-7118", "glassview@gmail.com", "Outdoor/Camping", "Real Estate", "Joshua Smith", "51-100", "May 7th, 2023"));
        items.add(new YourModel("Glass View Luxury Glamping", "Seattle, Wa", 2, "$5,000", "$500,000", "Accelerator", "Non Equity, Seed, Venture", "Glassview is a luxury glamping resort concept that offers fully furnished, mirrored-glass cabins situated in beautiful, natural locations.",  "Glassview is a luxury glamping resort concept that offers fully furnished, mirrored-glass cabins situated in beautiful, natural locations. Glassview’s value proposition aims to provide a unique and immersive outdoor experience!\n The Business\n Glassview is poised to enhance the luxury glamping experience. the glamping business model captures the upside of premium hotel pricing without the higher costs associated with resort operations. Glassview also owns the land it operates on, allowing us to capture the additional upside through appreciation and asset backed valuations.", R.drawable.glass_view_glamping, "(425) 999-7118", "glassview@gmail.com", "Outdoor/Camping", "Real Estate", "Joshua Smith", "51-100", "May 7th, 2023"));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_koloda, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name, tag1, tag2, location, GROLvl, minimum, maximum;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
            tag1 = itemView.findViewById(R.id.tag1);
            tag2 = itemView.findViewById(R.id.tag2);
            location = itemView.findViewById(R.id.location);
            GROLvl = itemView.findViewById(R.id.GROLvl);
            minimum = itemView.findViewById(R.id.minimum);
            maximum = itemView.findViewById(R.id.maximum);
        }

        void setData(YourModel data) {
            name.setText(data.name);
            image.setImageResource(data.imageResource);
            tag1.setText(data.tag1);
            tag2.setText(data.tag2);
            location.setText(data.location);
            GROLvl.setText(data.GROLvl);
            minimum.setText(data.minimum);
            maximum.setText(data.maximum);
        }
    }

    public List<YourModel> getItems() {
        return items;
    }

    public void setItems(List<YourModel> items) {
        this.items = items;
    }
}