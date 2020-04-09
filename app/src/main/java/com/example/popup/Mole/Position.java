package com.example.popup.Mole;

import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.example.popup.MainActivity;

public class Position {
    private float x, y;
    private float logicalDensity;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;

        logicalDensity = MainActivity.getContext().getResources().getDisplayMetrics().density;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    // Two accessor methods that convert from the something in MainActivity to pixels
    public int getConvertedX() {
        return (int) (x * logicalDensity / 2);
    }

    public int getConvertedY() {
        return (int) (y * logicalDensity / 2);
    }
}

// nice
