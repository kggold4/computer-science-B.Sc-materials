package comparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * return the object with maximum max using Comp
 */
public class ExampleObjects implements objects {

    private Collection<object> objects;

    public ExampleObjects() {
        this.objects = new ArrayList<>();
    }

    @Override
    public void add(object eo) {
        this.objects.add(eo);
    }

    @Override
    public void remove(object eo) {
        this.objects.remove(eo);
    }

    @Override
    public object max() {
        Comparator comp = new Comp();
        // Collections.max(data structure, comparator);
        return Collections.max(this.objects, comp);
    }

    @Override
    public object nestedMax() {
        object max = new ExampleObject(0);
        for(object eo : this.objects) {
            if(eo.getMax() > max.getMax()) max = eo;
        }
        return max;
    }

    @Override
    public Collection<object> sorted(Comparator<object> comp) {
        ArrayList<object> sortedObjects = new ArrayList<>(this.objects);
        sortedObjects.sort(comp);
        return sortedObjects;
    }
}
