package lecture2;

//lesson 2
//question 1
public class Question1 {
    public static void main(String[] args) {

        double a = MyConsole.readDouble("Get a:");
        double b = MyConsole.readDouble("Get b:");
        double x = b / a;

        if(a == 0 && b != 0) {
            System.out.println("No solution!");
        } else if(a == 0 && b == 0) {
            System.out.println("Infinite solutions!");
        } else {
            System.out.println(a + " * x = " + b + "\t" + "x = " + x);
        }

    }
}
