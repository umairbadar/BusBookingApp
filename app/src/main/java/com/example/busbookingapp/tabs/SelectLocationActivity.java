package com.example.busbookingapp.tabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.busbookingapp.R;
import com.google.android.material.tabs.TabLayout;

public class SelectLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location );

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

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        final ViewPager viewPager = findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setText("BOARDING"));
        tabLayout.addTab(tabLayout.newTab().setText("DESTINATION"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabsAdapter adapter = new tabsAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        adapter.addFragment(new BoardingFragment(), "Boarding");
        adapter.addFragment(new DestinationFragment(), "Destination");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
