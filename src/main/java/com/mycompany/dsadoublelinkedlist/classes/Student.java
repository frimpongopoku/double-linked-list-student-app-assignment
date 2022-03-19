package com.mycompany.dsadoublelinkedlist.classes;

/**
 *
 * @author Frimpong Opoku Agyemang
 */
import Helpers.Utils;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author PongoALU
 */
public class Student implements IDisplayable {

    /**
     *
     */
    public static final String FULL_TIME = "full-time";

    /**
     *
     */
    public static final String PART_TIME = "part-time";
    int Id;
    String name;
    int numberOfSubjects;
    ArrayList<Integer> marks;
    float averageMark;

    Date dateOfEnrollment = new Date();
    String category;

    /**
     *
     */
    public Student() {
    }

    /**
     *
     * @param name
     * @param category
     * @param Id
     * @param marks
     * @param average
     */
    public Student(String name, String category, int Id, ArrayList<Integer> marks, float average) {
        this.name = name;
        this.category = category;
        this.Id = Id;
        this.marks = marks;
        this.averageMark = average;
    }

    /**
     *
     * @param name
     * @param category
     * @param Id
     * @param numberOfSubjects
     */
    public Student(String name, String category, int Id, int numberOfSubjects) {
        this.name = name;
        this.category = category;
        this.Id = Id;
        this.numberOfSubjects = numberOfSubjects;
        this.marks = Utils.generateMarks(numberOfSubjects);
        this.averageMark = Utils.makeAverage(this.marks);
    }

    /**
     * Retrieves student ID
     * @return
     */
    public int getId() {
        return this.Id;
    }

    /**
     * Used to set student ID
     * @param id
     */
    public void setId(int id) {
        Id = id;
    }

    /**
     * Retrieves the name of the student
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Used to set the name of a user
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the number of subjects a user takes
     * @return
     */
    public int getNumberOfSubjects() {
        return numberOfSubjects;
    }

    /**
     * Used to set the number of subjects a student takes
     * @param numberOfSubjects
     */
    public void setNumberOfSubjects(int numberOfSubjects) {
        this.numberOfSubjects = numberOfSubjects;
    }

    /**
     * Retrieves the array or all student marks
     * @return
     */
    public ArrayList<Integer> getMarks() {
        return marks;
    }

    /**
     * Retrieve the average mark of the user
     * @return
     */
    public float getAverageMark() {
        return averageMark;
    }

    /**
     * Used to set the average mark of the student
     * @param averageMark
     */
    public void setAverageMark(int averageMark) {
        this.averageMark = averageMark;
    }

    /**
     *
     * @param marks
     */
    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
    }

    /**
     * Retrieves the date of enrolment of the student
     * @return
     */
    public Date getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    /**
     * Used to set the date of enrolment of the student
     * @param dateOfEnrollment
     */
    public void setDateOfEnrollment(Date dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    /**
     *
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Shows all information about the student in a human-friendly format
     */
    @Override
    public void display() {
        System.out.println(Id + " - " + name + ", Category: " + category + ", Date of Enrollment: " + Utils.humanFormatter.format(dateOfEnrollment) + ", Number of subjects: " + numberOfSubjects);
        System.out.println("........................");
        System.out.print(name + "'s Marks: ");
        System.out.println(Utils.arrayToString(marks,","));
        System.out.print("Average Score: ");
        System.out.println(averageMark);
        System.out.println("........................");
    }

    @Override
    public String toString() {
        return Id + "," + name + "," + averageMark + "," + category + "," + Utils.formatter.format(dateOfEnrollment) + "," + numberOfSubjects + "," + Utils.DELIMITER + Utils.arrayToString(marks,"-") + Utils.DELIMITER;
    }

}
