package lecture6;

public class Panel2 {
    public static void reverseMatrix(int[][] matrix) {
        for(int i = 0, j = matrix.length - 1 - i; i < matrix.length/ 2 ; i++, j--) {
            int[] t = matrix[i];
            matrix[j] =  matrix[i];
            matrix[j] = t;
        }
        Library.output(matrix);
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2},{3,4}};
        reverseMatrix(matrix);
    }
}
