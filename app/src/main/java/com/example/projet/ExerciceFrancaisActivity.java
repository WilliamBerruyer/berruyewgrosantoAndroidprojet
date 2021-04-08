package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projet.db.DatabaseClient;
import com.example.projet.db.User;
import com.example.projet.dbQuestion.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ExerciceFrancaisActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;
    private DatabaseClient mdb;
    private QuestionsAdapter adapter;
    private ListView listQuestions;
    private Cursor cursor;
    private String[] mystrings;
    private Object[] Toutesquestions;
    private List<Question> listeQuestions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("debug", "bite");
        setContentView(R.layout.activity_exercice_francais);

        // Récupération du DatabaseClient
        mdb = DatabaseClient.getInstance(getApplicationContext());
        getQuestions();
        listQuestions = findViewById(R.id.listQuestions);
        adapter = new QuestionsAdapter(this, new ArrayList<Question>());
        listQuestions.setAdapter(adapter);

        TextView questionTxt = findViewById(R.id.questionTxt);

        questionTxt.setText(listeQuestions.get(0).getQuestion());
//        getQuestions();

    }

    private void getQuestions() {
        ///////////////////////
        // Classe asynchrone permettant de récupérer des taches et de mettre à jour le listView de l'activité
        class GetQuestions extends AsyncTask<Void, Void, List<Question>> {

            @Override
            protected List<Question> doInBackground(Void... voids) {
                List<Question> QuestionList = mdb.getAppDatabase().questionDAO().getAll();
                return QuestionList;
            }

            @Override
            protected void onPostExecute(List<Question> questions) {
//                Log.d("valeurs", "test");
////                 Mettre à jour l'adapter avec la liste de taches
//                adapter.clear();
//                Log.d("debugPerso", questions +" async");
//                adapter.addAll(questions);
//
//                // Now, notify the adapter of the change in source
//                adapter.notifyDataSetChanged();
                    listeQuestions=questions;

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
}