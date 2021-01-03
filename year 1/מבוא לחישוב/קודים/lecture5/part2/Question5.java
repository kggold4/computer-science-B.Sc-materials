package lecture5.part2;

import java.util.Scanner;

//lesson 5b
//question 5
public class Question5 {

    public static void main(String[] args) {
        //create scanner
        Scanner scanner = new Scanner(System.in);

        //get width and height of the matrix
        System.out.print("insert matrix width: ");
        int width = scanner.nextInt();

        System.out.print("insert matrix height: ");
        int height = scanner.nextInt();

        //define matrix and get values to matrix cells
        int[][] matrix = new int[height][width];

        System.out.println("insert cells value:");
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print("i = " + i + ", j = " + j + ": ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        //close scanner
        scanner.close();

        //checking if the matrix is symmerical
        boolean isSymmetrical = checkSymmetry(matrix);

        //final output
        System.out.println();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }

        if(isSymmetrical) {
            System.out.println("\nmatrix is symmetrical");
        } else {
            System.out.println("\nmatrix is not symmetrical");
        }

    }

    public static boolean checkSymmetry(int[][] matrix) {

        boolean isSymmetrical = false;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == matrix[matrix.length - 1 - i][matrix[i].length - 1 - j]) {
                    isSymmetrical = true;
                } else {
                    isSymmetrical = false;
                }
            }
        }

        return isSymmetrical;
    }
}
