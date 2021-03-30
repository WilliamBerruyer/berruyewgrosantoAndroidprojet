package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.projet.db.User;

public class listeMatiereActivity extends AppCompatActivity {
    //Attributs
    public static final String USER_CONNECTED = "user_key";
    TextView connectedAs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_matiere);
        connectedAs= findViewById(R.id.connectedAs);
        if (getIntent().getStringExtra(USER_CONNECTED) == null){
            connectedAs.setText("Connecté en tant qu'invité");
        }
        else{
            connectedAs.setText("Connecté en tant que "+getIntent().getStringExtra(USER_CONNECTED));
        }
    }
}