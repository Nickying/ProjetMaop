package com.example.maop.maop;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VoirProduit extends AppCompatActivity implements View.OnClickListener {

    private TextView nomArticle;
    private Button btnRetour;
    private Button btnAjout;
    private Button btnPlus;
    private Button btnMoins;
    private EditText txtQuatite;
    private TextView description;
    private String article;
    private String value;
    private String id;
    private String itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voir_produit);

        nomArticle =(TextView) findViewById(R.id.nomArticle);
        article = getIntent().getStringExtra("article");
        nomArticle.setText(article);
        id = getIntent().getStringExtra("id");
        itemPosition = getIntent().getStringExtra("idarticle");

        btnRetour = (Button) findViewById(R.id.btnRetourProduit);
        btnAjout = (Button) findViewById(R.id.btnAjoutProduit);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMoins = (Button) findViewById(R.id.btnMoins);
        txtQuatite = (EditText) findViewById(R.id.editText);
        description = (TextView) findViewById(R.id.txtDescription);

        btnRetour.setOnClickListener(this);
        btnAjout.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMoins.setOnClickListener(this);

        //afficher();
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnRetourProduit:
                value="1";
                finish();
                break;
            case R.id.btnAjoutProduit:
                ajouter();
                break;

            case R.id.btnPlus:
                String quantite = txtQuatite.getText().toString();
                int i=Integer.parseInt(quantite.replaceAll("[\\D]", ""));
                i++;
                txtQuatite.setText(String.valueOf(i));
                break;
            case R.id.btnMoins:
                String quantite2 = txtQuatite.getText().toString();
                int i2=Integer.parseInt(quantite2.replaceAll("[\\D]", ""));
                if(i2>1){
                    i2--;
                }
                txtQuatite.setText(String.valueOf(i2));
                break;
        }
    }
    /*private void afficher(){
        ArticleManager am = new ArticleManager(this);
        am.open();
        int i=Integer.parseInt(value.replaceAll("[\\D]", ""));
        //Cursor c = am.getArticleid(getIntent().getStringExtra("value"));
        Cursor c = am.getArticleid("1");
        if (c.moveToFirst())
        {

               description.setText(c.getString(c.getColumnIndex(ArticleManager.KEY_DESCRIPTION)));

        }
        c.close();
    }*/

    private void ajouter(){
        ArticleManager am = new ArticleManager(this);
        am.open();
        int i=Integer.parseInt(itemPosition.replaceAll("[\\D]", ""));
        int quantite=Integer.parseInt(txtQuatite.getText().toString().replaceAll("[\\D]", ""));
        int idma=Integer.parseInt(id.toString().replaceAll("[\\D]", ""));
        am.addListe(i,quantite,idma);
        finish();
    }
}
