
package tests.StudentList;

import Helpers.Utils;
import com.mycompany.dsadoublelinkedlist.classes.Node;
import com.mycompany.dsadoublelinkedlist.classes.Student;
import com.mycompany.dsadoublelinkedlist.classes.StudentList;

/**
 *
 * @author Frimpong Opoku Agyemang
 */
public class StudentFactory {

    /**
     *
     * @param numberOfStudents
     * @return
     */
    public static StudentList makeStudents(int numberOfStudents){ 
        StudentList list = new StudentList();
        String[] categories = {Student.PART_TIME, Student.FULL_TIME};
        for (int i = 0; i < numberOfStudents; i++){
            int index = Utils.generateRandomNumberInRange(2);
            Student newStudent = new Student("Student - "+(i+1), categories[index] ,i+1, 8);
            list.add( new Node(newStudent));
        }
        
        return list;
    }
}
