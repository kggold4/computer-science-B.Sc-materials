package lecture5.part2;

import java.util.Scanner;

//lesson 5b
//question 2
public class Question2 {

    public static void main(String[] args) {
        //create scanner
        Scanner scanner = new Scanner(System.in);

        //matrix width
        System.out.print("insert matrix width: ");
        int width = scanner.nextInt();

        //matrix height
        System.out.print("insert matrix height: ");
        int height = scanner.nextInt();

        //close scanner
        scanner.close();

        //create matrix and generate randon valus in the cells
        int[][] matrix = new int[width][height];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)(Math.random() * 10);
            }
        }

        //output the matrix
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }

        //getting sum of matrix values from sumMatrix function
        int sum = sumMatrix(matrix);

        //final output
        System.out.println("sum of matrix cells value: " + sum);
    }

    //counting sum
    public static int sumMatrix(int[][] matrix) {

        int sum = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }
}
