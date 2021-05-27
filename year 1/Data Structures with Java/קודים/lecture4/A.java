package lecture4;

public class A {
    //checking MyStack class
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("stack: " + stack);
        System.out.println("top: " + stack.top());
        System.out.println("size: " + stack.size());
        System.out.println(stack.pop());
        System.out.println("stack: " + stack);
        System.out.println("top: " + stack.top());
        System.out.println("size: " + stack.size());
        System.out.println("is empty: " + stack.empty());
        System.out.println(stack.pop()+stack.pop()+stack.pop()+stack.pop());
        System.out.println(stack);
        System.out.println("is empty: " + stack.empty());
        System.out.println(stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("element at index 3: " + stack.elementAt(3));
        System.out.println("element at index 6: " + stack.elementAt(6));
        System.out.println(stack);
        System.out.println("top: " + stack.top());
    }
}