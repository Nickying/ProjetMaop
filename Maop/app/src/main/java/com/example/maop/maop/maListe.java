package com.example.maop.maop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class maListe extends AppCompatActivity implements View.OnClickListener{

    final String magasin = "magasin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_liste);

        TextView nomMagasin = (TextView) findViewById(R.id.nomMagasin);
        String value = getIntent().getStringExtra(magasin);
        nomMagasin.setText(value);
        Button Btnquitter = (Button) findViewById(R.id.btnquitter);
        Button Btnajout = (Button) findViewById(R.id.btnajout);
        Button Btnmodif = (Button) findViewById(R.id.btnmodif);

        Btnquitter.setOnClickListener(this);
        Btnajout.setOnClickListener(this);
        Btnmodif.setOnClickListener(this);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnquitter:
                quitter();
                break;
        }
    }

    private void quitter(){
        finish();
    }
}
