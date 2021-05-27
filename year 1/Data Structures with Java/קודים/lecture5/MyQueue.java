package lecture5;

public class MyQueue {

    private int front, tail, size, maxSize;
    private final int INIT_SIZE = 4;
    private Integer[] data;

    //defaule constructor
    public MyQueue() {
        this.maxSize = INIT_SIZE;
        this.front = this.tail = this.size = 0;
        this.data = new Integer[this.maxSize];
    }

    //constructor
    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = this.tail = this.size = 0;
        this.data = new Integer[this.maxSize];
    }

    //is empty method
    public boolean isEmpty() {
        return this.size == 0;
    }

    //enqueue new elemnt into the queue
    public boolean enqueue(int value) {
        
        //if queue is full
        if(this.size == this.maxSize) return false;
            
        //if tail == maxSize - 1 -> tail = 0
        else {
            this.data[tail] = value;
            this.tail = (this.tail + 1) % this.maxSize;
            this.size++;
            return true;
        }
    }

    //dequeue element
    public Integer dequeue() {
        
        if(this.isEmpty()) return null;
        else {
            Integer temp = this.data[front];
            this.front = (this.front + 1) % this.maxSize;
            this.size--;
            return temp;
        }
    }

    //return front element
    public Integer peek() {
        return this.data[front];
    }

    //get size
    public int size() {
        return this.size;
    }

    //to string method
    public String toString() {
        if(this.isEmpty()) return "[]";
        else {
            String str = "[";
            for(int i = 0; i < size - 1; i++) {
                str += data[(i + front) % maxSize] + ", ";
            }
            str += data[(size - 1 + front) % maxSize] + "]";
            return str;
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        
        queue.enqueue(6);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(5);

        System.out.println(queue.peek());
        queue.dequeue();

        System.out.println(queue);
    }
}