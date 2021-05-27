package lecture3;

//lesson 3
//question 6
public class Question6 {
    public static void main(String[] args) {

        int exit = 1;
        while(exit == 1) {
            exit = MyConsole.readInt("1) Continue program, 0) Exit program");
            if(exit == 1) {
                int num = MyConsole.readInt("\nGet number:");
                int sum = 0;

                for(int i = 1; i < num; i++) {
                    if(num % i == 0) {
                        sum += i;
                    }
                }

                if(sum == num) {
                    System.out.println(num + " is a perfect number\n");
                } else {
                    System.out.println(num + " is not a perfect number\n");
                }
            } else {
                break;
            }
        }

        //final output
        System.out.println("Exit program");
    }
}
