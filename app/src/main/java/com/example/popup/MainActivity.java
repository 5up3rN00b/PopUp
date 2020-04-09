package com.example.popup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;
import android.widget.RelativeLayout.*;

import com.example.popup.Mole.Mole;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private static FrameLayout mFrameLayout;
    private static Context context;
    private Button mButton;
    private ArrayList<Timer> timers = new ArrayList<>();
    private View mView;

    private View.OnTouchListener touch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            System.out.println("hi");

            int x = (int) event.getRawX();
            int y = (int) event.getRawY();

            System.out.println(x);
            System.out.println(y);

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.btn);
        mFrameLayout = findViewById(R.id.layout);
        mView = findViewById(R.id.touchView);

        context = getApplicationContext();

        mView.setOnTouchListener(touch);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                float logicalDensity = displayMetrics.density;

                int width = displayMetrics.widthPixels;
                int height = displayMetrics.heightPixels;
                Mole m = new Mole((float) Math.random() * width, (float) Math.random() * height);
            }
        });
    }

    public static FrameLayout getFrameLayout() {
        return mFrameLayout;
    }

    public static Context getContext() {
        return context;
    }
}
