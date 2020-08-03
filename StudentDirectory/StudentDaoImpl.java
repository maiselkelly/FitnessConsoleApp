package com.csc3020.Hw08FinalProject.em0608;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDaoImpl implements StudentDao {

    //List of Students
    List<Student> students;


    public StudentDaoImpl() {

        Student temp;

        try {
            students = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Hw08FinalProjectStudentList.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                temp = new Student();
                String[] parts = line.split(",");

                temp.setId(Integer.parseInt(parts[0]));
                temp.setFirstName(parts[1]);
                temp.setLastName(parts[2]);
                temp.setAccessId(parts[3]);
                temp.setGpa(Double.parseDouble(parts[4]));
                temp.setEntranceYear(Integer.parseInt(parts[5]));

                students.add(temp);

                // close();

            }
        } catch (IOException ioException) {
            ioException.getMessage();
        }

    }


    @Override
    public void showAllStudents() {
        students.forEach(current -> {
            System.out.println(current.toString());
        });
    }

    @Override
    public List<Student> readAllStudents() {
        return students;
    }


    @Override
    public void addNewStudent(Student student) {
        student.setId(students.size() + 1);
        students.add(student);
    }

    @Override
    public void updateStudent(String updateStudent) {

            String[] split = updateStudent.split(", ");
            int index = getStudentIndex(Integer.parseInt(split[0]));
            students.get(index).setFirstName(split[1]);
            students.get(index).setLastName(split[2]);
            students.get(index).setAccessId(split[3]);
            students.get(index).setGpa(Double.parseDouble(split[4]));
            students.get(index).setEntranceYear(Integer.parseInt(split[5]));

    }


    @Override
    public void deleteStudent(int idStudent) {

        try {
            Student student = findStudentID(idStudent);
       //     int index = getStudentIndex(idStudent);
            students.remove(student);
            System.out.println("Removed student: " + student.toString());
        }catch (Exception e){
            System.out.println("No Student Found");
        }

    }




    @Override
    public Student findStudentID(int idStudent) {
        for (Student student : students) {
            if (student.getId() == idStudent)
                return student;
        }
        return null;
    }



    public List<Student> findStudentByName(String name) throws Exception {
        List<Student> tempList = new ArrayList<Student>();
        students.forEach(current -> {
                if (current.getFirstName().toLowerCase().equals(name.toLowerCase()))
                    tempList.add(current);
             else if (current.getLastName().toLowerCase().equals(name.toLowerCase()))
                tempList.add(current);
        });
        if (tempList.isEmpty())
            throw new Exception("ERROR: no students found!");

        return tempList;
    }


    public List<Student> findStudentFirstName(String firstName) throws Exception {
        try {
            return findStudentByName(firstName);
        } catch (Exception e) {
            throw new Exception(e.getMessage() + " Property: " + firstName + '.');
        }
    }


    public List<Student> findStudentLastName(String lastName) throws Exception {
        try{
            return findStudentByName(lastName);
        }catch (Exception e){
            throw new Exception(e.getMessage() + "Property: " + lastName);
        }
    }


    public int getStudentIndex(int idStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == idStudent)
                return i;
        }
        return -1;
    }


    public void writeToFile() {

        String fileWrite;

        try (BufferedWriter oBufferedWriter = new BufferedWriter(new FileWriter("Hw08FinalProjectStudentList.txt"))) {

            for (Student student : students) {

                fileWrite = student.getId() + "," + student.getFirstName() + ","
                        + student.getLastName() + "," + student.getAccessId() + "," +
                        student.getGpa() + "," + student.getEntranceYear();

                oBufferedWriter.write(fileWrite);
                oBufferedWriter.newLine();

            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


}