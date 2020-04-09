package com.example.popup;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.popup.Mole.*;

import java.util.*;


public class Board extends AppCompatActivity {
    private static int score, highScore = 0;
    private static ArrayList<Mole> moles;
    private static Board b = null;
    public static boolean RESETTING = false;
    public static final int MAX_MOLES = 6;

    private Board() {
        moles = new ArrayList<Mole>();
    }

    public static Board getInstance() {
        if (b == null) {
            b = new Board();
        }

        return b;
    }

    public int getMoles() {
        return moles.size();
    }

    public void timedBirth() {

    }

    // Runs when there is a click
    public void click(int x, int y) {
        for (int i = 0; i < moles.size(); i++) {
            Mole m = moles.get(i);

            //System.out.println("X " + m.getPos().getConvertedX() + " Y " + m.getPos().getConvertedY() + " Real X " + x + " Real Y " + y);

            if (Math.abs(m.getPos().getConvertedX() - x) < m.getSide() * 2 && Math.abs(m.getPos().getConvertedY() - y) <= m.getSide() * 2) {
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
                moles.remove(i);
                m.death(true);

                MainActivity.getScore().setText("Score: " + score);
            }
        }
    }

    public boolean overlap(int x, int y) {
        for (int i = 0; i < moles.size(); i++) {
            Mole m = moles.get(i);

            if (Math.abs(m.getPos().getConvertedX() - x) < m.getSide() * 2 && Math.abs(m.getPos().getConvertedY() - y) <= m.getSide() * 2) {
                return true;
            }
        }

        return false;
    }

    public void resetBoard() {
        RESETTING = true;

        for (int i = 0; i < moles.size(); i++) {
            moles.get(i).death(false);
            i--;
        }

        if (score > highScore) {
            highScore = score;
        }

        score = 0;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MainActivity.getScore().setText("Score: " + score);
                MainActivity.getHighScore().setText("High Score: " + highScore);
            }
        });
    }

    public void addMole(Mole m) {
        moles.add(m);
    }

    public void removeMole(Mole m) {
        moles.remove(m);
    }
}
