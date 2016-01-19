package com.example.maop.maop;

/**
 * Created by Nicky on 19/01/2016.
 */
public class Afficher{
    private String tab[];

    public Afficher(){
        tab = new String[6];
        tab[0]="Nicky";
        tab[1]="Vang";
        tab[2]="Guillaume";
        tab[3]="Goubin";
        tab[4]="Drexchel";
        tab[5]="Astom";
    }


    public String getTab(int i){
        return this.tab[i];
    }
}
