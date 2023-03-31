package com.dashencko.androidtaskmanager.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dashencko.androidtaskmanager.Models.Task;
import com.dashencko.androidtaskmanager.R;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder>{
    Context context;
    List<Task> tasks;

    public TaskAdapter(Context context, List<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View taskItems = LayoutInflater.from(context).inflate(R.layout.task_item, parent, false);
        return new TaskAdapter.TaskViewHolder(taskItems);
    }


    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int position) {
        holder.taskBg.setCardBackgroundColor(Color.parseColor(tasks.get(position).getColor()));



        holder.taskTitle.setText(tasks.get(position).getTitle());
        holder.taskDescription.setText(tasks.get(position).getDescription());
        holder.taskPriority.setText(tasks.get(position).getPriority());
//        holder.taskName.setText(tasks.get(position).getName()); разобраться, почему выходит null


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, TasPage.class);
//                intent.putExtra("courseBg", Color.parseColor(courses.get(position).getColor()));
//                intent.putExtra("courseImage", imageId);
//                intent.putExtra("courseTitle", courses.get(position).getTitle());
//                intent.putExtra("courseDate", courses.get(position).getDate());
//                intent.putExtra("courseLevel", courses.get(position).getLevel());
//                intent.putExtra("courseText", courses.get(position).getText());
//
//                context.startActivity(intent);
//
//
//
//                context.startActivity(intent);
//            }
//        });
    }


    public int getItemCount() {
        return tasks.size();
    }

    public static final class TaskViewHolder extends RecyclerView.ViewHolder {

        CardView taskBg;
        TextView taskTitle, taskDescription, taskPriority, taskName;


        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            taskBg = itemView.findViewById(R.id.taskBg);
            taskTitle = itemView.findViewById(R.id.taskTitle);
            taskDescription = itemView.findViewById(R.id.taskDescription);
            taskPriority = itemView.findViewById(R.id.taskPriority);

        }
    }
}