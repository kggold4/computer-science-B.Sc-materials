package lecture4;

import java.util.Arrays;
import java.util.Scanner;

//lesson 4
//question 6

public class Question6 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //get length and define the array
        System.out.print("insert array length: ");
        int len = scanner.nextInt();
        int[] numbers = new int[len];

        //close scanner
        scanner.close();

        //generate random numbers in the array between 0 to len
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * len);
        }

        //output numbers list
        String output = Arrays.toString(numbers);
        System.out.println(output);

        //count and display the numbers that divided by 3
        int count = 0;
        System.out.print("\nnumbers in the array that divided by 3:\n");
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 3 == 0 && numbers[i]!= 0) {
                System.out.print(numbers[i] + ", ");
                count++;
            }
        }

        System.out.println("\n\nsum of numbers that divided by 3: " + count);
    }
}
