package iterator.q1;

import java.util.ArrayList;

public class EdgeIterator implements Iterator<edge_data> {

    private ArrayList<edge_data> edges;
    private int ind;
    public EdgeIterator(graph g) { init(g); }

    public void init(graph g) {
        this.edges = new ArrayList<>();
        Iterator<node_data> v_iter = (Iterator<node_data>) g.getV().iterator();
        while(v_iter.hasNext()) {
            int vid = v_iter.next().getKey();
            this.edges.addAll(g.getE(vid));
        }
        this.ind = 0;
    }

    @Override
    public boolean hasNext() { return this.ind < edges.size(); }

    @Override
    public edge_data next() {
        edge_data ans = null;
        if(hasNext()) { ans = this.edges.get(ind); ind++; }
        return ans;
    }
}
