package com.example.mohamadreza.taskapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mohamadreza.taskapp.models.CurrentPosition;
import com.example.mohamadreza.taskapp.models.DaoSession;
import com.example.mohamadreza.taskapp.models.User;
import com.example.mohamadreza.taskapp.models.UserDao;
import com.example.mohamadreza.taskapp.models.UserDao.Properties;
import org.greenrobot.greendao.query.Query;
import java.util.List;

public class ActivityLogin extends AppCompatActivity {


    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ActivityLogin.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        Button login = findViewById(R.id.button_login);
        TextView signUp = findViewById(R.id.text_view_sign_up);
        TextView guestMode = findViewById(R.id.text_view_guest_mode);
        final EditText userNameEditText = findViewById(R.id.edit_text_user_name_login);
        final EditText passwordEditText = findViewById(R.id.edit_text_password_login);

        guestMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ActivityMain.newIntent(ActivityLogin.this);
                startActivity(intent);
                CurrentPosition.setLogedIn(false);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ActivitySignUp.newIntent(ActivityLogin.this);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userNameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                DaoSession daoSession = (App.getApp()).getDaoSession();
                UserDao userDao = daoSession.getUserDao();

                Query<User> query = userDao.queryBuilder()
                        .where(
                        Properties.MUserName.eq(username),
                        Properties.MPassword.eq(password))
                        .build();
                List<User> isFind = query.list();

                if (!isFind.isEmpty()) {

                    User user = isFind.get(0);
                    Long userId = user.getId();
                        CurrentPosition.setUserId(userId);
                        CurrentPosition.setLogedIn(true);
                        Intent intent = ActivityMain.newIntent(ActivityLogin.this);
                        startActivity(intent);
                }
                else
                {
                    Toast.makeText(ActivityLogin.this, "user not found!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
