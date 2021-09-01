package exercise1_tr;

public class A {
    //binary search
    public static void main(String[] args) {
        int[] arr = {8,7,6,5,4,3,2,1};
        int key = 5;
        int result = binarySearch(arr, key);
        System.out.println(result != -1 ? "found index " + result : "not found");
    }

    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1, middle = (high - low) / 2;
        while(low <= high) {
            if(key == arr[middle]) return middle;
            else if(key < arr[middle]) high = middle - 1;
            else if(key > arr[middle]) low = middle + 1;
        }
        return -1;
    }

}