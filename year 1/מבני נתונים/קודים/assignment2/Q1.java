package assignment2;

public class Q1 {

    public static int countIslands(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int count = 0; 
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1 && !visited[i][j]) {
                    depthSearch(matrix, visited, i, j); 
                    count++;
                }
            }
        }
        return count; 
    }

    public static void depthSearch(int[][] matrix, boolean[][] visited, int i, int j) {
        int[] helpRow = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] helpCol = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            if(isSafe(matrix, helpRow[k] + i, helpCol[k] + j, visited)) {
                depthSearch(matrix, visited, helpRow[k] + i, helpCol[k] + j); 
            }
        }
    }

    public static boolean isSafe(int[][] matrix, int i, int j, boolean[][] visited) {
        return (i >= 0) && (i < matrix.length) && (j >= 0) && (j < matrix[0].length) && (matrix[i][j] == 1 && !visited[i][j]);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]  { { 1, 1, 0, 0, 0 },
                                        { 0, 1, 0, 0, 1 },
                                        { 1, 0, 0, 1, 1 },
                                        { 0, 0, 0, 0, 0 },
                                        { 1, 0, 1, 1, 0 } };
        System.out.println("Number of islands is: " + countIslands(matrix));
    }
}