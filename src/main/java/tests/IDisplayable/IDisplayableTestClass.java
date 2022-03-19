
package tests.IDisplayable;

import tests.IDisplayable.IDisplayableImplementation;

/**
 *
 * @author Frimpong Opoku Agyemang
 */
public class IDisplayableTestClass {
    
   public static void main (String[] args) { 
       System.out.println("---- Testing IDidisplayable Class ------");
       IDisplayableImplementation iDisplay = new IDisplayableImplementation();
       iDisplay.display();
   }
    
}
