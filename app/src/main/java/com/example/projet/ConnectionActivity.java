package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.projet.db.DatabaseClient;
import com.example.projet.db.User;

import java.util.ArrayList;

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

        // Récupérer les vues
        listUser = findViewById(R.id.listUser);
        buttonAddUser = findViewById(R.id.button_addUser);

        // Lier l'adapter au listView
        adapter = new UsersAdapter(this, new ArrayList<User>());
        listUser.setAdapter(adapter);
    }
    public void goNewAccount(View view) {
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }
}