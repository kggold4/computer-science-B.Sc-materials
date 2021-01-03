package lecture2;

//lesson 2
//question 4
public class Question4 {
    public static void main(String[] args) {

        int num = MyConsole.readInt("Get a number:");
        int digit, count = 0;

        while(num > 0) {
            digit = num % 10;

            if(digit == 0) {
                count++;
            }

            num = num / 10;
        }

        System.out.println("Number of zeros: " + count);
    }
}
