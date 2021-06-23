package fullSearchOn6;
/**
 * The maximum sub-matrix problem:
 * finding the sub-matrix which has the largest sum.
 * Exhaustive Search (Full Search)
 * Complexity: O(n^6=n^3*m^3) 
 */
public class MaxSuMatFullSearch {	//calculation sum of sub-matrix elements 

	public static int sumOfSubMatrixElements(int [][]mat,int r0, int c0, int r1, int c1) {
		int sum=0;
		for (int i = r0; i <= r1; i++){
			for (int j = c0; j <= c1; j++){
				sum = sum + mat[i][j];
			}
		}
		return sum;
	}

	public static void maxSumSubMatrixFullSearch(int [][]mat) {
		int m = mat.length, n = mat[0].length;
		int sum = 0, sumMax = 0, iStart = 0, jStart = 0, iEnd = 0, jEnd = 0;
		for (int i0 = 0; i0 < m; i0++){
			for (int j0 = 0; j0 < n; j0++){
				for (int i1 = i0; i1 < m; i1++){
					for (int j1 = j0; j1 < n; j1++){
						sum = sumOfSubMatrixElements(mat,i0,j0,i1,j1);
						if (sumMax<sum){
							sumMax = sum;
							iStart = i0;  jStart = j0;
							iEnd = i1;  jEnd = j1;
						}
					}
				}
			}	
		}
		System.out.println("iStart=" + iStart+", jStart="+jStart+", iEnd="+iEnd+", jEnd="+jEnd);
		System.out.println("sum max = "+sumMax);
		for (int i=iStart; i<=iEnd; i++){
			for (int j=jStart; j<=jEnd; j++){
				System.out.print(mat[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("**************************************");
	}

	public static void main(String[] args) {
		int mat1[][] = {{2,10,8,3},
				{-8,14,-1,4},
				{-6,-1,8,-2},
				{1,8,7,3},
				{8,2,-10,-8}};		//sumMax=61, iStart=0, jStart=1, iEnd=3, jEnd=3
		maxSumSubMatrixFullSearch(mat1);
		int mat2[][] = {{1,2,-1},
				{-1,0,1},
				{1,-5,-2}}; 		// sumMax=3, iStart=0, jStart=0, iEnd=0, jEnd=1
		maxSumSubMatrixFullSearch(mat2);
		int mat3[][] = {{2,-8,-6,1,8},
				{10,14,-1,8,2},
				{8,-1,8,7,-10},
				{3,4,-2,3,-8}};		//sumMax=61, iStart=1, jStart=0, iEnd=3, jEnd=3
		maxSumSubMatrixFullSearch(mat3);
		int mat4[][] = {{1,2,-1},
				{-1,0,1},
				{1,-5,-2},
				{4,-1,-1}};			//sumMax=5, iStart=0, jStart=0, iEnd=3, jEnd=0
		maxSumSubMatrixFullSearch(mat4);
		int mat5[][] = {{-10,5,-4,3,4},
				{4,-100,10,-30,5},
				{3,2,8,1,6},
				{-5,2,-20,3,1}};	//sumMax=20,  iStart=2, jStart=0, iEnd=2, jEnd=4
		maxSumSubMatrixFullSearch(mat5);
	}
}

