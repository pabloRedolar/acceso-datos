package org.iesch.ad.Ej1.models;

public class Grade {
    private String assignment;
    private int grade;


    public Grade() {
    }

    public Grade(String assignment, int grade) {
        this.assignment = assignment;
        this.grade = grade;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
