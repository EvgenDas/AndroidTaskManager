package com.dashencko.androidtaskmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dashencko.androidtaskmanager.Models.Task;
import com.dashencko.androidtaskmanager.retrofit.RetrofitService;
import com.dashencko.androidtaskmanager.retrofit.TaskApi;
import com.google.android.material.button.MaterialButton;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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
        initializeComponents();


    }

    private void initializeComponents() {
        enter_todo_et = (EditText) findViewById(R.id.enter_todo_et);
        editTextPriority = (EditText) findViewById(R.id.editTextPriority);
        editTextDescription = (EditText) findViewById(R.id.editTextDescription);
        editTextName = (EditText) findViewById(R.id.editTextName);
        calendar = Calendar.getInstance();
        mTv = (TextView)findViewById(R.id.textView7);

        ImageButton buttonSave = findViewById(R.id.save_todo_button);
        //////////////////////////////////////comment////////////////////////////////////////////
//
//        RetrofitService retrofitService = new RetrofitService();
//        TaskApi taskApi = retrofitService.getRetrofit().create(TaskApi.class);
//
//        buttonSave.setOnClickListener(view -> {
//            String title = String.valueOf(enter_todo_et.getText());
//            String priority = String.valueOf(editTextPriority.getText());
//            String description = String.valueOf(editTextDescription.getText());
//            String name = String.valueOf(editTextName.getText());
//            LocalDate estimateDate = ld;
//            String status = "Открыта";
//
//            Task task = new Task();
//            task.setTitle(title);
//            task.setPriority(priority);
//            task.setDescription(description);
//            task.setName(name);
//            task.setEstimate_date(estimateDate);
//            task.setStatus(status);
//
//            taskApi.TaskAddObject(task)
//                    .enqueue(new Callback<Task>() {
//                        @Override
//                        public void onResponse(Call<Task> call, Response<Task> response) {
//                            Toast.makeText(AddPage.this, "Save successful!", Toast.LENGTH_SHORT).show();
//                        }
//
//
//                        @Override
//                        public void onFailure(Call<Task> call, Throwable t) {
//                            Toast.makeText(AddPage.this, "Save failed!!!", Toast.LENGTH_SHORT).show();
//                            Logger.getLogger(AddPage.class.getName()).log(Level.SEVERE, "Error occurred", t);
//                        }
//                    });
//                    Intent intent = new Intent(this, MainActivity.class);
//                    startActivity(intent);
//             });
        //////////////////////////////////////comment////////////////////////////////////////////



    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateText(View view) {

        MainActivity.taskList.clear();
        MainActivity.FullTaskList.clear();



        MainActivity.taskList.add(new Task(17, enter_todo_et.getText().toString(), editTextDescription.getText().toString(), editTextName.getText().toString(), editTextPriority.getText().toString(), "#9C2CF3", 2, ld));


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