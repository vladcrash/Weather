package ru.vladislav.razgonyaev.domain.model;

import android.arch.persistence.room.Embedded;

import com.google.gson.annotations.SerializedName;

public class Parts {

    @Embedded
    @SerializedName("day")
    private Day day;

    public Parts() {
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
