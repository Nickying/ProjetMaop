package com.example.maop.maop;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VoirArticleMagasin extends AppCompatActivity implements View.OnClickListener{
    private TextView nomMagasin;
    private ListView liste;
    private ArrayList<String> tab = new ArrayList<String>();
    private String itemValue;
    private int itemPosition;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voir_article_magasin);

        nomMagasin = (TextView) findViewById(R.id.nomMagasin);
        nomMagasin.setText(getIntent().getStringExtra("magasin"));
        liste = (ListView) findViewById(R.id.listProduit);
        Button btnRetour = (Button) findViewById(R.id.btnRetour);

        btnRetour.setOnClickListener(this);

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
            case R.id.btnRetour:
                finish();
                break;
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
    private void voirArticle(){
        Intent intent = new Intent(this,VoirArticle.class);
        intent.putExtra("article", itemValue);
        startActivityForResult(intent, 1000);
    }
}
