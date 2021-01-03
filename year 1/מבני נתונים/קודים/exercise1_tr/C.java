package exercise1_tr;

import java.util.Arrays;

public class C {
    //selection sort
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        int[] sortedArr = selectionSort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    public static int[] selectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int min = findMin(arr, i);
            swap(arr, i, min);
        }
        return arr;
    }

    public static int findMin(int[] arr, int from) {
        int min = getMax(arr);
        int index = from;
        for(int i = from; i < arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static int getMax(int[] arr) {
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(max < arr[i]) max = arr[i];
        }
        return max;
    }

    public static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

}