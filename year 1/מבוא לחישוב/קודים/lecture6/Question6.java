package lecture6;

import java.util.Scanner;
import java.util.Arrays;

//lesson 6
//question 6
public class Question6 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //getting three chars word
        System.out.print("insert a word by three chars: ");
        String str = scanner.next();

        //checking if the word is built by three cahrs
        boolean condition = false;
        while(!condition) {
            if(str.length() != 3) {
                System.out.print("string is invalid, please insert a word by three chars: ");
                str = scanner.next();
            } else {
                condition = true;
            }
        }

        //close scanner
        scanner.close();

        //separate word chars to new array cells and sorting array
        char[] arr = new char[str.length()];
        for(int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        Arrays.sort(arr);

        String newStr = "";
        for(int i = 0; i < arr.length; i++) {
            newStr += arr[i];
        }

        //final output
        System.out.println("\nnew string after sorting by ABC: " + newStr);

    }
}
