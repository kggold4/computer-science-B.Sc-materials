package lecture5.part1;

import java.util.Scanner;
import java.util.Arrays;

//lesson 5a
//question 5
public class Question5 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //get numbers array length, define array and get cells value
        System.out.print("insert length of numbers array: ");
        int len = scanner.nextInt();
        int[] numbers = new int[len];

        for(int i = 0; i < numbers.length; i ++) {
            System.out.print("insert cell " + (i + 1) + " value: ");
            numbers[i] = scanner.nextInt();
        }

        //close scanner
        scanner.close();

        //output original array
        System.out.println("\nnumbers array before reverse: " + Arrays.toString(numbers));

        //sending array to reverse function
        int[] ordered = reverse(numbers);

        //final output
        System.out.println("numbers array after reverse:  " + Arrays.toString(ordered));

    }

    //reversing array order function
    public static int[] reverse(int[] numbers) {

        for(int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - i - 1];
            numbers[numbers.length - i - 1] = temp;
        }
        System.out.println("numbers array order is reversed");

        return numbers;
    }
}
