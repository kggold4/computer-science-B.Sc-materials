package comparator;

import java.util.Comparator;

/**
 * if o1 == o2: return 0
 * else if: o1 > o2: return 1
 * else: return -1
 */
public class Comp implements Comparator<object> {
    @Override
    public int compare(object o1, object o2) {
        return Double.compare(o1.getMax(), o2.getMax());
    }
}