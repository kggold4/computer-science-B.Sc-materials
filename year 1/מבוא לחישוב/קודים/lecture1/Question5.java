package lecture1;

//question 5
public class Question5 {
    public static void main(String[] args) {

        int num = MyConsole.readInt("Insert a three digit number: ");

        if(num > 99 && num < 1000) {
            System.out.println("Right digit is: " + num % 10);
        } else {
            System.out.println("This number is not three digit!");
        }

    }
}
