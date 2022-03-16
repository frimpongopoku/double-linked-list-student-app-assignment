package com.mycompany.dsadoublelinkedlist;

import com.mycompany.dsadoublelinkedlist.classes.Node;
import com.mycompany.dsadoublelinkedlist.classes.Student;
import com.mycompany.dsadoublelinkedlist.classes.StudentList;
import com.mycompany.dsadoublelinkedlist.classes.UserInputHandler;

/**
 *
 * @author Frimpong Opoku Agyemang
 */
public class App {

    final UserInputHandler InputReader = new UserInputHandler();
    StudentList list = new StudentList();

    public static void main(String[] args) throws Exception {

        //--- Testing IDisplayable class
//        TestingIDisplayable displayer = new TestingIDisplayable();
//        displayer.display();
        //-- Testing Student class
//        Student student = new Student("Mobi Dick","full-time");
//        student.display();
        //--- Testing StudentList display
//        StudentList list = new StudentList(); // Dont comment this part out, all the parts below for testing depend on this
//        list.createDummyList(); // Dont comment this part out, all the parts below for testing depend on this
//        list.display(); // Test list display
//
        //---- Testing StudentList insertion
//        Student newStudent = new Student("Sunday Guy","part-time",23);
//        list.insert(new Node(newStudent),1);
//        list.display(); Testing what list looks like after insertion
        //---- Testing StudentList item deletion with position
//        list.delete(0); // "Monday Guy" should be removed after here
//        list.display();
        // --- Testing StudentList find with studentId
//            Student found = list.findById(2);
//            if(found != null) found.display(); // "Tuesday Guy" should be printed here
//            else System.out.println("Sorry, could not find any user with that Id");
        // --- Testing StudentList find with studentName
//        Student found = list.findByName("Wednesday Guy");
//        if(found != null) found.display(); // "Wednesday Guy" should be printed here
//        else System.out.println("Sorry, could not find any user with that Name");
        // --- Testing StudentList saving to file
//        list.saveToFile("first-file.txt");
//        ------------------ Remove parts for testing code after you have copied the content of the console into a document like the assignment says -----
        //-------------- APP BEGINNING HERE --------------
        App app = new App();
        System.out.println("WELCOME TO THE ALU STUDENTS ADMIN DATABASE APP");
        app.launchMenu();

    }

    public void launchMenu() {
        System.out.format("\033[31m%s\033[0m%n", "========================= MAIN MENU =====================");
        System.out.format("\033[31m%s\033[0m%n", "A. ADD A STUDENT");
        System.out.format("\033[31m%s\033[0m%n", "R. REMOVE A STUDENT");
        System.out.format("\033[31m%s\033[0m%n", "S. SEARCH FOR STUDENT");
        System.out.format("\033[31m%s\033[0m%n", String.format("D. SHOW ALL (%s) STUDENT RECORDS",list.length));
        System.out.format("\033[31m%s\033[0m%n", "L. LOAD STUDENT RECORDS FROM FILE");
        System.out.format("\033[31m%s\033[0m%n", "Q. QUIT");
        System.out.format("\033[31m%s\033[0m%n", "=========================================================");
        char character = InputReader.readCharacter("Enter menu option", "ARSDLQ");
        switch (Character.toUpperCase(character)) {
            case 'A': {
                addStudent();
                break;
            }
            case 'R': {
                removeStudentFromRecords();
                break;
            }
            case 'S': {
                System.out.println("You can search by ID / Student Name");
                System.out.format("\033[31m%s\033[0m%n", "==================== SEARCH FOR STUDENT ====================");
                searchForStudent();
                break;
            }
            case 'D': {
                System.out.format("\033[31m%s\033[0m%n", "================= Displaying all student records ==============");
                showStudentRecords();
                break;
            }
            case 'L': {
                loadRecordsFromFile();
                break;
            }

            case 'Q': {
                quit();
                break;
            }
        }

    }

    public void addStudent() {
        String name = InputReader.readString("Name of new student");
        String cat = InputReader.readString("Student enrollment type(full-time/part-time)");
        Student student = new Student(name, cat, list.length + 1);
        list.add(new Node(student));
        launchMenu();
    }

    public void searchForStudent() {

        String input = InputReader.readString("Enter the name, or ID of student");
        int id;
        Student found = null;
        if (input.isEmpty()) {
            System.out.println("You did not type anything...");
            searchForStudent();
            return;
        }

        try {
            if (input.length() == 1) {
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

        launchMenu();

    }

    public void showStudentRecords() {
        list.display();
        launchMenu();
    }

    public void loadRecordsFromFile() {
        String filename = InputReader.readString("Filename");
        if (filename.isEmpty()) {
            System.out.println("You did not provide any filename...");
        } else {
            StudentList loadedList = list.loadFromFile(filename.trim());
            this.list = loadedList;
            loadedList.display();
        }
        launchMenu();
    }

    public void removeStudentFromRecords() {
        int id = InputReader.readInt("Whats the ID of the student you would like to remove?");
        int position = list.getPositionOfStudent(id);
        list.delete(position);
        launchMenu();
    }

    public void quit() {
        if (list.length > 0) {
            String filename = InputReader.readString("Give your file a name");
            if (filename.isEmpty()) {
                filename = "new-file.txt";
            }
            list.saveToFile(filename);
            System.out.println(String.format("The students records have been saved under the name '%s'. Thanks for using this app, goodbye!", filename));
        }
    }

}
