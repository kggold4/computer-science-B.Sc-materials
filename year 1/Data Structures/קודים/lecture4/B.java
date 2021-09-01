package lecture4;

public class B {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(func(arr, 0, arr.length, 5));

    }

    public static int func(int[]a, int low, int high, int goal){
        int t = get(a, low, high);
        System.out.println(t);
        if ( goal < t) return func(a, low, t-1, goal);
        else if (goal > t) return func(a, t+1, high, goal);
        else return a[t];
    }

    public static int get(int[] a, int low, int high) {
        int i = (int)((Math.random() * 10) * high);
        return a[i];
    }
}