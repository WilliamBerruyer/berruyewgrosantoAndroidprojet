package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet.calculData.CalculAddition;
import com.example.projet.calculData.CalculSoustraction;

public class ExerciceSoustractionActivity extends AppCompatActivity {
    private static final int HELLO_REQUEST = 0;
    int n;
    TextView nbTour;
    TextView calculTxt;
    EditText answer;
    Button next;
    CalculSoustraction calcul;
    String[] arrayQuestion = new String[11];
    String[] arrayBon = new String[11];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice_addition);

        nbTour = findViewById(R.id.nbTour);
        calculTxt = findViewById(R.id.questionTxt);
        answer = findViewById(R.id.réponse);
        next = findViewById(R.id.rep1);

        n=1;
        nbTour.setText("Question n°"+n);
        calcul = new CalculSoustraction();
        calculTxt.setText(calcul.getNombre1()+" - "+calcul.getNombre2());
        arrayQuestion[1]= calcul.getNombre1() + " - " + calcul.getNombre2() + " = " + calcul.getResultat();



    }

    public void clicValider(View view) {
        if (!answer.getText().toString().equals("")){
            if (n==10){
                if (calcul.getResultat()==Integer.parseInt(answer.getText().toString())){
                    arrayBon[10]= "ok";
                }
                else{
                    arrayBon[10]= "notok";
                }
                // Création d'une intention
                Intent AddidtionIntent = new Intent(ExerciceSoustractionActivity.this, ExerciceAdditionResultActivity.class);

                // Lancement de la demande de changement d'activité

                AddidtionIntent.putExtra(ExerciceAdditionResultActivity.ARRAYQUESTION, arrayQuestion);
                AddidtionIntent.putExtra(ExerciceAdditionResultActivity.ARRAYBON, arrayBon);
                startActivity(AddidtionIntent);
            }
            else{
                if (calcul.getResultat()==Integer.parseInt(answer.getText().toString())){
                    arrayBon[n]= "ok";
                }
                else{
                    arrayBon[n]= "notok";
                }
                n=n+1;
                nbTour.setText("Question n°"+n);
                calcul = new CalculSoustraction();
                calculTxt.setText(calcul.getNombre1()+" - "+calcul.getNombre2());
                answer.setText("");
                arrayQuestion[n]= calcul.getNombre1() + " - " + calcul.getNombre2() + " = " + calcul.getResultat();
            }
        }

    }
}
