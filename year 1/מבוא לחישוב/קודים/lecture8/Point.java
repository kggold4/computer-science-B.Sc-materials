package lecture8;

public class Point {
    double x, y;

    public void setValues(double x, double y ) {
        this.x = x;
        this.y = y;
    }

    public double distance() {
        double d = Math.sqrt(x*x + y*y);
        return d;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {

        Point p1 = new Point();
        System.out.println(p1.toString());
        p1.setValues(3.2, 1.1);
        System.out.println(p1.toString());
        Point p2 = new Point();
        p2.setValues(2, 9.3);
        System.out.println(p2.toString());


        double d = p1.distance();
        System.out.println(d);
    }
}
