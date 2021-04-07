package com.example.projet.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.projet.dbQuestion.Question;
import com.example.projet.dbQuestion.QuestionDAO;

@Database(entities = {User.class, Question.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();
    public abstract QuestionDAO questionDAO();

}