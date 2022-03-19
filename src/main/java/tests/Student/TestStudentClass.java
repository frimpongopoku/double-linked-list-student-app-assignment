package tests.Student;


import com.mycompany.dsadoublelinkedlist.classes.Student;


/**
 *
 * @author Frimpong Opoku Agyemang
 */
public class TestStudentClass {
    public static void main(String[] args){ 
        Student student = new Student("Frimpong Opoku Agyemang",Student.PART_TIME,1,8); 
        student.display();
        
    }
}
