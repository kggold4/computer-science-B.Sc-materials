package iterator;

import java.util.Iterator;
import java.util.List;

public class Iter {

    public static void print(List<String> list) {

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

    }
}
