
package com.mycompany.dsadoublelinkedlist.classes;

/**
 *
 * @author Frimpong Opoku Agyemang
 */
public class Node {
    Student data;
    Node next, previous;

    /**
     *
     */
    public Node(){}

    /**
     * Initialises a node with Student Object
     * @param s
     */
    public Node(Student s) {
        this.data = s;
    }
}

