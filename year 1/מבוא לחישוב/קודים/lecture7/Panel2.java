package lecture7;

//lesson 7
//panel 2
public class Panel2 {

    public static void main(String[] args) {

        int n = 20;
        long f = factorial(n);
        System.out.println(f);
    }

    public static long factorial(int n) {

        long ans;

        if(n == 0) {
            ans = 1;
        } else {
            ans = n * factorial(n - 1);
        }

        return ans;
    }

}
