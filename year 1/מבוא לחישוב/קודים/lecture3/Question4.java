package lecture3;

//lesson 3
//question 4
public class Question4 {
    public static void main(String[] args) {

        //variables
        int num = MyConsole.readInt("Get index:");
        int fibonacciNumber = 0;

        //if num equal to 1 or 2 print 1
        if(num == 2 || num == 1) {
            fibonacciNumber = 1;

            //if num is lower than 1 = error
        } else if(num < 1) {
            System.out.println("index need to be grater than 0");

            //if num is grater than 2
        } else {

            //indexing first cells
            int[] fibonacci = new int[num];
            fibonacci[0] = 1;
            fibonacci[1] = 1;

            //looping to get the fibonacci number by num
            for(int i = 2; i < num; i++) {
                fibonacci[i] = fibonacci[i - 1] +fibonacci[i - 2];
                fibonacciNumber = fibonacci[i];
            }

        }

        //final output
        System.out.println("fibonacci number by index: " + fibonacciNumber);
    }
}
