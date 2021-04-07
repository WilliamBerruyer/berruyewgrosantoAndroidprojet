package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.projet.db.DatabaseClient;
import com.example.projet.db.User;
import com.example.projet.dbQuestion.DatabaseClientQuestion;
import com.example.projet.dbQuestion.Question;

import java.util.List;

public class ExerciceFrancaisActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;
    private DatabaseClientQuestion mdb;
    private QuestionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_francais);

        // Récupération du DatabaseClient
        mdb = DatabaseClientQuestion.getInstance(getApplicationContext());
        // Mise à jour des utilisateurs
        getQuestions();
    }

    private void getQuestions() {
        ///////////////////////
        // Classe asynchrone permettant de récupérer des taches et de mettre à jour le listView de l'activité
        class GetQuestions extends AsyncTask<Void, Void, List<Question>> {

            @Override
            protected List<Question> doInBackground(Void... voids) {
                List<Question> QuestionList = mdb.getAppDatabase()
                        .questionDAO()
                        .getAll();
                return QuestionList;
            }

            @Override
            protected void onPostExecute(List<Question> questions) {
                super.onPostExecute(questions);

                // Mettre à jour l'adapter avec la liste de taches
                adapter.clear();
                adapter.addAll(questions);

                // Now, notify the adapter of the change in source
                adapter.notifyDataSetChanged();
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