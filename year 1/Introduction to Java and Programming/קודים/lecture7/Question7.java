package lecture7;

//lesson 7
//question 7 (bonus)
public class Question7 {
    public static void main(String[] args) {
        System.out.println(reverseNumber(61853));
    }

    public static int reverseNumber(int n) {

        int k = n, len = 0;

        //counting digits for the array
        while (k != 0) {
            k = k / 10;
            len++;
        }

        //define array and inert digits
        int[] digits = new int[len];
        for(int i = 0; i < digits.length; i++) {
            digits[i] = n % 10;
            n = n / 10;
        }

        //reverse array
        for(int i = 0; i < digits.length; i++) {
            int t = digits[i];
            digits[i] = digits[digits.length - i - 1];
            digits[digits.length - i - 1] = t;
        }

        //create string with array digits
        String numberString = "";
        for(int i = 0; i < digits.length; i++) {
            numberString += digits[i];
        }

        //parse string to number and return
        int number = Integer.parseInt(numberString);
        return number;

    }
}
