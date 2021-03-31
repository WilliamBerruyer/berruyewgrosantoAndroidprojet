package com.example.projet;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciceAdditionActivity extends AppCompatActivity {

    TextView nbTour;
    TextView calcul;
    EditText answer;
    Button prev;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice_addition);

        nbTour = findViewById(R.id.nbTour);
        calcul = findViewById(R.id.calcul);
        answer = findViewById(R.id.answer);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);



    }
}
