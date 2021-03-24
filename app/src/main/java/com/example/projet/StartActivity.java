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

public class StartActivity extends AppCompatActivity {
    //Attributs
    private static final int REQUEST_CODE = 0;
    private Button buttonConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void goConnect(View view) {
        Intent intent = new Intent(this, ConnectionActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }
}