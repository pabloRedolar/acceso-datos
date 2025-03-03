package org.iesch.ad.Ej1.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;

@Document()
public class Estudiante {

    private String _id;

    private String name;
    private int age;
    private Address address;
    private List<Course> courses;
    private List<HashMap<String, String>> extracurriculars;

    public Estudiante() {
    }

    public Estudiante(String _id, String name, int age, Address address, List<Course> courses, List<HashMap<String, String>> extracurriculars) {
        this._id = _id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.courses = courses;
        this.extracurriculars = extracurriculars;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<HashMap<String, String>> getExtracurriculars() {
        return extracurriculars;
    }

    public void setExtracurriculars(List<HashMap<String, String>> extracurriculars) {
        this.extracurriculars = extracurriculars;
    }
}
