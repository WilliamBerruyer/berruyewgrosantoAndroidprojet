package com.example.projet.additionData;

public class Calcul {

    private int min = 0;
    private int max = 20;
    private final double nombre1 = Math.random() * (max - min + 1) + min;
    private final double nombre2 = Math.random() * (max - min + 1) + min;
    private double resultat;

    private double choixUser;

    public Calcul() {
        initResultat();
    }

    private void initResultat(){
        resultat = nombre1 + nombre2;
    }

    public double getNombre1(){
        return nombre1;
    }

    public double getNombre2(){
        return nombre2;
    }

    public double getResultat(){
        return resultat;
    }

    public void setChoixUser(double choice){
        this.choixUser = choice;

    }

    public double getChoixUser(){
        return choixUser;
    }

    public boolean Answer(){
        return (getChoixUser() == getResultat());
    }


}
