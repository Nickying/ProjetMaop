package com.example.maop.maop;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class maListe extends AppCompatActivity implements View.OnClickListener{

    final String shop = "magasin";

    private ListView liste;
    private ArrayList<String> tab = new ArrayList<String>();
    private String itemValue;
    private int itemPosition;
    private ArrayAdapter<String> adapter;
    private String magasin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_liste);

        TextView nomMagasin = (TextView) findViewById(R.id.nomMagasin);
        magasin = getIntent().getStringExtra(shop);
        nomMagasin.setText(magasin);
        Button Btnquitter = (Button) findViewById(R.id.btnquitter);
        Button Btnajout = (Button) findViewById(R.id.btnajout);
        Button Btnmodif = (Button) findViewById(R.id.btnmodif);
        liste = (ListView) findViewById(R.id.listProduit);

        Btnquitter.setOnClickListener(this);
        Btnajout.setOnClickListener(this);
        Btnmodif.setOnClickListener(this);

        afficher();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, tab);
        liste.setAdapter(adapter);

         liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                itemPosition = position;

                // ListView Clicked item value
                itemValue = (String) liste.getItemAtPosition(position);
                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();
                voirArticle();

            }

        });

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnquitter:
                quitter();
                break;
            case R.id.btnajout:
                ajoutProduit();
                break;
        }
    }

    private void quitter(){
        finish();
    }

    private void ajoutProduit(){
        Intent intent = new Intent(this,VoirArticleMagasin.class);
        intent.putExtra("magasin",magasin);
        startActivity(intent);
    }
    private void voirArticle(){
        Intent intent = new Intent(this,VoirArticle.class);
        intent.putExtra("article",itemValue);
        startActivityForResult(intent,1000);
    }

   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1000) {

            String s=data.getExtras().getString("value");
            int i=Integer.parseInt(s.replaceAll("[\\D]", ""));
            if (i==1) {
                Toast.makeText(this, data.getExtras().getString("value"),
                        Toast.LENGTH_SHORT).show();
                tab.remove(itemPosition);
                adapter.notifyDataSetChanged();
            }
            else if (i==2){
                Toast.makeText(this, data.getExtras().getString("value"),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void afficher(){
        ArticleManager am = new ArticleManager(this);
        am.open();

        Cursor c = am.getAnimaux();
        if (c.moveToFirst())
        {
            do {
                tab.add(c.getString(c.getColumnIndex(ArticleManager.KEY_NOMARTICLE)));
                System.out.println(c.getString(c.getColumnIndex(ArticleManager.KEY_NOMARTICLE)));
            }
            while (c.moveToNext());
        }
        c.close();
    }


}
