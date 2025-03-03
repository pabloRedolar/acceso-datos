package org.iesch.ad.Ej1.models;

import java.util.HashMap;
import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private List<Grade> grades;


    public Course(String courseId, String courseName, List<Grade> grades) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.grades = grades;
    }

    public Course() {
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
