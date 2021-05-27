package lecture5.part1;

import java.util.Scanner;

//lesson 5a
//question 1
public class Question1 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //get array length
        System.out.print("insert length of the array: ");
        int len = scanner.nextInt();
        int[] numbers = new int[len];

        //get array numbers
        for(int i = 0; i < numbers.length; i++) {
            System.out.print("insert value of cell " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        //close scanner
        scanner.close();

        //sending the numbers to arraySum function
        double sum = arraySum(numbers);

        //final output
        System.out.println("\nsum of the numbers is: " + sum);

    }

    //return the sum of the array numbers
    public static double arraySum(int[] numbers) {

        int sum = 0;

        //caculate the sum of the numbers
        for(int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }

        //return sum to main function
        return sum;
    }
}
