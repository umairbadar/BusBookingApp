package com.example.busbookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SelectLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location);

        //Initializing Views
        initViews();
    }

    private void initViews(){

        TextView tv_location = findViewById(R.id.tv_location);
        tv_location.setText(getIntent().getStringExtra("location"));

        TextView tv_transporter = findViewById(R.id.tv_transporter);
        String bus_name = getIntent().getStringExtra("bus_name");
        String bus_desc = getIntent().getStringExtra("bus_desc");
        tv_transporter.setText(bus_name + " (" + bus_desc + ")");

        Toolbar toolbar = findViewById(R.id.select_location_toolbar);
        setSupportActionBar(toolbar);

    }
}
