package com.example.projet;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TableMultiplicationActivity extends AppCompatActivity {
    public static final String NOMBRE ="nombre_key";
    public final static int RESULT_REQUEST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_table_mutliplication);
        int valeur = getIntent().getIntExtra(NOMBRE,0);
        TextView text1 = findViewById(R.id.textView9);
        TextView text2 = findViewById(R.id.textView12);
        TextView text3 = findViewById(R.id.textView13);
        text1.setText(" " + valeur);
        text2.setText(" " + valeur);
        text3.setText(" " + valeur);
    }


    public void clicVal (View v){
        EditText e1 = findViewById(R.id.edit1);

        EditText e2 = findViewById(R.id.edit2);
        EditText e3 = findViewById(R.id.edit3);
        int valeur = getIntent().getIntExtra(NOMBRE,0);
        int nbErreur=0;
        if (Integer.parseInt(e1.getText().toString()) != valeur*1){
            nbErreur=nbErreur+1;
        }
        if (Integer.parseInt(e2.getText().toString()) != valeur*2){
            nbErreur=nbErreur+1;
        }
        if (Integer.parseInt(e3.getText().toString()) != valeur*3){
            nbErreur=nbErreur+1;
        }
        if (nbErreur>0){
            Intent intent = new Intent(this, ErreurTableMulActivity.class);
            intent.putExtra(ErreurTableMulActivity.NB_ERREUR, nbErreur);
            startActivityForResult(intent, RESULT_REQUEST);
        }
        else{
            Intent intent = new Intent(this, FelicitationTableMulActivity.class);
            startActivityForResult(intent, RESULT_REQUEST);
        }
    }
}
