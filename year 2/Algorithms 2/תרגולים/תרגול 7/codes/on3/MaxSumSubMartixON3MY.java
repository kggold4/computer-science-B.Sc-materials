package on3;
/**
 * The maximum sub-matrix problem:
 * finding the sub-matrix which has the largest sum.
 * Optimal solution - Super Best
 * Complexity: O(n^3) = minimum(O(n^2*m),O(m^2*n)) = O(minimum^2(m*n)*max(m,n))
 */
public class MaxSumSubMartixON3MY {
	public static int matrixSuperBestON3(int[][]mat){//O(N^3)
		int[][] help = helpMatrix(mat);
		int rows = help.length, cols = help[0].length;
		int i0=0, sum=0, iStart = 0, iEnd = 1, jStart = 0, jEnd = 0;
		int maxSum = mat[0][0];
		for (int j0=0; j0<cols; j0++){
			for (int q=j0; q<cols; q++){
				i0 = 0;
				for(int p=0; p < rows; p++){
					sum = sum_ij_pq(help, i0, j0, p, q);
					if (sum < 0){
						i0 = p+1;
					}
					else if (sum > maxSum){
						maxSum = sum;
						iEnd = p+1; 
						iStart = i0;
						jStart = j0;
						jEnd = q;
					}
				}
			}
		}
		System.out.println("maxSum=" + maxSum + ", iStart=" + iStart+", jStart="+jStart+", iEnd="+(iEnd-1)+", jEnd="+jEnd);
		return maxSum;
	}

	
	static int sum_ij_pq(int help[][], int i, int j, int p, int q){//O(1)
		int t = 0;
		if (i==0 && j==0){
			t = help[p][q];
		}
		else if (i==0 && j>0){
			t = help[p][q] - help[p][j-1];  
		}
		else if (i>0 && j==0){
			t = help[p][q] - help[i-1][q]; 
		}
		else{
			t = help[p][q] - help[p][j-1] - help[i-1][q] + help[i-1][j-1];
		}
		return t;
	}
	
	static int[][] helpMatrix(int[][]mat){//O(N^2)
		int[][]help = new int[mat.length][mat[0].length];
		//first column
		help[0][0] = mat[0][0];
		for (int i=1; i<help.length; i++) { 
			help[i][0] = help[i-1][0] + mat[i][0];
		}
		//first row
		for(int j=1; j<help[0].length; j++) {
			help[0][j] = help[0][j-1] + mat[0][j];
		}
		for (int i = 1; i < help.length; i++) {
			for (int j = 1; j < help[0].length; j++) {
				help[i][j] = mat[i][j] + help[i-1][j] + help[i][j-1] - help[i-1][j-1];
			}
		}
		return help;
	}
	
	public static void main(String[] args) {
		//sumMax=20,  iStart=2, jStart=0, iEnd=2, jEnd=4
		//int mat[][] = {{-10,5,-4,3,4},{4,-100,10,-30,5},{3,2,8,1,6},{-5,2,-20,3,1}};
		// maxSum=14, iStart=0, jStart=1, iEnd=1, jEnd=2
		//int mat[][] = {{1,2,3},{-3,4,5},{-1,-2,-4}};
		int mat[][] = {{1,2,3},{4,5,6},{7,8,9}};
		//int[][]mat = {{-2,1},{1,3}};
		//int[][]mat = {{1,2},{4,-3}};
		//int mat[][] = {{2,10,8,3},{-8,14,-1,4},{-6,-1,8,-2},{1,8,7,3},{8,2,-10,-8}};//sumMax=61, iStart=0, jStart=1, iEnd=3, jEnd=3
		matrixSuperBestON3(mat);
	}
}

