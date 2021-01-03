package practice_sorts;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) { //O(n^2)
        
        for(int i = 1; i < arr.length; i++) { //O(n)
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key) { //O(n)
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

    }

    public static void main(String[] args) {
        int[] arr = {2,5,4,8,9,6,4,7,5,8,4,2,3,1,5,4,7,8,9,5,6,5,6,5,4,7,5,9,9,1,2,3,5,4,7};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}