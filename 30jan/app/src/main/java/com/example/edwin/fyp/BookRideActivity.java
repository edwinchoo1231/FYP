package com.example.edwin.fyp;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class BookRideActivity extends AppCompatActivity {

    TextView show_booking_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride);
    }

    public void showTimePickerDialog(View v){
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(),"timePicker");
        show_booking_time.findViewById(R.id.show_booking_time);

    }


}


