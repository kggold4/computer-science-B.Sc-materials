package practice_queue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyQueue {

    public static void sort(Queue<Integer> queue) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(!queue.isEmpty()) {
            System.out.println(1);
            Integer temp = queue.peek();
            if(s1.empty()) s1.add(temp);
            else if(s1.peek() < temp) s1.add(temp);
            else {
                while(s1.peek() < temp) {
                    s2.add(s1.pop());
                }
                s1.add(temp);
                while(!s2.empty()) {
                    s1.add(s2.pop());
                }
            }
        }
        while(!s1.empty()) {
            queue.add(s1.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);
        queue.add(6);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);
        queue.add(10);
        queue.add(0);
        System.out.println(queue);
        sort(queue);
        System.out.println(queue);


    }
}
