package com.example.maop.maop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class Accueil extends AppCompatActivity implements View.OnClickListener {

    private String auchan;
    private String carrefour;
    private String inter;
    private String leclerc;
    private String value;

    final String magasin = "magasin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        ImageButton BtnAuchan = (ImageButton) findViewById(R.id.imgBoutique1);
        ImageButton BtnCarrefour = (ImageButton) findViewById(R.id.imgBoutique2);
        ImageButton BtnInter = (ImageButton) findViewById(R.id.imgBoutique3);
        ImageButton BtnLeclerc = (ImageButton) findViewById(R.id.imgBoutique4);
        Button Btnquitter = (Button) findViewById(R.id.btnquitter);

        BtnAuchan.setOnClickListener(this);
        BtnCarrefour.setOnClickListener(this);
        BtnInter.setOnClickListener(this);
        BtnLeclerc.setOnClickListener(this);
        Btnquitter.setOnClickListener(this);

        auchan="Auchan";
        carrefour="Carrefour";
        inter="Intermarché";
        leclerc="Leclerc";
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
            case R.id.btnquitter:
                quitter();
                break;
        }
    }

    private void lancerAuchan(){
        Intent liste = new Intent(this,maListe.class);
        value = "3";
        liste.putExtra(magasin,auchan);
        liste.putExtra("value",value);
        startActivity(liste);
    }

    private void lancerCarrefour(){
        Intent liste = new Intent(this,maListe.class);
        value = "1";
        liste.putExtra(magasin, carrefour);
        liste.putExtra("value",value);
        startActivity(liste);
    }

    private void lancerInter(){
        Intent liste = new Intent(this,maListe.class);
        value = "2";
        liste.putExtra(magasin, inter);
        liste.putExtra("value",value);
        startActivity(liste);
    }

    private void lancerLeclerc(){
        Intent liste = new Intent(this,maListe.class);
        value = "4";
        liste.putExtra(magasin,leclerc);
        liste.putExtra("value",value);
        startActivity(liste);
    }

    private void quitter(){
        finish();
    }

}
