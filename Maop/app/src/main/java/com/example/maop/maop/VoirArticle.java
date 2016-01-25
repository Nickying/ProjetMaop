package com.example.maop.maop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VoirArticle extends AppCompatActivity implements View.OnClickListener{
    private TextView nomArticle;
    private Button btnRetour;
    private Button btnModif;
    private Button btnSupp;
    private Button btnPlus;
    private Button btnMoins;
    private EditText txtQuatite;
    private TextView description;
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voir_article);

        nomArticle =(TextView) findViewById(R.id.nomArticle);
        value = getIntent().getStringExtra("article");
        nomArticle.setText(value);

        btnRetour = (Button) findViewById(R.id.retour);
        btnModif = (Button) findViewById(R.id.modification);
        btnSupp = (Button) findViewById(R.id.supprimer);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMoins = (Button) findViewById(R.id.btnMoins);
        txtQuatite = (EditText) findViewById(R.id.editText);
        description = (TextView) findViewById(R.id.txtQuantite);

        btnRetour.setOnClickListener(this);
        btnModif.setOnClickListener(this);
        btnSupp.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMoins.setOnClickListener(this);

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.supprimer:
                value="1";
                finish();
                break;
            case R.id.modification:
                finish();
                break;
            case R.id.retour:
                value="3";
                finish();
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

    public void finish() {
        // Prepare data intent
        Intent data = new Intent();
        data.putExtra("value", value);
        // Activity finished ok, return the data
        setResult(RESULT_OK, data);
        super.finish();
    }
    @Override
    public void onBackPressed() {
        value="2";
        finish(); // Do Here what ever you want do on back press;
    }
}
