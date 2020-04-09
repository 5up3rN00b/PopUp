package com.example.popup.Mole;

public class SuperMole extends Mole {
    private int lives;

    public SuperMole(float x, float y) {
        super(x, y);
        lives = 2;
    }

    public void hit() {
        lives--;

        if (lives == 0) {
            super.hit();
        }
    }
}
