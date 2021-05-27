package lecture7;

import java.util.Arrays;

//lesson 7
//panel 3
public class Panel3 {
    public static void main(String[] args) {

        int[] a = {1,5,9,4,2,3,4,3,1};
        selectionSort(a);
    }

    public static void selectionSort(int[] a) {
        int min = 0;
        for(int i = 0; i < a.length; i++) {
            min = i;
            for (int j = 0; j < a.length; j++) {
                if(a[j] < a[min]) min = i;
            }
            int t = a[i];
            a[i] = a[min];
            a[min] = t;
        }

        System.out.println(Arrays.toString(a));
    }
}
