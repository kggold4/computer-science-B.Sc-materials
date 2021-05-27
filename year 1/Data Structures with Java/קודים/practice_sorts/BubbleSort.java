package practice_sorts;

import java.util.Arrays;

public class BubbleSort { 

    public static void bubbleSort(int[] arr) { //O(n^2)
        for(int i = 0; i < arr.length; i++) {  // O(n)
            for(int j = 0; j < arr.length - 1; j++) { //O(n)
                if(arr[j] > arr[j + 1]) Functions.swap(arr, j, j + 1); // O(3)
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,9,6,5,4,7,2,1,4,5,5,7,4,6,3,2,1,4,8,9,7,5,4,2,3,6};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}