package com.example.mohamadreza.taskapp.models;

public class CurrentPosition {
     private static int mUserId;
     private static boolean mIsLogedIn;

    public static boolean isLogedIn() {
        return mIsLogedIn;
    }

    public static void setLogedIn(boolean logedIn) {
        mIsLogedIn = logedIn;
    }

    public static int getUserId() {
        return mUserId;
    }

    public static void setUserId(int muserId) {
        mUserId = muserId;
    }
}
