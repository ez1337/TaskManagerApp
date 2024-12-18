package com.carballeira.proyectogestortarea;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder>{
    // Dataset
    ArrayList<Task> taskList;

    public TaskAdapter(ArrayList<Task> list){
        this.taskList = list;
    }

    @NonNull
    @Override
    public TaskAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TaskAdapter.TaskViewHolder taskViewHolder =
                new TaskViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item,parent,false)
                );
        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.tv_title.setText(task.getSubject());
        holder.tv_description.setText(task.getDescription());
        holder.tv_duedate.setText(task.getDueDate());
        if (!task.isCompleted()) {
            holder.tv_complete_status.setText(R.string.status_incomplete);
        } else {
            holder.tv_complete_status.setText(R.string.status_complete);
        }
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title;
        TextView tv_description;
        TextView tv_duedate;
        TextView tv_complete_status;


        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_duedate = itemView.findViewById(R.id.tv_duedate);
            tv_complete_status = itemView.findViewById(R.id.tv_complete_status);
        }
    }
}
