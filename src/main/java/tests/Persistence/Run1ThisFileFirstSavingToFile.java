package tests.Persistence;


import com.mycompany.dsadoublelinkedlist.classes.StudentList;
import tests.StudentList.StudentFactory;

/**
 *
 * @author Frimpong Opoku Agyemang
 */
public class Run1ThisFileFirstSavingToFile {
        public static void main ( String[] args) { 
         StudentList list = StudentFactory.makeStudents(10);
        list.saveToFile("Test-save-file.txt");
        list.display();
        System.out.println(String.format("Your file named 'Test-save-file.txt' has been saved with a list of %s student records", list.length));
        // Now you may look through the Netbeans directory to find "Test-save-file.txt" 
    }
}
