package com.example.popup;

import com.example.popup.Mole.*;

import java.util.*;


public class Board {
    private static int numMoles, score;
    private static ArrayList<Mole> moles;
    private static Board b;

    private Board() {
        ArrayList<Mole> moles = new ArrayList<Mole>;
    }

    public static Board getInstance() {
        if (b == null) {
            b = new Board();
        }

        return b;
    }

    // Runs when there is a click
    public void click() {
        int index = -1;
        boolean died = false;
        for (Mole a : moles){ //traverses array to see if any are Hit, if so, call death, score ++
            index ++;
            if (a.isHit) {
                score++;
                a.death();
                break;
            }

        }

        if (index != moles.size()){ //if any were hit, remove it from arraylist and birth a new one
            moles.remove(index);
            Mole a = new Mole ();
            a.birth();
            moles.add(index, a);

        }

    }
}
