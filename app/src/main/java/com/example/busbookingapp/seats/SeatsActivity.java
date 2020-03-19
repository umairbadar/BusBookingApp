package com.example.busbookingapp.seats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.busbookingapp.R;
import com.example.busbookingapp.tabs.SelectLocationActivity;

import java.util.ArrayList;
import java.util.List;

public class SeatsActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Model_Seats> arr_list;
    private Adapter_Seats adapter;
    private TextView tv_location, tv_transporter, tv_transporter_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);

        //Initializing Views
        initViews();
    }

    private void initViews(){

        tv_location = findViewById(R.id.tv_location);
        tv_location.setText(getIntent().getStringExtra("location"));

        tv_transporter = findViewById(R.id.tv_transporter);
        tv_transporter.setText(getIntent().getStringExtra("bus_name"));

        tv_transporter_desc = findViewById(R.id.tv_transporter_desc);
        tv_transporter_desc.setText(getIntent().getStringExtra("bus_desc"));

        Toolbar toolbar = findViewById(R.id.seats_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView seat_list = findViewById(R.id.seats_list);
        seat_list.setLayoutManager(new GridLayoutManager(this, 4));
        arr_list = new ArrayList<>();
        adapter = new Adapter_Seats(arr_list);
        seat_list.setAdapter(adapter);
        getSeats();
    }

    private void getSeats(){

        for (int i = 0; i < 30; i++){

            Model_Seats item = new Model_Seats(
                    String.valueOf(i)
            );
            arr_list.add(item);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btn_pay){

            Intent intent = new Intent(getApplicationContext(), SelectLocationActivity.class);

            Bundle args = new Bundle();
            args.putString("location", tv_location.getText().toString());
            args.putString("bus_name", tv_transporter.getText().toString());
            args.putString("bus_desc", tv_transporter_desc.getText().toString());
            intent.putExtras(args);

            startActivity(intent);
        }
    }
}
