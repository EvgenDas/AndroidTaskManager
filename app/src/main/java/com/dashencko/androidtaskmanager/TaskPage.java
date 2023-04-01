package com.dashencko.androidtaskmanager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class TaskPage extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_page);

        ConstraintLayout taskBg = findViewById(R.id.taskPageBackground);
        TextView taskTitle = findViewById(R.id.taskPageTitle);
        TextView taskName = findViewById(R.id.taskPageName);
        TextView taskPriority = findViewById(R.id.taskPagePriority);
        TextView taskDescription = findViewById(R.id.taskPageDescription);

        taskBg.setBackgroundColor(getIntent().getIntExtra("taskBg", 0));
        taskTitle.setText(getIntent().getStringExtra("taskTitle"));
        taskName.setText(getIntent().getStringExtra("taskTitle"));
        taskPriority.setText(getIntent().getStringExtra("taskPriority"));
        taskDescription.setText(getIntent().getStringExtra("taskDescription"));




    }
}
