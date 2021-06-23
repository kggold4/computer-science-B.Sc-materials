package dijkstra;
/**
 * Dijkstra's algorithm for
 * single-source shortest path problem
 * that is implementation with built-in Java PriorityQueue class
 */
import java.util.PriorityQueue;

//Vertex contains list of adjacency edges with weights
class Vertex implements Comparable<Vertex>{
	public int name;
	public Edge[] edges;
	public double dist;
	public int previous;
	public boolean visited;

	public Vertex(int name) {
		this.name = name; 
		dist = Double.POSITIVE_INFINITY;
		previous = -1;
		visited = false;
	}
	public String toString() {
		return "" + name; 
	}
	public int compareTo(Vertex v) {
		int ans = 0;
		if (this.dist - v.dist > 0) ans = 1;
		else if (this.dist - v.dist < 0) ans = -1;
		return ans;
	}
}

class Edge{
	public int vert;
	public double weight;
	public Edge(int v, double w){ 
		vert = v; 
		weight = w; 
	}
}

public class Dijkstra {
	Vertex[] vertices;
	int source;
	
	public Dijkstra(Vertex[] vs, int source){
		this.source = source;
		vertices = new   Vertex[vs.length];
		for (int i=0; i<vs.length; i++){//O(|V|)
			vertices[i] = vs[i];
		}
	}

	public void computePaths(){
		Vertex s = vertices[source];
		s.dist = 0.;
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		q.add(s);
		//O(|V|*log|V|) + O(|E|*log|V|) = O((|V|+|E|)*log|V|)
		while (!q.isEmpty()) {//O(|E|)
			Vertex u = q.poll();//O(log|V|)
			// Visit each edge exiting for vertex u
			for (Edge e : u.edges){ 
				Vertex v = vertices[e.vert];
				if (!v.visited){
					double distU = u.dist + e.weight;
					if (distU < v.dist) {//relaxation
						v.dist = distU ;
						v.previous = vertices[u.name].name;
						/* when priority of vertex (dist) changes, 
						need to re-insert vertex in priority queue
						but before need delete this vertex and after
						re-insert it with changed distance and with changed previous vertex
						*/
						q.remove(v);//O(log|V|)
						q.add(v);//O(log|V|)
					}
				}
			}
			u.visited = true;
		}
	}

	public void printWeights(){
		System.out.print("weights: ");
		for (Vertex v : vertices) {
			System.out.printf(v.dist + ", ");
		}
		System.out.println();
	}
	public String getPath(int v){
		int t = v;
		String ans = t + "";
		while(t != source){
			t = vertices[t].previous;
			ans = t + "->" + ans;
		}
		return ans;
	}
	public void printPaths(){
		for (Vertex v : vertices){
			System.out.println("price of " + v.name+" = " + v.dist + ", path: " +  getPath(v.name));
		}
		System.out.println();
	}
	public static Vertex[] initGraph1(){
		Vertex v0 = new Vertex(0); 
		Vertex v1 = new Vertex(1); 
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		v0.edges = new Edge[]{new Edge(1,7), new Edge(2,9), new Edge(5,14)};
		v1.edges = new Edge[]{new Edge(0,7), new Edge(2,10), new Edge(3,15)};
		v2.edges = new Edge[]{new Edge(0,9), new Edge(1, 10), new Edge(3,11), new Edge(5,2)};
		v3.edges = new Edge[]{new Edge(1,15), new Edge(2,11), new Edge(4, 6)};
		v4.edges = new Edge[]{new Edge(3,6), new Edge(5,9)};
		v5.edges = new Edge[]{new Edge(4,9), new Edge(2,2), new Edge(0,14)};
		Vertex[] vs = {v0,v1,v2,v3,v4,v5};
		return vs;
	}
	public static Vertex[] initGraph2(){
		Vertex v0 = new Vertex(0); 
		Vertex v1 = new Vertex(1); 
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		v0.edges = new Edge[]{new Edge(1,10), new Edge(4,5)};
		v1.edges = new Edge[]{new Edge(2,1), new Edge(4,2)};
		v2.edges = new Edge[]{new Edge(3,4)};
		v3.edges = new Edge[]{new Edge(2,6), new Edge(0,7)};
		v4.edges = new Edge[]{new Edge(3,2), new Edge(2,9), new Edge(1,3)};
		Vertex[] vs = {v0,v1,v2,v3,v4};
		return vs;	
	}
	public static void main(String[] args) {
		Dijkstra ds = new Dijkstra(initGraph1(), 0);
		ds.computePaths();
		ds.printWeights();
		ds.printPaths();
	}
}
/*
		OUTPUT inint1
	weights: 0.0, 7.0, 9.0, 20.0, 20.0, 11.0, 
	price of 0 = 0.0, path: 0
	price of 1 = 7.0, path: 0->1
	price of 2 = 9.0, path: 0->2
	price of 3 = 20.0, path: 0->2->3
	price of 4 = 20.0, path: 0->2->5->4
	price of 5 = 11.0, path: 0->2->5

	 	OUTPUT inint2
	weights: 0.0, 8.0, 9.0, 7.0, 5.0, 
	price of 0 = 0.0, path: 0
	price of 1 = 8.0, path: 0->4->1
	price of 2 = 9.0, path: 0->4->1->2
	price of 3 = 7.0, path: 0->4->3
	price of 4 = 5.0, path: 0->4
 */
