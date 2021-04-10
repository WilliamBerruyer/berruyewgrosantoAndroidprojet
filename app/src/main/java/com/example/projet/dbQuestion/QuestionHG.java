package com.example.projet.dbQuestion;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class QuestionHG implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Question")
    private String question;

    @ColumnInfo(name = "BonneRéponse")
    private String BonneRéponse;

    @ColumnInfo(name = "FausseRéponseUn")
    private String FausseRéponseUn;

    @ColumnInfo(name = "FausseRéponseDeux")
    private String FausseRéponseDeux;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getFausseRéponseUn() {
        return FausseRéponseUn;
    }

    public void setFausseRéponseUn(String FausseRéponseUn) {
        this.FausseRéponseUn = FausseRéponseUn;
    }

    public String getBonneRéponse() {
        return BonneRéponse;
    }

    public void setBonneRéponse(String BonneReponse) {
        this.BonneRéponse = BonneReponse;
    }

    public String getFausseRéponseDeux() {
        return FausseRéponseDeux;
    }

    public void setFausseRéponseDeux(String FausseRéponseDeux) {
        this.FausseRéponseDeux = FausseRéponseDeux;
    }

}
