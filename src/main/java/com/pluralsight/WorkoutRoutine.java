package com.pluralsight;

public class WorkoutRoutine {
    private String name;
    private double length;

    public WorkoutRoutine() {
    }

    public WorkoutRoutine(String name, double length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
