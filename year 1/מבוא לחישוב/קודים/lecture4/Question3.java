package lecture4;

import java.util.Scanner;

//lesson 4
//question 3
public class Question3 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //insert length of the array
        System.out.println("Insert length of the array:");
        int len = scanner.nextInt();
        int[] numbers = new int[len];

        //insert the numbers
        for(int i = 0; i < numbers.length; i++) {
            System.out.println("Value of cell " + (i + 1) + ":");
            numbers[i] = scanner.nextInt();
        }

        //close scanner
        scanner.close();

        //output normal order
        System.out.println("\nNumbers in normal order:");
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }

        //reversing the order
        for(int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - i - 1];
            numbers[numbers.length - i - 1] = temp;
        }

        //output reverse order
        System.out.println("\n\nNumbers in reverse order:");
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }

    }
}
