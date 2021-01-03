package lecture2;

//lesson 2
//question 8
public class Question8 {
    public static void main(String[] args) {

        int n = MyConsole.readInt("Get n:");
        int m = MyConsole.readInt("Get m:");
        int k = MyConsole.readInt("Get k:");
        int min = n;

        if(m < n && m < k) {
            min = m;
        } else if(k < n && k < m) {
            min = k;
        }

        System.out.println("Minimum number is: " + min);

    }
}
