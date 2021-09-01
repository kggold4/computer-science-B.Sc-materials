package exercise1_tr;

import java.util.Arrays;

public class B {
    //bubble sort
    public static void main(String[] args) {
        int[] arr = {5,6,8,4,3,4,7,2,2,8,6,3,2,1,4,6,3,9,9,7,1,2,3,2,1,2,6};
        int[] sortedArr = bubbleSort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    public static int[] bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) swap(arr, j, j + 1);
            }
        }
        return arr;
    }

    public static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}