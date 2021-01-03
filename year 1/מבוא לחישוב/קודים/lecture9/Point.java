package lecture9;

public class Point {
    private double x,y;

    public Point() {

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this(p.x, p.y);
    }



    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

    public static double dist(Point p, Point q) {
        return Math.sqrt((p.x - q.x)*(p.x - q.x) + (p.y - q.y)*(p.y - q.y));
    }

    public static double largestDist(Point[] points) {
        double max = 0.0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                double d = dist(points[i], points[j]);
                if (max < d) {
                    max = d;
                }
            }
        }
        return max;
    }

//	public double dist(Point p) {
//
//	}

    public static void main(String[] args) {

        Point p = new Point();
        System.out.println(p);
        System.out.println(p.x + " " + p.y);
    }
}
