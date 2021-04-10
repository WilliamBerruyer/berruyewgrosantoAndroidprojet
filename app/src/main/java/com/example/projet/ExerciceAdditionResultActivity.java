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


public class ExerciceAdditionResultActivity extends AppCompatActivity {
    public static final String ARRAYQUESTION ="arrayQ";
    public static final String ARRAYBON ="arrayB";
    int nbError = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_addition_result);
        Bundle extras = getIntent().getExtras();
        String[] arrayQuestion = extras.getStringArray("arrayQ");
        String[] arrayBon = extras.getStringArray("arrayB");
        TextView result1 = findViewById(R.id.result1);
        TextView result2 = findViewById(R.id.result2);
        TextView result3 = findViewById(R.id.result3);
        TextView result4 = findViewById(R.id.result4);
        TextView result5 = findViewById(R.id.result5);
        TextView result6 = findViewById(R.id.result6);
        TextView result7 = findViewById(R.id.result7);
        TextView result8 = findViewById(R.id.result8);
        TextView result9 = findViewById(R.id.result9);
        TextView result10 = findViewById(R.id.result10);
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
        result4.setText(arrayQuestion[4]);
        if (arrayBon[4].equals("ok")){
            result4.setTextColor(0xff00ff00);
        }
        else{
            result4.setTextColor(0xffff0000);
            nbError=nbError+1;
        }
        result5.setText(arrayQuestion[5]);
        if (arrayBon[5].equals("ok")){
            result5.setTextColor(0xff00ff00);
        }
        else{
            result5.setTextColor(0xffff0000);
            nbError=nbError+1;
        }
        result6.setText(arrayQuestion[6]);
        if (arrayBon[6].equals("ok")){
            result6.setTextColor(0xff00ff00);
        }
        else{
            result6.setTextColor(0xffff0000);
            nbError=nbError+1;
        }
        result7.setText(arrayQuestion[7]);
        if (arrayBon[7].equals("ok")){
            result7.setTextColor(0xff00ff00);
        }
        else{
            result7.setTextColor(0xffff0000);
            nbError=nbError+1;
        }
        result8.setText(arrayQuestion[8]);
        if (arrayBon[8].equals("ok")){
            result8.setTextColor(0xff00ff00);
        }
        else{
            result8.setTextColor(0xffff0000);
            nbError=nbError+1;
        }
        result9.setText(arrayQuestion[9]);
        if (arrayBon[9].equals("ok")){
            result9.setTextColor(0xff00ff00);
        }
        else{
            result9.setTextColor(0xffff0000);
            nbError=nbError+1;
        }
        result10.setText(arrayQuestion[10]);
        if (arrayBon[10].equals("ok")){
            result10.setTextColor(0xff00ff00);
        }
        else{
            result10.setTextColor(0xffff0000);
            nbError=nbError+1;
        }
        errorTxt.setText("Tu as fait : "+nbError+" erreur(s)");
    }

    public void goMain(View view){
        Intent intent = new Intent(this, ExerciceMathActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}