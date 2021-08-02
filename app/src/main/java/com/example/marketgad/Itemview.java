package com.example.marketgad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Itemview extends AppCompatActivity {
    TextView datasiplay,totalamount,itemcount,displaydate;
    ImageView dispimage;
    ArrayList<String> prices = new ArrayList<String>();
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> imagestrings = new ArrayList<String>();
    RecyclerView recyclerView;
    String count,total;
    LinearLayout upload;
    List<DataHolder> holderList=new ArrayList<DataHolder>();
    private LinearLayoutManager mLayoutManager;
    private Adapter mAdapter;

    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemview);
        datasiplay=findViewById(R.id.datadisplay);
        totalamount=findViewById(R.id.totalamount);
        displaydate=findViewById(R.id.displaydate);
        recyclerView=findViewById(R.id.recyclerview);
        upload=findViewById(R.id.upload);
        itemcount=findViewById(R.id.itemcount);
        count=getIntent().getStringExtra("items");
        total=getIntent().getStringExtra("total");
        prices=getIntent().getStringArrayListExtra("price");
        //names=getIntent().getStringArrayExtra("names");

        names= getIntent().getStringArrayListExtra("names");
        itemcount.setText(count);
        imagestrings=getIntent().getStringArrayListExtra("imagestrings");
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        date = dateFormat.format(calendar.getTime());
        displaydate.setText("Date :"+date+"|  GST No: ABCD12E");

        //datasiplay.setText(String.valueOf(imagestrings));
  //      Bitmap bmp = (Bitmap)this.getIntent().getParcelableExtra("bmp");
//        dispimage.setImageBitmap(bmp);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Itemview.this,payment.class);
                i.putExtra("total",total);
                i.putExtra("count",count);
                startActivity(i);
            }
        });
        totalamount.setText(getIntent().getStringExtra("total"));
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        setItems();
        mAdapter = new Adapter(holderList);
        recyclerView.setAdapter(mAdapter);
    }

    private void setItems() {

        for(int i=0;i<names.size();i++){
            DataHolder item=new DataHolder();
            item.setDname(names.get(i));
            item.setDphoto(imagestrings.get(i));
            item.setPrice(prices.get(i));
            holderList.add(item);
        }

    }
}