package lecture5.part2;

import java.util.Scanner;

//lesson 5b
//question 3
public class Question3 {

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

        //get sum of the main diagonal from trace function
        int sumTrace = trace(matrix);

        //output
        System.out.println("\nmatrix:");
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }

        System.out.println("\nsum of main diagonal is: " + sumTrace);
    }

    public static int trace(int[][] matrix) {

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i == j) {
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }
}
