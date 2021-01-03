package lecture4;

//lesson 4
//question 2
public class Question2 {
    public static void main(String[] args) {

        //variables
        int num = MyConsole.readInt("Insert length of numbers:");
        int[] numbers = new int[num];
        int max = 0, min = 30;

        //generate random numbers in the array
        //between 10 to 30
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 30);
            while(numbers[i] <= 10) {
                numbers[i] = (int)(Math.random() * 30);
            }

            //calculate the max number
            while(numbers[i] > max) {
                max = numbers[i];
            }

            //calculate the minimum nubmer
            while(numbers[i] < min) {
                min = numbers[i];
            }

            //display the random number
            System.out.print(numbers[i] + ", ");

        }

        //final output
        System.out.println("\n");
        System.out.println("\nMaximum number: " + max);
        System.out.println("\nMinimum number: " + min);

    }
}
