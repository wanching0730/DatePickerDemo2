package com.example.android.datepickerdemo1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by WanChing on 10/7/2017.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);


        DatePicker datePicker = dialog.getDatePicker();

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        datePicker.setMinDate(calendar.getTimeInMillis());

        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        datePicker.setMaxDate(calendar.getTimeInMillis());

        return  dialog;

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        EditText date_selection = (EditText) getActivity().findViewById(R.id.date_selection);
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        Calendar cal = new GregorianCalendar(year, month, dayOfMonth);
        date_selection.setText(dateFormat.format(cal.getTime()));
    }
}
