package lecture2;

//lesson 2
//question 6
public class Question6 {
    public static void main(String[] args) {
        int m = MyConsole.readInt("Get m:");
        int n = MyConsole.readInt("Get n:");

        System.out.println(m + "^" + n + " = " + (int)(Math.pow(m, n)));
    }
}
