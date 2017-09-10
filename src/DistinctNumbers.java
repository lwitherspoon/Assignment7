import java.util.Scanner;
import java.util.Arrays;

/**
 * Program to count and display distinct numbers
 * @author Laura Witherspoon
 * Assignment 7.3
 * Date: 9/9/2017
 */

public class DistinctNumbers {

    /**
     * Prompts user to input ten numbers
     * Allows user to input positive and negative numbers and zero
     */
    private static int[] readInput() {
        int[] numbersArray = new int[10];
        System.out.println("Please enter ten numbers, each separated by a space.");

        Scanner keyboard = new Scanner(System.in);
        int numbers = 0;

        while (numbers < 10) {
            numbersArray[numbers] = keyboard.nextInt();
            numbers++;
        }

        Arrays.sort(numbersArray);

        return numbersArray;
    }

    /**
     * Check if value at given position in given array is unique in the array
     * @param iteration the array position
     * @param array the array to check uniqueness against
     * @return true or false if value is unique
     */
    private static boolean isDistinct(int iteration, int[] array) {
        boolean isDistinct = true;

        for (int j = iteration + 1; j < array.length; j++) {
            if (array[iteration] == array[j]) {
                isDistinct = false;
            }
        }

        return isDistinct;
    }

    /**
     * Creates and returns a new array containing the distinct numbers in a given array
     * @param array the array within which to check for distinct numbers
     * @return array of the distinct numbers in the given array
     */
    private static Integer[] createDistinctNumbersArray(int[] array) {
        Integer[] distinctNumbersArray = new Integer[array.length];

        // Loop through numbers and check if they are distinct
        // If distinct, save number at position i to new array
        // If not distinct, new array value at position i defaults to null
        for (int i = 0; i < array.length; i++) {
            if (isDistinct(i, array)) {
                distinctNumbersArray[i] = array[i];
            }
        }

        return distinctNumbersArray;
    }

    /**
     * Counts the number of distinct numbers in a given array
     * @param array the array in which to count distinct numbers
     * @return the count of distinct numbers in array
     */
    static int countDistinctNumbersInArray(int[] array) {
        int counter = 0;

        // Loop through numbers and increase counter if they are unique
        for (int i = 0; i < array.length; i++) {
            if (isDistinct(i, array)) {
                counter++;
            }
        }

        return counter;
    }

    /**
     * Gets concatenated string of distinct numbers
     * @param numbersArray array of numbers input by user
     * @return a concatenated string of distinct numbers separated by spaces
     */
    static String getDistinctNumbers(int[] numbersArray) {

        String result = "";

        for (Integer num : createDistinctNumbersArray(numbersArray)) {

            // Null indicates duplicate (non-distinct) number and is ignored
            if (num != null)
                result += num + " ";
        }

        return result;
    }

    public static void main(String[] args) {

        int[] numbersArray = readInput();
        System.out.println("\nNumber of distinct numbers: " + countDistinctNumbersInArray(numbersArray));
        System.out.print("The distinct numbers are: ");
        System.out.println(getDistinctNumbers(numbersArray));

    }
}
