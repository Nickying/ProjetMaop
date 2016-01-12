package com.example.maop.maop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class maListe extends AppCompatActivity {

    final String magasin = "magasin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_liste);

        TextView nomMagasin = (TextView) findViewById(R.id.nomMagasin);
        String value = getIntent().getStringExtra(magasin);
        nomMagasin.setText(value);
    }
}
