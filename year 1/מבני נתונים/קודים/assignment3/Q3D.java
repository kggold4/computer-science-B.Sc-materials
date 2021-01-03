package assignment3;

public class Q3D {
    public static MinHeap mergeTwoHeaps(MinHeap h1, MinHeap h2) {
        int[] newHeapArray = mergeArrays(h1.getA(), h2.getA());
        MinHeap newHeap = new MinHeap(newHeapArray);
        MinHeap.heapSort(newHeap);
        return newHeap;
    }

    // merging two arrays into on array
    private static int[] mergeArrays(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        for(int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        int j = a.length;
        for(; j < c.length; j++) {
            c[j] = b[j];
        }
        return c;
    }
}
