package bottleFW;

public class BottleBooleanFW {

	//**************************************************************************

	// the matrix initialization
	public static boolean[][] initBooleanMatrixBottle(int m, int n){
		int dim = (m+1)*(n+1); // matrix dimension
		boolean [][]mat = new boolean[dim][dim];
		for (int i=0; i<dim; i++){
			for (int j=0; j<dim; j++){
				mat[i][j]= false;
			}
		}
		for (int i=0; i<=m; i++){
			for (int j=0; j<=n; j++){
				int index = indexRow(i,j,n);
				mat[index][indexRow(0,j,n)]=true;
				mat[index][indexRow(i,0,n)]=true;
				mat[index][indexRow(i,n,n)]=true;
				mat[index][indexRow(m,j,n)]=true;
				int indexTo=indexRow(Math.max(0,i+j-n),Math.min(n,i+j) ,n);
				mat[index][indexTo]=true;
				indexTo = indexRow(Math.min(m,i+j),Math.max(0,j+i-m) ,n);
				mat[index][indexTo]=true;
			}
		}
		for (int j=0; j<dim; j++){
			mat[j][j]= false;
		}
		return mat;		
	}

	//**************************************************************************

	//the index calculation for rows
	private static int indexRow(int i, int j, int n){
		return (n+1)*i + j;
	}

	//**********************************************************
	
    //Constructing paths for modes   
	public static String[][] FWBooleanForBottle(boolean [][] mat, int n){
		int len = mat.length;
		// path matrix initialization
		String [][]pathMat = new String[len][len];
		for (int i=0;i<len;i++){
			int ai = i/(n+1),  bi = i%(n+1);  
			for (int j=0;j<len;j++){
				int aj = j/(n+1),  bj = j%(n+1); 
				if (mat[i][j]) 
					pathMat[i][j] = "(" + ai +","+ bi + ")->(" + aj +","+ bj + ") ";
				else  
					pathMat[i][j] = "";
			}
		}
		// path matrix building
		for (int k = 0; k<len; k++){
			for (int i = 0; i<len; i++){
				for (int j = 0; j<len; j++){
					if(!mat[i][j]){
						mat[i][j] = (mat[i][k] && mat[k][j]);
						if (mat[i][j]) pathMat[i][j] = pathMat[i][k] + pathMat[k][j];
					}
				}
			}
		}
		return pathMat;
	}

	//**************************************************************************
	//Constructing paths for index 
	public static String[][] FWAlgorithmBool(boolean [][] bm){
		int n = bm.length;
		// path matrix initialization 
		String [][]pathMat = new String[n][n];
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				if (bm[i][j]) pathMat[i][j] = " "+i+"->"+j;
				else  pathMat[i][j] = "";
			}
		}
		// path matrix calculation
		for (int k = 0; k<n; k++){
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n; j++){
					if(!bm[i][j]){
						bm[i][j] = (bm[i][k] && bm[k][j]);
						if (bm[i][j]) pathMat[i][j] = pathMat[i][k] + pathMat[k][j];
					}
				}
			}
		}
		return pathMat;
	}
	//**************************************************************************

	public static void printBoolMatrix(boolean [][] b){
		for(int i=0; i<b.length; i++){
			for(int j=0; j<b[0].length; j++){
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------");
	}

	//**********************************************************

	public static void printPath(String [][]pathMat, boolean[][] mat){
		System.out.println();
		for(int i=0; i<pathMat.length; i++){
			for(int j=0; j<pathMat[0].length; j++){
				if (!mat[i][j]) 
					System.out.printf("%18s","*, ");
				else 
					System.out.printf("%18s","["+pathMat[i][j]+"]");
			}
			System.out.println();
		}
	}
	//**********************************************************
	static void IsExistPath(int i1, int j1, int i2, int j2, boolean[][] mat, String[][] paths, int n, int m) {
		i1 = i1>j1?i1:j1;
		j1 = i1>j1?j1:i1;
		i2 = i2>j2?i2:j2;
		j2 = i2>j2?j2:i2;
		System.out.println("Is Exist path from ("+i1+","+j1+") to ("+i2+","+j2+")?");

		if(i1>m ||i2>m ||j1>n ||j2>n ) {
			System.out.println("NO..");
			return;
		}
		int i = indexRow(i1, j1, n);
		int j = indexRow(i2, j2, n);
		if (mat[i][j] == true)
			System.out.println("YES! "+paths[i][j]);
		else
			System.out.println("NO..");
	}
	//**********************************************************
	public static void checkBottleBoolean(int m, int n){
		System.out.println("--------Before FW Algoritm-----------------");
		boolean mat[][] = initBooleanMatrixBottle(m,n);
		printBoolMatrix(mat);

		System.out.println("--------After FW Algoritm-----------------");
		String[][] paths = FWBooleanForBottle(mat, n);//a pair of bottel's contents
		//String[][] paths = FWAlgorithmBool(mat);  //state index for a pair of bottel's contents
		printBoolMatrix(mat);
		System.out.println("--------Paths-----------------");
		printPath(paths, mat);
		IsExistPath(0,0,4,0,mat,paths,n,m);
	}

	//**************************************************************************

	public static void main(String[] args) {
		int m=5, n=3;//m-the first bottle, n-the second bottle, m>=n
		System.out.println("m = "+ m + ",  n = "+n+"\n");
		checkBottleBoolean(m, n);
	}
}

