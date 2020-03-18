package com.example.busbookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initializing Views
        initViews();
    }

    private void initViews() {

        Toolbar toolbar = findViewById(R.id.toolbar_login);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.tv_signup:
                startActivity(new Intent(getApplicationContext(), SignupActivity.class));
                break;

            case R.id.btn_login:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                break;
        }
    }
}
