package lecture6;

import java.util.Scanner;

//lesson 6
//question 4
public class Question4 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //getting string
        System.out.print("insert a word: ");
        String str = scanner.next();

        //clsoe scanner
        scanner.close();

        //counting the first word in string
        int counter = 0;
        char first = str.charAt(0);

        for(int i = 0; i < str.length(); i++) {
            if(first == str.charAt(i)) counter++;
        }

        System.out.println("first word is \"" + first + "\" appeared " + counter + " times in the string.");
    }
}
