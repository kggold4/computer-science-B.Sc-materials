package marathon1;

import java.util.Arrays;

public class A {
    
    //counting sort
    public static void main(String[] args) {
        int[] arr = {5,6,3,3,4,5,8,7,8,6,6,5,3,4,3,7,7,5,6,9};
        int[] counts = countingSort(arr);
        System.out.println(Arrays.toString(counts));
    }

    public static int[] countingSort(int[] arr) {

        //getting min
        int min = arr[0];
        for(int i = 0; i < arr.length; i++) { // O(n)
            if(min > arr[i]) min = arr[i];
        }

        //getting max
        int max = min;
        for(int i = 0; i < arr.length; i++) { // O(n)
            if(max < arr[i]) max = arr[i];
        }

        int range = max - min + 1;
        int[] counts = new int[range];

        for(int i = 0; i < arr.length; i++) { // O(n)
            counts[arr[i] - min]++;
        }

        return counts;
    } // O(n) + O(n) + O(n) = O(n + n + n) = O(n)
}