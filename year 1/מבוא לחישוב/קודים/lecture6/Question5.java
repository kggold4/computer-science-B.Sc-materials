package lecture6;

import java.util.Scanner;

//lesson 6
//question 5
public class Question5 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner  = new Scanner(System.in);

        //getting string
        System.out.print("insert a string: ");
        String str = scanner.nextLine();

        //close scanner
        scanner.close();

        //counting spaces
        int counter = 0;
        char space = ' ';

        for(int i = 0; i < str.length(); i++) {
            if(space == str.charAt(i)) counter++;
        }

        //final output
        System.out.print("numbers of word in the sentence: " + (counter + 1));

    }
}
