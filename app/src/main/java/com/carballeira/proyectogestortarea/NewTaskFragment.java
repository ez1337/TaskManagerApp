package com.carballeira.proyectogestortarea;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.Calendar;

public class NewTaskFragment extends DialogFragment {
    private EditText descriptionInput;
    private EditText dateInput;
    private Spinner subjectSelector;
    private Button cancelBtn;
    private Button addBtn;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.new_task_diablog_box,null);

        subjectSelector = view.findViewById(R.id.subjectSpinner);
        descriptionInput = view.findViewById(R.id.inputDescription);

        dateInput = view.findViewById(R.id.dateSelector);
        dateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        requireContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                               dateInput.setText(day + "/" + (month+1) + "/" + year);
                            }
                        },
                        year,month,day
                );
                datePickerDialog.show();
            }
        });

        cancelBtn = view.findViewById(R.id.cancel_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewTaskFragment.this.getDialog().cancel();
            }
        });

        addBtn = view.findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Task> list = new ArrayList<>();
                Bundle data = new Bundle();
                String description = descriptionInput.getText().toString();
                String date = dateInput.getText().toString();
                String subject = subjectSelector.getSelectedItem().toString();

                if (description.isEmpty() || date.isEmpty()) {
                    Toast.makeText(getContext(), "Completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                Task newTask = new Task(subject,description,date,false);
                list.add(newTask);
                data.putParcelableArrayList("tasks-db",list);

                TaskListFragment fragment = new TaskListFragment();
                fragment.setArguments(data);
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.mainContainerView, fragment)
                        .commit();
                dismiss();
            }
        });

        builder.setView(view);

        return builder.create();
    }
}
