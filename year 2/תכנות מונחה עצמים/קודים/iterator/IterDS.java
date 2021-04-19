package iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IterDS implements ds, Iterable<object> {

    private int size;
    private Collection<object> list;

    public IterDS() {
        this.list = new ArrayList<>();
        this.size = 0;
    }

    @Override
    public Iterator<object> iterator() {
        return this.list.iterator();
    }

    @Override
    public long size() {
        return this.size;
    }

    @Override
    public Collection<object> getObjects() {
        return null;
    }
}
