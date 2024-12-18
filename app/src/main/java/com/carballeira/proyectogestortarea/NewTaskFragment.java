package com.carballeira.proyectogestortarea;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.textfield.TextInputEditText;

public class NewTaskFragment extends DialogFragment {
    private EditText descriptionInput;
    private EditText dateInput;
    private Spinner subjectSelector;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.new_task_diablog_box,null);

        descriptionInput = view.findViewById(R.id.inputDescription);
        dateInput = view.findViewById(R.id.dateSelector);
        subjectSelector = view.findViewById(R.id.subjectSpinner);



        builder.setView(view);

        return builder.create();
    }
}
