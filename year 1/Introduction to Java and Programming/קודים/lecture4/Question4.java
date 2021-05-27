package lecture4;

import java.util.Scanner;

//lesson 4
//question 4
public class Question4 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //get array length and define array
        System.out.println("Insert length numbers array: ");
        int len = scanner.nextInt();
        int[] numbers = new int[len];

        //close scanner
        scanner.close();

        //generate random numbers between 0 to len
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * len);
        }

        //output the numbers list
        System.out.println("\nNumbers list:");
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }

        //counting double(not odd) numbers in the array
        int count = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) {
                count++;
            }
        }

        //final output, numbers of double numbers
        System.out.println("\n\nThere is " + count + " double numbers");

    }
}
