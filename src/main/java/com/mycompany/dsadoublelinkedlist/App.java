package com.mycompany.dsadoublelinkedlist;

import Helpers.Utils;
import com.mycompany.dsadoublelinkedlist.classes.Node;
import com.mycompany.dsadoublelinkedlist.classes.Student;
import com.mycompany.dsadoublelinkedlist.classes.StudentList;
import com.mycompany.dsadoublelinkedlist.classes.UserInputHandler;
import java.util.ArrayList;

/**
 *
 * @author Frimpong Opoku Agyemang
 */
public class App {

    final UserInputHandler InputReader = new UserInputHandler();
    StudentList list = new StudentList();

    public static void main(String[] args) throws Exception {

        App app = new App();
        System.out.println("WELCOME TO THE ALU STUDENTS ADMIN DATABASE APP");
        app.showMainMenu();

    }

    public void showMainMenu() {

        System.out.format("\033[31m%s\033[0m%n", "========================= MAIN MENU =====================");
        System.out.format("\033[31m%s\033[0m%n", "A. ADD A STUDENT");
        System.out.format("\033[31m%s\033[0m%n", "R. REMOVE A STUDENT");
        System.out.format("\033[31m%s\033[0m%n", "S. SEARCH FOR STUDENT");
        System.out.format("\033[31m%s\033[0m%n", String.format("D. SHOW ALL (%s) STUDENT RECORDS", list.length));
        System.out.format("\033[31m%s\033[0m%n", "L. LOAD STUDENT RECORDS FROM FILE");
        System.out.format("\033[31m%s\033[0m%n", "Q. QUIT");
        System.out.format("\033[31m%s\033[0m%n", "");
        System.out.format("\033[31m%s\033[0m%n", "[Type 'back' or 'menu' at any point in time to go to main menu]");
        System.out.format("\033[31m%s\033[0m%n", "=========================================================");

        char character = InputReader.readCharacter("What would you like to do", "ARSDLQ");
        switch (Character.toUpperCase(character)) {
            case 'A' -> {
                System.out.format("\033[31m%s\033[0m%n", "================= ADD STUDENT ==============");
                addStudent();
            }
            case 'R' -> {
                System.out.format("\033[31m%s\033[0m%n", "================= REMOVE STUDENT ==============");
                removeStudentFromRecords();
            }
            case 'S' -> {
                System.out.println("You can search by ID / Student Name");
                System.out.format("\033[31m%s\033[0m%n", "============== SEARCH FOR STUDENT ==============");
                searchForStudent();
            }
            case 'D' -> {
                System.out.format("\033[31m%s\033[0m%n", "========= DISPLAYING ALL STUDENT RECORDS =======");
                showStudentRecords();
            }
            case 'L' -> {
                System.out.format("\033[31m%s\033[0m%n", "============== LOADING FROM FILE ==============");
                loadRecordsFromFile();
            }

            case 'Q' -> {
                quit();
            }
        }

    }

    public Boolean userWantsToGoBack(String input) {
        if (input.toLowerCase().equals("back") || input.toLowerCase().equals("b")) {
            System.out.println("Going back...");
            return true;
        }

        return false;
    }

    
    

    public void addStudent() {
        String name = InputReader.readString("Name of new student");
        if (userWantsToGoBack(name)) {
            showMainMenu();
            return;
        }

        if (name.isEmpty()) {
            System.out.println("You did not type any student name, please retry....");
            addStudent();
            return;
        }

        System.out.println("Student Enrollment Type");
        System.out.println("---------------------------");
        Character c = Character.toLowerCase(InputReader.readCharacter("F. FULL TIME P. PART TIME", "FP"));
        String cat = "";
        if (c.equals('f')) {
            cat = Student.FULL_TIME;
        }
        if (c.equals('p')) {
            cat = Student.PART_TIME;
        }
        int numberOfObjects = InputReader.readInt("How many subjects does this student take?");

        Student student = new Student(name, cat, list.length + 1, numberOfObjects);
        
        list.add(new Node(student));
        showMainMenu();
    }

    public void searchForStudent() {
        String input = InputReader.readString("Enter the name, or ID of student");
        if (userWantsToGoBack(input)) {
            showMainMenu();
            return;
        }
        int id;
        Student found = null;
        if (input.isEmpty()) {
            System.out.println("You did not type anything...");
            searchForStudent();
            return;
        }

        try {
            if (input.length() == 1) { // If user typed one character, it means its probably a number, so search by ID
                id = Integer.parseInt(input);
                found = list.findById(id);
            } else {
                found = list.findByName(input);
            }

        } catch (Exception e) {
            // Means the user did not type a number, they typed one letter. So search for a  user that has a name like that 
            found = list.findByName(input);
        }

        if (found == null) {
            System.out.println(String.format("Sorry, we could not find any student record with ID or name of '%s'", input));
        } else {
            found.display();
        }

        showMainMenu();

    }

    public void showStudentRecords() {
        list.display();
        showMainMenu();
    }

    public void loadRecordsFromFile() {
        String filename = InputReader.readString("Filename");
        if (userWantsToGoBack(filename)) {
            showMainMenu();
            return;
        }
        if (filename.isEmpty()) {
            System.out.println("You did not provide any filename...");
        } else {
            list.loadFromFile(filename.trim());
            list.display();
        }
        showMainMenu();
    }

    public void removeStudentFromRecords() {
        if (list.length == 0) {
            System.out.println("There are no records available yet to remove...");
            showMainMenu();
            return;
        }
        String id = InputReader.readString("Whats the ID of the student you would like to remove?");
        if (userWantsToGoBack(id)) {
            showMainMenu();
            return;
        }
        int pos = list.getIndexOf(Integer.parseInt(id));
        if (pos != -1) {
            list.delete(pos);
        } else {
            System.out.println(String.format("Sorry, no student exists with ID '%s'...", id));
        }
        showMainMenu();
    }

    public void quit() {
        if (list.length > 0) {
            String filename = InputReader.readString("Give your file a name");
            if (userWantsToGoBack(filename)) {
                showMainMenu();
                return;
            }
            if (filename.isEmpty()) {
                filename = "new-file.txt";
            }
            String[] pieces  =filename.split(".");
            boolean doesNotHaveTXTExtension = pieces[pieces.length -1].equals("txt");
            if(doesNotHaveTXTExtension){ 
                filename = pieces[0] +".txt";
            }
            list.saveToFile(filename);
            System.out.println(String.format("The students records have been saved under the name '%s'. Thanks for using this app, goodbye!", filename));
        }else { 
            System.out.println("Your list is currently empty, you do not have anything to save yet.");
        }
    }

}
