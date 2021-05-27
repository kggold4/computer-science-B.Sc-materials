package lecture2;

import java.util.Arrays;

public class Mix {
    public static void main(String[] args) {
        int limit = 1000000;
        int list[] = new int[limit];
        for(int i = 0; i < limit; ++i) {
            list[i] = i;
        }
        mix(list);
        System.out.println(Arrays.toString(list));
    }

    public static void mix(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            swap(arr, i, getRandom(i, arr.length - 1));
        }
    }

    public static int getRandom(int min, int max) {
        return (int)(Math.random() * (max - min)) + min;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
