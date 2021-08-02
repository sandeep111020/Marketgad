package com.example.marketgad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<DataHolder> mDataSet;
    static  int i =0;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView anameTxtView, priceview,count;

        ImageView imageView;
        Bitmap bitmap;
        String  encodedString;
        public ViewHolder(View v) {
            super(v);
            count = (TextView) v.findViewById(R.id.listcount);
            anameTxtView=(TextView) v.findViewById(R.id.listname);
            priceview = (TextView) v.findViewById(R.id.listprice);
            imageView=(ImageView) v.findViewById(R.id.listimage);

        }
    }

    public Adapter(List<DataHolder> myData) {
        mDataSet = myData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.anameTxtView.setText(mDataSet.get(position).getDname());
        holder.priceview.setText(mDataSet.get(position).getPrice());
        holder.encodedString = mDataSet.get(position).getDphoto();
        i++;
        holder.count.setText(i+"");
        byte [] encodeByte= Base64.decode(holder.encodedString,Base64.DEFAULT);
        Bitmap bitmap=BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);

        holder.imageView.setImageBitmap(bitmap);
        //Bitmap bitmap=mDataSet.get(position).getDphoto();


    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}