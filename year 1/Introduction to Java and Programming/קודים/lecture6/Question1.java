package lecture6;

import java.util.Scanner;

//lesson 6
//question 1
public class Question1 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //getting strings
        System.out.print("insert the first string: ");
        String strA = scanner.nextLine();

        System.out.print("insert the second string: ");
        String strB = scanner.nextLine();

        //close scanner
        scanner.close();

        //output
        if(strA.equals(strB)) {
            System.out.println("\nthe strings are equal");
        } else {
            System.out.println("\nthe strings are not equal");
        }
    }
}
