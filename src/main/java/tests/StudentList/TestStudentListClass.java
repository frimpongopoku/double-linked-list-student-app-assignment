package tests.StudentList;

import tests.StudentList.StudentFactory;
import Helpers.Utils;
import com.mycompany.dsadoublelinkedlist.classes.Node;
import com.mycompany.dsadoublelinkedlist.classes.Student;
import com.mycompany.dsadoublelinkedlist.classes.StudentList;

/**
 *
 * @author Frimpong Opoku Agyemang
 */
public class TestStudentListClass {

    public static void main(String[] args) {
        //------ Test adding, and displaying student records to student list
        StudentList list = StudentFactory.makeStudents(5);
        System.out.println("------ DISPLAY ALL STUDENT RECORDS ----------");
        list.display();
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        //------- Test removing a student record
        System.out.println("------ Removing 'Student - 1' -------");
        list.delete(0);
        System.out.println(String.format("------- Displaying remaining(%s) students ------", list.length));
        list.display();

        System.out.println("");
        System.out.println("");
        System.out.println("");
        //-------- Test inserting a record at some position 
        System.out.println("------- Inserting new student at index 3 --------");
        Student stud = new Student("New Guy Inserted", Student.FULL_TIME, 999, 8);
        list.insert(new Node(stud), 3);
        System.out.println("--------- Displaying students after insertion... ------------");
        list.display();

    }
}
