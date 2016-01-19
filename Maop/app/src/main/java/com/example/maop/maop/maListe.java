package com.example.maop.maop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class maListe extends AppCompatActivity implements View.OnClickListener{

    final String magasin = "magasin";

    private ListView liste;
    private String[] tab;

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
        liste = (ListView) findViewById(R.id.listProduit);

        Btnquitter.setOnClickListener(this);
        Btnajout.setOnClickListener(this);
        Btnmodif.setOnClickListener(this);

        Afficher afficher = new Afficher();

        affiche(afficher);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, tab);
        liste.setAdapter(adapter);

         liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) liste.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();

            }

        });

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

    private void affiche(Afficher afficher){

        tab = new String[6];
        for(int i=0;i<tab.length;i++){
            tab[i] = afficher.getTab(i);
        }
    }
}
