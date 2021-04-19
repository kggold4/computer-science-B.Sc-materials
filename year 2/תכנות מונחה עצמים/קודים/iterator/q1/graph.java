package iterator.q1;

import java.util.Collection;

public interface graph {
    public Collection<node_data> getV();
    public Collection<edge_data> getE(int node_id);
}
