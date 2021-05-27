package lecture3;

import java.util.Arrays;

public class C {
    //radix sort LSD
    public static void main(String[] args) {
        int[] arr = {329, 457, 657, 839, 436, 720, 355};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int max = getMax(arr), exp = 1, n = arr.length, base = 10;
        int[] temp = new int[n];
        while(max / exp > 0) {
            int[] bucket = new int[base];
            for(int i = 0; i < n; i++) {
                int index = (arr[i] / exp) % base;
                bucket[index]++;
            }

            for(int i = 1; i < base; i++) {
                bucket[i] = bucket[i] + bucket[i - 1];
            }

            for(int i = n - 1; i >= 0; i--) {
                int j = (arr[i] / exp) % base;
                temp[--bucket[j]] = arr[i];
            }

            for(int i = 0; i < n; i++) {
                arr[i] = temp[i];
                exp = exp / base;
            }
        }
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(max < arr[i]) max = arr[i];
        }
        return max;
    }
}