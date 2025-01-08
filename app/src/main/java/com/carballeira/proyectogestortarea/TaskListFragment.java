package com.carballeira.proyectogestortarea;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class TaskListFragment extends Fragment {

    ArrayList<Task> taskList;

    public TaskListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this.taskList == null){
            if (getArguments() != null) {
                this.taskList = getArguments().getParcelableArrayList("tasks-db");
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        RecyclerView rvTasks = view.findViewById(R.id.rvTaskList);

        if(this.taskList == null){
            if (getArguments() != null) {
                this.taskList = getArguments().getParcelableArrayList("tasks-db");
            }
        }

        TaskAdapter taskAdapter = new TaskAdapter(this.taskList);
        rvTasks.setAdapter(taskAdapter);
        rvTasks.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}