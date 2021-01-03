package lecture1;

import java.util.Arrays;

public class A {
    public static void main(String[] args) {
        int[] arr = {4,6,3,1,8,9,2};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    public static int[] insertionSort(int[] arr) {
        //O(n^2)
        for(int i = 0; i < arr.length; i++) {
            int j = i;
            int a = arr[j];
            while(j > 0 && arr[j-1] > a) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = a;
        }
        return arr;
    }
}