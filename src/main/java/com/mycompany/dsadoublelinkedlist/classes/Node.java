
package com.mycompany.dsadoublelinkedlist.classes;

/**
 *
 * @author Frimpong Opoku Agyemang
 */
public class Node {
    Student data;
    Node next, previous;

    public Node(){}
    public Node(Student d) {
        this.data = d;
    }
}

