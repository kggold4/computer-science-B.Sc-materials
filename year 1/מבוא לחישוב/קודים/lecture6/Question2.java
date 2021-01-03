package lecture6;

import java.util.Scanner;

//lesson 6
//question 2
public class Question2 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //getting string
        System.out.print("insert string (one word): ");
        String str = scanner.next();

        //close scanner
        scanner.close();

        //checking if the string is symmetrical
        boolean isSymmetrical = false;

        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) == str.charAt(str.length() - i - 1)) {
                isSymmetrical = true;
            } else {
                isSymmetrical = false;
            }
        }

        //final output
        System.out.println("string symmetrical: " + isSymmetrical);
    }
}
