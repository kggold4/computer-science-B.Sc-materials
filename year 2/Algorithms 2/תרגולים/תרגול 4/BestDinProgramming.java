import java.util.Arrays;

/**
 * The maximum subarray problem:
 * finding the contiguous subarray within a one-dimensional array of numbers
 * which has the largest sum. 
 * Dynamic programming
 * Complexity: O(n^2) 
 */

public class BestDinProgramming {

	//O(N^2) - top down: mat[i][j] = mat[i][j-1] + a[j]
	public static int bestDP1(int[]a){
		int n = a.length;
		int [][]mat = new int[n][n];
		int sumMax=a[0], beginMax=0, endMax=0, length=0;
		for (int i=0; i<n; i++){
			mat[i][i] = a[i];
			if (sumMax < a[i]){
				sumMax = a[i];
				beginMax = endMax = i;
			}
		}
		for (int i=0; i<n; i++){
			for (int j=i+1; j<n; j++){
				mat[i][j] = mat[i][j-1] + a[j];
				if (sumMax < mat[i][j]){
					sumMax = mat[i][j];
					beginMax = i;
					endMax = j;
				}
			}
		}
		length = endMax +1 - beginMax;
		//System.out.println(Arrays.toString(a) + " sumMax = "+sumMax+", interval: ["+beginMax + ","+endMax+"], length: "+length);

		return sumMax;
	}

	//O(N^2) - bottom up: mat[i][j] = mat[i+1][j] + a[i];
	public static int bestDP2(int[]a){
		int n = a.length;
		int [][]mat = new int[n][n];
		int sumMax=a[0], beginMax=0, endMax=0, length=0;
		for (int i=0; i<n; i++){
			mat[i][i] = a[i];
			if (sumMax < a[i]){
				sumMax = a[i];
				beginMax = endMax = i;
			}
		}
		for (int i=n-1; i>=0; i--){
			for (int j=i+1; j<n; j++){
				mat[i][j] = mat[i+1][j] + a[i];
				if (sumMax < mat[i][j]){
					sumMax = mat[i][j];
					beginMax = i;
					endMax = j;
				}
			}
		}
		length = endMax +1 - beginMax;
		//System.out.println(Arrays.toString(a) + " sumMax = "+sumMax+", interval: ["+beginMax + ","+endMax+"], length: "+length);

		return sumMax;
	}

	//O(N^2) - bottom up: mat[i][j] = mat[i+1][j] + mat[i][i];
	public static int bestDP4(int[]a){
		int n = a.length;
		int [][]mat = new int[n][n];
		int sumMax=a[0], beginMax=0, endMax=0, length=0;
		for (int i=0; i<n; i++){
			mat[i][i] = a[i];
			if (sumMax < mat[i][i]){
				sumMax = mat[i][i];
				beginMax = endMax = i;
			}
		}
		for (int i=n-1; i>=0; i--){
			for (int j=i+1; j<n; j++){
				mat[i][j] = mat[i+1][j] + mat[i][i];
				if (sumMax < mat[i][j]){
					sumMax = mat[i][j];
					beginMax = i;
					endMax = j;
				}
			}
		}
		length = endMax +1 - beginMax;
		//System.out.println(Arrays.toString(a) + " sumMax = "+sumMax+", interval: ["+beginMax + ","+endMax+"], length: "+length);

		return sumMax;
	}

	//O(N^2) mat[i][j] = mat[i][j-1] + mat[i-1][j] - mat[i-1][j-1];
	public static int bestDP3(int[]a){
		int n = a.length;
		int [][]mat = new int[n][n];
		int sumMax=a[0], beginMax=0, endMax=0;
		for (int i=0; i<n; i++){
			mat[i][i] = a[i];
			if (sumMax < a[i]){
				sumMax = a[i];
				beginMax = endMax = i;
			}
		}
		for (int i=n-1; i<n; i++){
			for (int j=i; j<n; j++){
				mat[i][j] = mat[i][j-1] + mat[i-1][j] - mat[i-1][j-1];
				if (sumMax < mat[i][j]){
					sumMax = mat[i][j];
					beginMax = i;
					endMax = j;
				}
			}
		}
		return sumMax;
	}	

	public static void test(){
		int arr[] = {10,2,-5,8,-100,3,50,-80,1,2,3}; //sum=53
		System.out.println("DP1: "+bestDP1(arr));
		System.out.println("DP2: "+bestDP2(arr));
		int arr1[] = {3,-2,5,1}; //sum=7
		System.out.println("DP1: "+bestDP1(arr1));
		System.out.println("DP2: "+bestDP2(arr1));
	}

	public static void testTime(){
		int size = 8000, loop = 100;
		long t1 = 0, t2 = 0, t3 = 0;
		for (int i=1; i<=loop;i++){
			int arr[] = MyLibrary.randomIntegerArrayMinus(size);
			long start = System.currentTimeMillis();
			int sumMax = bestDP1(arr);
			long end = System.currentTimeMillis();
			t1 = t1 + (end-start);
			////////
			start = System.currentTimeMillis();
			sumMax = bestDP2(arr);
			end = System.currentTimeMillis();
			t2 = t2 + (end-start);
			////////
			start = System.currentTimeMillis();
			sumMax = bestDP4(arr);
			end = System.currentTimeMillis();
			t3 = t3 + (end-start);

		}
		System.out.println("DP1 (top down) time = "+ t1/loop + " ms");
		System.out.println("DP2 (bottom up) time = "+t2/loop + " ms");
		System.out.println("DP4 (bottom up - mat[i][j]) time = "+t3/loop + " ms");
	}
	public static void main(String[] args) {
		test();
		testTime();
	}
}
/* 
DP1: 53
DP2: 53
DP1: 7
DP2: 7
DP1 (top down) time = 58 ms
DP2 (bottom up) time = 52 ms
///////////////////////////////////////////
[10, 2, -5, 8, -100, 3, 50, -80, 1, 2, 3] sumMax = 53, interval: [5,6], length: 2
DP1: 53
[10, 2, -5, 8, -100, 3, 50, -80, 1, 2, 3] sumMax = 53, interval: [5,6], length: 2
DP2: 53
[3, -2, 5, 1] sumMax = 7, interval: [0,3], length: 4
DP1: 7
[3, -2, 5, 1] sumMax = 7, interval: [0,3], length: 4
DP2: 7
 */