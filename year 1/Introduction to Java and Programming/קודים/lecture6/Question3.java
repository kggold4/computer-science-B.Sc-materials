package lecture6;

import java.util.Scanner;

//lesson 6
//question 3
public class Question3 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //getting string
        System.out.print("insert string: ");
        String str = scanner.nextLine();

        //close scanner
        scanner.close();

        //reversing string
        String reverse = "";

        for(int i = str.length() - 1; i >= 0 ; i--) {
            char temp = str.charAt(i);
            reverse += temp;
        }

        //final output
        System.out.println("string after reversing: " + reverse);
    }
}
