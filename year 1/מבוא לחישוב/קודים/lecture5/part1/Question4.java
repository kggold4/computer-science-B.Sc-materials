package lecture5.part1;

import java.util.Scanner;
import java.util.Arrays;

//lesson 5a
//question 4

public class Question4 {

    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //get length of numbers array, define array and get the cells value
        System.out.print("insert length of array numbers: ");
        int len = scanner.nextInt();
        int[] numbers = new int[len];

        for(int i = 0; i < numbers.length; i++) {
            System.out.print("insert cell " + (i + 1) + " value: ");
            numbers[i] = scanner.nextInt();
        }

        //close scanner
        scanner.close();

        //sending numbers to the palindrom function
        boolean isSymmetrical = palindrom(numbers);

        //final output
        System.out.println("the numbers:" + Arrays.toString(numbers));
        if(isSymmetrical) {
            System.out.println("the numbers are in symmetrical order");
        } else {
            System.out.println("the numbers are not in symmetrical order");
        }

    }

    //checking if the numbers array order is symmetrical
    public static boolean palindrom(int[] numbers) {

        boolean isSymmetrical = false;
        for(int i = 0; i < numbers.length/2; i++) {
            if((numbers[i] == numbers[numbers.length - i - 1]) && (numbers[numbers.length - i - 1] == numbers[i])) {
                isSymmetrical = true;
            } else {
                isSymmetrical = false;
            }
        }

        //return true if the numbers in the array order is symmetrical
        return isSymmetrical;
    }

}
