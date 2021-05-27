package assignment1;

/**
 * 
 * assignment 1 - Data structures Sk2020
 * @author Kfir Goldfarb, id: 208980359
 * @version 1.4
 * *** INDEXING: ***
 * @see Question 4 section a is arrange function at line 196
 * @see Question 4 section b is isSymmetrical function at line 230
 * @see Question 4 section c is isSymmetricalQueue function at line 273
 * @see Question 5 section a is MyQueue class at line 403
 * @see Question 5 section b is MyStack class at line 474
 * @see Question 5 section c is MyQueueWithStacks class at line 529
 * @see Question 5 section d is MyStackWithQueues class at line 569
 * 
 */

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

// Range Class is the main class fo checking all other classes
public class Range {

    public static void main(String[] args) {

        System.out.println("\n\n***Question 4***\n\n");

        //macking persons for checking Person class
        Person p1 = new Person();
        p1.name = "amir";
        p1.age = 30;
        Person p2 = new Person();
        p2.name = "bob";
        p2.age = 24;
        Person p3 = new Person();
        p3.name = "charly";
        p3.age = 17;
        Person p4 = new Person();
        p4.name = "daniel";
        p4.age = 18;
        Person p5 = new Person();
        p5.name = "eli";
        p5.age = 20;
        Person p6 = new Person();
        p6.name = "feeb";
        p6.age = 9;
        Person p7 = new Person();
        p7.name = "goyle";
        p7.age = 13;
        Person p8 = new Person();
        p8.name = "hanry";
        p8.age = 14;
        Person p9 = new Person();
        p9.name = "ilay";
        p9.age = 20;
        Person p10 = new Person();
        p10.name = "nil";
        p10.age = 17;

        Person[] persons1 = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10}; // non symmetrical array
        Person[] persons2 = {p1, p2, p3, p4, p5, p5, p4, p3, p2, p1};  // symmetrical array

        //question 4 section a:
        //checking arrange fucntion

        System.out.println("\n\n***section a***\n\n");
        Person.arrange(persons1);
        for(int i = 0; i < persons1.length; i++) {
            System.out.println("age: " + persons1[i].age + ", name: " + persons1[i].name);
        }

        //question 4 section b:
        //checking isSymmetrical stack fucntion

        System.out.println("\n\n***section b***\n\n");
        System.out.println("persons1 is symmetrical stack: " + Person.isSymmetrical(persons1)); // false
        System.out.println("persons2 is symmetrical stack: " + Person.isSymmetrical(persons2)); // true

        //question 4 section c:
        //checking isSymmetrical queue fucntion

        System.out.println("\n\n***section c***\n\n");
        System.out.println("persons1 is symmetrical queue: " + Person.isSymmetricalQueue(persons1)); // false
        System.out.println("persons2 is symmetrical queue: " + Person.isSymmetricalQueue(persons2)); // true

        //question 5
        System.out.println("\n\n***question 5***\n\n");

        //question 5 section a
        //checking MyQueue class

        System.out.println("\n\n***section a - MyQueue class***\n\n");

        MyQueue<Integer> queue = new MyQueue<>();
        System.out.println("queue: " + queue);
        System.out.println("size: " + queue.size());
        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.println("peek: " + queue.peek());
        queue.enqueue(15);
        queue.enqueue(10);
        queue.enqueue(5);
        queue.enqueue(0);
        System.out.println("queue: " + queue);
        System.out.println("contains 5: " + queue.contains(5));
        System.out.println("contains 20: " + queue.contains(20));
        System.out.println("queue: " + queue);
        System.out.println("size: " + queue.size());
        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.println("peek: " + queue.peek());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("queue: " + queue);
        System.out.println("size: " + queue.size());
        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.println("peek: " + queue.peek());
        queue.clear();
        System.out.println("cleared queue: " + queue);

        //question 5 section b
        //checking MyStack class

