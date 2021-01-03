package assignment3;

import java.util.Arrays;

public class MinHeap {

    int _positiveInfinity = Integer.MAX_VALUE;
    private int[] _a;
    private int _size;

    // constructor
    public MinHeap(int arr[]){
        _size = arr.length;
        _a = new int[_size];
        for (int i=0; i<_size; i++){
            _a[i]=arr[i];
        }
    }

    // returns the heap size
    public int getSize() { return _size; }

    // returns the heap array
    public int[] getA(){ return _a;}

    // parent returns the parent of vertex
    private  int parent(int i) { return (i - 1) / 2; }

    // leftChild returns the left child of vertex i
    private int leftChild(int i) { return 2 * i + 1; }

    // rightChild returns the right child of vertex
    private int rightChild(int i) {return 2 * i + 2; }

    // returns the heap minimum
    public int heapMinimum(){ return _a[0]; }

    // returns true if the heap is empty, otherwise false
    public boolean isEmpty() {
        boolean ans = false;
        if (_size == 0) ans = true;
        return ans;
    }

    // the minHeapfy function maintains the min-heap property
    private void minHeapify(int v, int heapSize){
        int smallest;
        int left = leftChild(v);
        int right = rightChild(v);
        if (left<heapSize && _a[left]<_a[v]){
            smallest = left;
        }
        else{
            smallest = v;
        }
        if (right<heapSize && _a[right]<_a[smallest]){
            smallest = right;
        }
        if (smallest!=v){
            swap(v, smallest);
            minHeapify(smallest, heapSize);
        }
    }

    // building a min-heap from arbitrary array of Nodes
    public void buildMinHeap(){
        for (int i=_size/2-1; i>=0; i--){
            minHeapify(i, _size);
        }
    }

    // the heap sort algorithm
    public static void heapSort(MinHeap heap){
        heap.buildMinHeap();
        int heapSize = heap._size;
        for (int i = heapSize - 1; i >= 1; i--) {
            heap.swap(0, i);
            heapSize = heapSize - 1;
            heap.minHeapify(0, heapSize);
        }
    }

    // the heap minimum element extraction
    public int heapExtractMin(){
        int node=_positiveInfinity;// infinity
        if (!isEmpty()){
            node = _a[0];
            _a[0]=_a[_size-1];
            _size = _size-1;
            minHeapify(0, _size);
        }
        return node;
    }

    // the heapDecreaseKey implements the Decrease Key operation
    private void heapDecreaseKey(int i, int key){
        if (key <=_a[i]){
            _a[i] = key;
            while (i>0 && _a[parent(i)]>_a[i]){
                swap(i, parent(i));
                i = parent(i);
            }
        }
    }

    // minHeapInsert function implements the Insert-Key operation
    public void minHeapInsert(int key){
        resize(1);
        _a[_size-1] = _positiveInfinity;
        heapDecreaseKey(_size-1, key);
    }

    // increment an array
    private void resize(int increment){
        int temp[] = new int[_size+increment];
        for (int i=0; i<_size; i++){
            temp[i]=_a[i];
        }
        _a = temp;
        _size = _size+increment;
    }

    // swap two array elements
    private void swap(int i, int j){
        int t = _a[i];
        _a[i] = _a[j];
        _a[j] = t;
    }
    // print a heap array
    public void print(){
        for (int i=0; i<_size; i++){
            System.out.print(_a[i]+"; ");
        }
        System.out.println();
    }

    public static boolean isMinHeap(int[] arr){
        boolean ans = true;
        for (int i=0; ans && i<arr.length/2; i++){
            int left = i*2 + 1;
            int right = i*2 + 2;
            if (left<arr.length && arr[i]>arr[left]) ans = false;
            if (ans && right<arr.length && arr[i]>arr[right]) ans = false;
        }
        return ans;
    }

    public static int[] kSmallestNumbers(int[] arr, int k){
        MinHeap hp = new MinHeap(arr);
        hp.buildMinHeap();//O(n)
        int []ans = new int[k];
        for(int i=0; i<k; i++){//O(k*log(n))
            ans[i] = hp.heapExtractMin();//O(log(n))
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int nodes1[] = {16,5,8,4,2,1};
        MinHeap heap1 = new MinHeap(nodes1);
        heap1.print();
        heap1.print();
    }

}
