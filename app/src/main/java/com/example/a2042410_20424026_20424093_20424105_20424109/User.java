package com.example.a2042410_20424026_20424093_20424105_20424109;

public class User {
    private String name;
    private String grade;
    private Double average;

    public User() {
        this.name = "";
        this.grade = "";
        this.average = 0.0;
    }

    public User(String grade, String name, Double average){
        this.grade = grade;
        this.name = name;
        this.average = average;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }
}
