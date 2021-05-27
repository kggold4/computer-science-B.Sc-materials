package exercise1_sort;

public class A {
    public static void main(String[] args) {
        int[] arr = {5,1,6,4,2,3};
        System.out.println("1 : " + place(1, arr));
        System.out.println("2 : " + place(2, arr));
        System.out.println("3 : " + place(3, arr));
        System.out.println("4 : " + place(4, arr));
        System.out.println("5 : " + place(5, arr));
        System.out.println("6 : " + place(6, arr));
        System.out.println("7 : " + place(7, arr));
    }

    public static int place(int place, int[] arr) {
        //if place input is invalid
        if(place > arr.length || place < 0) {
            System.out.print("invalid place ");
            return -1;
        }

        //getting max
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]) max = arr[i];
        }

        //if place is 1 return max
        if(place == 1) {
            return max;
        }

        //getting the max in place
        int j = 0, currentMax = max;
        while(j < place - 1) { //O(n) : from 0 to place - 1
            //getting the max in limit by place
            currentMax = getMax(max, arr); //O(n)
            max = currentMax;
            j++;
        }
        
        //return the max in place
       return currentMax;
    }

    public static int getMax(int limit, int[] arr) {
        int max = arr[1];
        for(int i = 0; i < arr.length; i++) {
            if(max < arr[i] && arr[i] < limit) max = arr[i];
        }
        return max;
    }
}