package lecture1;

//question 1
public class Question1 {

    public static void main(String[] args) {

        int a = MyConsole.readInt("Get a:");
        int b = MyConsole.readInt("Get b:");

        System.out.println("a = " + a + ", b = " + b);

        int x = a;
        int y = b;

        a = y;
        b = x;

        System.out.println("a = " + a + ", b = " + b);
    }
}