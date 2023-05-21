package com.dashencko.androidtaskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.dashencko.androidtaskmanager.Models.Task;

import java.time.LocalDate;

public class TaskPage extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_page);

        ConstraintLayout taskBg= findViewById(R.id.taskPageBackground);
        TextView taskTitle = findViewById(R.id.taskPageTitle);
        TextView taskName = findViewById(R.id.taskPageName);
        TextView taskPriority = findViewById(R.id.taskPagePriority);
        TextView taskDescription = findViewById(R.id.taskPageDescription);
        TextView taskEstimateDate = findViewById(R.id.taskPageEstimateDate);


        taskBg.setBackgroundColor(getIntent().getIntExtra("taskBg", 0));
        taskTitle.setText(getIntent().getStringExtra("taskTitle"));
        taskName.setText(getIntent().getStringExtra("taskName"));
        taskPriority.setText(getIntent().getStringExtra("taskPriority"));
        taskDescription.setText(getIntent().getStringExtra("taskDescription"));
        taskEstimateDate.setText(getIntent().getStringExtra("taskEstimateDate"));
    }
    public void addItem(View view) {
        Toast.makeText(this, "Изменение", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, AddPage.class);
        startActivity(intent);
    }

    public void CompleteTask(View view) {
        Toast.makeText(this, "Завершение", Toast.LENGTH_LONG).show();

    }
}
