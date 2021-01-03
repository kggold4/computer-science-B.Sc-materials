package lecture1;

//question 11
public class Question11 {
    public static void main(String[] args) {

        final double pi = Math.PI;
        double radius = MyConsole.readDouble("Get cyrcle radius:");

        double s = pi * Math.pow(radius, 2);
        double p = 2 * pi * radius;

        System.out.println("Surface: " + s);
        System.out.println("Scope: " + p);

    }
}
