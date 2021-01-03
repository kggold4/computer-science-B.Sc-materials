package lecture2;

import java.util.Arrays;

public class B {
    
    public static void main(String[] args) {
        int[] a1 = {3,7,9,4,1,5,3,2};
        int[] a2 = {5,6,9,4,3,1,3,4,9,4,3,1,3,5,1,7};
        mergeSort(a1);
        mergeSort(a2);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }

    // merge sort
    public static void mergeSort(int[] arr) {
        // sort arr[0, n) not include n = arr.length
        mergeSort(arr, 0, arr.length);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        // sort arr[low, high) not include high
        if(low < high - 1) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid, high);
            int n = high - low;
            int[] temp = new int[n];
            int i = low, j = mid, k = 0;
            //merge rwo arrays: arr[low, mid), arr[mid, high)
            while(i < mid && j < high) {
                if(arr[j] < arr[i]) temp[k++] = arr[j++];
                else temp[k++] = arr[i++];
            }
            while(i < mid) temp[k++] = arr[i++];
            while(j < high) temp[k++] = arr[j++];
            //retieve temp to source array
            for(int p = 0; p < n; p++) arr[low + p] = temp[p];
        }
    }
}