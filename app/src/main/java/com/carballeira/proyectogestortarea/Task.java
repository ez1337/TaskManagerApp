package com.carballeira.proyectogestortarea;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Task implements Parcelable {
    private String subject;
    private String description;
    private String dueDate;
    private boolean completed = false;

    public Task(){}

    public Task(String subject, String description, String dueDate, boolean completed) {
        this.subject = subject;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    protected Task(Parcel in) {
        subject = in.readString();
        description = in.readString();
        dueDate = in.readString();
        completed = in.readByte() != 0;
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted() {
        this.completed = !completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", completed=" + completed +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(subject);
        parcel.writeString(description);
        parcel.writeString(dueDate);
        parcel.writeByte((byte) (completed ? 1 : 0));
    }
}
