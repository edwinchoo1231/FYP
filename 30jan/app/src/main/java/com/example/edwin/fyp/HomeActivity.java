package com.example.edwin.fyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onStartDriving(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void onBookARide(View view) {
        Intent intent = new Intent(this, BookRideActivity.class);
        startActivity(intent);
    }

    public void onViewBooking(View view) {
        Intent intent = new Intent(this, ViewBookingActivity.class);
        startActivity(intent);
    }

    public void onDrivingInfo(View view) {
        Intent intent = new Intent(this, DrivingInfoActivity.class);
        startActivity(intent);
    }
}