        System.out.println("\n\n***section b - MyStack class***\n\n");
        MyStack<Integer> stack = new MyStack<>();
        System.out.println("stack: " + stack);
        System.out.println("size: " + stack.size());
        System.out.println("isEmpty: " + stack.isEmpty());
        System.out.println("pop: " + stack.pop());
        stack.push(15);
        stack.push(10);
        stack.push(5);
        stack.push(0);
        System.out.println("stack: " + stack);
        System.out.println("contains 5: " + stack.contains(5));
        System.out.println("contains 20: " + stack.contains(20));
        System.out.println("stack: " + stack);
        System.out.println("size: " + stack.size());
        System.out.println("isEmpty: " + stack.isEmpty());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("stack: " + stack);
        System.out.println("size: " + stack.size());
        System.out.println("isEmpty: " + stack.isEmpty());
        System.out.println("pop: " + stack.pop());
        stack.clear();
        System.out.println("cleared stack: " + stack);

        //question 5 section c
        //checking queueStack class

        System.out.println("\n\n***section c - queueStack class***\n\n");
        MyQueueWithStacks<Integer> queueStack = new MyQueueWithStacks<>();
        System.out.println(queueStack.dequeue());
        System.out.println("enqueue 15");
        queueStack.enqueue(15);
        System.out.println("enqueue 20");
        queueStack.enqueue(20);
        System.out.println("enqueue 25");
        queueStack.enqueue(25);
        System.out.println("enqueue 30");
        queueStack.enqueue(30);
        System.out.println("dequeue: " + queueStack.dequeue());

        //question 5 section d
        //checking stackQueue class

        System.out.println("\n\n***section d - stackQueue class***\n\n");
        MyStackWithQueues<Integer> stackQueue = new MyStackWithQueues<>();
        System.out.println("push 15");
        stackQueue.push(15);
        System.out.println("push 10");
        stackQueue.push(10);
        System.out.println("push 5");
        stackQueue.push(5);
        System.out.println("push 0");
        stackQueue.push(0);
        System.out.println("pop: " + stackQueue.pop());
        System.out.println("pop: " + stackQueue.pop());
    }
}

// Person class contains all question 4
// I used MyQueuePerson class I write below to make this class

class Person {

    public int age;
    public String name; // small letters only

    //to string method i make for checking class
    public String toString() {
        return "age: " + this.age + " ,name: " + this.name;
    }

    //*****************************************************************************/
    // question 4 section a:

    public static void arrange(Person[] persons) {

        // *** mark n as persons.length ***

        //define temp array that will be the new ordered persons arrays
        Person[] temp = new Person[persons.length]; // O(1)

        //temp take all the items with age < 18 to the first indexes
        int k = 0; // O(1)
        for(int i = 0; i < persons.length; i++) { // O(n)
            if(persons[i].age < 18) {
                temp[k] = persons[i]; // O(1)
                k++; // O(1)
            }
        }

        //temp take all the items with age >= 18 to the last indexes
        for(int j = 0; j < persons.length; j++) { // O(n)
            if(persons[j].age >= 18) {
                temp[k] = persons[j]; // O(1)
                k++; // O(1)
            }
        }

        //make persons assign to temp
        for(int q = 0; q < temp.length; q++) persons[q] = temp[q]; // O(n)

        // arrange function complexity:
        // O(1) + O(1) + O(n) * 2 * O(1) + O(n) * 2 * O(1) + O(n) = O(n)
    }

    //*****************************************************************************/
    // question 4 section b:

