package com.dashencko.androidtaskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dashencko.androidtaskmanager.Adapters.CategoryAdapter;
import com.dashencko.androidtaskmanager.Adapters.TaskAdapter;
import com.dashencko.androidtaskmanager.Models.Category;
import com.dashencko.androidtaskmanager.Models.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler, taskRecycler;
    CategoryAdapter categoryAdapter;

    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Мои задачи"));
        categoryList.add(new Category(2, "Выполняются"));
        categoryList.add(new Category(3, "Завершённые"));
        categoryList.add(new Category(4, "Отменённые"));
        categoryList.add(new Category(4, "Удалённые"));

        setCategoryRecycler(categoryList);

        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1, "Сделать кр", "Сделать кр до завтра", "Евгений", "1", "#9C2CF3"));
        taskList.add(new Task(2, "Сделать курсовую", "Сделать до завтра", "Игорь", "1", "#9C2CF3"));
        taskList.add(new Task(3, "Пройти курс", "Пройти курс на степике", "Борис", "2", "#9C2CF3"));




        setTaskRecycler(taskList);
    }

    private void setTaskRecycler(List<Task> taskList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

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
}