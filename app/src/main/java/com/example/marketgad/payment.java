package com.example.marketgad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class payment extends AppCompatActivity {
    TextView  textView;
String count,amount;
ImageView watsapp,messng;
TextView Rpay;
TextView countview,amountview;
    ArrayList<String> names;
    EditText mobile;
    String smsNumber;
    View pdfFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        textView=findViewById(R.id.textView);
        countview=findViewById(R.id.itemcount);
        amountview=findViewById(R.id.totalamount);
        watsapp=findViewById(R.id.watsapp);
        messng=findViewById(R.id.messenging);
        mobile=findViewById(R.id.mobinumber);
        //pdfFile=findViewById(R.drawable.pdf);
        Rpay=findViewById(R.id.Rmessenging);
        count=getIntent().getStringExtra("count");
        amount=getIntent().getStringExtra("total");
        count="3";
        amount="500";
        countview.setText(count);
        amountview.setText(amount);
        watsapp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                smsNumber=mobile.getText().toString();
                Intent sendIntent = new Intent("android.intent.action.MAIN");
                //sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, "You have just purchased items worth"+amount+"from General Store.Please find the below pdf.To proceed with your payment. Click the below link");
                sendIntent.putExtra("jid", smsNumber + "@s.whatsapp.net");
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);

                Uri uri = Uri.fromFile(getFileStreamPath(String.valueOf(R.raw.pdf)));
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("application/pdf");
                share.putExtra(Intent.EXTRA_STREAM, uri);
                share.setPackage("com.whatsapp");
                startActivity(share);
            }
        });
        messng.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                smsNumber=mobile.getText().toString();
                Intent sendIntent = new Intent("android.intent.action.MAIN");
                //sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, "You have just purchased items worth"+amount+"from General Store.Please find the below pdf.To proceed with your payment. Click the below link");
                sendIntent.putExtra("jid", smsNumber + "@s.whatsapp.net");
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
            }
        });
        Rpay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                smsNumber=mobile.getText().toString();
                Intent sendIntent = new Intent("android.intent.action.MAIN");
                //sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, "You have just purchased items worth"+amount+"from General Store.Please find the below pdf.To proceed with your payment. Click the below link");
                sendIntent.putExtra("jid", smsNumber + "@s.whatsapp.net");
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
            }
        });
    }
}