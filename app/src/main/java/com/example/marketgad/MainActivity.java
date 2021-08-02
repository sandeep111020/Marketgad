package com.example.marketgad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView one,two,three,four,five,six,seven,eight,nine,zero,plus,mul,dot,clear,run,equal,total,current,count;
    EditText name;
    ImageView image;
    String temp="0",zerotemp="0";
    String totalvalue,imagedata;
    private static final int CAMERA_REQUEST = 1888;
    ArrayList<String> prices = new ArrayList<String>();
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> imagestrings = new ArrayList<String>();
    int totalintvalue=0,countvalue=0;
    Bitmap photo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one=findViewById(R.id.button1);
        two=findViewById(R.id.button2);
        three=findViewById(R.id.button3);
        four=findViewById(R.id.button4);
        five=findViewById(R.id.button5);
        six=findViewById(R.id.button6);
        seven=findViewById(R.id.button7);
        eight=findViewById(R.id.button8);
        nine=findViewById(R.id.button9);
        zero=findViewById(R.id.button0);
        plus=findViewById(R.id.buttonplus);
        mul=findViewById(R.id.buttonmul);
        clear=findViewById(R.id.buttonclear);
        dot=findViewById(R.id.buttondot);
        run=findViewById(R.id.buttonrun);
        equal=findViewById(R.id.buttonequal);
        total=findViewById(R.id.totalamount);
        current=findViewById(R.id.currentamount);
        count=findViewById(R.id.count);
        image=findViewById(R.id.imageView2);
        name=findViewById(R.id.editTextTextPersonName2);
        Toast.makeText(MainActivity.this,"Click Plus to Add Items",Toast.LENGTH_SHORT).show();

        StringBuffer sb= new StringBuffer(temp);

        sb.deleteCharAt(sb.length()-1);
        temp= String.valueOf(sb);
        current.setText(temp);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=temp+"1";
                current.setText(temp);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=temp+"2";
                current.setText(temp);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=temp+"3";
                current.setText(temp);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=temp+"4";
                current.setText(temp);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=temp+"5";
                current.setText(temp);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=temp+"6";
                current.setText(temp);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=temp+"7";
                current.setText(temp);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=temp+"8";
                current.setText(temp);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=temp+"9";
                current.setText(temp);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=temp+"0";
                current.setText(temp);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current.setText(temp);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MainActivity.class);
                startActivity(i);

            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(name.getText().toString())&&TextUtils.isEmpty(imagedata)){
                    Toast.makeText(MainActivity.this,"Please enter Name of product and upload image",Toast.LENGTH_SHORT).show();
                }
                else {
                    totalintvalue= Integer.parseInt(temp)+totalintvalue;

                    prices.add(temp);

                    names.add(name.getText().toString());
                    imagestrings.add(imagedata);
                    totalvalue= String.valueOf(totalintvalue);
                    temp=zerotemp;
                    countvalue++;

                    count.setText(countvalue+"");
                    current.setText(temp);
                    total.setText(totalvalue);
                    name.setText("");

                }

            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,payment.class);
                startActivity(i);
                current.setText(temp);
            }
        });
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Itemview.class);
                i.putExtra("names",names);
                i.putExtra("imagestrings",imagestrings);
                i.putExtra("price",prices);
                i.putExtra("bmp",photo);
                i.putExtra("total",totalvalue);
                i.putExtra("items",String.valueOf(countvalue));
                startActivity(i);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuffer sb= new StringBuffer(temp);

                sb.deleteCharAt(sb.length()-1);
                temp= String.valueOf(sb);
                current.setText(temp);
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST) {


           /* Uri contentUri = data.getData();
            String[] proj = { MediaStore.Images.Media.DATA };
            Cursor cursor = managedQuery(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            String tmppath = cursor.getString(column_index);
            Bitmap croppedImage = BitmapFactory.decodeFile(tmppath);

            image.setImageBitmap(croppedImage);*/

            // Bitmap croppedImage = BitmapFactory.decodeFile(croppedImage);


            Uri contentUri= data.getData();
            photo = (Bitmap) data.getExtras().get("data");
            imagedata= String.valueOf(data.getExtras().get("data"));
           //name.setText(String.valueOf(data.getExtras().get("data")));
            ByteArrayOutputStream ByteStream=new  ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG,100, ByteStream);
            byte [] b=ByteStream.toByteArray();
            String tempo= Base64.encodeToString(b, Base64.DEFAULT);
            imagestrings.add(tempo);
            image.setImageBitmap(photo);

        }
    }


}