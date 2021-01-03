package exercise1_tr;

import java.util.Arrays;

public class D {
    //insertion sort
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,4,8,6,2,1,2,3,5,3,4,1,4,8,6,2,7,2,1,5,6,9,1,1,9};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}