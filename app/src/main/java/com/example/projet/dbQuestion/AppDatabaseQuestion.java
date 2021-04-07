package com.example.projet.dbQuestion;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Question.class}, version = 1, exportSchema = false)
public abstract class AppDatabaseQuestion extends RoomDatabase {

    public abstract QuestionDAO questionDAO();

}