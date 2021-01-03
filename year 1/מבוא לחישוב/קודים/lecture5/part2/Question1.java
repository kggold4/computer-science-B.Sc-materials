package lecture5.part2;

import java.util.Scanner;

//lesson 5b
//question 1
public class Question1 {
    public static void main(String[] args) {

        //create scanner
        Scanner scanner = new Scanner(System.in);

        System.out.print("insert matrix width:");
        int width = scanner.nextInt();

        System.out.print("insert matrix height:");
        int height = scanner.nextInt();

        //close scanner
        scanner.close();

        int[][] matrix = new int[width][height];
        int cell = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = cell;
                cell++;
            }
        }

        printMatrix(matrix);

    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
