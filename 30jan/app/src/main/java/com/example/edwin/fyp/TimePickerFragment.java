package com.example.edwin.fyp;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{
    TextView show_booking_time_on_app;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),this,hour,minute, DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute){
        show_booking_time_on_app.findViewById(R.id.show_booking_time);
        //show_booking_time.setText(hourOfDay+":"+minute);
    }



    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        //show_booking_time.findViewById(R.id.show_booking_time);
        //show_booking_time.setText(hourOfDay+":"+minute);
    }
}
