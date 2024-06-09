package com.example.bchacks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.List;

public class SwipeActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private CardStackLayoutManager manager;
    private CardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe);

        CardStackView cardStackView = findViewById(R.id.cardStack);
        manager = new CardStackLayoutManager(this, new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) {
                Log.d(TAG, "onCardDragging: d=" + direction.name() + " ratio=" + ratio);
            }

            @Override
            public void onCardSwiped(Direction direction) {
                Log.d(TAG, "onCardSwiped: p=" + manager.getTopPosition() + " d=" + direction);
//                if (direction == Direction.Right){
//                    Toast.makeText(MainActivity.this, "Direction Right", Toast.LENGTH_SHORT).show();
//                }
//                if (direction == Direction.Top){
//                    Toast.makeText(MainActivity.this, "Direction Top", Toast.LENGTH_SHORT).show();
//                }
//                if (direction == Direction.Left){
//                    Toast.makeText(MainActivity.this, "Direction Left", Toast.LENGTH_SHORT).show();
//                }
//                if (direction == Direction.Bottom){
//                    Toast.makeText(MainActivity.this, "Direction Bottom", Toast.LENGTH_SHORT).show();
//                }

                // Paginating
                if (manager.getTopPosition() == adapter.getItemCount() - 5){
                    paginate();
                }

            }

            @Override
            public void onCardRewound() {
                Log.d(TAG, "onCardRewound: " + manager.getTopPosition());
            }

            @Override
            public void onCardCanceled() {
                Log.d(TAG, "onCardRewound: " + manager.getTopPosition());
            }

            @Override
            public void onCardAppeared(View view, int position) {
//                TextView tv = view.findViewById(R.id.item_name);
//                Log.d(TAG, "onCardAppeared: " + position + ", nama: " + tv.getText());
            }

            @Override
            public void onCardDisappeared(View view, int position) {
//                TextView tv = view.findViewById(R.id.item_name);
//                Log.d(TAG, "onCardAppeared: " + position + ", nama: " + tv.getText());
            }
        });
        manager.setStackFrom(StackFrom.None);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.FREEDOM);
        manager.setCanScrollHorizontal(true);
        manager.setSwipeableMethod(SwipeableMethod.Manual);
        manager.setOverlayInterpolator(new LinearInterpolator());
        adapter = new CardAdapter(addList());
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);
        cardStackView.setItemAnimator(new DefaultItemAnimator());

    }

    private void paginate() {
        List<YourModel> old = adapter.getItems();
        List<YourModel> baru = new ArrayList<>(addList());
//        CardStackCallback callback = new CardStackCallback(old, baru);
//        DiffUtil.DiffResult hasil = DiffUtil.calculateDiff(callback);
        adapter.setItems(baru);
//        hasil.dispatchUpdatesTo(adapter);
    }

    private List<YourModel> addList() {
        List<YourModel> dataList = new ArrayList<>();
        dataList.add(new YourModel("Glass View Luxury Glamping", "Seattle, Wa", 2, "$5,000", "$500,000", "Accelerator", "Non Equity, Seed, Venture", "Glassview is a luxury glamping resort concept that offers fully furnished, mirrored-glass cabins situated in beautiful, natural locations.",  "Glassview is a luxury glamping resort concept that offers fully furnished, mirrored-glass cabins situated in beautiful, natural locations. Glassview’s value proposition aims to provide a unique and immersive outdoor experience!\n The Business\n Glassview is poised to enhance the luxury glamping experience. the glamping business model captures the upside of premium hotel pricing without the higher costs associated with resort operations. Glassview also owns the land it operates on, allowing us to capture the additional upside through appreciation and asset backed valuations.", R.drawable.glass_view_glamping, "(425) 999-7118", "glassview@gmail.com", "Outdoor/Camping", "Real Estate", "Joshua Smith", "51-100", "May 7th, 2023"));
        dataList.add(new YourModel("Glass View Luxury Glamping", "Seattle, Wa", 2, "$5,000", "$500,000", "Accelerator", "Non Equity, Seed, Venture", "Glassview is a luxury glamping resort concept that offers fully furnished, mirrored-glass cabins situated in beautiful, natural locations.",  "Glassview is a luxury glamping resort concept that offers fully furnished, mirrored-glass cabins situated in beautiful, natural locations. Glassview’s value proposition aims to provide a unique and immersive outdoor experience!\n The Business\n Glassview is poised to enhance the luxury glamping experience. the glamping business model captures the upside of premium hotel pricing without the higher costs associated with resort operations. Glassview also owns the land it operates on, allowing us to capture the additional upside through appreciation and asset backed valuations.", R.drawable.glass_view_glamping, "(425) 999-7118", "glassview@gmail.com", "Outdoor/Camping", "Real Estate", "Joshua Smith", "51-100", "May 7th, 2023"));
        return dataList;
    }
}