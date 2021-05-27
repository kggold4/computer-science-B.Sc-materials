package lecture5.part2;

import java.util.Scanner;

public class Question7 {
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

        int zerosCount = numZeros(matrix);

        //output
        System.out.println("\nmatrix:\n");
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }

        System.out.println("\nnumbers of zeros in matrix: " + zerosCount);
    }

    //counting zeros
    public static int numZeros(int[][] matrix) {

        int zerosCount = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) zerosCount++;
            }
        }

        return zerosCount;
    }
}
