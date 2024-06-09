//package com.example.bchacks;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//
//import java.util.List;
//
//public class SwipeAdapter extends BaseAdapter {
//
//    private Context context;
//    private List<YourModel> dataList;
//
//    public SwipeAdapter(Context context, List<YourModel> dataList) {
//        this.context = context;
//        this.dataList = dataList;
//    }
//
//    @Override
//    public int getCount() {
//        return dataList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return dataList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View view;
//        if (convertView == null) {
//            view = LayoutInflater.from(context).inflate(R.layout.item_koloda, parent, false);
//        } else {
//            view = convertView;
//        }
//
//        TextView name = view.findViewById(R.id.name);
//        TextView pitch = view.findViewById(R.id.shortDescription);
//        ImageView image = view.findViewById(R.id.image);
//
//        // Get the current item from the dataList
//        YourModel currentItem = dataList.get(position);
//
//        // Set the text for the profile name and description
//        name.setText(currentItem.name);
//        pitch.setText(currentItem.description);
//
//        // Set the image resource
//        image.setImageResource(currentItem.imageResource);
//
//        return view;
//    }
//
//}
