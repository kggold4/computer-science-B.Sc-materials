package lecture5.part2;

import java.util.Scanner;

//lesson 5b
//question 4
public class Question4 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //get width and height of the matrix
        System.out.print("insert matrix width: ");
        int width = scanner.nextInt();

        System.out.print("insert matrix height: ");
        int height = scanner.nextInt();

        //close scanner
        scanner.close();

        //define matrix and cells value
        int[][] matrix = new int[height][width];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)(Math.random() * 10);
            }
        }

        //get sum of the sub diagonal from trace function
        int sumTrace = trace(matrix);

        //output
        System.out.println("\nmatrix:");
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }

        System.out.println("\nsum of sub diagonal is: " + sumTrace);
    }

    public static int trace(int[][] matrix) {

        int sum = 0;

        for(int i = matrix.length - 1; i >= 0; i--) {
            sum += matrix[i][matrix.length - i - 1];
            System.out.println("i = " + i + ", j = " + (matrix.length - i - 1));
        }

        return sum;
    }
}
