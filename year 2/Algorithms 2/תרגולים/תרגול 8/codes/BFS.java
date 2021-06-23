import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {
	private  int size;//number of vertexes
	private  Queue<Integer> q;
	private  int dist[], pred[], color[], partition[];
	private  final int WHITE=1, GRAY=2,  BLACK=3, NIL = -1;
	private  ArrayList<Integer>[] graph;
	private  int numComps, source;
	private  int components[];
	/**
	 * constructor
	 * @param g adjacency-list representation of graph
	 */
	public BFS(ArrayList<Integer> g[]){
		size = g.length;
		q = new ArrayBlockingQueue<Integer>(size);
		dist = new int[size];
		pred = new int[size];
		color = new int[size];
		partition = new int[size];
		graph = new ArrayList[size];
		components = new int[size];
		for (int i = 0; i < size; i++) {
			graph[i] = new ArrayList<Integer>(g[i]);
		}
		source = 0;
		numComps = 0;
	}
	/**
	 * algorithm for traversing or searching graph data structures
	 * @param s source or starting node
	 */
	public void bfs(int s){
		for (int i = 0; i < size; i++) {
			dist[i] = NIL;
			pred[i] = NIL;
			color[i] = WHITE;
		}
		source = s;
		dist[source] = 0;
		color[source] = GRAY;
		q.add(source);
		while(!q.isEmpty()){
			int u = q.poll();//Retrieves and removes the head of this queue, or returns null if this queue is empty
			for(int v : graph[u]){
				if (color[v] == WHITE){
					dist[v] = dist[u]+1;
					pred[v] = u;
					color[v] = GRAY;
					q.add(v);
				}
			}
			color[u] = BLACK;
		}
	}
	/**
	 * The following procedure returns out the vertices on a shortest path from s to v,
	 * assuming that BFS has already been run to compute the shortest-path tree.
	 * @param s source or starting node
	 * @param v ending node
	 * @return a shortest path from s to v
	 */
	public String getPath(int s,int v){
		bfs(s);
		//print();
		if (dist[v]==NIL) return null;
		String path = new String();
		if (v==s) path = path + s;
		else{
			path = path + v;
			int t = pred[v];
			while (t != NIL){
				path = t + "->" + path;
				t = pred[t];
			}
		}
		return path;
	}

	/**
	 * Check if the graph is connected or no.
	 * @return true if the graph is connected,
	 * otherwise return false
	 */
	public boolean isConnected(){
		boolean ans = true;
		bfs(0);
		for (int i=0; ans && i<size; i++){
			if  (dist[i] == NIL) ans = false;
		}
		return ans;
		
	}
	/**
	 * Calculate a number of the Graph Connected Components 
	 */
	// components[i] - component's number of vertex i 
	private void connectedComponents(){
		while (hasNextComponent()){
			numComps++;
			bfs(source);
			for (int i = 0; i < components.length; i++) {
				if (dist[i]!=NIL) components[i] = numComps;
			}
		}
		System.out.println("Number of the graph connected components is " + numComps
				);
	}
	/**
	 * 
	 * @return true if the graph has the connected components,
	 * otherwise return false
	 */
	private boolean hasNextComponent(){
		boolean ans = false;
		for (int i = 0; !ans && i < components.length; i++) {
			if(components[i] == 0) {
				ans = true;
				source = i;
			}
		}
		return ans;
	}
	/**
	 * 
	 * @return All Graph Connected Components
	 */
	public String getAllComponents(){
		connectedComponents();
		ArrayList<Integer>[] compsList = new ArrayList[numComps];
		for (int i = 0; i < compsList.length; i++) {
			compsList[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < components.length; i++) {
			int n = components[i];
			compsList[n-1].add(i);
		}
		String ans = new String();
		for (int i = 0; i < compsList.length; i++) {
			ans = ans + compsList[i] + "\n";
		}
		return ans;
	}
	
		
	public void print(){
		System.out.println("pred: " + Arrays.toString(pred));
		System.out.println("dist: " + Arrays.toString(dist));
		System.out.println("color: " + Arrays.toString(color));
	}
	/**
	 * Check if the graph is bipartite or no
	 * @return true if the graph is bipartite,
	 * otherwise return false
	 */
	public boolean isBipartite (){
		boolean  bipartite = true;
		int partitions[] = new int[size];
		for (int i = 0; i < partitions.length; i++) {
			partitions[i] = 0;
		}
		int s = 0;//source vertex
		dist[s] = 0;
		color[s] = GRAY;
		partitions[s] = 1;
		q.add(s);
		while(bipartite && !q.isEmpty()){
			int u = q.poll();//Retrieves and removes the head of this queue, or returns null if this queue is empty
			for(int v : graph[u]){
				if (partition [u] == partition [v])
					bipartite = false;
				else if (color[v] == WHITE){
					dist[v] = dist[u]+1;
					pred[v] = u;
					color[v] = GRAY;
					partition[v] = 3 - partition[u];
					q.add(v);
				}
			}
			color[u] = BLACK;
		}
		return bipartite;
	}
	/**
	 * Calculate a graph diameter
	 * @param graph
	 * @param s source or starting node
	 * @return a graph diameter
	 */
	static int diameter(ArrayList<Integer>[] graph, int s) {
		BFS bf1= new BFS(graph);
		bf1.bfs(s);
		int maxIndex = max(bf1.dist);
		BFS bf2= new BFS(graph);
		bf2.bfs(maxIndex);
		return  max(bf2.dist);
	}
	/**
	 * Find index of maximum element in an array
	 * @param a
	 * @return index of maximum element
	 */
	private static int max(int[] a) {
		int ind = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[ind]) ind = i;
		}
		return ind;
	}
}
