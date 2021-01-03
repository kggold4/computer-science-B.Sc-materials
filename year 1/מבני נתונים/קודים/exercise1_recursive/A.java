package exercise1_recursive;

//question 1
public class A {
    public static void main(String[] args) {
        System.out.println(fact(5));
    }

    public static long fact(int n) {
        if(n == 0) return 1;
        return n * fact(n - 1);
    }
}