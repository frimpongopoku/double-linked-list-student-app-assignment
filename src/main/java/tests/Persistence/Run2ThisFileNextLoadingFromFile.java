package tests.Persistence;

import com.mycompany.dsadoublelinkedlist.classes.StudentList;

/**
 *
 * @author Frimpong Opoku Agyemang
 */
public class Run2ThisFileNextLoadingFromFile {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        StudentList list = new StudentList();
        list.loadFromFile("Test-save-file.txt");
        System.out.println(String.format(" %s student records loaded", list.length));
        System.out.println(String.format("----- Displaying all %s student records loaded file",list.length));
        list.display();
    }
}
