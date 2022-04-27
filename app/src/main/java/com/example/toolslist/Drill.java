package com.example.toolslist;

import androidx.annotation.NonNull;

public class Drill {

    private String title;
    private String info;
    private int resId;

    public Drill(String title, String info, int resId) {
        this.title = title;
        this.info = info;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getResId() {
        return resId;
    }

    @NonNull
    @Override
    public String toString() {
        return getTitle();
    }
}
