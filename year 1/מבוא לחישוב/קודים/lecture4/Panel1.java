package lecture4;

import java.util.Scanner;

//lesson 4
//teacher example 1 for do while loop
public class Panel1 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //variables
        int a = scanner.nextInt();
        int ans = 0;

        //close scanner
        scanner.close();

        do {
            int r = a % 10;
            ans = ans * 10 + r;
            a = a / 10;
        } while (a > 0);

        System.out.println("ans = " + ans);

    }
}
