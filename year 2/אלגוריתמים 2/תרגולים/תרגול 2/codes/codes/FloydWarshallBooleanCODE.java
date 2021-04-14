

import java.util.Arrays;
public class FloydWarshallBooleanCODE{
	/**
	 * Problem 1: Floyd-Warshall algorithm
	 * Build transitive closure of a graph
	 * @param bm - a boolean matrix
	 */
	public static void buildFWBooleanMatrix(boolean [][] bm){
		// matrix calculation
		int n = bm.length;
		for (int k = 0; k<n; k++){
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n; j++){
					bm[i][j] = bm[i][j] || (bm[i][k] && bm[k][j]);
				}
			}
		}
	}
	/**
	 * Problem 2: Constructing a path by Floyd-Warshall algorithm
	 * @param bm - a boolean matrix
	 * @return a path matrix
	 */
	public static String [][] buildPathMatrix(boolean [][] bm){
		int n = bm.length;
		// path matrix initialization
		String [][] pathMat = new String[n][n];
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				if (bm[i][j]) 
					pathMat[i][j] = " "+i+"->"+j+" ";
				else  
					pathMat[i][j] = "";
			}
		}
		// path matrix building
		for (int k = 0; k<n; k++){
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n; j++){
					if (!bm[i][j] && (bm[i][k] && bm[k][j])){								
						pathMat[i][j] = pathMat[i][k]+pathMat[k][j];							
					}
					bm[i][j] = bm[i][j] || (bm[i][k] && bm[k][j]);
				}
			}
		}
		return pathMat;
	}
	//Problem 4: Check the connectivity of the graph
	public static boolean isConnected(boolean mat[][]){//O(n^2)
		boolean ans = true;
		for(int i=0; ans && i<mat.length; i++){
			for(int j=0; ans && j<mat.length; j++){
				if (!mat[i][j]) ans = false;
			}
		}
		return ans;
	}
	public static boolean isConnectedComplexN(boolean mat[][]){//O(n)
		boolean ans = true;
		for(int i=0; ans && i<mat.length; i++){
			if (!mat[i][0]) ans = false;
		}
		return ans;
	}
	//Problem 3: Number connected component
	public static int[][] connectComponentsOfGraphBoolN2(boolean [][] mat){//O(n^2)
		int[][]t = new int[mat.length][mat.length];
		int numComps = 1, count = 0;
		for(int i=0; i<mat.length; i++){
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j] && t[i][j]==0){
					t[i][j] = t[j][i] = numComps;
				}
			}
			if (count > 0) numComps++;
			count = 0;
		}
		return t;
	}
	//Problem 3: Number connected component + List connected component
	public static void connectComponentsOfGraphBoolean(boolean [][] mat){
		// number of connected components
		// in undirected graph (square symmetric matrix)
		int n = mat.length;
		// connectComp[j] - the component number of vertex j
		int connectComp[] = new int[n];
		int numComponentes = 0;

		for(int i=0; i<mat.length; i++){
			if (connectComp[i]==0){
				numComponentes++;
				connectComp[i]=numComponentes;
			}
			for(int j=i+1; j<mat.length; j++){
				// vertex j is not defined yet   the path exists
				if (connectComp[j]==0 && mat[i][j]){
					connectComp[j] = numComponentes;
				}
			}
		}
		//List connected component
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
	//**********************************************************
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
				{false,true,true,true}};
		return mat;	
	}
	public static boolean[][] initB3(){
		boolean [][] mat = {{true,true,false,false}, 
				{true,true,false,false},
				{false,false,true,true},
				{false,false,true,true}};
		return mat;	
	}
	public static boolean[][] initB4(){
		boolean [][] mat = {{true,true,false}, 
				{true,true,true},
				{false,true,true}};
		return mat;	
	}
	public static boolean[][] initB5(){
		boolean [][] mat = {{true,true,false,false}, 
				{true,true,true,false},
				{false,true,true,true},
				{false,false,true,true}};
		return mat;	
	}
	public static boolean[][] initB6(){
		boolean [][] mat = {{true,true,false,false,true}, 
				{true,true,true,false,false},
				{false,true,true,true,false},
				{false,false,true,true,true},
				{true,false,false,true,true}};
		return mat;	
	}
	//        V4
	//        /\
	//       /  \
	//      /____\
	//     V0     V5
	//    V6------V3
	//      |     |
	//	    |_____|
	//     V1     V2
	//
	public static boolean[][] Init01() {
		boolean[][] mat= {{false,false,false,false,true,true,false},
				{false,false,true,false,false,false,true},
				{false,true,false,true,false,false,false},
				{false,false,true,false,false,false,true},
				{true,false,false,false,false,true,false},
				{true,false,false,false,true,false,false},
				{false,true,false,true,false,false,false}};
		return mat;
	}
	public static boolean[][] initBool(){
		boolean [][] mat = {{ false,  true, false, false,  true},
				{  true, false,  true, false, false},
				{ false,  true, false,  true, false},
				{ false, false,  true, false,  true},
				{  true, false, false,  true, false}};
		return mat;	
	}
	//**********************************************************
	public static void printBooleanMatrix(boolean[][] mat){
		for(int i=0; i<mat.length; i++){
			for(int j=0; j<mat[0].length; j++){
				System.out.print(mat[i][j]+", ");
			}
			System.out.println();
		}
	}
	public static void printPath(String [][]pathMat, boolean[][] mat){
		System.out.println();
		for(int i=0; i<pathMat.length; i++){
			for(int j=0; j<pathMat[0].length; j++){
				if (!mat[i][j]) System.out.printf("%28s","*, ");
				else System.out.printf("%28s",pathMat[i][j]+"; ");
			}
			System.out.println();
		}
	}	
	public static void checkFWBooleanMatrix(){
		System.out.println("\ninitBool ");
		boolean[][]mat = initBool();
		buildFWBooleanMatrix(mat);
		printBooleanMatrix(mat);
		String [][] path = buildPathMatrix(initBool());
		printPath(path,mat);
		System.out.println("Is the graph connected?  " + isConnected(mat));
	}
	public static void checkComps(){
		boolean[][]mat = initBool();
		connectComponentsOfGraphBoolean(mat);
	}
	public static void main(String[] args) {
		checkFWBooleanMatrix();
		checkComps();
	}
}
