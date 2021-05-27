package lecture4;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {

        System.out.println("convers int numbers to binay:\n");

        //create scanner
        Scanner scanner = new Scanner(System.in);

        System.out.print("insert int: ");
        int x = scanner.nextInt();
        int originalX = x;

        //close scanner
        scanner.close();

        int result = 0;

        for(int pow = 0; x > 0; pow++) {
            result += (x % 2)*Math.pow(10, pow);
            x /= 2;
        }

        System.out.println(originalX + " in binay is = " + result);
    }
}
