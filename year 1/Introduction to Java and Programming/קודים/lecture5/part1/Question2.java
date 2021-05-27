package lecture5.part1;

import java.util.Scanner;

//lesson 5a
//question 2

public class Question2 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //get length of the array
        System.out.print("insert length of numbers array: ");
        int len = scanner.nextInt();

        //define array
        int[] numbers = new int[len];

        //get numbers value
        for(int i = 0; i < numbers.length; i++) {
            System.out.println("insert value of cell " + (i + 1) + ":");
            numbers[i] = scanner.nextInt();
        }

        //close scanner
        scanner.close();

        //sent to function arrayMean the numbers to get the average
        double avg = arrayMean(numbers);


        //final output
        System.out.println("numbers average: " + avg);

    }

    //calculate and return the numbers average
    public static double arrayMean(int[] numbers) {

        int sum = 0 ,avg = 0;

        for(int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }

        avg = sum / numbers.length;

        return avg;
    }
}
