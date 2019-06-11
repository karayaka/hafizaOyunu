package com.example.kisar.hafizaoyunu;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;

/**
 * Created by kisar on 6.06.2019.
 */


public class kart extends android.support.v7.widget.AppCompatButton {
    boolean acikmi=false,cevrilebilir=true;
    int resimID;
    int arkaPlanId;
    int onPlanId=0;
    Drawable arka,on;
    public kart(Context context,int id) {
        super(context);
        setId(id);
        arkaPlanId=R.drawable.star;
        if(id%8==1){
           onPlanId=R.drawable.cart1;
        }
        if(id%8==2){
            onPlanId=R.drawable.cart2;
        }
        if(id%8==3){
            onPlanId=R.drawable.cart3;
        }
        if(id%8==4){
            onPlanId=R.drawable.cart4;
        }
        if(id%8==5){
            onPlanId=R.drawable.cart5;
        }
        if(id%8==6){
            onPlanId=R.drawable.cart6;
        }
        if(id%8==7){
            onPlanId=R.drawable.cart7;
        }
        if(id%8==0){
            onPlanId=R.drawable.cart8;
        }
        arka= AppCompatDrawableManager.get().getDrawable(context,arkaPlanId);
        on= AppCompatDrawableManager.get().getDrawable(context,onPlanId);
        setBackground(arka);

    }
    public void cevir(){
        if(cevrilebilir){
            if(!acikmi){//arkası cevriliyse
                setBackground(on);
                acikmi=true;
            }else{
                setBackground(arka);
                acikmi=false;
            }

        }


    }



}