    public static boolean isSymmetrical(Person[] persons) {

        // *** mark n as persons.length ***

        //define left and right stacks
        Stack<Person> leftStack = new Stack<>();  // O(1)
        Stack<Person> rightStack = new Stack<>(); // O(1)

        //fill left stack
        int i = 0; // O(1)
        while(i < persons.length / 2) { // O(n/2)
            leftStack.push(persons[i]); // O(1)
            i++; // O(1)
        }

        //fill right stack
        int j = persons.length - 1; // O(1)
        while(j >= persons.length / 2) { // O(n/2)
            rightStack.push(persons[j]); // O(1)
            j--; // O(1)
        }

        //if there is a single item at the middle of the persons arrays he will not checked in the symmertical check
        if(leftStack.size() > rightStack.size()) leftStack.pop();
        else if(leftStack.size() < rightStack.size()) rightStack.pop();

        //checking symmetrical
        int k = 0; // O(1)
        while(k < persons.length / 2) { // O(n/2)
            if(leftStack.pop().age != rightStack.pop().age) return false; // O(1)
            k++; // O(1)
        }

        return true; // O(1)

        // isSymmetrical function complexity:
        // O(1) + O(1) + O(1) + O(n/2) * (O(1) + O(1)) + O(n/2) * (O(1) + O(1)) + O(1) +O(n/2) * (O(1) + O(1)) + O(1) = O(n)

    }

    //*****************************************************************************/
    // question 4 section c:

    public static boolean isSymmetricalQueue(Person[] persons) {

        // *** mark n as persons.length ***

        //define left and right stacks queues
        MyQueuePerson<Person> leftQueue = new MyQueuePerson<Person>(); // O(1)
        MyQueuePerson<Person> rightQueue = new MyQueuePerson<Person>(); // O(1)

        //check if persons.length has odd or even Person items, and get the right middle index
        int t = persons.length; // O(1)
        if(t % 2 == 0) t--; // O(1)
        else t++; // O(1)

        //fill left queue
        int i = 0; // O(1)
        while(i < t / 2) { // O(n/2)
            leftQueue.enqueue(persons[i]); // O(1)
            i++; // O(1)
        }

        //fill right queue
        int j = persons.length - 1; // O(1)
        while(j > persons.length / 2) { // O(n/2)
            rightQueue.enqueue(persons[j]); // O(1)
            j--; // O(1)
        }

        //checking symmetrical
        while(!leftQueue.isEmpty() && !rightQueue.isEmpty()) { // O(n/2)
            if(leftQueue.dequeue().age != rightQueue.dequeue().age) return false; // O(1)
        }

        return true; // O(1)

        // O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(n/2) * (O(1) + O(1)) + O(n/2) * (O(1) + O(1)) + O(n/2) * O(1)
    }
}

//my queue class I wrote
class MyQueuePerson<T> {

    private int front, tail, size, maxSize;
    private final int INIT_SIZE = 10;
    private Person[] data;

    //defaule constructor
    public MyQueuePerson() {
        this.maxSize = INIT_SIZE;
        this.front = this.tail = this.size = 0;
        this.data = new Person[this.maxSize];
    }

    //constructor
    public MyQueuePerson(int maxSize) {
        this.maxSize = maxSize;
        this.front = this.tail = this.size = 0;
        this.data = new Person[this.maxSize];
    }

    //resize function
    private void resize() {
        Person[] temp = new Person[this.data.length + INIT_SIZE];
        for(int i = 0; i < this.data.length; i++) {
            temp[i] = this.data[i];
        }
        this.data = temp;
    }

    //is empty method
    public boolean isEmpty() {
        return this.size == 0;
    }

