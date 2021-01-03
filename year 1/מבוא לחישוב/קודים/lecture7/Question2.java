package lecture7;

//lesson 7
//question 2
public class Question2 {
    public static void main(String[] args) {

        //final output
        System.out.println(sum(10));

    }

    //recursion function the return sum of n and n-1
    public static int sum(int num) {

        if(num == 1) {
            return 1;
        } else {
            return (num + sum(num - 1));
        }

    }
}
