package lecture2;

//lesson 2
//question 3
public class Question3 {
    public static void main(String[] args) {

        int num = MyConsole.readInt("Get number:");
        int count = 0;

        if(num == 0) count = 1;

        while(num > 0) {
            num = num / 10;
            count++;
        }

        System.out.println("Number of digits: " + count);

    }
}
