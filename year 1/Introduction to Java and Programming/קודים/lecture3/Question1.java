package lecture3;

//lesson 3
//question 1
public class Question1 {
    public static void main(String[] args) {

        //variables
        int num = MyConsole.readInt("Get number:");
        int i, count = 1;

        //loop
        for(i = 1; i <= num; i++) {
            count = count *= i;
        }

        //output
        System.out.println("!Number = " + count);
    }
}
