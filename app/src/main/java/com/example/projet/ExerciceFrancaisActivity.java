package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.example.projet.db.DatabaseClient;
import com.example.projet.db.User;
import com.example.projet.dbQuestion.DatabaseClientQuestion;
import com.example.projet.dbQuestion.Question;

import java.util.List;

public class ExerciceFrancaisActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;
    private DatabaseClientQuestion mdb;
    private QuestionsAdapter adapter;
    List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_francais);

        // Récupération du DatabaseClient
        mdb = DatabaseClientQuestion.getInstance(getApplicationContext());
        // Mise à jour des utilisateurs
        questions=getQuestions();
        TextView textQuestion = findViewById(R.id.questionTxt);
        textQuestion.setText(questions.get(1).getQuestion());
    }


    protected List<Question> getQuestions(Void... voids) {
        List<Question> QuestionList = mdb.getAppDatabase().questionDAO().getAll();
        return QuestionList;
    }
    @Override
    protected void onStart() {
        super.onStart();


    }
    @Override
    protected void onResume() {
        super.onResume();

        // Mise à jour des questons
        getQuestions();

    }
}