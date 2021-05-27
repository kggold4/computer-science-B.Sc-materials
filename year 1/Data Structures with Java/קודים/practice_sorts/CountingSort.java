package practice_sorts;

import java.util.Arrays;

public class CountingSort {
    public static int[] countingSort(int[] arr) {
        int min = Functions.findMin(arr, 0);
        int max = Functions.findMax(arr, 0);

        int range = (max - min) + 1;
        int[] freq = new int[range];

        for(int i = 0; i < arr.length; i++) {
            freq[arr[i] - min]++;
        }

        return freq;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,8,6,5,4,7,8,9,5,6,2,1,4,5,4,1,2,5,4,1,2,5,8,9,8,9,8,9,8,5,6,8,4,7,8,5,1,2,5,4,5,2,5,8,8,8,8,9};
        int[] freq = countingSort(arr);
        System.out.println(Arrays.toString(freq));
    }
}