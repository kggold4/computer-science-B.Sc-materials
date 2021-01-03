package lecture4;

public class MyStack {

    private final int MAX_SIZE = 5;
    private Integer[] items;
    private int size, max;

    //main constructor
    public MyStack(int max) {
        this.max = max;
        items = new Integer[max];
        size = 0;
    }

    //default constructor
    public MyStack() {
        max = MAX_SIZE; //default size
        items = new Integer[max];
        size = 0;
    }

    //add item method
    public boolean push(int data) {
        if(size == max) return false;
        else {
            items[size++] = data;
            return true;
        }
    }

    //remove item method
    public Integer pop() {
        if(size > 0) return items[--size];
        else return null;
    }

    //get top item method
    public Integer top() {
        if(size > 0) return items[size - 1];
        else return null;
    }

    //clear stack method
    public void clear() {
        size = 0;
    }

    //is empty method
    public boolean empty() {
        return (size == 0);
    }

    //get size method
    public int size() {
        return size;
    }

    //element at method
    public Integer elementAt(int index) {
        if(index >= size) return null;
        else return items[index];
    }

    //to string method
    public String toString() {
        String result = "[";
        for(int i = 0; i < size; i++) { //O(size)
            result += items[i];
            if(i != size -1) result += ", ";
        }
        result += "]";
        return result;
    }

    //print method
    public void print() {
        System.out.println("stack: " + this);
    }
}