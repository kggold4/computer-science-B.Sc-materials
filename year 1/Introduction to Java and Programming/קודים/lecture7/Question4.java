package lecture7;

//lesson 7
//question 4
public class Question4 {
    public static void main(String[] args) {
        triangle(5);
    }

    public static void triangle(int num) {

        if(num > 0) {

            int n = num;
            while(n != 0) {
                System.out.print("*");
                n--;
            }

            System.out.println();
            triangle(num - 1);
        }
    }
}
