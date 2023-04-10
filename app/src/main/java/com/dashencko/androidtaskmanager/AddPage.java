package com.dashencko.androidtaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dashencko.androidtaskmanager.Models.Task;
import com.google.android.material.textview.MaterialTextView;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class AddPage extends AppCompatActivity {
    public static final String TAG = "AddPage";

    EditText enter_todo_et, editTextPriority, editTextDescription, editTextName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_page);

        enter_todo_et = (EditText) findViewById(R.id.enter_todo_et);
        editTextPriority = (EditText) findViewById(R.id.editTextPriority);
        editTextDescription = (EditText) findViewById(R.id.editTextDescription);
        editTextName = (EditText) findViewById(R.id.editTextName);

    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateText(View view) {

        CalendarView calendarView = findViewById(R.id.calendarView);


        final int[] estimate_date = new int[3];
        estimate_date[0] = 0;
        estimate_date[1] = 1;
        estimate_date[2] = 2;
	    calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

                @Override
                public void onSelectedDayChange(CalendarView view, int year,
                int month, int dayOfMonth) {

                    estimate_date[0] = year;
                    estimate_date[1] = month;
                    estimate_date[2] = dayOfMonth;
                    String date = year + "/" + month + "/" + dayOfMonth;
                    Log.d(TAG, "onSelectedDayChange: date: " + date);
                    System.out.println("###############################");

                }
            });


        LocalDate date = LocalDate.now();



        MainActivity.taskList.clear();
        MainActivity.FullTaskList.clear();


        MainActivity.taskList.add(new Task(10, enter_todo_et.getText().toString(), editTextDescription.getText().toString(), editTextName.getText().toString(), editTextPriority.getText().toString(), "#9C2CF3", 2, date));


        MainActivity.taskAdapter.notifyDataSetChanged();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);



    }
}