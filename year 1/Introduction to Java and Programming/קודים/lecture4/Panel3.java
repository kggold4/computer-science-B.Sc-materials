package lecture4;

import java.util.Scanner;

//lesson 4
//teacher example 3 for functions
public class Panel3 {
    public static void swap(int a, int b) {

        //swaping parameters
        int t = a;
        a = b;
        b = t;

        //output
        System.out.println("\nafter swap: a = " + a + " b = " + b);
    }

    //main function
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //get num
        System.out.print("insert a: ");
        int a = scanner.nextInt();
        System.out.print("\ninsert b: ");
        int b = scanner.nextInt();

        //close scanner
        scanner.close();

        //output
        System.out.println("\nafter swap: a = " + a + " b = " + b);

        //send parameters a and b to swap function
        swap(a, b);

    }
}
