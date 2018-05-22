package com.example.edwin.fyp;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{
    TextView show_booking_time_on_app;
    Button timeBtn;
    OnTimePickedListener mCallback;

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
        if (view != null) {
            tv1.setText(getString(R.string.booking_time_is, "Hour: " + view.getCurrentHour() + " Minute: " + view.getCurrentMinute()));
        }

        else {
            tv1.setText(null);
        }
    }
}
