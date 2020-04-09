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
import android.view.WindowManager;
import android.widget.*;
import android.widget.RelativeLayout.*;

import com.example.popup.Mole.Mole;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private static FrameLayout mFrameLayout;
    private static Context context;
    private static WindowManager windowManager;
    private Button mButton;
    private ArrayList<Timer> timers = new ArrayList<>();
    private View mView;

    private static final float GESTURE_THRESHOLD_DP = 16.0f;
    float scale;
    int mGestureThreshold;

    private View.OnTouchListener touch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            int x = (int) event.getRawX();
            int y = (int) event.getRawY();

            Board.getInstance().click(x, y);

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

        windowManager = getWindowManager();

        mView.setOnTouchListener(touch);

        scale = getResources().getDisplayMetrics().density;
        mGestureThreshold = (int) (GESTURE_THRESHOLD_DP * scale + 0.5f);

        System.out.println(mGestureThreshold);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                float logicalDensity = displayMetrics.density;

                int width = displayMetrics.widthPixels;
                int height = displayMetrics.heightPixels;

                System.out.println("Width " + width + " Height " + height);

                // Convert pixel to something (maybe dp)
                Mole m = new Mole((float) Math.random() * ((float) width * 160 / 120), (float) Math.random() * ((float) height * 160 / 120));
                Board.getInstance().addMole(m);
            }
        });
    }

    public static FrameLayout getFrameLayout() {
        return mFrameLayout;
    }

    public static Context getContext() {
        return context;
    }

    public static WindowManager getManager() {
        return windowManager;
    }
}
