package lecture1;

//question 3
public class Question3 {
    public static void main(String[] args) {

        double a = MyConsole.readDouble("Get a:");
        double b = MyConsole.readDouble("Get b:");

        double avg = (a + b) / 2;
        System.out.println("Average is: " + avg);

    }
}
