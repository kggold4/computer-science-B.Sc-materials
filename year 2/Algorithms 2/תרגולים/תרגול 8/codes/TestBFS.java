public class TestBFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BFS b = new BFS(InitGraph.initGraph2());
    	b.bfs(2);              
    	b.print();

		System.out.println("Path from 0 to 2 is "+ b.getPath(0, 2));
		System.out.println("Graph is bipartite? " + b.isBipartite());
		System.out.println("Graph is connected? " + b.isConnected());
		
		System.out.println("All graph components are " + b.getAllComponents());
		System.out.println("Graph diameter is " + BFS.diameter(InitGraph.initGraph2(),2));
	}

}
