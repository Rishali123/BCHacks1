package com.example.bchacks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class SwipeAdapter extends BaseAdapter {

    private Context context;
    private List<Integer> List;

    public SwipeAdapter(Context context, java.util.List<Integer> list) {
        this.context = context;
        List = list;
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

        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_koloda, parent, false);
        } else {
            view = convertView;
        }
        return null;
    }
}
