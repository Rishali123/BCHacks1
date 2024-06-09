package com.example.bchacks;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class SwipeAdapter extends BaseAdapter {

    private Context context;
    private List<Integer> List;

    public SwipeAdapter(Context context, java.util.List<Integer> list) {
        Log.i("Swipe", "Verify 1");
        this.context = context;
        Log.i("Swipe", "Verify 2");
        List = list;
        Log.i("Swipe", "Verify 3");
    }

    @Override
    public int getCount() {
        return 20;
    }


    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Log.i("Swipe", "Verify 7");
        if (convertView == null) {
            Log.i("Swipe", "Verify 8");
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_koloda, parent, false);
        } else {
            view = convertView;
            Log.i("Swipe", "Verify 9");
        }
        Log.i("Swipe", "Verify 10");
        return view;
    }
}