    //enqueue new elemnt into the queue
    public boolean enqueue(Person value) {
        
        if(size == data.length) resize();

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
    public Person dequeue() {
        
        if(this.isEmpty()) return null;
        else {
            Person temp = this.data[front];
            this.front = (this.front + 1) % this.maxSize;
            this.size--;
            return temp;
        }
    }

    //return front element
    public Person peek() {
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

    public void print() {
        System.out.println("queue: " + this);
    }
}

class MyQueue<T> {

    private LinkedList<T> data;
    private T front;

    //default constructor
    public MyQueue() { // O(1)
        this.data = new LinkedList<T>();
        this.front = null;
    }

    //enqueue new elemnt into the queue method
    public void enqueue(T val) {

        if(this.isEmpty()) { // O(1)
            this.data.add(val); // O(1)
            this.front = this.data.getFirst(); // O(1)
        } else {
            this.data.add(val); // O(1)
        }
    }

    //dequeue element for queue method
    public T dequeue() { //best case: O(1), wrost case: // O(n)
        
        if(this.isEmpty()) return null;
        else if(this.data.size() == 1) {
            T temp = this.front; // O(1)
            this.clear();        // O(n)
            return temp;         // O(1)
        }
        else {
            T temp = this.front;               // O(1)
            this.data.removeFirst();           // O(1)
            this.front = this.data.getFirst(); // O(1)
            return temp;                       // O(1)
        }
    }

    //contains method
    public boolean contains(T val) { // O(n)
        return this.data.contains(val);
    }

    //isEmpty method
    public boolean isEmpty() { // O(1)
        return this.data.isEmpty();
    }

    //size method
    public int size() { // O(1)
        return this.data.size();
    }

    //peek method
    public T peek() { // O(1)
        return this.front;
    }

    //clear method
    public void clear() {  // O(n)
        this.data.clear(); // O(n)
        this.front = null; // O(1)
    }

    //to string method
    public String toString() { // O(n)
        return this.data.toString();
    }
}

class MyStack<T> {

    private LinkedList<T> data;
    private T top;

    //default constructor
    public MyStack() {
        this.data = new LinkedList<T>();
        this.top = null;
    }

    // push new elemnt into the stack method
    public void push(T val) { // O(1)
        this.data.add(val);
        this.top = val;
    }

    // pop element for stack method
    public T pop() { // O(1)
        if(this.isEmpty()) return null;
        else {
            T temp = this.top;
            this.data.removeLast();
            this.top = this.data.getLast();
            return temp;
        }
    }

    //if val is contain in stack method
    public boolean contains(T val) { // O(n)
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

    //to string method
    public String toString() { // O(n)
        return this.data.toString();
    }
}

class MyQueueWithStacks<T> {

    private Stack<T> inStack;
    private Stack<T> outStack;

    public MyQueueWithStacks() {
        this.inStack = new Stack<T>();  // O(1)
        this.outStack = new Stack<T>(); // O(1)
    }

    // enqueue item to the queue  
    public void enqueue(T val) {  
        // move all elements from inStack to outStack  
        while(!inStack.isEmpty()) { // O(n)
            outStack.push(inStack.pop());
        }
  
        // push item into inStack
        inStack.push(val); // O(1)
  
        // push everything back to inStack  
        while (!outStack.isEmpty()) { // O(n)
            inStack.push(outStack.pop());
        }  
    }  
  
    // dequeue an item from the queue  
    public T dequeue() {  
        // if first stack is empty  
        if (inStack.isEmpty()) return null;

        // Return top of inStack 
        else {
            T temp = inStack.pop(); // O(1)
            inStack.pop();          // O(1)
            return temp;            // O(1)
        }
    }
}

class MyStackWithQueues<T> {
    
    private Queue<T> inQueue;
    private Queue<T> outQueue;

    public MyStackWithQueues() {
        this.inQueue = new LinkedList<T>();  // O(1)
        this.outQueue = new LinkedList<T>(); // O(1)
    }

    // push item to the queue  
    public void push(T val) {  
        // move all elements from inQueue to outQueue  
        while(!inQueue.isEmpty()) { // O(n)
            outQueue.add(inQueue.peek());
            inQueue.remove();
        }
  
        // add item into inQueue  
        inQueue.add(val); // O(1)
  
        // add everything back to inQueue  
        while (!outQueue.isEmpty()) { // O(n)
            inQueue.add(outQueue.peek());
            outQueue.remove();
        }  
    }  
  
    // pop an item from the queue  
    public T pop() {  
        // if first Queue is empty  
        if(inQueue.isEmpty()) return null; // O(1)

        // Return top of inQueue  
        else {
            T temp = inQueue.peek(); // O(1)
            inQueue.remove();          // O(1)
            return temp;             // O(1)
        }
    }

    //to string method
    public String toString() { // O(n)
        return "" + inQueue + outQueue;
    }
}