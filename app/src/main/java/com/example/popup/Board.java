package com.example.popup;

import com.example.popup.Mole.*;

import java.util.*;


public class Board {
    private static int numMoles, score;
    private static ArrayList<Mole> moles;
    private static Board b = null;

    private Board() {
        moles = new ArrayList<Mole>();
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
    public void click(int x, int y) {
        for (int i = 0; i < moles.size(); i++) {
            Mole m = moles.get(i);

            System.out.println("X " + m.getPos().getConvertedX() + " Y " + m.getPos().getConvertedY() + " Real X " + x + " Real Y " + y);

            if (Math.abs(m.getPos().getConvertedX() - x) < m.getSide() && Math.abs(m.getPos().getConvertedY() - y) <= m.getSide()) {
                m.hit();
            }
        }

        kill();
    }

    public void kill() {
        for (int i = 0; i < moles.size(); i++) { //traverses array to see if any are Hit, if so, call death, score ++
            Mole m = moles.get(i);
            if (m.isHit()) {
                score++;
                m.death();
                moles.remove(i);
                //i--;
            }
        }
    }

    public void addMole(Mole m) {
        moles.add(m);
    }

    public void removeMole(Mole m) {
        moles.remove(m);
    }
}
