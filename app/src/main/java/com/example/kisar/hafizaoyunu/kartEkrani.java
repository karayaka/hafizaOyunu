package com.example.kisar.hafizaoyunu;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class kartEkrani extends AppCompatActivity {
    String isim;
    TextView tvgelenisim;
    int sonKart=0;
    int skore=0,hata=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kart_ekrani);
        Intent i= getIntent();
         isim= i.getStringExtra("mesaj");
        tvgelenisim=(TextView) findViewById(R.id.etgelenisim);
        tvgelenisim.setText("Hoş Geldiniz:"+isim);
        GridLayout lygrid =(GridLayout)findViewById(R.id.lygrid);
        kart kartlar[] = new kart[16];
        for (int j=1;j<=16;j++){
            kartlar[j-1]=new kart(this,j);
            kartlar[j-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  final kart k=(kart)v;
                    k.cevir();
                    if(sonKart>0){
                        final kart k2=(kart)findViewById(sonKart);
                        if(k2.onPlanId==k.onPlanId&&k2.getId()!=k.getId()){
                            //eslestiler
                            k.cevrilebilir=false;
                            k2.cevrilebilir=false;
                            skore++;
                            TextView tvskor=(TextView)findViewById(R.id.tvskor);
                            tvskor.setText("Skorunuz:"+skore);

                            if(skore==8){
                                //oyun bitti
                                Intent i= new Intent(kartEkrani.this,skoreActivity.class);
                                i.putExtra("puan",hata);
                                i.putExtra("isim",isim);
                                startActivity(i);

                            }
                        }else{
                            //eslesmediler 2 sinide geri çevir
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k2.cevir();
                                    k.cevir();
                                }
                            },500);

                            sonKart=0;
                            hata++;
                            TextView tvhata=(TextView)findViewById(R.id.tvhata);
                            tvhata.setText("Hata Sayınız: "+hata);
                        }
                    }
                    else{
                        sonKart=k.getId();
                    }


                }
            });
        }
        for (int j=0;j<16;j++){
            int rg=(int)(Math.random()*16);
            kart k=kartlar[rg];
            kartlar[rg]=kartlar[j];
            kartlar[j]=k;
        }
        for (int j=0;j<16;j++){
            lygrid.addView(kartlar[j]);
        }


    }

}
