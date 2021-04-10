package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class listeMatiereActivity extends AppCompatActivity {
    //Attributs
//    private static final int REQUEST_CODE = 0;
    public static final String USER_CONNECTED = "user_key";
    TextView connectedAs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_matiere);
        connectedAs= findViewById(R.id.connectedAs);
        if (getIntent().getStringExtra(USER_CONNECTED) == null){
            connectedAs.setText("Connecté en tant qu'invité");
        }
        else{
            connectedAs.setText("Connecté en tant que "+getIntent().getStringExtra(USER_CONNECTED));
        }
    }

    public void goMath(View view) {
        Intent intent = new Intent(this, ExerciceMathActivity.class);
        startActivity(intent);
    }
    public void goFrancais(View view) {
        Intent intent = new Intent(this, ExerciceFrancaisActivity.class);
        startActivity(intent);
    }
    public void goHG(View view) {
        Intent intent = new Intent(this, ExerciceHistoireGeoActivity.class);
        startActivity(intent);
    }
}