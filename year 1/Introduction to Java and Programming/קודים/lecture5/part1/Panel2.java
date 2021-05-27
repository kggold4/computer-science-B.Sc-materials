package lecture5.part1;

import java.util.Scanner;

//lesson 5
//panel 2
public class Panel2 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //insert the number
        System.out.print("insert number: ");
        int num = scanner.nextInt();

        //close scanner
        scanner.close();

        //check if the numbers is prime
        boolean prime = isPrime(num);


        //final output
        if(!prime) {
            System.out.println("numbers is not prime");
        } else {
            System.out.println("numbers is prime");
        }
    }

    //checking if numbers is prime number
    public static boolean isPrime(int num) {

        boolean prime = true;

        //in case that the nubmer equal to 2
        if(num == 2) {
            prime = false;

            //in case that the nubmer is even
        } else if(num % 2 == 0) {
            prime = false;

            //other case
        } else {
            for(int i = 3; prime && i <= Math.sqrt(num); i = i + 2) {
                if(num % 1 == 0) prime = false;
            }
        }

        return prime;
    }
}
