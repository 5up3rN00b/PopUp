package com.example.myapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Leaderboard extends MainActivity {
    private ArrayList<User> users;
    private static Leaderboard l;

    protected Leaderboard() {
        users = new ArrayList<>();
    }

    public static Leaderboard getInstance() {
        if (l == null) {
            return new Leaderboard();
        } else {
            return l;
        }
    }

    public void getTop(int i) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getPlanted().size() - u2.getPlanted().size();
            }
        });
        for(int j = 0; j < i; j++){
            mDisplayInfo.setText((CharSequence) users.get(j));
        }
    }

    public void addUser(User u) {
        users.add(u);
    }
}
