package lecture4;

import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        System.out.print("insert a numbers: ");
        int num = scanner.nextInt();

        //close scanner
        scanner.close();

        int count = 0;

        while(num != 0) {
            num = num / 10;
            count++;
        }

        if(count == 0) count++;

        System.out.println(count);

    }
}
