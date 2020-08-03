package com.csc3020.Hw08FinalProject.em0608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;


public class MainSource {

    public static void main(String[] args) throws IOException {

        StudentDao oStudentDao = new StudentDaoImpl();
        char caseInput;

        try {
            do {
                caseInput = printMenu();
                switch (caseInput) {
                    case '1':
                        System.out.println("Print all students");
                        oStudentDao.showAllStudents();
                        break;

                    case '2':
                        //Adding a Student
                        addingAStudent(oStudentDao);
                        break;

                    case '3':
                        //Updating a Student
                        updatingAStudent(oStudentDao);
                        break;

                    case '4':
                        //Deleting a Student
                        deletingAStudents(oStudentDao);
                        break;

                    case '5':
                        //Search for Students by ID
                        searchingById(oStudentDao);
                        break;

                    case '6':
                        //Search for Students by First Name
                        searchingByFirstName(oStudentDao);
                        break;


                    case '7':
                        //Search for Students by Last Name
                        searchingByLastName(oStudentDao);
                        break;

                    case 'q':
                        System.out.println("Exit.");
                }


            } while (caseInput != 'q');


        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.getClass().getSimpleName());
        }
    }


    public static String userInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static char printMenu() {

        char option = 'q';

        System.out.println("CSC 3020 Final Project");
        System.out.println("1. Show student list");
        System.out.println("2. Add a New Student");
        System.out.println("3. Edit a student by Id");
        System.out.println("4. Delete a student");
        System.out.println("5. Find a student by Id");
        System.out.println("6. Find student(s) by First Name");
        System.out.println("7. Find student(s) by Last Name");
        System.out.println("Please q to exit or Press 1-7");

        option = Character.toLowerCase(userInput().charAt(0));
        return option;

    }


    public static void addingAStudent(StudentDao oStudentDao) {
        System.out.println("Adding a new student");
        System.out.println("Enter: Id, First Name, Last Name, Access ID, GPA and Entrance Year");
        try {

            Scanner input = new Scanner(System.in);
            String addReaderConsole = input.nextLine();
            String[] addSplit = addReaderConsole.split(",");

            Student addStudent = new Student();
            addStudent.setId(-1);
            addStudent.setFirstName(addSplit[1]);
            addStudent.setLastName(addSplit[2]);
            addStudent.setAccessId(addSplit[3]);
            addStudent.setGpa(Double.parseDouble(addSplit[4]));
            addStudent.setEntranceYear(Integer.parseInt(addSplit[5].trim()));

            oStudentDao.addNewStudent(addStudent);
            System.out.println("Student: " + addStudent + " has been added to the list.");

            oStudentDao.writeToFile();

        } catch (Exception oException) {
            System.out.println("Invalid input.");
            System.out.println(oException.getMessage());
        }
    }

    public static void updatingAStudent(StudentDao oStudentDao) throws IOException, NumberFormatException {
        System.out.println("Updating a student");
        System.out.println("Please enter a student id to update.");

        BufferedReader updateIDReader = new BufferedReader(new InputStreamReader(System.in));
        String idReader;
        idReader = updateIDReader.readLine();


        Student student1 = oStudentDao.findStudentID(Integer.parseInt(idReader));
        if (student1 != null)
            System.out.println("Updating: " + student1);

        System.out.println("Enter Student information");
        BufferedReader updateInfo = new BufferedReader(new InputStreamReader(System.in));
        String updateReader;
        updateReader = updateInfo.readLine();


        oStudentDao.updateStudent(updateReader);
        System.out.println("Updated Student information: " + updateReader);

        oStudentDao.writeToFile();

    }

    public static void deletingAStudents(StudentDao oStudentDao) throws IOException {
        System.out.println("Deleting a Student");
        System.out.println("Please enter a student id to delete.");

        BufferedReader deleteIDReader = new BufferedReader(new InputStreamReader(System.in));
        String idReader2;
        idReader2 = deleteIDReader.readLine();
        int studentID = Integer.parseInt(idReader2);

        oStudentDao.deleteStudent(studentID);
        oStudentDao.writeToFile();
    }

    public static void searchingByFirstName(StudentDao oStudentDao) {
        try {
            System.out.println("Searching for a Student");
            System.out.println("Please enter a student first name to search.");
            BufferedReader findIDReader = new BufferedReader(new InputStreamReader(System.in));
            String fNameReader;
            fNameReader = findIDReader.readLine();

            oStudentDao.findStudentFirstName(fNameReader).forEach(current -> {
                System.out.println(current.toString());
            });


        } catch (Exception oException) {
            System.out.println("Invalid first name entered");
        }
    }

    public static void searchingByLastName(StudentDao oStudentDao){
        try {
            System.out.println("Searching for a Student");
            System.out.println("Please enter a student last name to search.");
            BufferedReader findIDReader = new BufferedReader(new InputStreamReader(System.in));
            String lNameReader;
            lNameReader = findIDReader.readLine();

            oStudentDao.findStudentLastName(lNameReader).forEach(current->{
                System.out.println(current.toString());
            });

        } catch (Exception oException) {
            System.out.println("Invalid last name entered");
            System.out.println(oException.getMessage());
        }

    }

    public static void searchingById(StudentDao oStudentDao){
        try {

            System.out.println("Searching for a Student");
            System.out.println("Please enter a student id to search.");
            BufferedReader findIDReader = new BufferedReader(new InputStreamReader(System.in));
            String idReader1 = findIDReader.readLine();
            int studentID1 = Integer.parseInt(idReader1);

                System.out.println(oStudentDao.findStudentID(studentID1));

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }


}



