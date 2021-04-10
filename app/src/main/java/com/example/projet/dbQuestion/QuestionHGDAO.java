package com.example.projet.dbQuestion;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface QuestionHGDAO {
    @Query("SELECT * FROM QuestionHG")
    List<QuestionHG> getAll();

    @Insert
    void insert(QuestionHG question);

    @Insert
    long[] insertAll(QuestionHG... questions);

    @Delete
    void delete(QuestionHG question);

    @Update
    void update(QuestionHG question);
}
