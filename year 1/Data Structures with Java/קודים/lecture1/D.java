package lecture1;


public class D {
    public static void main(String[] args) {
        int[] arr = new int[100];
        int i = 0;
        while(i < 100) {
            arr[i] = i + 1;
            i++;
        }

        System.out.println(binarySearchInduction(arr , 95));
    }

    public static int binarySearchInduction(int[] arr, int data) {

        if(data < arr[0]) return -1;
        if(data > arr[arr.length - 1]) return -arr.length-1;

        int low = 0, high = arr.length - 1;
        int middle = (low + high) / 2;

        while(low <= high) {
            middle = (low + high) / 2;
            if(arr[middle] == data) return middle;
            else if(data < arr[middle]) high = middle - 1;
            else if(data > arr[middle]) low = middle + 1;
        }
        return -1;
    }
}