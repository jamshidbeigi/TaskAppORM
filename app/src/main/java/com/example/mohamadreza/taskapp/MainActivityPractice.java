package com.example.mohamadreza.taskapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mohamadreza.taskapp.models.DaoSession;
import com.example.mohamadreza.taskapp.models.Task;
import com.example.mohamadreza.taskapp.models.TaskDao;
import com.example.mohamadreza.taskapp.models.User;
import com.example.mohamadreza.taskapp.models.UserDao;

public class MainActivityPractice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        DaoSession daoSession = (App.getApp()).getDaoSession();
        TaskDao taskDao =daoSession.getTaskDao();

        UserDao userDao = daoSession.getUserDao();

        Task task = new Task();
        task.setTitle("hello");
        task.setMDescription("how are you");
        task.setMDone(true);
        taskDao.insert(task);

        User user = new User();
        user.setMUserName("m.reza");
        user.setMPassword("m131423");

        userDao.insert(user);

        Toast.makeText(this,task.getMDate()+"",Toast.LENGTH_SHORT).show();
    }
}
