package lecture2;

import java.util.Arrays;

public class A {
    public static void main(String[] args) {
        int[] a = {1,5,8,10,12};
        int[] b = {2,8,9,13,14};
        int[] c = {};
        System.out.println(Arrays.toString(merge(a, b)));
        System.out.println(Arrays.toString(merge(b, c)));
        System.out.println(Arrays.toString(merge(c, a)));
    }

    // merge two arrays function
    public static int[] merge(int[] a1, int[] a2) {
        
        int n1 = a1.length, n2 = a2.length;
        int[] ans = new int[n1 + n2];
        int i = 0,  j = 0, k = 0;
        while(i < n1 && j < n2) { //O(n1) + O(n2) = O(n1 + n2)
            if(a1[i] < a2[j]) {
                ans[k++] = a1[i++];
            } else {
                ans[k++] = a2[j++];
            }
        }
        while(i < n1) ans[k++] = a1[i++]; //O(n1)
        while(j < n2) ans[k++] = a2[j++]; //O(n2)

        return ans;
    }
}