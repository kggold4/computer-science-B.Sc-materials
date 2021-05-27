package exercise1_sort;

import java.util.Arrays;

public class B {
    public static void main(String[] args) {
        String[] words = {"be", "be", "not", "or", "to", "to", "to"};
        int[] numbers = wordRepeat(words);
        System.out.println(Arrays.toString(numbers));
    }

    public static int[] wordRepeat(String[] words) {
        int[] arr = new int[4];

        int found = 1, indexOfAns = 0;
        for(int i = 1; i < words.length; i++) { //O(n - 1) = O(n), n = words.length
            String temp = words[i - 1];
            if(words[i].equals(temp)) {
                found++;
            } else {
                arr[indexOfAns] = found;
                found = 1;
                indexOfAns++;
            }
            if(i == words.length - 1) arr[indexOfAns] = found;
        }
        return arr;
    }
}