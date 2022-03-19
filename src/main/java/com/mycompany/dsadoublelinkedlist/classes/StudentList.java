package com.mycompany.dsadoublelinkedlist.classes;

import Helpers.Utils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class that represents the node
 *
 * @author Frimpong Opoku Agyemang
 */
public class StudentList implements IDisplayable {

    private final Node head, tail;

    /**
     *
     */
    public int length = 0;

    /**
     *
     */
    public StudentList() {
        this.head = new Node();
        this.tail = new Node();
    }

    /**
     * Takes in the id of a Student ID And traverses the node chain to find the
     * position of any student whose ID matches Then returns the Student Object
     * on the node
     *
     * @param id
     * @return
     */
    public Student findById(int id) {
        int count = 0;
        Node node = head.next;
        while (count < length) {
            if (node.data != null && id == node.data.getId()) {
                return node.data;
            }
            node = node.next;
            count++;
        }
        return null;
    }

    /**
     *
     * @param name
     * @return
     */
    public Student findByName(String name) {
        int count = 0;
        Node node = head.next;
        while (count < length) {
            if (node.data != null && name.toLowerCase().equals(node.data.getName().toLowerCase())) {
                return node.data;
            }
            node = node.next;

            count++;
        }
        return null;
    }

    /**
     * Takes in the id of a Student ID And traverses the node chain to find the
     * position of any student whose ID matches Then returns the position of the
     * matching student on the node chain
     *
     * @param id
     * @return
     */
    public int getIndexOf(int id) {
        int count = 0;
        Node node = head.next;
        while (count < length) {
            if (node.data != null && id == node.data.getId()) {
                return count;
            }
            node = node.next;

            count++;
        }
        return -1;
    }

    /**
     * Takes in a new node, and a position as parameters And reconstructs the
     * node chain with the just-passed node at the specified position
     *
     * @param n
     * @param position
     */
    public void insert(Node n, int position) {
        if (length <= 0) {
            head.next = n;
            n.previous = head;
            n.next = tail;
            tail.previous = n;
        } else {
            int count = 0;
            Node node = head.next;
            while (count < position) {
                node = node.next;
                count++;
            }
            node.previous.next = n;
            n.previous = node.previous;
            n.next = node;
            node.previous = n;
        }
        length++;
    }

    /**
     * Takes a new node, And appends it to the end of node chain
     *
     * @param n
     */
    public void add(Node n) {
        if (length == 0) {
            head.next = n;
            n.previous = head;
            n.next = tail;
            tail.previous = n;
        } else {
            Node node = tail.previous;
            node.next = n;
            n.previous = node;
            n.next = tail;
            tail.previous = n;
        }
        length++;
    }

    /**
     * Takes in a position as parameter, And removes the node that exists at the
     * specified position
     *
     * @param position
     */
    public void delete(int position) {

        if (length == 1) {
            head.next = tail;
            tail.previous = head;
            length = 0;
        }

        if (position < 0 || position > length - 1) {
            System.out.println(String.format("The node you want to delete at position %s is out of range", position));
        }

        int count = 0;
        Node node = head.next;

        while (count < position) {
            node = node.next;
            count++;
        }
        Node previous = node.previous;
        Node next = node.next;
        previous.next = next;
        next.previous = previous;

        length--;

    }

    /**
     * Takes in a filename And uses it as a label to store the "stringified"
     * content of of the StudentList object
     *
     * @param filename
     */
    public void saveToFile(String filename) {
        try (PrintWriter output = new PrintWriter(filename)) {
            output.print(this.toString());
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Takes in a file name, reads the content of the file And uses its content
     * to reconstruct a new studentList object
     *
     * @param filename
     */
    public  void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] temp;
            String line = br.readLine();
            while (line != null) {
                temp = line.split(",");
                String name, category;
                int id, subs;
                float average;
                String[] marks;
                id = Integer.parseInt(temp[0]);
                name = temp[1];
                average = Float.valueOf(temp[2]);
                category = temp[3];
                Date date = Utils.formatter.parse(temp[4]); 
                subs = Integer.parseInt(temp[5]);
                marks = temp[6].trim().split(Utils.DELIMITER)[1].split("-");
                //Create new student object with deconstructed string, and just processed values
                Student newStudent = new Student(name, category, id, Utils.toArrayList(marks), average);
                newStudent.setDateOfEnrollment(date);
                newStudent.setNumberOfSubjects(subs);

                this.add(new Node(newStudent));
                line = br.readLine();
            }

            br.close();
        } catch (IOException | ParseException | NumberFormatException  ex) {
            System.out.println("Sorry, the content of your file cannot be loaded into the app...");

        }
       
    }

    /**
     * Displays the content of all nodes on the double linked list chain
     */
    @Override
    public void display() {
        Node node = head.next;
        if (length == 0) {
            System.out.println("There are no records of students yet...");
            return;
        }
        int count = 0;
        try {

            while (count <= length) {
                if (node.previous != null && node.next != null) {
                    node.data.display();
                }
                node = node.next;
                count++;
            }
        } catch (Exception e) {
            System.out.println("Sorry, some records were not valid to be processed...");
        }
    }

    @Override
    public String toString() {
        String string = "";
        Node node = head.next;
        if (length == 0) {
            return string;
        }
        int count = 0;
        while (count <= length) {
            if (node.previous != null && node.next != null) {
                if (string.isEmpty()) {
                    string = node.data.toString();
                } else {
                    string += "\n" + node.data.toString();
                }
            }
            node = node.next;
            count++;
        }
        return string;
    }

}
