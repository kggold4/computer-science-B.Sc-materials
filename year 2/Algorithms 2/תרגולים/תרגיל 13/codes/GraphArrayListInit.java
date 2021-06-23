import java.util.ArrayList;

public class GraphArrayListInit {
	public static ArrayList<Integer>[] initGraph(){//connected graph with circle
		int size = 8;
		ArrayList<Integer>[] graph = new ArrayList[size];
		for (int i = 0; i < size; i++)  
			graph[i] = new ArrayList<Integer>();
		graph[0].add(1); 
		graph[1].add(0); graph[1].add(2);
		graph[2].add(1); graph[2].add(3);
		graph[3].add(2); graph[3].add(4); graph[3].add(5);
		graph[4].add(3); graph[4].add(5); graph[4].add(6);
		graph[5].add(3); graph[5].add(4); graph[5].add(6); graph[5].add(7);
		graph[6].add(4); graph[6].add(5); graph[6].add(7); graph[7].add(5); graph[7].add(6);
		return graph;
	}

	public static ArrayList<Integer>[] initGraph1(){//with cycle
		int size = 4;
		ArrayList<Integer>[] g = new ArrayList[size];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<Integer>();
		}
		g[0].add(1); g[0].add(2); g[0].add(3);
		g[1].add(0); g[1].add(2); 
		g[2].add(0); g[2].add(1); 
		g[3].add(0); 
		return g;
	}
	public static ArrayList<Integer>[] initGraph2(){
		int size = 9;
		ArrayList<Integer>[] g = new ArrayList[size];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<Integer>();
		}
		g[0].add(1); g[0].add(5); g[0].add(8); 
		g[1].add(0); g[1].add(2); g[1].add(4); 
		g[2].add(1); g[2].add(3); g[2].add(4); 
		g[3].add(2); g[3].add(6); g[3].add(7); 
		g[4].add(1); g[4].add(2); g[4].add(6); 
		g[5].add(0); g[5].add(6); 
		g[6].add(3); g[6].add(4); g[6].add(5); 
		g[7].add(3);
		g[8].add(0);
		return g;
	}
	public static ArrayList<Integer>[] initGraph3(){//with cycle
		int size = 6;
		ArrayList<Integer>[] g = new ArrayList[size];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<Integer>();
		}
		g[0].add(2); g[0].add(1); g[0].add(5); 
		g[1].add(0); g[1].add(2);
		g[2].add(0); g[2].add(1); g[2].add(3); g[2].add(4); 
		g[3].add(5); g[3].add(4); g[3].add(2); 
		g[4].add(3); g[4].add(2);
		g[5].add(3); g[5].add(0); 
		return g;
	}
	public static ArrayList<Integer>[] initGraph4(){//with cycle
		int size = 6;
		ArrayList<Integer>[] g = new ArrayList[size];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<Integer>();
		}
		g[0].add(1); g[0].add(3); 
		g[1].add(0); g[1].add(4);
		g[2].add(4); g[2].add(5);
		g[3].add(0);
		g[4].add(1); g[4].add(2); g[4].add(5);
		g[5].add(2); g[5].add(4); 
		return g;
	}
	public static ArrayList<Integer>[] initGraph5(){//without cycle
		int size = 6;
		ArrayList<Integer>[] g = new ArrayList[size];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<Integer>();
		}
		g[0].add(1); g[0].add(3); 
		g[1].add(0); g[1].add(4);
		g[2].add(4); g[2].add(5);
		g[3].add(0);
		g[4].add(1); g[4].add(2);
		g[5].add(2);
		return g;
	}
}
