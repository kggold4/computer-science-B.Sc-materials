package lecture6;

import java.util.Scanner;

//lesson 6
//question 8
public class Question8 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //getting num
        System.out.print("insert a natural number: ");
        int num = scanner.nextInt();

        //close scanner
        scanner.close();

        //counting num length
        int lengthCounter = 0;
        int countingNum = num;
        while(countingNum != 0) {
            countingNum = countingNum / 10;
            lengthCounter++;
        }

        //define array with num digits
        int[] separate = new int[lengthCounter];
        int separatingNum = num;
        for(int i = 0; i < separate.length; i++) {
            separate[i] = separatingNum % 10;
            separatingNum = separatingNum / 10;
        }

        //getting the max digit
        int max = 0;
        for(int i = 0; i < separate.length; i++) {
            if(separate[i] > max) max = separate[i];
        }

        //final output
        System.out.println("max digit is: " + max);
    }
}
