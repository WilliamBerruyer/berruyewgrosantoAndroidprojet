package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projet.calculData.CalculSoustraction;
import com.example.projet.db.AppDatabase;
import com.example.projet.db.DatabaseClient;
import com.example.projet.db.User;
import com.example.projet.dbQuestion.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class ExerciceFrancaisActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;
    private DatabaseClient mdb;
    private List<Question> listeQuestionsAll;
    Question[] listeQuestionsPassees = new Question[4];
    String[] arrayQuestion = new String[4];
    String[] arrayBon = new String[4];
    private TextView questionTxt;
    private TextView rep1;
    private TextView rep2;
    private TextView rep3;
    int n = 1;
    TextView nbTour;
    Question q;

    private List<Question> QuestionList;

    public ExerciceFrancaisActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_francais);

        // Récupération du DatabaseClient
        mdb = DatabaseClient.getInstance(getApplicationContext());
        getQuestions();


       // listQuestions = findViewById(R.id.listQuestions);
        //adapter = new QuestionsAdapter(this, new ArrayList<Question>());
       // listQuestions.setAdapter(adapter);

        questionTxt = findViewById(R.id.questionTxt);
        nbTour = findViewById(R.id.nbTour);
        rep1 = findViewById(R.id.rep1);
        rep2 = findViewById(R.id.rep2);
        rep3 = findViewById(R.id.rep3);

   //     questionTxt.setText(listeQuestions.get(1).getQuestion());
//        getQuestions();

    }


    private void getQuestions() {
        ///////////////////////
        // Classe asynchrone permettant de récupérer des taches et de mettre à jour le listView de l'activité
        class GetQuestions extends AsyncTask<Void, Void, List<Question>> {

            @Override
            protected List<Question> doInBackground(Void... voids) {
                QuestionList = mdb.getAppDatabase().questionDAO().getAll();
                listeQuestionsAll = mdb.getAppDatabase().questionDAO().getAll();
        //        questionTxt.setText(QuestionList.get(7).getQuestion());
          //      rep1.setText(QuestionList.get(7).getBonneRéponse());
            //    rep2.setText(QuestionList.get(7).getFausseRéponseUn());
              //  rep3.setText(QuestionList.get(7).getFausseRéponseDeux());
//                affiche();
                return QuestionList;
            }

            @Override
            protected void onPostExecute(List<Question> questions) {
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
        arrayQuestion[1]=q.getQuestion();
        setAfficheQuestion(q);

    }
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
            for (Question quest : listeQuestionsPassees) {
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
        arrayQuestion[n]=q.getQuestion();
        setAfficheQuestion(q);
    }
    private void setAfficheQuestion(Question q){
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
            Intent AddidtionIntent = new Intent(ExerciceFrancaisActivity.this, ExerciceFrancaisResultActivity.class);
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