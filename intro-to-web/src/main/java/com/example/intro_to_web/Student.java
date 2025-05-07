package com.example.intro_to_web;

public class Student {
    private String name;
    private int roll;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

}
