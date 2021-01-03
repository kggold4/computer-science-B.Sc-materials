package lecture1;

//question 7
public class Question7 {
    public static void main(String[] args) {

        int num = MyConsole.readInt("Insert a three digit number: ");

        if(num > 99 && num < 1000) {

            int right = num % 10;
            int middle = (num % 100) / 10;
            int left = num / 100;

            System.out.println("Digits are: " + " Right: " + right + " Middle: " + middle + " Left: " + left);
        } else {
            System.out.println("This number is not three digit!");
        }

    }
}
