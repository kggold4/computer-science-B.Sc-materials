package dijkstra;
/**
 * Dijkstra's algorithm for
 * single-source shortest path problem
 * that is implementation with Min-Heap class
 */
// n - number of vertices, m - number of edges
class Vertex2 {
	public int name;
	public Edge2[] edges;
	public double dist;
	public int previous;
	public boolean visited;
	
	public Vertex2(int name, double dist) {
		this.name = name; 
		this.dist = dist;
		previous = -1;
		visited = false;
	}
	
	public Vertex2(Vertex2 v) {
		this.name = v.name; 
		this.dist = v.dist;
		previous = v.previous;
		visited = v.visited;
		
	}
	
	public String toString() {
		return "" + name; 
	}
}

class Edge2{
	public  int vert;
	public double weight;
	public Edge2(int v, double w){ 
		vert = v; 
		weight = w; 
	}
}

public class Dijkstra2 {
	Vertex2[] vertices;
	int source;
	public static double infinity = Double.POSITIVE_INFINITY;
	
	public Dijkstra2(Vertex2[] vs, int source){
		this.source = source;
		vertices = new   Vertex2[vs.length];
		for (int i=0; i<vs.length; i++){
			vertices[i] = vs[i];
		}
	}

	public void computePaths(){
		Vertex2 s = vertices[source];
		s.dist = 0.;
		HeapMin Q = new HeapMin();
		Q.minHeapInsert(s);		
		//O(nlogn)
		for (int i=1; i<vertices.length; i++){//O(n)
			Q.minHeapInsert(vertices[i]);//O(logn)
		}		
		//O(nlogn) + O(mlogn) = O((m+n)logn)
		while (!Q.isEmpty()) {//O(m)
			Vertex2 u = Q.heapExtractMin();//O(logn)
			// Visit each edge exiting for vertex u
			for (Edge2 e : u.edges){
				Vertex2 v = vertices[e.vert];
				if (!v.visited){
					double distU = u.dist + e.weight;
					if (distU < v.dist) {//relaxation
						v.dist = distU ;
						v.previous = vertices[u.name].name;
						Q.heapDecreaseKey(v);//O(logn)
					}
				}
			}
			u.visited = true;
		}
	}

	public void printWeights(){
		System.out.print("weights: ");
		for (Vertex2 v : vertices) {
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
		for (Vertex2 v : vertices){
			System.out.println("price of " + v.name+" = " + v.dist + ", path: " +  getPath(v.name));
		}
		System.out.println();
	}
	
	public static Vertex2[] initGraph1(){
		Vertex2 v0 = new Vertex2(0, infinity); 
		Vertex2 v1 = new Vertex2(1, infinity); 
		Vertex2 v2 = new Vertex2(2, infinity);
		Vertex2 v3 = new Vertex2(3, infinity);
		Vertex2 v4 = new Vertex2(4, infinity);
		Vertex2 v5 = new Vertex2(5, infinity);
		v0.edges = new Edge2[]{new Edge2(1,7), new Edge2(2,9), new Edge2(5,14)};
		v1.edges = new Edge2[]{new Edge2(0,7), new Edge2(2,10), new Edge2(3,115)};
		v2.edges = new Edge2[]{new Edge2(0,9), new Edge2(1, 10), new Edge2(3,11), new Edge2(5,2)};
		v3.edges = new Edge2[]{new Edge2(1,15), new Edge2(2,11), new Edge2(4, 6)};
		v4.edges = new Edge2[]{new Edge2(3,6), new Edge2(5,9)};
		v5.edges = new Edge2[]{new Edge2(4,9), new Edge2(2,2), new Edge2(0,14)};
		Vertex2[] vs = {v0,v1,v2,v3,v4,v5};
		return vs;
	}
	public static Vertex2[] initGraph2(){
		Vertex2 v0 = new Vertex2(0, infinity); 
		Vertex2 v1 = new Vertex2(1, infinity); 
		Vertex2 v2 = new Vertex2(2, infinity);
		Vertex2 v3 = new Vertex2(3, infinity);
		Vertex2 v4 = new Vertex2(4, infinity);
		v0.edges = new Edge2[]{new Edge2(1,10), new Edge2(4,5)};
		v1.edges = new Edge2[]{new Edge2(2,1), new Edge2(4,2)};
		v2.edges = new Edge2[]{new Edge2(3,4)};
		v3.edges = new Edge2[]{new Edge2(2,6), new Edge2(0,7)};
		v4.edges = new Edge2[]{new Edge2(3,2), new Edge2(2,9), new Edge2(1,3)};
		Vertex2[] vs = {v0,v1,v2,v3,v4};
		return vs;	
	}
	
	public static void main(String[] args) {
		Dijkstra2 ds = new Dijkstra2(initGraph1(), 0);
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
