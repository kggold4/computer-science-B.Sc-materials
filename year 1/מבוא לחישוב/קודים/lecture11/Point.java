package lecture11;

public class Point {
    private double _x;
    private double _y;

    // ********* constructors ********

    public Point (double x1, double y1) {
        _x = x1; _y = y1;
    }

    public Point (Point p) {
        _x = p.x(); _y = p.y();
    }

    // ********** public methods *********

    public double x() {
        return _x;
    }

    public double y() {
        return _y;
    }

    /** @return the L2 distanse */

    public double distance (Point p) {
        double temp = Math.pow (p.x() - _x, 2) + Math.pow (p.y() - _y, 2);
        return Math.sqrt (temp);
    }
    /** @return a String contains the Point data*/

    public String toString() {
        return "[" + _x + "," + _y+"]";
    }

    /** logical equals: return true iff p instance of Point && logically the same) */

    public boolean equals (Object p) {
        return p!=null && p instanceof Point && ((Point)p)._x == _x && ((Point)p)._y==_y;
    }
}
