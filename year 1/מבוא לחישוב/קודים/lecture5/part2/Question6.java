package lecture5.part2;

import java.util.Scanner;

//lesson 5b
//question 6
public class Question6 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //getting width and height of the matrix
        System.out.print("insert matrix width: ");
        int width = scanner.nextInt();

        System.out.print("insert matrix height: ");
        int height = scanner.nextInt();

        //close scanner
        scanner.close();

        //define matrix and generate random numbers to cells value
        int[][] matrix = new int[height][width];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)(Math.random() * 10);
            }
        }

        //output
        System.out.println("\nbefore transposing matrix:\n");
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }

        //transposing matrix and output
        int[][] transposingMatrix = transpose(matrix, height, width);

        System.out.println("\nafter transposing matrix:\n");
        for (int i = 0; i < transposingMatrix.length; i++) {
            for (int j = 0; j < transposingMatrix[i].length; j++) {
                System.out.print(transposingMatrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] matrix, int height, int width) {

        int[][] transposingMatrix = new int[width][height];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                transposingMatrix[j][i] = matrix[i][j];
            }
        }

        return transposingMatrix;
    }
}
