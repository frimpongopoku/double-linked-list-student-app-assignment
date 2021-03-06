package com.mycompany.dsadoublelinkedlist.classes;

import java.util.Scanner;

/**
 *
 * @author Frimpong Opoku Agyemang
 */
public class UserInputHandler {

    private final Scanner reader;

    /**
     *
     */
    public UserInputHandler() {
        reader = new Scanner(System.in);
    }

    // Read Character
    /**
     *
     * @param prompt
     * @return
     */
    public char readCharacter(String prompt) {

        System.out.println(prompt + ": ");
        char inputText = reader.nextLine().charAt(0);
        return inputText;
    }

    // Read Character - set of valid values
    /**
     *
     * @param prompt
     * @param validCharacters
     * @return
     */
    public char readCharacter(String prompt, String validCharacters) {
        char inputText = 0;
        boolean inputError;
        try {

            do {
                inputError = false;
                System.out.println(prompt + ": ");
                inputText = reader.nextLine().toUpperCase().charAt(0);
                if (validCharacters.indexOf(inputText) == -1) {
                    inputError = true;
                    System.out.println("Character out of range: please re-enter: ");
                }
            } while (inputError);
        } catch (Exception e) {
            System.out.println("You might have put in an invalid input, please try again...");
            return readCharacter(prompt, validCharacters);
        }
        return inputText;
    }

    // Read String
    /**
     *
     * @param prompt
     * @return
     */
    public String readString(String prompt) {

        System.out.println(prompt + ": ");
        String inputText = reader.nextLine();
        return inputText;
    }

    // Read Int
    /**
     *
     * @param prompt
     * @param max
     * @param min
     * @return
     */
    public int readInt(String prompt, int max, int min) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(reader.nextLine());
                if (inputNumber < min || inputNumber > max) {
                    inputError = true;
                    System.out.println("Number out of range: please re-enter\n");
                }
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }

    // Read Int
    /**
     *
     * @param prompt
     * @return
     */
    public int readInt(String prompt) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(reader.nextLine());
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }

}
