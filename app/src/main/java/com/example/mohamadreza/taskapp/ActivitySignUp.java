package com.example.mohamadreza.taskapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.mohamadreza.taskapp.models.DaoSession;
import com.example.mohamadreza.taskapp.models.User;
import com.example.mohamadreza.taskapp.models.UserDao;

public class ActivitySignUp extends AppCompatActivity {

    private EditText mUserName;
    private EditText mPassword;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ActivitySignUp.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_page);

        mUserName = findViewById(R.id.edit_text_username);
        mPassword = findViewById(R.id.edit_text_password);
        Button signUp = findViewById(R.id.button_sign_up);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DaoSession daoSession = (App.getApp()).getDaoSession();
                UserDao userDao = daoSession.getUserDao();

                User user = new User();
                String userName = mUserName.getText().toString();
                String password = mPassword.getText().toString();
                user.setMUserName(userName);
                user.setMPassword(password);
                userDao.insert(user);
                onBackPressed();
            }
        });
    }
}
