package lecture6;

import java.util.Scanner;

//lesson 6
//question 7
public class Question7 {

    public static void main(String[] args) {

        //creat scanenr
        Scanner scanner = new Scanner(System.in);

        //getting word
        System.out.print("insert a word: ");
        String str = scanner.nextLine();

        //close scanner
        scanner.close();

        //define the first char and new substring
        char c = str.charAt(0);
        String newStr = str.substring(1);

        //output, first char in upper case
        System.out.println("\nfirst char in upper case: " + (char)((int)(c) - 32) + newStr);

    }
}
