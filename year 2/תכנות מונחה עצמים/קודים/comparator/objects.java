package comparator;

import java.util.Collection;
import java.util.Comparator;

public interface objects {

    /**
     * add
     * @param eo
     */
    public void add(object eo);

    /**
     *
     * @param eo
     */
    public void remove(object eo);

    /**
     *
     * @return
     */
    public object max();

    /**
     *
     * @return
     */
    public object nestedMax();

    /**
     *
     * @param comp
     * @return
     */
    public Collection<object> sorted(Comparator<object> comp);
}
