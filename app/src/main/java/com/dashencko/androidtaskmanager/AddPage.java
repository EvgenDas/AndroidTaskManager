package com.dashencko.androidtaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.dashencko.androidtaskmanager.Models.Task;

import java.time.LocalDate;
import java.util.Calendar;

public class AddPage extends AppCompatActivity {
    TextView mTv;

    EditText enter_todo_et, editTextPriority, editTextDescription, editTextName;
    Calendar calendar;
    DatePickerDialog datePickerDialog;
    LocalDate ld = LocalDate.of(2016, 2, 4);





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_page);

        enter_todo_et = (EditText) findViewById(R.id.enter_todo_et);
        editTextPriority = (EditText) findViewById(R.id.editTextPriority);
        editTextDescription = (EditText) findViewById(R.id.editTextDescription);
        editTextName = (EditText) findViewById(R.id.editTextName);
        calendar = Calendar.getInstance();
        mTv = (TextView)findViewById(R.id.textView7);



    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateText(View view) {

        MainActivity.taskList.clear();
        MainActivity.FullTaskList.clear();



        MainActivity.taskList.add(new Task(10, enter_todo_et.getText().toString(), editTextDescription.getText().toString(), editTextName.getText().toString(), editTextPriority.getText().toString(), "#9C2CF3", 2, ld));

        System.out.println(ld);
        System.out.println("_______________________________________________________");


        MainActivity.taskAdapter.notifyDataSetChanged();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void updateDate(View view) {

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);


        datePickerDialog = new DatePickerDialog(AddPage.this, new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                ld = LocalDate.of(mYear, (mMonth + 1), mDay);
                mTv.setText(mDay + "/" + (mMonth + 1) + "/" + mYear);
            }

        }, day, month, year);

        datePickerDialog.show();


    }
}