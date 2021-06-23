import java.util.ArrayList;

public class InitGraph {
	public static ArrayList<Integer>[] initGraph1(){//connected graph with circle
		int size = 7;
		ArrayList<Integer>[] graph = new ArrayList[size];
		for (int i = 0; i < size; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		graph[0].add(1); graph[0].add(2);  
		graph[1].add(0); graph[1].add(2);  
		graph[2].add(1); graph[2].add(0);  

		graph[3].add(4); graph[3].add(5);  
		graph[4].add(3); graph[4].add(6);  
		graph[5].add(3); graph[5].add(6);  
		graph[6].add(4); graph[6].add(5);  

		return graph;		
	}
	
	public static ArrayList<Integer>[] initGraph2(){//connected graph with circle
		int size = 8;
		ArrayList<Integer>[] graph = new ArrayList[size];
		for (int i = 0; i < size; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		graph[0].add(1); graph[0].add(4);  
		graph[1].add(0); graph[1].add(5);  
		graph[2].add(5); graph[2].add(6); graph[2].add(3);  
		graph[3].add(2); graph[3].add(6); graph[3].add(7);  
		graph[4].add(0); 
		graph[5].add(1); graph[5].add(2); graph[5].add(6);
		graph[6].add(5); graph[6].add(2); graph[6].add(7); graph[6].add(3); 
		graph[7].add(3); graph[7].add(6);
		return graph;
	}
	public static ArrayList<Integer>[] initGraph3(){//connected graph with circle
		int size = 4;
		ArrayList<Integer>[] graph = new ArrayList[size];
		for (int i = 0; i < size; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		graph[0].add(1); graph[0].add(2); 
		graph[1].add(0); graph[1].add(3); 
		graph[2].add(0); graph[2].add(3); 
		graph[3].add(1); graph[3].add(2); 
		return graph;
	}
	public static ArrayList<Integer>[] initGraph4(){//connected graph with circle
		int size = 6;
		ArrayList<Integer>[] graph = new ArrayList[size];
		for (int i = 0; i < size; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		graph[0].add(1); graph[0].add(3); 
		graph[1].add(0); graph[1].add(4);  graph[1].add(2); 
		graph[2].add(1); graph[2].add(5); 
		graph[3].add(0); graph[3].add(4); 
		graph[4].add(1); graph[4].add(3); graph[4].add(5); 
		graph[5].add(2); graph[5].add(4); 
		return graph;
	}
	public static ArrayList<Integer>[] initGraph5(){//K4
		int size = 4;
		ArrayList<Integer>[] graph = new ArrayList[size];
		for (int i = 0; i < size; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		graph[0].add(1); graph[0].add(2); graph[0].add(3); 
		graph[1].add(0); graph[1].add(3); graph[1].add(2); 
		graph[2].add(0); graph[2].add(3); graph[2].add(1); 
		graph[3].add(1); graph[3].add(2); graph[3].add(0); 
		return graph;
	}
	public static ArrayList<Integer>[] initGraph6(){//P5
		int size = 5;
		ArrayList<Integer>[] graph = new ArrayList[size];
		for (int i = 0; i < size; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		graph[0].add(1); 
		graph[1].add(0); graph[1].add(2);
		graph[2].add(1); graph[2].add(3);
		graph[3].add(2); graph[3].add(4);
		graph[4].add(3);
		return graph;
	}
	public static ArrayList<Integer>[] initGraph7(){//Airplane
		int size = 9;
		ArrayList<Integer>[] graph = new ArrayList[size];
		for (int i = 0; i < size; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		graph[0].add(1); graph[0].add(3); 
		graph[1].add(0); graph[1].add(2); graph[1].add(4);
		graph[2].add(1); graph[2].add(5);
		graph[3].add(0); graph[3].add(4); graph[3].add(6);
		graph[4].add(1); graph[4].add(3); graph[4].add(5); graph[4].add(7); 
		graph[5].add(2); graph[5].add(4); graph[5].add(8); 
		graph[6].add(3); graph[6].add(7); 
		graph[7].add(4); graph[7].add(6); graph[7].add(8); 
		graph[8].add(7); graph[8].add(5); 
		return graph;
	}

}
