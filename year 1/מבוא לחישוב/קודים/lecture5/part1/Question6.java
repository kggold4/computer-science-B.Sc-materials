package lecture5.part1;

import java.util.Scanner;
import java.util.Arrays;

//lesson 5a
//question 6
public class Question6 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //get length, define array and gets cells value
        System.out.print("insert length of numbers array: ");
        int len = scanner.nextInt();
        int[] numbers = new int[len];
        for(int  i = 0; i < numbers.length; i++) {
            System.out.print("insert cell " + (i + 1) + " value: ");
            numbers[i] = scanner.nextInt();
        }

        //get i and j
        int m = 0, i = 0, j = 0;
        while(m == 0) {
            System.out.println("\ninsert two index numbers you want to swap them (between 0 to "  + (numbers.length - 1) +  ")");
            System.out.print("insert first numbers index: ");
            i = scanner.nextInt();
            System.out.print("insert second number index: ");
            j = scanner.nextInt();
            if((i >= 0 && i < numbers.length) && (j >= 0 && j < numbers.length)) {
                break;
            } else {
                System.out.println("one of numbers is out range!");
            }
        }

        //close scanner
        scanner.close();

        //output before swap
        System.out.println("numbers array before swaping i with j:\n\t" + Arrays.toString(numbers));

        //sending numbers array to swap function
        int[] swapNumbers = swap(i, j, numbers);

        //final output
        System.out.println("numbers array after swaping i with j:\n\t" + Arrays.toString(swapNumbers));
    }

    //swap function
    public static int[] swap(int i, int j, int[] numbers) {

        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;

        return numbers;
    }
}
