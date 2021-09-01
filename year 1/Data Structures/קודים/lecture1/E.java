package lecture1;

public class E {
    public static void main(String[] args) {

        int x = 2, y = 4, max1 = x;

        if(x >= y) max1 = x;
        else if(y > x) max1 = y;

        //same if
        int max2 = x > y ? x : y;

        System.out.println("max1 = " + max1 + ", max2 = " + max2);
    }
}