package practice_sorts;

import java.util.Arrays;

public class RadixSort {
    
    public static void radixSort(int[] arr) {
        int max = Functions.findMax(arr, 0), exp = 1, n = arr.length, base = 10;
        int[] temp = new int[n];
        while(max / exp > 0) {
            int[] bucket = new int[base];
            for(int i = 0; i < n; i++) {
                int index = (arr[i]) % base;
                bucket[index]++;
            }

            for(int i = 1; i < base; i++) bucket[i] += bucket[i - 1];

            for(int i = n - 1; i >= 0; i--) {
                int j = (arr[i] / exp) % base;
                temp[bucket[j]] = arr[i];
            }

            for(int i = 0; i < n; i++){
                arr[i] = temp[i];
                exp /= base;
            }       
        }
    }
    public static void main(String[] args) {
        int[] arr = {329, 457, 657, 839, 436, 720, 355};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}