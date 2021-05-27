package lecture5.part1;
import java.util.Scanner;

//lesson 5
//panel 1
public class Panel1 {

        //main function
        public static void main(String[] args) {

            //create scanner
            Scanner scanner = new Scanner(System.in);

            System.out.println("insert two numbers: ");
            System.out.print("first:  ");
            int a = scanner.nextInt();
            System.out.print("second: ");
            int b = scanner.nextInt();

            //close scanner
            scanner.close();

            double average = avg(a, b);

            System.out.println("average is: " + average);
        }

        public static double avg(int a, int b) {

            double average = (double)(a + b) / 2;
            return average;

        }
}
