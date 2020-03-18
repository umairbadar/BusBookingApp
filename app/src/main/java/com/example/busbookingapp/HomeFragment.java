package com.example.busbookingapp;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.busbookingapp.Bus.BusActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private TextView tv_date, tv_day;
    private Button btn_searchBus;
    private EditText et_boarding, et_destination;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Initializing Views
        initViews(view);

        return view;
    }

    private void initViews(View view) {

        MainActivity.tv_toolbar_text.setText(R.string.journey_details);

        tv_date = view.findViewById(R.id.tv_date);
        tv_date.setOnClickListener(this);

        btn_searchBus = view.findViewById(R.id.btn_searchBus);
        btn_searchBus.setOnClickListener(this);

        tv_day = view.findViewById(R.id.tv_day);

        et_boarding = view.findViewById(R.id.et_boarding);
        et_destination = view.findViewById(R.id.et_destination);
    }

    private void showDatePicker(Context context) {

        final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current date
        DatePickerDialog datePicker = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                //Getting Day of week using Date
                SimpleDateFormat simpledateformat = new SimpleDateFormat("EEEE");
                Date date = new Date(year, monthOfYear, dayOfMonth - 1);
                String dayOfWeek = simpledateformat.format(date);

                //Setting Day of the week
                tv_day.setText(dayOfWeek);

                //Setting Date
                tv_date.setText(dayOfMonth + " " + MONTHS[monthOfYear]);
            }
        }, mYear, mMonth, mDay);
        datePicker.show();
    }

    private boolean callNextActivity(){

        if (TextUtils.isEmpty(et_boarding.getText())){

            et_boarding.setError("Enter Boarding");
            et_boarding.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(et_destination.getText())){

            et_destination.setError("Enter Destination");
            et_destination.requestFocus();
            return false;
        } else {
            Intent intent = new Intent(getContext(), BusActivity.class);
            String location = et_boarding.getText().toString() + " - " + et_destination.getText().toString();
            intent.putExtra("location", location);
            startActivity(intent);
            return true;
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.tv_date:
                showDatePicker(getContext());
                break;

            case R.id.btn_searchBus:
                if (callNextActivity()){
                    callNextActivity();
                }
                break;
        }
    }
}
