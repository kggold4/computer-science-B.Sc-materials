package exercise1_recursive;

//question 2
public class B {
    public static void main(String[] args) {
        System.out.println(fibonachi(10));
    }

    public static int fibonachi(int num) {
        if(num == 0 || num == 1) return 1;
        else return (fibonachi(num - 1)) + (fibonachi(num - 2));
    }
}