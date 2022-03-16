
package com.mycompany.dsadoublelinkedlist.classes;

/**
 *
 * @author Frimpong Opoku Agyemang
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements IDisplayable {
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    int Id;
    String name;
    int numberOfSubjects;
    int marks;
    Date dateOfEnrollment = new Date();
    String category;

    public Student() {
    }

    public Student(String name, String category,int Id) {
        this.name = name;
        this.category = category;
        this.Id = Id;
    }


    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSubjects() {
        return numberOfSubjects;
    }

    public void setNumberOfSubjects(int numberOfSubjects) {
        this.numberOfSubjects = numberOfSubjects;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Date getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(Date dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public void display() {
        System.out.println(Id + " - " + name + ", " + "Marks: " + marks + ", Category: " + category + ", Date of enrollment: " + formatter.format(dateOfEnrollment) + ", Number of subjects: " + numberOfSubjects);
    }

    @Override
    public String toString() {
        return Id + "," + name + ","  + marks + "," + category + "," + formatter.format(dateOfEnrollment) + "," + numberOfSubjects;
    }

}

