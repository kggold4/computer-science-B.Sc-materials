package lecture3;

//lesson 3
//question 5
public class Question5 {
    public static void main(String[] args) {

        //variables
        int num = MyConsole.readInt("Number of numbers to insert: ");
        double[] numbers = new double[num];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = MyConsole.readInt("Insert the " + (i + 1) + " number:");
        }

        int max = 0;
        for(int j = 0; j < numbers.length; j++) {
            if(numbers[j] > max) max = (int)numbers[j];
        }

        //final output
        System.out.println("Maximum number is: " + max);
    }
}

