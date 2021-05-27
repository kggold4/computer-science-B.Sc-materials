package lecture7;

//lesson 7
//question 5
public class Question5 {
    public static void main(String[] args) {
        PrintReverseTriangle(5);
    }

    private static int start = 0;

    public static void PrintReverseTriangle(int num) {

        if(1 <= num) {

            start++;

            int i = 0;
            while(i != start) {
                System.out.print("*");
                i++;
            }
            System.out.println();

            PrintReverseTriangle(num - 1);
        }

    }
}
