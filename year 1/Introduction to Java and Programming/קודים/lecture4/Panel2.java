package lecture4;

import java.util.Scanner;

//lesson 4
//teacher example 2 for switch Cases
public class Panel2 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //get num
        System.out.print("insert a number season of the year (between 1 to 4): ");
        int num = scanner.nextInt();

        //close scanner
        scanner.close();

        //number case
        switch (num) {
            case 1:
                System.out.println("season is summer");
                break;
            case 2:
                System.out.println("season is spring");
                break;
            case 3:
                System.out.println("season is winter");
                break;
            case 4:
                System.out.println("season is autumn");
                break;
            default:
                System.out.println("not match number");
                break;
        }
    }
}
