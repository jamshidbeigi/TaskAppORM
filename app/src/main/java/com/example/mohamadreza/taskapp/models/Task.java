package com.example.mohamadreza.taskapp.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class Task {


    @Id(autoincrement = true)
    private Long id;
    private String mTitle;
    @Generated(hash = 996373347)
    public Task(Long id, String mTitle) {
        this.id = id;
        this.mTitle = mTitle;
    }
    @Generated(hash = 733837707)
    public Task() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.mTitle;
    }
    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
    public String getMTitle() {
        return this.mTitle;
    }
    public void setMTitle(String mTitle) {
        this.mTitle = mTitle;
    }

}