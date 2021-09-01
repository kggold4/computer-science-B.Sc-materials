package practice_sorts;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr) { //O(n^2)
        for(int i = 0; i < arr.length; i++) { //O(n)
            int min = Functions.findMinIndex(arr, i); //O(n)
            Functions.swap(arr, i, min); //O(3)
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,7,8,7,6,5,4,2,1,5,6,6,8,9,6,5,4,2,3,1,4,8,6,5,4,8,4};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}