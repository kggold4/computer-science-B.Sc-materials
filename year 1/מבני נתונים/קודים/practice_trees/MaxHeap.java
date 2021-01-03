package practice_trees;

import java.util.NoSuchElementException;

// max heap class
public class MaxHeap {
    int[] heap;
    int SIZE;

    // constructor
    public MaxHeap(int length) {
        this.heap = new int[length];
        this.SIZE = 0;
    }

    // create heap from array constructor
    public MaxHeap(int[] arr) {
        this.heap = new int[arr.length + 1];
        for(int i = 1; i < this.heap.length; i++) {
            this.heap[i] = arr[i - 1];
        }
        this.SIZE = arr.length;
        buildHeap();
    }

    private void buildHeap() {
        for(int i = SIZE / 2; i > 0; i--) {
            maxHeapify(i);
        }
    }

    // left child
    private int left(int i) {
        int answer = 2 * i;
        if(answer > SIZE) throw new NoSuchElementException();
        return answer;
    }

    // right child
    private int right(int i) {
        int answer = 2 * i + 1;
        if(answer > SIZE) throw new NoSuchElementException();
        return answer;
    }

    // parent
    private int parent(int i) {
        if(i <= 0) throw new NoSuchElementException();
        return i / 2;
    }

    // insertion
    public void add(int value) {
        if(SIZE == heap.length -1) ensureCapacity();
        heap[SIZE + 1] = value; // start with 1
        SIZE++;
        swapUp(SIZE - 1);
    }

    // ensure capacity method
    public void ensureCapacity() {
        int[] temp = new int[SIZE * 2 + 1];
        for(int i = 0; i < this.heap.length; i++) temp[i] = this.heap[i];
        this.heap = temp;
    }

    // swap up - ordering values
    private void swapUp(int index) {
        if(index != 1) {
            int parent = parent(index);
            if(this.heap[parent] < this.heap[index]) {
                swap(index, parent);
                swapUp(parent);
            }
        }
    }

    // delete max
    public int removeMax() {

        // heap is empty
        if(SIZE == 0) throw new NoSuchElementException();

        // heap is not empty
        else {
            swap(1, SIZE);
            SIZE--;
            maxHeapify(1);
        }
        return this.heap[SIZE + 1];
    }

    // take i down
    private void maxHeapify(int i) {
        int left, right;

        // getting left and right
        try{ left = left(i); } catch (NoSuchElementException ex) { left = 0; }
        try{ right = right(i); } catch (NoSuchElementException ex) { right = 0; }

        // get largest
        int largest = i;
        if(left >= 1 && this.heap[left] > heap[largest]) largest = left;
        if(right >= 1 && this.heap[right] > heap[largest]) largest = right;
        if(largest != i) {
            swap(largest, i);
            maxHeapify(largest);
        }
    }

    // max method
    public int max() {
        if(SIZE > 1) return this.heap[1];
        else throw new NoSuchElementException();
    }

    public boolean contains(int value) {
        if(SIZE == 0) return false;
        int i = 1;
        while(i <= SIZE) {
            if(this.heap[i] == value) return true;
            i++;
        }
        return false;
    }

    // swapping function
    private void swap(int i, int j) {
        int temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }

    // function that checking if given array is represents Min-Heap or not
    public static boolean isMinHeap(int[] a, int i) {
        if(i*2+1 >= a.length) return true;
        boolean left = (a[i] >= a[i*2+1] && isMinHeap(a, i*2+1));
        boolean right = (i*2+2 == a.length || a[i] >= a[i*2+2] && isMinHeap(a, i*2+2));
        return left && right;
    }

    public static void main(String[] args) {

    }
}