public class FloydWarshallNegative {

	static int infinity = Integer.MAX_VALUE;
	/**
	 * Computing a matrix of shortest-path weights by Floyd-Warshall algorithm
	 * @param mat - a weight edge matrix
	 */
	public static void FWNeg(int [][] mat){
		int n = mat.length;
		// matrix building
		for (int k = 0; k<n; k++){
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n; j++){
					if (mat[i][k]!=infinity && mat[k][j]!=infinity){
						mat[i][j] = Math.min(mat[i][j], mat[i][k]+mat[k][j]);
						//System.out.println("k="+k+", i="+i+", j="+j+", mat["+i+","+j+"]="+mat[i][j]); 
					}
				}
			}
		}
	}
	/**
	 * Constructing a shortest path by Floyd-Warshall algorithm
	 * @param mat - a weight edge matrix
	 * @return a path matrix
	 */
	public static String [][] buildPathMatrix(int [][] mat){
		int n = mat.length;
		// path matrix initialization
		String [][]pathMat = new String[n][n];
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				if (mat[i][j] != infinity) 
					pathMat[i][j] = " "+i+"->"+j+" ";
				else  pathMat[i][j] = "";
			}
		}
		// path matrix building
		for (int k = 0; k<n; k++){
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n; j++){
					if (mat[i][k]!=infinity && mat[k][j]!=infinity){
						if (mat[i][j] > mat[i][k]+mat[k][j]){
							mat[i][j] = mat[i][k]+mat[k][j];
							pathMat[i][j] = pathMat[i][k]+pathMat[k][j];
						}
					}
				}
			}
		}
		return pathMat;
	}

	/**
	 * Check if it's a negative cycle in the graph
	 * @param mat - matrix of shortest-path weights that is getting after Floyd-Warshall algorithm
	 * @return true if it's a negative cycle in the graph otherwise false
	 */
	public static boolean checkNegativeCircle(int[][] mat){
		boolean ans = false;
		for (int i = 0; !ans && i<mat.length; i++){
			if (mat[i][i]<0) ans = true;
		}
		return ans;
	}
	/**
	 * Print all paths of negative cycle in the graph
	 * @param mat
	 */
	public static void printPathNegativeCircle(int[][] mat){
		String [][] pathMat = buildPathMatrix(mat);		
		for(int i=0; i<pathMat.length; i++){
			for(int j=0; j<pathMat[0].length; j++){
				if (mat[i][j] < 0) System.out.print(pathMat[i][j]+"; ");				
			}
			System.out.println();
		}
	}
	
	public static void checkFWNegativeCircle() {
		int[][] mat = {{0,1,infinity},
					   {infinity,0,-5},
			           {2,infinity,0}};
		int n = mat.length;
		int[][] matSource = new int[n][n];
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){				 
					matSource[i][j] = mat[i][j];				
			}
		}
		System.out.println("\nCheck Negative Circle");
		printMatrix(mat);	
		FWNeg(mat);
		System.out.println("After Floyd-Warshall algorithm");
		printMatrix(mat);		
		System.out.println("Is there a negative cycle? "+checkNegativeCircle(mat));
		System.out.println("\nAll Paths of Negative Circle");
		printPathNegativeCircle(matSource);	
	}
	
	public static void printMatrix(int[][] mat){
		for(int i=0; i<mat.length; i++){
			for(int j=0; j<mat[0].length; j++){				
				if (mat[i][j] ==infinity) {
					if (i==j) System.out.print("0, ");
					else System.out.print("*, ");
				}
				else 
					System.out.print(mat[i][j]+", ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][]mat1={{infinity,3,-10},{3,infinity,-1},{-10,-1,infinity}};
		int[][]mat={{infinity,5,-2},{5,infinity,-1},{-2,-1,infinity}};
		int[][]mat2={{0,-1,10},{-1,0,2},{10,2,0}};
		int[][]mat3={{0,infinity},{-5,0}};
		int[][]mat4={{0,-5},{-5,0}};
		int[][]mat5={{0,5},{5,0}};
		int[][]mat6={{0,5,2},{5,0,-1},{2,-1,0}};
		int[][]mat7={{0,5,2},{5,0,infinity},{2,-1,0}};
		int[][]mat8={{0,-5,2},{-5,0,infinity},{2,1,0}};
		
		System.out.println("Before: Graph with negative-weight edges");
		printMatrix(mat8);
		FWNeg(mat8);	
		System.out.println("After FW");
		printMatrix(mat8);
		
		checkFWNegativeCircle();
		
	}

}
