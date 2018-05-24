package com.example.edwin.fyp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.math.BigDecimal;

public class DrivingInfoActivity extends Activity implements GPSCallback {
    private GPSManager gpsManager = null;
    private double speed = 0.0,longitude = 0.0,latitude = 0.0;
    Boolean isGPSEnabled=false;
    LocationManager locationManager;
    double currentSpeed,kmphSpeed,newlatitude, newlongitude,msSpeed, distance_travelled = 0.0;
    TextView txtview,txtview2,txtview3;

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mRootRef = database.getReference();
    DatabaseReference mLocationRef = mRootRef.child("Location");



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving_info);
        txtview= findViewById(R.id.info);
        txtview2 = findViewById(R.id.info2);
        txtview3 = findViewById(R.id.info3);
        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();

        ValueEventListener valueEventListener = mLocationRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Double text = dataSnapshot.getValue(newlatitude);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


    }

    public void getCurrentSpeed(View view){
        txtview.setText(getString(R.string.info));
        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
        gpsManager = new GPSManager(DrivingInfoActivity.this);
        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(isGPSEnabled) {
            gpsManager.startListening(getApplicationContext());
            gpsManager.setGPSCallback(this);
        } else {
            gpsManager.showSettingsAlert();
        }
    }

    @Override
    public void onGPSUpdate(Location location) {
        speed = location.getSpeed();
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        currentSpeed = round(speed, 3, BigDecimal.ROUND_HALF_UP);
        kmphSpeed = round((currentSpeed * 3.6), 3, BigDecimal.ROUND_HALF_UP);
        //txtview.setText(kmphSpeed+"km/h");
        newlatitude = round(latitude, 6, BigDecimal.ROUND_HALF_UP);
        newlongitude = round(longitude, 6, BigDecimal.ROUND_HALF_UP);
        msSpeed = kmphSpeed * 1000 / 3600;
        msSpeed = round(msSpeed,3,BigDecimal.ROUND_HALF_UP);
        distance_travelled += msSpeed;
        distance_travelled = round(distance_travelled,3,BigDecimal.ROUND_HALF_UP);
        txtview.setText(newlatitude + " lat, " + newlongitude + " lon");
        txtview2.setText(kmphSpeed + "km/h, " + msSpeed + "m/s");
        txtview3.setText("distance travelled: "+distance_travelled+"m");
    }

    @Override
    protected void onDestroy() {
        gpsManager.stopListening();
        gpsManager.setGPSCallback(null);
        gpsManager = null;
        super.onDestroy();
    }

    public static double round(double unrounded, int precision, int roundingMode) {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(precision, roundingMode);
        return rounded.doubleValue();
    }

    public void onTrackerActivity(View view) {
        Intent intent = new Intent(this, TrackerActivity.class);
        startActivity(intent);
    }
}