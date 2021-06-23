import java.util.Arrays;

/**
 * The maximum subarray problem:
 * finding the contiguous subarray within a one-dimensional array of numbers
 * which has the largest sum. 
 * Exhaustive Search (Full Search)
 * Complexity: O(n^3) 
 */

public class BestExhaustiveSearch {//O(n^3)

	public static void bestExhaustiveSearch(int arr[]){
		int sum = 0, sumMax = arr[0], start = 0, end = 0;
		for (int i=0; i<arr.length; i++){
			for (int j = i; j < arr.length; j++) {
				sum = 0;
				for (int k=i; k<=j; k++){
					sum = sum + arr[k];
					if (sum > sumMax){
						sumMax = sum;
						start = i;
						end = k;
					}
				}
			}
		}
		System.out.println(Arrays.toString(arr) + " sumMax = "+sumMax+", interval: ["+start + ","+end+"]");
	}
	public static void main(String[] args) {
		int[]a1 = {1,2,3,-50,2,4,-34,4};//sum=6
		int[]a2 = {1,2,3,-50,2,4,-34,6};// sum=6
		int[]a3 = {3,3,-50,1,2,3,-34,4};// sum=6
		int[]a4 = {1,2,2,1,-50,2,4,-34,1,2,3};//sum=6
		int[]a5 = {-1,-2,-2,-1,-50};// sum=-1
		int[]a6 = {6,-50,1,2,3,-34,3,3};//sum=6
		int[]a7 = {10,2,-5,8,-100,3,50,-80,1,2,3}; //sum=53
		int[]a8 = {3,-2,5,1};//sum = 7
		bestExhaustiveSearch(a1);
		bestExhaustiveSearch(a2);
		bestExhaustiveSearch(a3);
		bestExhaustiveSearch(a4);
		bestExhaustiveSearch(a5);
		bestExhaustiveSearch(a6);
		bestExhaustiveSearch(a7);
		bestExhaustiveSearch(a8);
	}

}
