package com.example.projet;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet.db.DatabaseClient;
import com.example.projet.db.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //
    private static final int REQUEST_CODE_ADD = 0;

    // DATA
    private DatabaseClient mDb;
    private UsersAdapter adapter;

    // VIEW
    private Button buttonAdd;
    private ListView listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        listUser = findViewById(R.id.listUser);
        buttonAdd = findViewById(R.id.button_add);

        // Lier l'adapter au listView
        adapter = new UsersAdapter(this, new ArrayList<User>());
        listUser.setAdapter(adapter);

        // Ajouter un événement au bouton d'ajout
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ADD);
            }
        });

        // EXEMPLE : Ajouter un événement click à la listView
        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Récupération de la tâche cliquée à l'aide de l'adapter
                User user = adapter.getItem(position);

                // Message
                Toast.makeText(MainActivity.this, "Click : " + user.getNom() , Toast.LENGTH_SHORT).show();
            }
        });

        // EXEMPLE : Ajouter un événement long click à la listView
        listUser.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                // Récupération de la tâche cliquée à l'aide de l'adapter
                User user = adapter.getItem(position);

                // Message
                Toast.makeText(MainActivity.this, "LongClick : " + user.getNom(), Toast.LENGTH_SHORT).show();

                return false;
            }
        });


    }


    /**
     *
     *
     */
    private void getUsers() {
        ///////////////////////
        // Classe asynchrone permettant de récupérer des taches et de mettre à jour le listView de l'activité
        class GetUsers extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> taskList = mDb.getAppDatabase()
                        .userDAO()
                        .getAll();
                return taskList;
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
        // Création d'un objet de type GetTasks et execution de la demande asynchrone
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

    //    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == REQUEST_CODE_ADD && resultCode == RESULT_OK) {
//
//            // Mise à jour des taches
//            getTasks();
//        }
//    }
}
