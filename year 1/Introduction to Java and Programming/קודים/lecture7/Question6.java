package lecture7;

//lesson 7
//question 6
public class Question6 {
    public static void main(String[] args) {
        fibonacci(10);
    }

    static public int a, b = 1,c , start = 0;

    public static void fibonacci(int n) {

        if(start < n) {
            c = a + b;
            int d = a;
            a = c;
            b = d;
            fibonacci(n-1);
        } else {
            System.out.println(c);
        }
    }
}
