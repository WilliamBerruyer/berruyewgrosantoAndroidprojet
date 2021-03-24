package com.example.projet;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projet.db.DatabaseClient;
import com.example.projet.db.User;

public class AddUserActivity extends AppCompatActivity {

    // DATA
    private DatabaseClient mDb;

    // VIEW
    private EditText editTextNomView;
    private EditText editTextPrenomView;
    private EditText editTextFinishByView;
    private Button saveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        editTextNomView = findViewById(R.id.editTextNomView);
        editTextPrenomView = findViewById(R.id.editTextPrenomView);
        saveView = findViewById(R.id.button_save);

        // Associer un événement au bouton save
        saveView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser();
            }
        });
    }

    private void saveUser() {

        // Récupérer les informations contenues dans les vues
        final String sNom = editTextNomView.getText().toString().trim();
        final String sPrenom = editTextPrenomView.getText().toString().trim();

        // Vérifier les informations fournies par l'utilisateur
        if (sNom.isEmpty()) {
            editTextNomView.setError("Task required");
            editTextNomView.requestFocus();
            return;
        }

        if (sPrenom.isEmpty()) {
            editTextPrenomView.setError("Desc required");
            editTextPrenomView.requestFocus();
            return;
        }

        /**
         * Création d'une classe asynchrone pour sauvegarder la tache donnée par l'utilisateur
         */
        class SaveUser extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {

                // creating a task
                User user = new User();
                user.setNom(sNom);
                user.setPrenom(sPrenom);

                // adding to database
                mDb.getAppDatabase()
                        .userDAO()
                        .insert(user);

                return user;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);

                // Quand la tache est créée, on arrête l'activité AddTaskActivity (on l'enleve de la pile d'activités)
                setResult(RESULT_OK);
                finish();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        SaveUser st = new SaveUser();
        st.execute();
    }

}

