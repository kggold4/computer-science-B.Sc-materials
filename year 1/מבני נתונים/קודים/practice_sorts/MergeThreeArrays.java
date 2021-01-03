package practice_sorts;
import java.util.Arrays;

public class MergeThreeArrays {
    public static void main(String[] args) {
        int[] a = {1,8,15};
        int[] b = {2,4,10,11};
        int[] c = {5,7,9};
        int[] d = merge(a, b, c);
        System.out.println(Arrays.toString(d));
    }
    public static int[] merge(int[] a, int[] b, int[] c) {
        int[] d = new int[a.length + b.length + c.length];
        int i = 0, j = 0, k = 0, q = 0;
        while(q < d.length) {
            if(a[i] < b[j] && a[i] < c[k]) {
                d[q] = a[i];
            }
            q++;
        }
        return d;
    }
}