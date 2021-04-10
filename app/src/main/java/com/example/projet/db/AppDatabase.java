package com.example.projet.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.projet.ExerciceFrancaisActivity;
import com.example.projet.dbQuestion.Question;
import com.example.projet.dbQuestion.QuestionDAO;
import com.example.projet.dbQuestion.QuestionHG;
import com.example.projet.dbQuestion.QuestionHGDAO;

@Database(entities = {User.class, Question.class, QuestionHG.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract UserDAO userDAO();
    public abstract QuestionDAO questionDAO();
    public abstract QuestionHGDAO questionHGDAO();


}

