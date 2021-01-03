package lecture2;

//lesson 2
//question 5
public class Question5 {
    public static void main(String[] args) {

        int number = MyConsole.readInt("Get number:");
        int count = 1, i = 1;

        while(i <= number) {
            count *= i;
            i++;
        }

        System.out.println("!number = " + count);


    }
}
