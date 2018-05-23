package com.example.edwin.fyp;

import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BookRideActivity extends AppCompatActivity {

    TextView show_booking_time;
    Button timeBtn, mbook_ride_button;
    EditText marrival, mdeparture;
    String ArrivalHolder, DepartureHolder;
    String personName,personGivenName,personFamilyName,personEmail,personId;
    Uri personPhoto;
    String path;


    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride);
        mbook_ride_button = findViewById(R.id.book_ride_button);
        marrival = findViewById(R.id.arrival);
        mdeparture = findViewById(R.id.departure);

        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000);
        final String formatted_id = String.format("%05d", num);



        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        path = "booking/"+date;
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            personName = account.getDisplayName();
            personGivenName = account.getGivenName();
            personFamilyName = account.getFamilyName();
            personEmail = account.getEmail();
            personId = account.getId();
            personPhoto = account.getPhotoUrl();
        }


        mbook_ride_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                GetDataFromEditText();
                mConditionRef = mRootRef.child(path+"/booking_id");
                mConditionRef.setValue(formatted_id);
                mConditionRef = mRootRef.child("booking_id/"+personId);
                mConditionRef.setValue(formatted_id);
                mConditionRef = mRootRef.child(path+"/ID");
                mConditionRef.setValue(personId);
                mConditionRef = mRootRef.child(path+"/Name");
                mConditionRef.setValue(personName);
                String a_details = ArrivalHolder;
                mConditionRef = mRootRef.child(path+"/arrival");
                mConditionRef.setValue(a_details);
                String d_details = DepartureHolder;
                mConditionRef = mRootRef.child(path+"/departure");
                mConditionRef.setValue(d_details);
                mConditionRef = mRootRef.child(path+"/status");
                mConditionRef.setValue("pending");

                Toast.makeText(BookRideActivity.this,"Data Inserted Successfully into Firebase Database", Toast.LENGTH_LONG).show();
                startActivity(new Intent(BookRideActivity.this, HomeActivity.class));

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showTimePickerDialog(View v){
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(),"timePicker");

    }

    public void GetDataFromEditText(){

        ArrivalHolder = marrival.getText().toString().trim();

        DepartureHolder = mdeparture.getText().toString().trim();

    }




}


