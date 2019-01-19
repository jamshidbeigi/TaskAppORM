package com.example.mohamadreza.taskapp.models;

import java.util.Date;
import java.util.UUID;

public class User {

    private int mId;
    private String mUserName;
    private String mEmail;
    private String mPassword;

    public void setId(int id) {
        mId = id;
    }

    public User() {
    }
    public int getId() {
        return mId;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String name) {
        this.mUserName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }
}