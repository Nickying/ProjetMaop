package com.example.maop.maop;

import java.util.ArrayList;

/**
 * Created by Nicky on 19/01/2016.
 */
public class Afficher{
    private ArrayList<String> tab;

    public Afficher(){
        tab = new ArrayList<String>();

        tab.add("Nicky");
        tab.add("Vang");
        tab.add("Guillaume");
        tab.add("Goubin");
        tab.add("Drexchel");
        tab.add("Astom");
    }


    public String getTab(int i){
        return this.tab.get(i);
    }
    public int getTailleTab(){
        return this.tab.size();
    }
}
