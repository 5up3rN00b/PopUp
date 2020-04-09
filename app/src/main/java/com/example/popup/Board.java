package com.example.popup;

import com.example.popup.Mole.*;

import java.util.*;


public class Board {
    private static int numMoles, score;
    private static ArrayList<Mole> moles;
    private static Board b;

    private Board() {
        ArrayList<Mole> moles = new ArrayList<>();
    }

    public static Board getInstance() {
        if (b == null) {
            b = new Board();
        }

        return b;
    }

    public void timedBirth() {
        
    }

    // Runs when there is a click
    public void click() {
        for (int i = 0; i < moles.size(); i++){ //traverses array to see if any are Hit, if so, call death, score ++
            Mole m = moles.get(i);
            if (m.isHit()) {
                score++;
                m.death();
            }
        }
    }
}
