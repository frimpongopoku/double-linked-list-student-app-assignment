package Helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Frimpong Opoku Agyemang
 */
public class Utils {

    /**
     *
     */
    public static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY HH:mm");

    /**
     *
     */
    public static final SimpleDateFormat humanFormatter = new SimpleDateFormat("dd MMMM, yyyy HH:mm a");

    /**
     * 
     */
    public static final String DELIMITER = "::";

    /**
     * Generates a random between 0, and a provided limit
     * @param limit
     * @return
     */
    public static int generateRandomNumberInRange(int limit) {
        Random r = new Random();
        return r.nextInt(limit);
    }

    /**
     * Given an array, and delimiter, it combines the elements of the array into a string separated by the delimiter
     * @param arr
     * @param delimiter
     * @return
     */
    public static String arrayToString(ArrayList<Integer> arr, String delimiter) {
        String string = "";
        for (int i = 0; i < arr.size(); i++) {
            String s = String.valueOf(arr.get(i));
            if (string.isEmpty()) {
                string = s;
            } else {
                string += delimiter + s;
            }
        }
        return string;
    }
    
    /**
     * Changes a String[] into an ArrayList
     * @param arr
     * @return
     */
    public static ArrayList toArrayList(String[] arr){
        ArrayList<String> list = new ArrayList();
        for(int i =0; i< arr.length; i++ ){
            list.add(arr[i]);
        }
        return list;
    }
    
    /**
     * Generates random numbers between the range of 0, and 100. It generates as many numbers  with 
     * respect to the the integer value provided as parameter.
     * @param num
     * @return
     */
    public static ArrayList<Integer> generateMarks(Integer num) {
        ArrayList<Integer> marks = new ArrayList();
        for (int i = 0; i < num; i++) {
            marks.add(Utils.generateRandomNumberInRange(100));
        }

        return marks;
    }
    
    /**
     * Determines the average, given an array of marks
     * @param marks
     * @return
     */
    public static float makeAverage(ArrayList<Integer> marks) {
        int sum = 0;
        for (int i = 0; i < marks.size(); i++) {
            sum += marks.get(i);
        }
        return (float) sum / marks.size();
    }

}
