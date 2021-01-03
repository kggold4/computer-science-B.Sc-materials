package practice_sorts;

import java.util.LinkedList;

class MyStackInteger {

    private LinkedList<Integer> data;
    private Integer top;

    //default constructor
    public MyStackInteger() {
        this.data = new LinkedList<Integer>();
        this.top = null;
    }

    // push new elemnt into the stack method
    public void push(int val) { // O(1)
        this.data.add(val);
        this.top = val;
    }

    // pop element for stack method
    public Integer pop() { // O(1)
        if(this.isEmpty()) return null;
        else {
            Integer temp = this.top;
            this.data.removeLast();
            if(!data.isEmpty()) this.top = this.data.getLast();
            else this.top = null;
            
            return temp;
        }
    }

    public MyStackInteger sort() {

        MyStackInteger newStack = new MyStackInteger();

        while(!this.isEmpty()) {
            Integer temp = this.pop();
            while(!newStack.isEmpty() && newStack.peek() > temp) {
                this.push(newStack.pop());
            }
            newStack.push(temp);
        }

        return newStack;
    }

    public MyStackInteger revese() {
        MyStackInteger newStack = new MyStackInteger();
        while(!this.isEmpty()) {
            newStack.push(this.pop());
        }
        return newStack;
    }

    //if val is contain in stack method
    public boolean contains(Integer val) { // O(n)
        return this.data.contains(val);
    }

    //is empty method
    public boolean isEmpty() { // O(1)
        return this.data.isEmpty();
    }

    //size method
    public int size() { // O(1)
        return this.data.size();
    }

    //clear method
    public void clear() {  // O(n)
        this.data.clear(); // O(n)
        this.top = null; // O(1)
    }

    public Integer peek() {
        return this.top;
    }

    //to string method
    public String toString() { // O(n)
        return this.data.toString();
    }

    public static void main(String[] args) {
        MyStackInteger stack = new MyStackInteger();
        stack.push(8);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        
        System.out.println("stack: " + stack);
        stack = stack.sort();
        System.out.println("stack: " + stack);
        stack = stack.revese();
        System.out.println("stack: " + stack);
        

    }
}