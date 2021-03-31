package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ExerciceMultiplicationActivity extends AppCompatActivity {
    public final static int HELLO_REQUEST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice_table_mul);
        NumberPicker np = (NumberPicker) findViewById(R.id.np);
        //Set the minimum value of NumberPicker
        np.setMinValue(1);
        //Specify the maximum value/number of NumberPicker
        np.setMaxValue(10);
        np.setWrapSelectorWheel(true);

    }

    public void onClickValider (View v){
        NumberPicker np = (NumberPicker) findViewById(R.id.np);
        Intent intent = new Intent(this, TableMultiplicationActivity.class);
        int valeur = np.getValue();
        intent.putExtra(TableMultiplicationActivity.NOMBRE, valeur);
        startActivityForResult(intent,HELLO_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == HELLO_REQUEST) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Retour Ok", Toast.LENGTH_SHORT).show();
            } else if (requestCode == RESULT_CANCELED) {
                Toast.makeText(this,"Retour cancel/back",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
