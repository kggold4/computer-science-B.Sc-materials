package lecture9;

public class Interval2 {
    private Point p1;
    private Point p2;

    public Interval2(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Interval2(Interval2 keta) {
        this.p1 = keta.p1;
        this.p2 = keta.p2;
    }

    public double intLength() {

        double len = Math.sqrt(Math.pow(this.p1.getX() - this.p2.getX(), 2) + Math.pow(this.p1.getY() - this.p2.getY(), 2));

        return len;
    }

    public static void main(String[] args) {

        Point p1 = new Point(-2, 1.11);
        System.out.println(p1);
        Point p2 = new Point(1.5, 7.27);
        System.out.println(p2);

    }
}
