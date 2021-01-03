package lecture8;

public class Interval {
    double _left, _right;

    //question 1
    public Interval(double x, double y) {

        if(x <= y) {
            this._left = x;
            this._right = y;
        } else {
            this._left = y;
            this._right = x;
        }

    }

    //question 2
    public boolean contains(double x) {

        if(x >= this._left && x <= this._right) {
            return true;
        } else {
            return false;
        }

    }

    //question 3
    public double length() {
        return Math.abs(this._right - this._left);
    }


    //question 4
    public boolean intersection(Interval b) {
        if(b._left > this._right || b._right < this._left) {
            return false;
        } else {
            return true;
        }
    }

    //question 5
    public String toString() {
        return "x = " + this._left + " y = " + this._right;
    }


    //question 6
    public double midPoint() {
        return (this._left + this._right) / 2;
    }

    //question 7
    public double distBetweenMidPoints(Interval b) {

        double x = ((this._left + this._right) / 2);
        double y = ((b._left + b._right) / 2);

        if(x >= y) {
            return x - y;
        } else {
            return y - x;
        }
    }

    //question 8
    public Interval commonPart(Interval b) {

        double left = 0.0;
        double right = 0.0;

        if(b._left > this._right || b._right < this._left || this._left > b._right || this._right < b._left) {
            left = 0.0;
            right = 0.0;
        } else if(b._left <= this._left && b._right >= this._right) {
            left = this._left;
            right = this._right;

        } else if(b._left >= this._left && b._right <= this._right) {
            left = b._left;
            right = b._right;

        } else if(b._left <= this._left && b._right <= this._right) {
            left = this._left;
            right = b._right;

        } else if(b._left >= this._left && b._right >= this._right) {
            left = b._left;
            right = this._right;

        } else {
            right = 0.0;
            left = 0.0;
        }

        Interval i10 = new Interval(right, left);
        return i10;
    }

    public static void main(String args[]) {

        Interval i1 = new Interval(1, 13);
        Interval i2 = new Interval(14, 15);
        Interval i3 = new Interval(16, 2);
        Interval i4 = new Interval(-15, 100);
        Interval i5 = new Interval(100, 102);
        Interval i6 = new Interval(0, 2);
        Interval i7 = new Interval(-300, 300);

        System.out.println("\ncontains:");
        System.out.println(i1.contains(123));
        System.out.println(i3.contains(4));
        System.out.println(i7.contains(-200));

        System.out.println("\nlength:");
        System.out.println(i4.length());
        System.out.println(i7.length());

        System.out.println("\nintersection:");
        System.out.println(i3.intersection(i1));
        System.out.println(i5.intersection(i6));

        System.out.println("\ntoString:");
        System.out.println(i1.toString());
        System.out.println(i6.toString());
        System.out.println(i7.toString());

        System.out.println("\nmidPoint");
        System.out.println(i1.midPoint());
        System.out.println(i5.midPoint());
        System.out.println(i6.midPoint());

        System.out.println("\ndistBetweenMidPoints:");
        System.out.println(i4.distBetweenMidPoints(i7));
        System.out.println(i3.distBetweenMidPoints(i5));
        System.out.println(i1.distBetweenMidPoints(i6));

        System.out.println("\ncommonPart:");
        System.out.println(i1.commonPart(i3).toString());
        System.out.println(i2.commonPart(i5).toString());
        System.out.println(i6.commonPart(i7).toString());
    }
}
