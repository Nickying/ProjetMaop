package com.example.maop.maop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VoirProduit extends AppCompatActivity implements View.OnClickListener {

    private TextView nomArticle;
    private Button btnRetour;
    private Button btnAjout;
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voir_produit);

        nomArticle =(TextView) findViewById(R.id.nomArticle);
        value = getIntent().getStringExtra("article");
        nomArticle.setText(value);

        btnRetour = (Button) findViewById(R.id.retour);
        btnAjout = (Button) findViewById(R.id.btnAjoutProduit);

        btnRetour.setOnClickListener(this);
        btnAjout.setOnClickListener(this);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.supprimer:
                value="1";
                finish();
                break;
            case R.id.modification:
                finish();
            case R.id.retour:
                value="retour";
                finish();
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
}