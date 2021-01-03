package practice_sorts;

public class Functions {

    public static int findMax(int[] arr, int from) {
        int max = arr[from];
        for(int i = from; i < arr.length; i++) {
            if(max < arr[i]) max = arr[i];
        }
        return max;
    }

    public static int findMin(int[] arr, int from) {
        int min = arr[from];
        for(int i = from; i < arr.length; i++) {
            if(min > arr[i]) min = arr[i];
        }
        return min;
    }

    public static int findMinIndex(int[] arr, int from) {
        int min = arr[from];
        int minIndex = from;
        for(int i = from; i < arr.length; i++) {
            if(min > arr[i])  {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,4,7,9,6,5,8,6,20,7,20,9};
        System.out.println(findMin(arr, 6));
    }
}