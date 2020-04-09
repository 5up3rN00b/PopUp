package com.example.popup.Mole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.popup.MainActivity;
import com.example.popup.R;

import java.util.*;

public class Mole extends AppCompatActivity {
    private ImageView img;
    private Position p;
    private boolean isHit;

    private Timer timer;

    private static double side = 40, duration = 30;

    private FrameLayout layout;

    public Mole() {

    }

    public Mole(float x, float y) {
        p = new Position(x, y);
        isHit = false;
        layout = MainActivity.getFrameLayout();
        birth();

        timer = new Timer();
        timer.schedule(new MoleTask(), 1000);
    }

    public void birth() {
        img = new ImageView(MainActivity.getContext());
        img.setImageResource(R.drawable.mole);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.width = 100;
        lp.height = 100;
        img.setLayoutParams(lp);

        img.setX(p.getX());
        img.setY(p.getY());

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                layout.addView(img);
            }
        });
    }

    public void death() {
        System.out.println("hi");

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                layout.removeView(img);
            }
        });
    }

    public Position getPos() {
        return p;
    }

    public double getSide() {
        return side;
    }

    public double getDuration() {
        return duration;
    }

    public boolean isHit() {
        return isHit;
    }

    class MoleTask extends TimerTask {
        public void run() {
            death();
            timer.cancel();
        }
    }
}
