package com.example.projet.additionData;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Calcul {

    private int min = 0;
    private int max = 20;
    Random rand = new Random();
    private final int nombre1 =  min + rand.nextInt((max - min) + 1);
    private final int nombre2 = min + rand.nextInt((max - min) + 1);
    private int resultat;

    public Calcul() {
        initResultat();
    }

    private void initResultat(){
        resultat = nombre1 + nombre2;
    }

    public int getNombre1(){
        return nombre1;
    }

    public int getNombre2(){
        return nombre2;
    }

    public int getResultat(){
        return resultat;
    }

    public boolean Answer(double choixUser){
        return (choixUser == getResultat());
    }


}
