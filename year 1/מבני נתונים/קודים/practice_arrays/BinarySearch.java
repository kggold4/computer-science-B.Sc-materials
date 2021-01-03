package practice_arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int length = 100;
        int[] a = new int[length];
        for(int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        System.out.println(binarySearchRecursive(a, 100)); // false
        System.out.println(binarySearchRecursive(a, 3));   // true
        System.out.println();
        System.out.println(binarySearchLoops(a, 100)); // false
        System.out.println(binarySearchLoops(a, 3));   // true
    }
    public static boolean binarySearchRecursive(int[] a, int key) {
        if(a.length == 0) return false;
        else return binarySearchRecursive(a, key, 0, a.length - 1);
    }
    private static boolean binarySearchRecursive(int[] a, int key, int low, int high) {
        if(low < high) {
            int middle = (low + high) / 2;
            if(a[middle] == key) return true;
            else if(a[middle] < key) return binarySearchRecursive(a, key, middle + 1, high);
            else return binarySearchRecursive(a, key, low, middle - 1);
        }
        return false;
    }

    public static boolean binarySearchLoops(int[] a, int key) {
        int low = 0, high = a.length - 1;
        while(low < high) {
            int middle = (low + high) / 2;
            if(a[middle] == key) return true;
            else if(a[middle] < key) low = middle + 1;
            else high = middle - 1;
        }
        return false;
    }
}
