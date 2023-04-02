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
import com.dashencko.androidtaskmanager.TaskPage;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
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
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.taskBg.setCardBackgroundColor(Color.parseColor(tasks.get(position).getColor()));


        holder.taskTitle.setText(tasks.get(position).getTitle());
//        holder.taskDescription.setText(tasks.get(position).getDescription());
        holder.taskPriority.setText(tasks.get(position).getPriority());
        holder.taskName.setText(tasks.get(position).getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TaskPage.class);
                intent.putExtra("taskBg", Color.parseColor(tasks.get(position).getColor()));
                intent.putExtra("taskTitle", tasks.get(position).getTitle());
                intent.putExtra("taskPriority", tasks.get(position).getPriority());
                intent.putExtra("taskDescription", tasks.get(position).getDescription());
                intent.putExtra("taskName", tasks.get(position).getName());

                context.startActivity(intent);
            }
        });
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
            taskName = itemView.findViewById(R.id.taskName);
            taskPriority = itemView.findViewById(R.id.taskPriority);

        }
    }
}