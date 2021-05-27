package exercise1_tr;

public class F {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    public static long fibonacci(int n) {
        if(n == 1 || n == 2) return 1;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }
}