package practice_stacks;

import java.util.Stack;

public class MyStack {

    public static void reverse(Stack<Integer> t) {
        Stack<Integer> r = new Stack<>();
        while(!t.empty()) {
            r.push(t.pop());
        }
        t = r;
        System.out.println(t);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(2);
        stack.push(0);
        stack.push(10);
        stack.push(7);
        stack.push(6);
        System.out.println(stack);
        reverse(stack);
    }
}