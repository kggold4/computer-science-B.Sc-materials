package lecture3;

import java.util.Arrays;

public class B {
    //counting sort
    public static void main(String[] args) {
        int[] arr = {6,5,4,7,8,4,5,4,8,9,6,3,3,5,4,7,8,9,9,9,9,5,4,5,7,8,6};
        int[] counting = countingSort(arr);
        System.out.println(Arrays.toString(counting));
    }

    public static int[] countingSort(int[] arr) {
        int low = getMin(arr), high = getMax(arr);
        int range = high - low;
        int[] counting = new int[range + 1];

        for(int i = 0; i < arr.length; i++) {
            counting[arr[i] - low]++;
        }
        
        return counting;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(max < arr[i]) max = arr[i];
        }
        return max;
    }

    private static int getMin(int[] arr) {
        int min = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(min > arr[i]) min = arr[i];
        }
        return min;
    }
}