package com.dashencko.androidtaskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.dashencko.androidtaskmanager.Adapters.CategoryAdapter;
import com.dashencko.androidtaskmanager.Adapters.TaskAdapter;
import com.dashencko.androidtaskmanager.Models.Category;
import com.dashencko.androidtaskmanager.Models.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, taskRecycler;
    CategoryAdapter categoryAdapter;

    static TaskAdapter taskAdapter;

    static List<Task> taskList = new ArrayList<>();

    static List<Task> FullTaskList = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Мои задачи"));
        categoryList.add(new Category(2, "Открытые"));
        categoryList.add(new Category(3, "Выполняются"));
        categoryList.add(new Category(4, "Завершённые"));
        categoryList.add(new Category(5, "Отменённые"));
        categoryList.add(new Category(6, "Удалённые"));

        setCategoryRecycler(categoryList);


        taskList.add(new Task(1, "Сделать курсовую", "Сделать до завтра", "Игорь", "1", "#9C2CF3", 3, LocalDate.now()));
        taskList.add(new Task(2, "Сделать контрольную", "Сделать кр до завтра", "Евгений", "1", "#9C2CF3", 2, LocalDate.now()));
        taskList.add(new Task(3, "Отправить задание", "Сделать кр до завтра", "Олег", "2", "#9C2CF3", 2, LocalDate.now()));
        taskList.add(new Task(4, "Ответить по правкам", "Сделать кр до завтра", "Никита", "1", "#9C2CF3", 2, LocalDate.now()));
        taskList.add(new Task(5, "Задание по английскому", "Сделать кр до завтра", "Евгений", "3", "#9C2CF3", 2, LocalDate.now()));
        taskList.add(new Task(6, "Подготовить доклад", "Сделать до завтра", "Влад", "2", "#9C2CF3", 3, LocalDate.now()));

        taskList.add(new Task(7, "Написать программу", "Сделать до завтра", "Евгений", "4", "#9C2CF3", 3, LocalDate.now()));
        taskList.add(new Task(8, "Готовиться к кр", "Сделать кр до завтра", "Илья", "1", "#9C2CF3", 2, LocalDate.now()));
        taskList.add(new Task(9, "Сделать кр", "Сделать кр до завтра", "Евгений", "1", "#9C2CF3", 2, LocalDate.now()));
        taskList.add(new Task(10, "Сделать кр", "Сделать кр до завтра", "Евгений", "1", "#9C2CF3", 2, LocalDate.now()));
        taskList.add(new Task(11, "Сделать кр", "Сделать кр до завтра", "Евгений", "1", "#9C2CF3", 2, LocalDate.now()));
        taskList.add(new Task(12, "Сделать кр", "Сделать кр до завтра", "Евгений", "1", "#9C2CF3", 2, LocalDate.now()));
        taskList.add(new Task(13, "Сделать курсо", "Сделать до завтра", "Игорь", "1", "#9C2CF3", 3, LocalDate.now()));

        taskList.add(new Task(14, "Сделать курсовую", "Сделать до завтра", "Игорь", "1", "#9C2CF3", 3, LocalDate.now()));
        taskList.add(new Task(15, "Сделать кр", "Сделать кр до завтра", "Евгений", "1", "#9C2CF3", 2, LocalDate.now()));



        FullTaskList.addAll(taskList);
        setTaskRecycler(taskList);
    }


    private void setTaskRecycler(List<Task> taskList) {
        RecyclerView.LayoutManager layoutManager
                = new GridLayoutManager(this, 2);


        taskRecycler = findViewById(R.id.taskRecycler);
        taskRecycler.setLayoutManager(layoutManager);
        taskAdapter = new TaskAdapter(this, taskList);
        taskRecycler.setAdapter(taskAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }
    public void addItem(View view) {
        Toast.makeText(this, "Добавление", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, AddPage.class);
        startActivity(intent);

    }

    @SuppressLint("NotifyDataSetChanged")
    public static void showTaskByCategory(int category) {
        if(category == 1) {
            taskList.clear();
            taskList.addAll(FullTaskList);
            taskAdapter.notifyDataSetChanged();
        } else {
            List<Task> filterTask = new ArrayList<>();

            FullTaskList.forEach(x -> {
                if (x.getCategory() == category)
                    filterTask.add(x);
            });
            taskList.clear();
            taskList.addAll(filterTask);
            taskAdapter.notifyDataSetChanged();
        }
    }
}