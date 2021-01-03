package practice_sorts;

public class MergeSort {
    
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid, high);
            int n = high - low;
            int[] temp = new int[n];
            int i = low, j = mid, k = 0;

            //merge algorithm
            while(i < mid && j < high) {
                if(arr[j] < arr[i]) temp[k++] = arr[j++];
                else temp[k++] = arr[i++];
            }
            while(i < mid) temp[k++] = arr[i++];
            while(j < high) temp[k++] = arr[j++];

            for(int p = 0; p < n; p++) arr[low + p] = temp[p];
        }
    }
}