package com.example.maop.maop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Accueil extends AppCompatActivity implements View.OnClickListener {

    String auchan;
    String carrefour;
    String inter;
    String leclerc;

    final String magasin = "magasin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        ImageButton BtnAuchan = (ImageButton) findViewById(R.id.imgBoutique1);
        ImageButton BtnCarrefour = (ImageButton) findViewById(R.id.imgBoutique2);
        ImageButton BtnInter = (ImageButton) findViewById(R.id.imgBoutique3);
        ImageButton BtnLeclerc = (ImageButton) findViewById(R.id.imgBoutique4);

        BtnAuchan.setOnClickListener(this);
        BtnCarrefour.setOnClickListener(this);
        BtnInter.setOnClickListener(this);
        BtnLeclerc.setOnClickListener(this);

        auchan="auchan";
        carrefour="carrefour";
        inter="inter";
        leclerc="leclerc";
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.imgBoutique1:
                lancerAuchan();
                break;
            case R.id.imgBoutique2:
                lancerCarrefour();
                break;
            case R.id.imgBoutique3:
                lancerInter();
                break;
            case R.id.imgBoutique4:
                lancerLeclerc();
                break;
        }
    }

    private void lancerAuchan(){
        Intent liste = new Intent(this,Liste.class);
        liste.putExtra(magasin,auchan);
        startActivity(liste);
    }

    private void lancerCarrefour(){
        Intent liste = new Intent(this,Liste.class);
        liste.putExtra(magasin, carrefour);
        startActivity(liste);
    }

    private void lancerInter(){
        Intent liste = new Intent(this,Liste.class);
        liste.putExtra(magasin, inter);
        startActivity(liste);
    }

    private void lancerLeclerc(){
        Intent liste = new Intent(this,Liste.class);
        liste.putExtra(magasin,leclerc);
        startActivity(liste);
    }
}
