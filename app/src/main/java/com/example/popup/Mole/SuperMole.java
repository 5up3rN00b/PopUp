package com.example.popup.Mole;

public class SuperMole extends Mole {
    private int lives;
    public SuperMole(){
        super(x, y);
        lives = 2;
    }

    public void death() {// decrease life by 1 everytime it's clicked
        lives--;
        if(lives == 0){
            layer.remove();
        }
    }
}
