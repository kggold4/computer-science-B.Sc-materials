package exercise1_tr;

import java.util.Arrays;

public class E {
    //merge sort
    public static void main(String[] args) {
        int[] arr = {7,4,5,8,9,5,4,2,3,1,8,5,2,1,4,7,9,6,3,2,5,1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if(low < high - 1) {
            int middle = (low + high) / 2;
            mergeSort(arr, low, middle);
            mergeSort(arr, middle, high);
            int n = high - low;
            int[] temp = new int[n];
            int i = low, j = middle, k = 0;

            while(i < middle && j < high) {
                if(arr[j] < arr[i]) temp[k++] = arr[j++];
                else temp[k++] = arr[i++];
            }
            while(i < middle) temp[k++] = arr[i++];
            while(j < high) temp[k++] = arr[j++];
            
            for(int p = 0; p < n; p++) arr[low + p] = temp[p];
        }
    }
}