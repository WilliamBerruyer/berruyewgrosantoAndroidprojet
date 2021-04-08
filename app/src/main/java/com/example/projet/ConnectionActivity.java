package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projet.db.DatabaseClient;
import com.example.projet.db.User;

import java.util.ArrayList;
import java.util.List;

public class ConnectionActivity extends AppCompatActivity {
    //Attributs
    private static final int REQUEST_CODE = 0;
    private DatabaseClient mDb;
    private UsersAdapter adapter;
    private ListView listUser;
    private Button buttonAddUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());
        // Mise à jour des utilisateurs
        getUsers();
        // Récupérer les vues
        listUser = findViewById(R.id.listUser);
        buttonAddUser = findViewById(R.id.button_addUser);

        // Lier l'adapter au listView
        adapter = new UsersAdapter(this, new ArrayList<User>());
        listUser.setAdapter(adapter);

        // Ajout d'un événement click à la listView
        listUser.setOnItemClickListener((parent, view, position, id) -> {

            // Récupération de l'utilisateur cliqué à l'aide de l'adapter
            User user = adapter.getItem(position);

            Intent intent = new Intent(this, listeMatiereActivity.class);
            String nomUser = user.getPrenom()+" "+user.getNom();
            intent.putExtra(listeMatiereActivity.USER_CONNECTED, nomUser);
            startActivityForResult(intent, REQUEST_CODE);
        });


    }
    private void getUsers() {
        ///////////////////////
        // Classe asynchrone permettant de récupérer des taches et de mettre à jour le listView de l'activité
        class GetUsers extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> userList = mDb.getAppDatabase()
                        .userDAO()
                        .getAll();
                return userList;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);

                // Mettre à jour l'adapter avec la liste de taches
                adapter.clear();
                adapter.addAll(users);

                // Now, notify the adapter of the change in source
                adapter.notifyDataSetChanged();
            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        // Création d'un objet de type GetUsers et execution de la demande asynchrone
        GetUsers gt = new GetUsers();
        gt.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Mise à jour des taches
        getUsers();

    }
    @Override
    protected void onResume() {
        super.onResume();

        // Mise à jour des taches
        getUsers();

    }


    public void goNewAccount(View view) {
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }
}