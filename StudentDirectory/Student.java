package com.csc3020.Hw08FinalProject.em0608;

public class Student implements Comparable<Student> {
    int id;
    String firstName;
    String lastName;
    String accessId;
    double gpa;
    int entranceYear;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(int entranceYear) {
        this.entranceYear = entranceYear;
    }


    public Student(){

    }

    public Student(int id){
        this();
        this.id = id;
    }


    public Student(Student input){
      //  this.input = input;
    }


    public Student(int id, String firstName, String lastName, String accessId, double gpa, int entranceYear) {
        this(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.accessId = accessId;
        this.gpa = gpa;
        this.entranceYear = entranceYear;
    }

    @Override
    public String toString() {
        return   id + "," +
                 firstName + "," +
                 lastName + "," +
                 accessId + "," +
                 gpa + "," +
                 entranceYear;
    }

    @Override
    public int compareTo(Student o){
        return 0;
    }
}
