package practice_sorts;

import java.util.Arrays;

public class QuickSort {
    
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = low;
        low++;
        while(low <= high) {
            if(arr[low] <= arr[pivot]) low++;
            else if(arr[high] > arr[pivot]) high--;
            else Functions.swap(arr, high, low);
        }
        Functions.swap(arr, high, pivot);
        return high;

    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,8,9,6,5,4,7,5,3,2,1,5,8,9,6,5,4,7,5,8};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}