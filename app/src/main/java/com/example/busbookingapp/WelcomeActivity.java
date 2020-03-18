package com.example.busbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.tv_start){

            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
    }
}
