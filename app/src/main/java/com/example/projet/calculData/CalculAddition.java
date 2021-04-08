package com.example.projet.calculData;
import java.util.Random;


public class CalculAddition {

    private int min = 1;
    private int max = 30;
    Random rand = new Random();
    private final int nombre1 =  min + rand.nextInt((max - min) + 1);
    private final int nombre2 = min + rand.nextInt((max - min) + 1);
    private int resultat;

    public CalculAddition() {
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
