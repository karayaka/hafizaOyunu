package com.example.kisar.hafizaoyunu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class skoreActivity extends AppCompatActivity {

    TextView tvad,tvskor,tvhata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skore);
        tvad=(TextView)findViewById(R.id.tvad);
        tvhata=(TextView)findViewById(R.id.tvhata);
        tvskor=(TextView)findViewById(R.id.tvskorfinal);
        Intent i=getIntent();
        String isim= i.getStringExtra("isim");
        int skor= i.getIntExtra("puan",0);
        tvad.setText("Tebrikler: "+isim);
        tvhata.setText("Hata: "+skor);
        tvskor.setText("Skor ile kazandınız");


    }
}
