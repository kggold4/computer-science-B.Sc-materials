package lecture7;

//lesson 7
//question 1
public class Question1 {
    public static void main(String args[]) {

        //final output
        System.out.println(fact(10));

    }

    //recursion function that return n!
    public static int fact(int n) {

        if(n == 1) {
            return 1;
        } else {
            return (n * fact(n - 1));
        }

    }
}
