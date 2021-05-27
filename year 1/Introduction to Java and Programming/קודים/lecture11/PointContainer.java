package lecture11;

public class PointContainer {
    // *** data members ***

    public static final int INIT_SIZE = 10; // the first (init) size of the set.
    public static final int RESCALE = 10; // the re-scale factor of this set.
    private int _sp = 0;
    private Point[] _points;

    /*** Constructors: creates a empty set ***/

    public PointContainer() {
        _sp=0;
        _points = new Point[INIT_SIZE];
    }

    /** returns the actual amount of Point contains in this set */
    public int size() {return _sp;}
    /** add a Point to this collection */
    public void add (Point p) {
        if (p != null){
            if(_sp==_points.length) rescale(RESCALE);
            _points[_sp] = new Point(p);
            _sp++;
        }
    }
    /** returns a reference to the Point at the index, (not a copy) */
    public Point at(int p){
        if (p>=0 && p<size()) return _points[p];
        return null;
    }
    /************** private methods *************/

    private void rescale(int t) {
        Point[] tmp = new Point[_sp+t];
        for(int i=0;i<_sp;i++) tmp[i] = _points[i];
        _points = tmp;
    }
}
