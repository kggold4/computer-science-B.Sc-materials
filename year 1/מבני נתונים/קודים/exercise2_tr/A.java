package exercise2_tr;

import java.util.Stack;

public class A {
    public static boolean question5(String s) {

        Stack<Character> st = new Stack<Character>();

        // going throw all chars
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            // if char i is an opennig parenthesis
            if(current == '(' || current == '{' || current == '[') {
                st.push(current);
            
            // if char i is not an opennig parenthesis
            } else {
                if(st.isEmpty()) return false;

                char top = st.pop();
                if((top == '(' && current != ')') || (top == '{' && current != '}') && (top == '[' && current != ']')) return false;
            }
        }
        
        return  st.isEmpty();
    }

    public static void main(String[] args) {
        String str1 = "[()]{[{}{}]}";
        String str2 = "(]{()})";
        System.out.println(question5(str1));
        System.out.println(question5(str2));
    }
}