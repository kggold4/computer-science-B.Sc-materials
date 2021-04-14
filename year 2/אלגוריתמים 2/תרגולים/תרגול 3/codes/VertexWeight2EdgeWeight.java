import java.util.Arrays;

public class VertexWeight2EdgeWeight {
	static int infinity = Integer.MAX_VALUE;
	/**
	 * Building an edge weight matrix from a vertex weight array and a boolean matrix of edges
	 * @param vertexWeight - an array of vertex's weight
	 * @param mb - a boolean matrix of edges
	 * @return an edge weight matrix
	 */
	public static int[][] vertexWeightArray2edgeWeightMatrix(int[] vertexWeight, boolean mb[][]){
		// matWEdges - for building matrix of edge weights
		int n = mb.length;
		int [][]matWEdges = new int[mb.length][mb[0].length];
		for (int i = 0; i < n; i++) Arrays.fill(matWEdges[i], infinity);
		for (int i = 0; i <n; i++) {
			for (int j = 0; j < n; j++) {
				if (mb[i][j] && i!=j) matWEdges[i][j] = vertexWeight[i] + vertexWeight[j];
			}
		}
		System.out.println("\nMatrix of edge's weights");
		printMatrix(matWEdges);
		return matWEdges;
	}
	/** 
	 * Building a shortest-path weight's matrix from a vertex weight array and a boolean matrix of edges
	 * by Floyd-Warshall algorithm
	 * @param vertexWeight - an array of vertex's weight
	 * @param mb - a boolean matrix of edges, where is 
	 * 			   mb[i]]j] = true if edge exists between vertices i, j
	            or mb[i]]j] = false if edge does't exist between vertices i, j 
	 * @return a shortest-path weight's matrix
	 */
	public static int[][] FW4VertexWeight(int[] vertexWeight, boolean mb[][]){
		//matrix of prices 
		int[][] matWEdges = vertexWeightArray2edgeWeightMatrix(vertexWeight, mb);
		FWAlgorithm(matWEdges);
		return matWEdges;
	}
	/**
	 * Floyd-Warshall algorithm:
	 * Computing the shortest-path weights by bottom up:
	 * build the matrix of shortest-path weights
	 * @param mat -  a weight's edge matrix
	 */
	public static void FWAlgorithm(int mat[][]){
		int n = mat.length;
		for (int k = 0; k<n; k++){
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n; j++){
					if (mat[i][k]!=infinity && mat[k][j]!=infinity){
						if (mat[i][j] > mat[i][k]+mat[k][j]){
							mat[i][j] = mat[i][k]+mat[k][j];
						}
					}
				}
			}
		}
	}
	/**
	 * Building a vertex weight matrix from a vertex weight array and an edge's weight matrix
	 * @param vertexWeight an array of vertices weights
	 * @param matWEdges a matrix of edge's weights
	 * @return matWVert - a matrix of vertice's weights
	 */
	public static int[][] edgeWeightMatrix2VertexWeightMatix(int[] vertexWeight, int matWEdges[][]){
		int n = matWEdges.length;
		int[][] matWVert = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if (matWEdges[i][j]!=infinity)
					matWVert[i][j] = (matWEdges[i][j] + vertexWeight[i] + vertexWeight[j])/2;
				else matWVert[i][j] = infinity;
			}
		}
		return matWVert;
	}
	/**
	 * Building an edge's weight matrix from a vertex weight array and a vertice's weight matrix
	 * @param vertexWeight - an array of vertice's weights
	 * @param matWVert - a matrix of vertice's weights
	 * @return - a matrix of edge's weights
	 */
	public static int[][] vertexWeightMatrix2edgeWeightMatrix(int[] vertexWeight, int matWVert[][]){
		int n = matWVert.length;
		int [][] matWEdges = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if (matWVert[i][j]!=infinity)
					matWEdges[i][j] = 2*matWVert[i][j] - vertexWeight[i] - vertexWeight[j];
			}
		}
		return matWEdges;
	}

	public static void checkFWVertecesWeightToEdgesWeght(){
		boolean mb[][] = initB1();
		int [] weVert = {1,2,3,4};
		int[][] mat = FW4VertexWeight(weVert, mb);
		System.out.println("Matrix of prices after Floyd-Warshall algorithm");
		printMatrix(mat);

		System.out.println("Matrix of vertixe's weights");
		printMatrix(edgeWeightMatrix2VertexWeightMatix(weVert, mat));
		System.out.println("Matrix of edges weights");
		printMatrix(vertexWeightMatrix2edgeWeightMatrix(weVert, edgeWeightMatrix2VertexWeightMatix(weVert, mat)));
	}
	/**
	 * Check if it's a negative cycle in the graph
	 * @param mat
	 * @return
	 */
	public static boolean checkNegativeCircle(int[][] mat){
		boolean ans = false;
		for (int i = 0; !ans && i<mat.length; i++){
			if (mat[i][i]<0) ans = true;
		}
		return ans;
	}
	public static void checkFWNegativeCircle() {
		int[][] mat = {{0,1,infinity},
					   {infinity,0,-5},
			           {2,infinity,0}};
		System.out.println("\nCheck Negative Circle");
		printMatrix(mat);	
		FWAlgorithm(mat);
		System.out.println("After Floyd-Warshall algorithm");
		printMatrix(mat);		
		System.out.println("Is there a negative cycle? "+checkNegativeCircle(mat));
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
	public static boolean[][] initB1(){
		boolean [][] mat = {{true,true,true,false}, 
				{true,true,false,true},
				{true,false,true,true},
				{false,true,true,true}};

		return mat;	
	}
	public static boolean[][] initB2(){
		boolean [][] mat = {{true,false,false,false}, 
				{false,true,true,true},
				{false,true,true,true},
				{false,true,true,false}};
		return mat;	
	}

	public static void main(String[] args) {
		checkFWVertecesWeightToEdgesWeght();
		checkFWNegativeCircle();
	}
}
