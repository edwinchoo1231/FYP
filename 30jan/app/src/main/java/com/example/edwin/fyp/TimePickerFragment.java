package com.example.edwin.fyp;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{
    String show_booking_time_on_app;
    Button timeBtn;
    OnTimePickedListener mCallback;
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef = mRootRef.child("booking/time");

    public interface OnTimePickedListener {
        public void onTimePicked(int hour, int minute);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),this,hour,minute, DateFormat.is24HourFormat(getActivity()));
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView tv1= getActivity().findViewById(R.id.show_booking_time);
        tv1.setText(getString(R.string.booking_time_is, "Hour: " + view.getCurrentHour() + " Minute: " + view.getCurrentMinute()));
        show_booking_time_on_app = "Hour: " + view.getCurrentHour() + " Minute: " + view.getCurrentMinute();
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        String path = "booking/"+date;
        mConditionRef = mRootRef.child(path+"/Time");
        mConditionRef.setValue(show_booking_time_on_app);


    }
}

/*

 */