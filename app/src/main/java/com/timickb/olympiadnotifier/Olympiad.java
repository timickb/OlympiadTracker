package com.timickb.olympiadnotifier;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Olympiad {
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("subjects")
    @Expose
    private ArrayList<String> subjects;

    @SerializedName("classes")
    @Expose
    private ArrayList<String> classes;

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public ArrayList<String> getClasses() {
        return classes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public void setClasses(ArrayList<String> classes) {
        this.classes = classes;
    }
}
