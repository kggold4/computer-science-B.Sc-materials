package lecture4;

import java.util.Arrays;
import java.util.Scanner;

//lesson 4
//question 7

public class Question7 {

        //main function
        public static void main(String[] args) {

            //create scanner
            Scanner scanner = new Scanner(System.in);

            //array
            double[] numbers = new double[3];

            //input
            for(int i = 0; i < numbers.length; i++) {
                System.out.print("insert value of cell " + (i + 1) + ": ");
                numbers[i] = scanner.nextDouble();
            }

            //close scanner
            scanner.close();

            //output
            System.out.println("\nbefore: " + Arrays.toString(numbers));


            //order by grater to lower
            Arrays.sort(numbers);
            for(int i = 0; i < numbers.length / 2; i++) {
                double temp = numbers[i];
                numbers[i] = numbers[numbers.length - i - 1];
                numbers[numbers.length - i - 1] = temp;
            }

            //output
            System.out.println("\nafter:  " + Arrays.toString(numbers));

        }
}
