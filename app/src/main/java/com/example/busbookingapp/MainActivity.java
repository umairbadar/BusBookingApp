package com.example.busbookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static TextView tv_toolbar_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing Views
        initViews();
    }

    private void initViews(){

        Toolbar toolbar = findViewById(R.id.toolbar_mainactivity);
        setSupportActionBar(toolbar);

        tv_toolbar_text = findViewById(R.id.tv_toolbar_text);

        ImageButton home = findViewById(R.id.home);
        home.performClick();
    }

    private void callFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onClick(View view) {

        Fragment fragment = null;

        switch (view.getId()){

            case R.id.home:
                fragment = new HomeFragment();
                callFragment(fragment);
                break;

            case R.id.tickets:
                break;

            case R.id.profile:
                break;

            case R.id.wallet:
                break;

            case R.id.settings:
                break;
        }
    }
}
