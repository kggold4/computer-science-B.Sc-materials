package lecture2;

//lesson 2
//question 9
public class Question9 {
    public static void main(String[] args) {

        int n = MyConsole.readInt("Get n:");
        int m = MyConsole.readInt("Get m:");
        int k = MyConsole.readInt("Get k:");
        int max = n;

        if(m > n && m > k) {
            max = m;
        } else if(k > n && k > m) {
            max = k;
        }

        System.out.println("Maximum number is: " + max);
    }
}
