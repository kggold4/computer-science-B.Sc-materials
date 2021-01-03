package lecture1;

//question 2
public class Question2 {
    public static void main(String[] args) {
        int x = MyConsole.readInt("Get x:");
        int y = MyConsole.readInt("Get y:");
        int z = MyConsole.readInt("Get z:");
        int u = MyConsole.readInt("Get u:");

        System.out.println("Before rotaion: X = " + x + ", Y = "+ y + ", Z = "+ z + ", U = " + u);

        System.out.println("Before rotaion: X = " + y + ", Y = "+ z + ", Z = "+ u + ", U = " + x);
    }
}
