package lecture6;

//panel 1 - transpose matix
public class Panel1 {
    public static int[][] transposeSqMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = i + 1; j < mat[i].length; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }
        return mat;
    }

    //main function
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        //output matrix
        Library.output(mat);
        System.out.println();
        int newMat[][] = transposeSqMatrix(mat);

        //output matrix
        Library.output(newMat);
    }
}
