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

import com.example.popup.Mole.*;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private static FrameLayout mFrameLayout;
    private static Context context;
    private static WindowManager windowManager;
    private static TextView mScore;

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
        mScore = findViewById(R.id.score);

        context = getApplicationContext();

        windowManager = getWindowManager();

        mView.setOnTouchListener(touch);

        scale = getResources().getDisplayMetrics().density;
        mGestureThreshold = (int) (GESTURE_THRESHOLD_DP * scale + 0.5f);

        System.out.println(mGestureThreshold);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Test if board has more moles than Board.getInstance().MAX_MOLES
                while (true) {
                    if (Board.getInstance().getMoles() < Board.getInstance().MAX_MOLES) {
                        float logicalDensity = context.getResources().getDisplayMetrics().density;

                        int width = context.getResources().getDisplayMetrics().widthPixels;
                        int height = context.getResources().getDisplayMetrics().heightPixels;

                        //System.out.println("Width " + width + " Height " + height);

                        // Convert pixel to something (maybe dp)
                        Mole m = new Mole((float) Math.random() * width * 2 / logicalDensity, (float) Math.random() * height * 2 / logicalDensity);
                        Board.getInstance().addMole(m);
                    }
                }
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

    public static TextView getScore() {
        return mScore;
    }
}
