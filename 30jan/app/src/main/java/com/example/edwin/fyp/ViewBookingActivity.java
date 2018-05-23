package com.example.edwin.fyp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ViewBookingActivity extends AppCompatActivity {

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mDepartureRef,mArrivalRef,mshow_booking_timeRef,mStatusRef,mDeleteRef;//= mRootRef.child("condition");

    TextView mDeparture, mArrival, mshow_booking_time,mstatus_view;
    Button mConfirm,mDelete;
    String personName,personGivenName,personFamilyName,personEmail,personId;
    Uri personPhoto;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_booking);
        final String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        path = "booking/"+date;
        mDeparture = findViewById(R.id.departure);
        mArrival = findViewById(R.id.arrival);
        mshow_booking_time = findViewById(R.id.show_booking_time);
        mstatus_view = findViewById(R.id.status_view);
        mConfirm = findViewById(R.id.confirm);
        mDelete = findViewById(R.id.delete_book);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            personName = account.getDisplayName();
            personGivenName = account.getGivenName();
            personFamilyName = account.getFamilyName();
            personEmail = account.getEmail();
            personId = account.getId();
            personPhoto = account.getPhotoUrl();
        }

        mConfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(ViewBookingActivity.this,"You have confirmed your ride. Enjoy your drive!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(ViewBookingActivity.this, HomeActivity.class));

            }
        });

        mDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mDeleteRef =mRootRef.child("booking/date");
                mDeleteRef.removeValue();

                Toast.makeText(ViewBookingActivity.this,"You have deleted your ride. Please book again!!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(ViewBookingActivity.this, HomeActivity.class));

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Query mIDRef = mRootRef.child(path+"/ID").equalTo(personId);
        mIDRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //String text = dataSnapshot.getValue(String.class);

                mDepartureRef = mRootRef.child(path+"/departure");
                mDepartureRef.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String text = dataSnapshot.getValue(String.class);
                        mDeparture.setText(getString(R.string.departure_view,text));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                mArrivalRef = mRootRef.child(path+"/arrival");
                mArrivalRef.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String text = dataSnapshot.getValue(String.class);
                        mArrival.setText(getString(R.string.arrival_view,text));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                mshow_booking_timeRef = mRootRef.child(path+"/Time");
                mshow_booking_timeRef.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String text = dataSnapshot.getValue(String.class);
                        mshow_booking_time.setText(getString(R.string.booking_time_view,text));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                mStatusRef = mRootRef.child(path+"/status");
                mStatusRef.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String text = dataSnapshot.getValue(String.class);
                        mstatus_view.setText(getString(R.string.booking_status,text));
                        if (text.equals("approved")){
                            findViewById(R.id.confirm).setVisibility(View.VISIBLE);
                        }
                        if (text.equals("pending")){
                            findViewById(R.id.confirm).setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

    public void onBack(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }




}
