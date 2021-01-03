package lecture2;

//lesson 2
//question 2
public class Question2 {
    public static void main(String[] args) {
        check();
    }

    public static void check() {
        int num = MyConsole.readInt("Insert a number:");
        int i = 0, sum = 0;

        if(num > 0) {
            while(i <= num) {
                sum = sum + i;
                i++;
            }
            System.out.println("Sum from 0 to " + num + " is: " + sum);

        } else {
            System.out.println("Number need to be > 0");
            check();
        }
    }
}
