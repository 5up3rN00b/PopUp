package com.example.popup;

import com.example.popup.Mole.*;

import java.util.*;

public class Board {
    private static int numMoles, score;
    private static ArrayList<Mole> moles;
    private static Board b;

    private Board() {

    }

    public static Board getInstance() {
        if (b == null) {
            b = new Board();
        }

        return b;
    }

    // Runs when there is a click
    public void click() {

    }
}
