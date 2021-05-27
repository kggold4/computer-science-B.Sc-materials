package lecture7;

//lesson 7
//question 3
public class Question3 {
    public static void main(String[] args) {

        //call printLine function
        printLine(5);

    }

    //recursion function that print *
    public static void printLine(int num) {
        if(num > 0) {
            System.out.print("*");
            printLine(num - 1);
        }
    }
}
