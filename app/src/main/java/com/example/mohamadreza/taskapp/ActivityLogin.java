package com.example.mohamadreza.taskapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.mohamadreza.taskapp.models.CurrentPosition;

public class ActivityLogin extends AppCompatActivity {

    private String username;
    private String password;


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
            }
        });
    }
}
