package lecture2;

//lesson 2
//question 7
public class Question7 {
    public static void main(String[] args) {

        int m = MyConsole.readInt("Get m:");
        int n = MyConsole.readInt("Get n:");
        int gcd = Math.min(m, n);

        while(m % gcd != 0 || n % gcd != 0) {
            gcd--;
        }
        System.out.println(gcd);
    }
}
