
import java.util.Arrays;

public class FloydWarshallWeightsCODE {
	static int infinity = Integer.MAX_VALUE;
	/**
	 * Problem 1: Floyd-Warshall algorithm
	 * Computing the shortest-path weights bottom up
	 * @param mat -  a weight edge matrix
	 */
	public static void buildFWWeightMatrix(int [][] mat){
		int n = mat.length;
		// matrix building
		for (int k = 0; k<n; k++){
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n; j++){
					if (mat[i][k]!=infinity && mat[k][j]!=infinity){
						mat[i][j] = Math.min(mat[i][j], mat[i][k]+mat[k][j]);
					}
				}
			}
		}
	}
	/**
	 * Problem 2: Constructing a shortest path by Floyd-Warshall algorithm
	 * @param bm - a weight edge matrix
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

	//Problem 3: Number connected component
	public static void connectComponentsOfGraph(int [][] mat){
		// number of connected components
		// in undirected graph (square symmetric matrix)
		int n = mat.length;
		// connectComp[j] - number of component of vertex j
		int connectComp[] = new int[n];
		int numComponentes = 0;

		for(int i=0; i<mat.length; i++){
			if (connectComp[i]==0){
				numComponentes++;
				connectComp[i]=numComponentes;
			}
			for(int j=i+1; j<mat.length; j++){
				// vertex j is not defined yet   the path exists
				if (connectComp[j]==0 && mat[i][j] != infinity){
					connectComp[j] = numComponentes;
				}
			}
		}

		String vs[] = new String[numComponentes];
		for (int i=0; i<numComponentes; i++)
			vs[i] = new String();
		for (int i=0; i<n; i++){
			int index = connectComp[i] - 1;
			vs[index] = vs[index] + i + ","; 
		}
		System.out.println(Arrays.toString(connectComp));
		System.out.println("number of components = "+numComponentes);
		for (int i=0; i<numComponentes; i++)
			System.out.println("component number " + i + ", vertices: [" + vs[i].substring(0, vs[i].length()-1) + "]");
	}

	public static void printPath(String [][]pathMat, int[][] mat){
		System.out.println();
		for(int i=0; i<pathMat.length; i++){
			for(int j=0; j<pathMat[0].length; j++){
				if (mat[i][j] == infinity) System.out.print("*, ");
				else System.out.print(pathMat[i][j]+"; ");
			}
			System.out.println();
		}
	}
	public static void printMatrix(int[][] mat){
		for(int i=0; i<mat.length; i++){
			for(int j=0; j<mat[0].length; j++){
				//if (i==j) System.out.print("0, ");
				if (mat[i][j] ==infinity) System.out.print("*, ");
				else System.out.print(mat[i][j]+", ");
			}
			System.out.println();
		}
	}
	
	//**********************************************************
	public static int[][] init1(){
		int [][] mat = {{1,9,6,infinity}, 
				{9,8,infinity,18},
				{6,infinity,5,15},
				{infinity,18,15,10}};

		return mat;	
	}
	public static int[][] init2(){
		int [][] mat = {{1,infinity,infinity,infinity}, 
				{infinity,1,1,1},
				{infinity,1,1,1},
				{infinity,1,1,infinity}};
		return mat;	
	}

	public static int[][] init3(){
		int [][] mat = {{infinity,1,1,infinity,infinity,infinity}, 
				{infinity,infinity,1,1,infinity,infinity},
				{infinity,infinity,infinity,1,infinity,infinity},
				{1,infinity,1,infinity,infinity,infinity},
				{infinity,infinity,infinity,infinity,infinity,1},
				{infinity,infinity,1,infinity,infinity,infinity}};
		return mat;	
	}
	public static int[][] init4(){
		int [][] mat = {{0,3,-10}, {3,1,5},{-10,5,1}};
		return mat;	
	}
	public static int[][] init5(){
		int [][] mat = {{1,infinity,1,infinity}, 
				{infinity,1,infinity,1},
				{1,infinity,1,infinity},
				{infinity,1,infinity,1}};

		return mat;	
	}
	public static int[][] init6(){
		int [][] mat = {{1,1,1,infinity,infinity,infinity,infinity}, 
				{1,1,1,1,infinity,infinity,infinity},
				{1,1,1,infinity,infinity,infinity,infinity},
				{infinity,1,infinity,1,infinity,infinity,infinity},
				{infinity,infinity,infinity,infinity,1,1,1},
				{infinity,infinity,infinity,infinity,1,1,1},
				{infinity,infinity,infinity,infinity,1,1,1}};

		return mat;	
	}
	public static int[][] init7(){
		int [][] mat = {{1,1,infinity,infinity,infinity,infinity,infinity}, 
				{1,1,infinity,infinity,infinity,infinity,infinity},
				{infinity,infinity,1,1,1,infinity,infinity},
				{infinity,infinity,1,1,1,infinity,infinity},
				{infinity,infinity,1,1,1,infinity,infinity},
				{infinity,infinity,infinity,infinity,infinity,1,1},
				{infinity,infinity,infinity,infinity,infinity,1,1}};

		return mat;	
	}
	public static int[][] init8(){
		int [][] mat = {{1,infinity,infinity,infinity,1,infinity,infinity}, 
				{infinity,1,infinity,1,infinity,infinity,infinity},
				{infinity,infinity,1,1,infinity,infinity,infinity},
				{infinity,1,1,1,infinity,infinity,infinity},
				{1,infinity,infinity,infinity,1,infinity,infinity},
				{infinity,infinity,infinity,infinity,infinity,1,1},
				{infinity,infinity,infinity,infinity,infinity,1,1}};

		return mat;	
	}
	public static int[][] init9(){
		int [][] mat = {{0,3,8,infinity,-4},
				{infinity,0,infinity,1,7},
				{infinity,4,0,infinity,infinity},
				{infinity,infinity,-5,0,infinity},
				{infinity,infinity,infinity,6,0}};
		return mat;	
	}
	public static int[][] init10(){
		int [][] mat = {{0,2,10,infinity}, {2,0,5,infinity},{10,5,0,infinity},{infinity,infinity,infinity,0}};
		return mat;	
	}
	public static int[][] init11(){
		int [][] mat = {{0,2,10,infinity,infinity}, {2,0,5,infinity,infinity},{10,5,0,infinity,infinity},{infinity,infinity,infinity,0,2},{infinity,infinity,infinity,2,0}};
		return mat;	
	}
	public static int[][] init12(){
		int [][] mat = {{0,1,infinity,infinity,1}, 
				{1,0,1,infinity,infinity},
				{infinity,1,0,1,infinity},
				{infinity,infinity,1,0,1},
				{1,infinity,infinity,1,0}};
		return mat;	
	}
	public static int[][] initInt(){
		int [][] mat = {{0,2,infinity,infinity,18},
						{2,0,4,infinity,infinity},
						{infinity,4,0,1,infinity},
						{infinity,infinity,1,0,5},
						{18,infinity,infinity,5,0}};
		return mat;	
   }

	public static void checkFW(){
		System.out.println("\nFloyd-Warshall algorithm: check weight matrix ");
		int[][]mat = initInt();
		String [][] path = buildPathMatrix(mat);
		printMatrix(mat);	
		System.out.print("\nAll paths:");
		printPath(path, mat);
		//connectComponentsOfGraph(mat);	
	}
	public static void main(String[] args) {		
		checkFW();
	}
}
