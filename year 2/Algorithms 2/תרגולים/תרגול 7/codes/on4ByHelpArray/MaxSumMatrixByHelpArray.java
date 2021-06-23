package on4ByHelpArray;

import java.util.Arrays;
/**
 * The maximum sub-matrix problem:
 * finding the sub-matrix which has the largest sum.
 * Using Best in the band - Help Array
 * n = numOfRows, m = numOfColumns
 * O(n(n+1)/2) - number of bands, 
 * O(n*m) - number of elements in the band 
 * best - O(n)
 * Complexity: O(n^2)*(O(n*m+O(m))=min(O(n^3*m^2),O(n^2*m^3))=O(min^3(m*n)*max(m,n))
 */
public class MaxSumMatrixByHelpArray {

	public static int maxSumMatrixON5(int[][] mat){
		
		int max = mat[0][0];
		
		for (int i0 = 0; i0 < mat.length; i0++) { //n(n+1)/2
			for (int i1 = i0; i1 < mat.length; i1++) {
				System.out.println("i0 = " + i0 + "   i1 = " + i1 + "   mat.length = " + mat.length);
				int[] sumBand = sumOfBand(mat, i0, i1); //O(n*m)
				System.out.println(Arrays.toString(sumBand)); 
				//int ans = best(sumBand)[3];// O(m)
				int ans = best1(sumBand); // O(m)
				System.out.println("ans = " + ans);
				if(ans > max) max = ans;
			}
		}		
		return max;
	}
	
	public static int[] sumOfBand(int[][]mat, int i0, int i1){
		
		int sumBand[] = new int[mat[0].length];
		
		for (int j = 0; j < mat[0].length; j++) {
			for (int i = i0; i <= i1; i++) {
				sumBand[j] = sumBand[j] + mat[i][j];
			}
		}
		return sumBand;
	}
	
	public static void main(String[] args) {
		
		int mat1[][] = {{2,10,8,3},
						{-8,14,-1,4},
						{-6,-1,8,-2},
						{1,8,7,3},
						{8,2,-10,-8}};		//sumMax=61
		
		int max = maxSumMatrixON5(mat1);
		System.out.println("\nmax = " + max);
	}
	
	public static int best1(int arr[]) {
		
	    int maxSoFar = arr[0];
	    int maxEndingHere = 0; 
	    
	    for (int i = 0; i < arr.length; i++){
	    	maxEndingHere = Math.max(maxEndingHere + arr[i], 0);
	    	maxSoFar = Math.max(maxEndingHere, maxSoFar); 
	    }
	    return maxSoFar;	     
	}
	/**
	 * The maximum sub-array/sub-interval problem:
	 * finding the contiguous sub-array within an one-dimensional array of numbers
	 * which has the largest sum. 
	 * Optimal Best solution
	 * Complexity: O(n)
	 * @param a an one-dimensional array of numbers
	 * @return array with 4 parameters:
	 * 		   begin index, end index of sub-array,
	 * 		   length of sub-interval, max sum of the interval 
	 */
	public static int[] best(int[] a){
		int i=0;
		while (i<a.length && a[i]<=0) {i++;}
		if (i == a.length){
			int index = 0;
			for (int j=0; j<a.length; j++){
				if (a[j] > a[index]) index = j;
			}
			int[]ans = {index, index, 1, a[index]};
			return ans;
		}
		else{
			int sum=0, maxSum=a[i], beginMax = i, endMax = i, count = 0, countMax = 1;
			while(i<a.length){
				sum = sum + a[i];
				count++;
				if (sum < 0){
					sum = 0;
					count = 0;
				}
				else if (sum > maxSum){
					maxSum = sum;
					endMax = i;
					countMax = count;
				}
				i++;
			}
			beginMax = endMax + 1 - countMax;
			int[]ans = {beginMax, endMax, countMax, maxSum};
			//printBest(a, ans);
			return ans;
		}
	}

}

/*
int[][] m = {{1,2,3,6},
			 {2,-3,1,2},
			 {5,2,7,0}};
int max = maxSumMatrixON5(m);
System.out.println(max);
*/

