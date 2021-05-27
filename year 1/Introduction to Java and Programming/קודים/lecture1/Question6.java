package lecture1;

//question 6
public class Question6 {
    public static void main(String[] args) {

        int num = MyConsole.readInt("Insert a three digit number: ");

        if(num > 99 && num < 1000) {
            System.out.println("Middle digit is: " + (num % 100) / 10);
        } else {
            System.out.println("This number is not three digit!");
        }

    }
}
