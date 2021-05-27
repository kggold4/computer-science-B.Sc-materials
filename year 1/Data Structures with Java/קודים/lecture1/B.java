package lecture1;

public class B {
    public static void main(String[] args) {
        System.out.println(gcd(162, 88));
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}