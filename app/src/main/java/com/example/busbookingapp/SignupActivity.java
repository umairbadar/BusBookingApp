package com.example.busbookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Initializing Views
        initViews();
    }

    private void initViews(){

        Toolbar toolbar = findViewById(R.id.toolbar_signup);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tv_login:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;
        }
    }
}
