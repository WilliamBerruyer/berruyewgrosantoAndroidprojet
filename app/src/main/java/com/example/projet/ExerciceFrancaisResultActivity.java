package com.example.projet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ExerciceFrancaisResultActivity extends AppCompatActivity {
    public static final String ARRAYQUESTION ="arrayQ";
    public static final String ARRAYBON ="arrayB";
    int nbError = 0;
    //
//    ArrayList<String> arrayQuestion = intent.getStringArrayListExtra("arrayQ");
//    String[] arrayQuestion = getIntent().getExtras().getStringArray("arrayQ");
//    String[] arrayBon = getIntent().getExtras().getStringArray("arrayB");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_francais_result);
        Bundle extras = getIntent().getExtras();
        String[] arrayQuestion = extras.getStringArray("arrayQ");
        String[] arrayBon = extras.getStringArray("arrayB");
        TextView result1 = findViewById(R.id.result1);
        TextView result2 = findViewById(R.id.result2);
        TextView result3 = findViewById(R.id.result3);
        TextView errorTxt = findViewById(R.id.Nberror);
        result1.setText(arrayQuestion[1]);
        if (arrayBon[1].equals("ok")){
            result1.setTextColor(0xff00ff00);
        }
        else{
            result1.setTextColor(0xffff0000);
            nbError=nbError+1;
        }
        result2.setText(arrayQuestion[2]);
        if (arrayBon[2].equals("ok")){
            result2.setTextColor(0xff00ff00);
        }
        else{
            result2.setTextColor(0xffff0000);
            nbError=nbError+1;
        }
        result3.setText(arrayQuestion[3]);
        if (arrayBon[3].equals("ok")){
            result3.setTextColor(0xff00ff00);
        }
        else{
            result3.setTextColor(0xffff0000);
            nbError=nbError+1;
        }

        errorTxt.setText("Tu as fait : "+nbError+" erreur(s)");
    }

    public void goMain(View view){
        Intent intent = new Intent(this, listeMatiereActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}