import java.util.ArrayList;
import java.util.Arrays;

public class DFSRecurs2 {
	private final int WHITE=1, GRAY=2,  BLACK=3, NIL = -1;// colors
	private int first[], last[], pred[], color[];
	private int time, size;
	private ArrayList<Integer>[] graph;
	private int startCycle, endCycle;
	private boolean hasCycle;
	
	/**
	 * Constructor
	 * @param g adjacency-list representation of graph
	 */
	public DFSRecurs2(ArrayList<Integer>[] g){
		size = g.length;
		pred = new int[size];
		color = new int[size];
		first = new int[size];
		last = new int[size];
		this.graph = new ArrayList[g.length];
		for (int i = 0; i < g.length; i++) {
			graph[i] = new ArrayList<Integer>(g[i]);
		}
	}

	public void dfs(int s){
		for (int i = 0; i < size; i++) {
			color[i] = WHITE;
			pred[i] = NIL;
			first[i] = 0;
			last[i] = 0;
		}
		hasCycle = false;
		startCycle = NIL;
		endCycle = NIL;
		time = 0;
		visit(s);
	}
	
	private void visit(int u){
		color[u] = GRAY;
		first[u] = ++time;
		for(int v : graph[u]){
			if (!hasCycle && color[v] == GRAY && pred[u] != v){
				hasCycle = true;
				startCycle = u;
				endCycle = v;
			}
			if (color[v] == WHITE){
				color[v] = GRAY;
				pred[v] = u;
				visit(v);
			}
		}
		color[u] = BLACK;
		last[u] = ++time;
	}
	
	public String dfsPath(int u, int v){
		String ans = null;
		dfs(u);
		if (color[v] != WHITE){
			ans = new String() + v;
			while (v!=u){
				v = pred[v];
				ans = v + "->" + ans;
			}
		}
		return ans;
	}
	
	public String dfsCycle(){
		String ans = null;
		boolean firstCycle = false;
		for (int i=0; !firstCycle && i<size; i++){
			int s = graph[i].get(0);
			dfs(s);
			if (hasCycle){
				firstCycle = true;
				dfs(startCycle);
				ans = dfsPath(startCycle, endCycle);
				ans = ans + "->" + endCycle;
			}
		}
		return ans;
	}
	
	public void print(){
		System.out.println("colors:  "+Arrays.toString(color));
		System.out.println("pred:  "+Arrays.toString(pred));
		System.out.println("first:  "+Arrays.toString(first));
		System.out.println("last:  "+Arrays.toString(last));
		System.out.println("cycle:  "+hasCycle);
	}
}
