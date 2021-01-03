package lecture5.part1;

import java.util.Arrays;
import java.util.Scanner;

//lesson 5a
//question 3

public class Question3 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //get numbers array length and define array
        System.out.print("insert length of numbers array: ");
        int len = scanner.nextInt();
        int[] numbers = new int[len];

        //get numbers array values
        for(int i = 0; i < numbers.length; i++) {
            System.out.print("insert value of cell " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        //close scanner
        scanner.close();

        //output numbers array
        System.out.println("numbers: " + Arrays.toString(numbers));

        //sending numbers to arrayStdev function and get stdev
        double stdev = arrayStdev(numbers);

        //final output
        System.out.println("\nStdev = " + stdev);

    }

    //stdev function
    public static double arrayStdev(int[] numbers) {

        //getting sum of numbers
        double sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }

        //getting average of numbers
        double avg = sum / numbers.length;
        System.out.println("avg is: " + avg);

        //calulate the induction
        double induction = 0;
        for(int i = 0; i < numbers.length; i++) {
            induction = induction + Math.pow((numbers[i] - avg), 2);
        }

        //sqrt base and stdev calculation
        double base = induction / numbers.length;
        double stdev = Math.sqrt(base);

        //return to main function the stdev value
        return stdev;
    }
}
