package lecture5.part1;

import java.util.Scanner;
import java.util.Arrays;

//lesson 5a
//question 7 (bonus)

public class Question7 {
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

        //close scanner
        scanner.close();

        //output before swap
        System.out.println("\nnumbers array before orrdering:\n" + Arrays.toString(numbers));

        //ordering the numbers array
        int[] orderedNumbers = evenOddSort(numbers);

        //final output
        System.out.println("\nnumbers array after orrdering (odds are first and than evens):\n" + Arrays.toString(orderedNumbers));
    }

    //evens and odds numbers sorting in array function
    public static int[] evenOddSort(int[] numbers) {

        //counting odds and evens
        int oddsCount = 0 ,evensCount = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) {
                oddsCount++;
            } else {
                evensCount++;
            }
        }

        //split array to odds array and to even array
        int[] odds = new int[oddsCount];
        int[] evens = new int[evensCount];

        int oddsCounter = 0, evensCounter = 0;

        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) {
                odds[oddsCounter] = numbers[i];
                oddsCounter++;
            } else {
                evens[evensCounter] = numbers[i];
                evensCounter++;
            }
        }

        //sorting new arrays
        Arrays.sort(odds);
        Arrays.sort(evens);

        //combine those evens and odds arrays to new array in order
        int[] orderedNumbers = new int[numbers.length];

        for(int i = 0; i < odds.length; i++) {
            orderedNumbers[i] = odds[i];
        }

        int orderedNumbersCounter = 0;
        for(int i = odds.length; i < orderedNumbers.length; i++) {
            orderedNumbers[i] = evens[orderedNumbersCounter];
            orderedNumbersCounter++;
        }

        //return to main function the new ordered numbers
        return orderedNumbers;
    }
}
