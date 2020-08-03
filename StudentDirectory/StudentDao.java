package com.csc3020.Hw08FinalProject.em0608;

import java.io.IOException;
import java.util.List;

public interface StudentDao {

    public List<Student> readAllStudents();
    public void showAllStudents();
    public void addNewStudent(Student student);
    public void updateStudent(String updateStudent);
    public void deleteStudent(int id);
    public Student findStudentID(int id);
    public List <Student> findStudentFirstName(String firstName) throws Exception;
    public List <Student> findStudentLastName(String lastName) throws Exception;
    public void writeToFile();
}


