package lecture3;

//lesson 3
//question 3
public class Question3 {
    public static void main(String[] args) {

        //variables
        int m = MyConsole.readInt("Get m:");
        int n = MyConsole.readInt("Get n:");

        //output
        System.out.println("m^n = " + (int)(Math.pow(m, n)));

    }
}
