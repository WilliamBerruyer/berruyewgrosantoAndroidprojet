package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projet.db.DatabaseClient;
import com.example.projet.dbQuestion.Question;
import com.example.projet.dbQuestion.QuestionHG;

import java.util.List;
import java.util.Random;


public class ExerciceHistoireGeoActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;
    private DatabaseClient mdb;
    private List<QuestionHG> listeQuestionsAll;
    QuestionHG[] listeQuestionsPassees = new QuestionHG[4];
    String[] arrayQuestion = new String[4];
    String[] arrayBon = new String[4];
    private TextView questionTxt;
    private TextView rep1;
    private TextView rep2;
    private TextView rep3;
    int n = 1;
    TextView nbTour;
    QuestionHG q;

    private List<QuestionHG> QuestionList;

    public ExerciceHistoireGeoActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_francais);

        // Récupération du DatabaseClient
        mdb = DatabaseClient.getInstance(getApplicationContext());
        getQuestions();
        questionTxt = findViewById(R.id.questionTxt);
        nbTour = findViewById(R.id.nbTour);
        nbTour.setText("Question n°1");
        rep1 = findViewById(R.id.rep1);
        rep2 = findViewById(R.id.rep2);
        rep3 = findViewById(R.id.rep3);
    }

    //Pour récupérer toutes les questions
    private void getQuestions() {
        ///////////////////////
        // Classe asynchrone permettant de récupérer des taches et de mettre à jour le listView de l'activité
        class GetQuestions extends AsyncTask<Void, Void, List<QuestionHG>> {

            @Override
            protected List<QuestionHG> doInBackground(Void... voids) {
                QuestionList = mdb.getAppDatabase().questionHGDAO().getAll();
                listeQuestionsAll = mdb.getAppDatabase().questionHGDAO().getAll();
                return QuestionList;
            }

            @Override
            protected void onPostExecute(List<QuestionHG> questions) {
                super.onPostExecute(questions);
                affiche();

            }
        }
        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        // Création d'un objet de type GetQuestions et execution de la demande asynchrone
        GetQuestions gt = new GetQuestions();
        gt.execute();

    }
    @Override
    protected void onStart() {
        super.onStart();

        // Mise à jour des questions
        getQuestions();

    }
    @Override
    protected void onResume() {
        super.onResume();

        // Mise à jour des questons
        getQuestions();

    }

    private void affiche(){
        Random rand = new Random();
        int i;
        i = +rand.nextInt(listeQuestionsAll.size());
        if (i==0){
            i=1;
        }
        q=listeQuestionsAll.get(i);
        listeQuestionsPassees[1]=q;
        questionTxt.setText(q.getQuestion());
        arrayQuestion[1]=(q.getQuestion()+ " "+q.getBonneRéponse() +"\n");
        setAfficheQuestion(q);

    }

    //Générer une nouvelle question
    private void newQuestion(int n){
        Random rand = new Random();
        boolean b = false;
        int i = 0;
        while (!b){
            b=true;
            i = rand.nextInt(listeQuestionsAll.size());
            if (i==0){
                i=1;
            }
            for (QuestionHG quest : listeQuestionsPassees) {
                if (quest != null){
                    if (quest.getQuestion().equals(listeQuestionsAll.get(i).getQuestion())){
                        b=false;
                    }
                }
            }
        }
        q=listeQuestionsAll.get(i);
        listeQuestionsPassees[n]=q;
        questionTxt.setText(q.getQuestion());
        arrayQuestion[n]=q.getQuestion() +" "+ q.getBonneRéponse()+"\n";
        setAfficheQuestion(q);
    }

    //Générer l'affichage des réponses
    private void setAfficheQuestion(QuestionHG q){
        Random rand = new Random();
        int i = 1+rand.nextInt(5);
        if (i==1){
            rep1.setText(q.getBonneRéponse());
            rep2.setText(q.getFausseRéponseUn());
            rep3.setText(q.getFausseRéponseDeux());
        }
        if (i==2){
            rep1.setText(q.getBonneRéponse());
            rep3.setText(q.getFausseRéponseUn());
            rep2.setText(q.getFausseRéponseDeux());
        }
        if (i==3){
            rep3.setText(q.getBonneRéponse());
            rep1.setText(q.getFausseRéponseUn());
            rep2.setText(q.getFausseRéponseDeux());
        }
        if (i==4){
            rep2.setText(q.getBonneRéponse());
            rep1.setText(q.getFausseRéponseUn());
            rep3.setText(q.getFausseRéponseDeux());
        }
        if (i==5){
            rep2.setText(q.getBonneRéponse());
            rep3.setText(q.getFausseRéponseUn());
            rep1.setText(q.getFausseRéponseDeux());
        }
        if (i==6){
            rep3.setText(q.getBonneRéponse());
            rep2.setText(q.getFausseRéponseUn());
            rep1.setText(q.getFausseRéponseDeux());
        }
    }

    //Quand on clique sur une réponse
    public void onClick(View v) {
        if (n==3){
            Button btnclicked = findViewById(v.getId());
            Log.d("btnclick", btnclicked.getText().toString());
            if (btnclicked.getText().toString().equals(q.getBonneRéponse())){
                arrayBon[n]= "ok";
                Log.d("btnclick", "ok");
            }
            else{
                arrayBon[n]= "notok";
                Log.d("btnclick", "notok");
            }
            // Création d'une intention
            Intent AddidtionIntent = new Intent(ExerciceHistoireGeoActivity.this, ExerciceFrancaisResultActivity.class);
            // Lancement de la demande de changement d'activité
            AddidtionIntent.putExtra(ExerciceAdditionResultActivity.ARRAYQUESTION, arrayQuestion);
            AddidtionIntent.putExtra(ExerciceAdditionResultActivity.ARRAYBON, arrayBon);
            startActivity(AddidtionIntent);
        }
        else{
            Button btnclicked = findViewById(v.getId());
            Log.d("btnclick", btnclicked.getText().toString());
            if (btnclicked.getText().toString().equals(q.getBonneRéponse())){
                arrayBon[n]= "ok";
                Log.d("btnclick", "ok");
            }
            else{
                arrayBon[n]= "notok";
                Log.d("btnclick", "notok");
            }
            n=n+1;
            nbTour.setText("Question n°"+n);
            newQuestion(n);
        }

    }

}