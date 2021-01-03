package exercise1_recursive;

//question 3
public class C {
    public static void main(String[] args) {
        printBackward("hello");
    }

    public static void printBackward(String s) {
        int len = s.length();
        if(len > 0) {
            System.out.println(s.substring(len - 1, len));
            printBackward(s.substring(0, len - 1));
        }
    }
}