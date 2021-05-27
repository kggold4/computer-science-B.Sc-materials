

public class BottleBoolean {
	// the matrix initialization
	public static boolean[][] initBooleMatrBottle(int m, int n){
		int dim = (m+1)*(n+1); // matrix dimension
		boolean [][]mat = new boolean[dim][dim];
		for (int i=0; i<dim; i++){
			for (int j=0; j<dim; j++){
				mat[i][j]= false;
			}
		}
		for (int i=0; i<=m; i++){
			for (int j=0; j<=n; j++){
				int ind = index(i,j,n);
				mat[ind][index(0,j,n)]=true;
				mat[ind][index(i,0,n)]=true;
				mat[ind][index(i,n,n)]=true;
				mat[ind][index(m,j,n)]=true;
				int i1=index(Math.max(0,i+j-n),Math.min(n,i+j) ,n);
				mat[ind][i1]=true;
				i1 = index(Math.min(m,i+j),Math.max(0,j+i-m) ,n);
				mat[ind][i1]=true;
			}
		}
		return mat;		
	}
	//the index calculation
	private static int index(int i, int j, int n){
		return (n+1)*i + j;
	}
	public static void printBoolMatrix(boolean [][] b){
		for(int i=0; i<b.length; i++){
			for(int j=0; j<b[0].length; j++){
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		boolean m[][] = initBooleMatrBottle(2,2);
		printBoolMatrix(m);

	}

}
