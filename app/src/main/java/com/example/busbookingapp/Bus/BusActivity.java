package com.example.busbookingapp.Bus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.busbookingapp.R;

import java.util.ArrayList;
import java.util.List;

public class BusActivity extends AppCompatActivity {

    private List<Model_Bus> arr_list;
    private Adapter_Bus adapter;
    public static TextView tv_toolbar_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        //Initializing Views
        initViews();
    }

    private void initViews(){

        String location = getIntent().getStringExtra("location");

        Toolbar toolbar = findViewById(R.id.toolbar_busactivity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_toolbar_text = findViewById(R.id.tv_toolbar_text);
        tv_toolbar_text.setText(location);

        RecyclerView bus_list = findViewById(R.id.bus_list);
        bus_list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        arr_list = new ArrayList<>();
        adapter = new Adapter_Bus(arr_list, this);
        bus_list.setAdapter(adapter);

        getBuses();
    }

    private void getBuses(){

        for (int i = 10; i <= 50; i += 10){

            Model_Bus item = new Model_Bus(
                    "Bus " + i,
                    "A/C Multi Axle Semi Sleeper",
                    "9:" + i,
                    "7:" + i,
                    "PKR 100" + i,
                    "20" + i + " seats"
            );

            arr_list.add(item);
        }

        adapter.notifyDataSetChanged();
    }
}
