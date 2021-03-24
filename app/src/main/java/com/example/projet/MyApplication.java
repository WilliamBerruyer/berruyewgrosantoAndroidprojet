package com.example.projet;

import android.app.Application;

import com.example.projet.db.User;

public class MyApplication extends Application {
    private User user;

    public User getUser(){
        return user;
    }

    public void setUser() {
        this.user = user;
    }
}
