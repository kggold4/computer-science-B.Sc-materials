package lecture1;

//question 9
public class Question9 {
    public static void main(String[] args) {

        int num = MyConsole.readInt("Insert a three digit number: ");

        if(num > 99 && num < 1000) {

            int a = num % 10;
            int b = (num % 100) / 10;
            int c = num / 100;
            int result = a + b + c;

            System.out.println("Sum of digits are: " + result);
        } else {
            System.out.println("This number is not three digit!");
        }

    }
}
