package lecture4;

import java.util.Arrays;
import java.util.Scanner;

//lesson 4
//question 5
public class Question5 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //get array length and define array
        System.out.println("insert length of numbers:");
        int len = scanner.nextInt();
        int[] numbers = new int[len];
        for(int i = 0; i < numbers.length; i++) {
            System.out.print("value of cell " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        //close scanner
        scanner.close();

        //checking if the array is symmetrical
        boolean isSymetrical = false;
        for(int i = 0; i < numbers.length / 2; i++) {
            if(numbers[i] == numbers[numbers.length - i - 1]) {
                isSymetrical = true;
            }
        }

        //output
        String output = Arrays.toString(numbers);
        System.out.println("\nNumbers list is: " + output);
        if(isSymetrical) {
            System.out.println("the numbers array is symmetrical");
        } else {
            System.out.println("the numbers array is not symmetrical");
        }
    }
}
