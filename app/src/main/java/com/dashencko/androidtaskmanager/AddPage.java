package com.dashencko.androidtaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dashencko.androidtaskmanager.Models.Task;
import com.google.android.material.textview.MaterialTextView;

public class AddPage extends AppCompatActivity {
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


        MainActivity.taskList.add(new Task(10, enter_todo_et.getText().toString(), editTextDescription.getText().toString(), editTextName.getText().toString(), editTextPriority.getText().toString(), "#9C2CF3", 2));
        MainActivity.taskAdapter.notifyDataSetChanged();
        MainActivity.FullTaskList.addAll(MainActivity.taskList);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);



    }
}