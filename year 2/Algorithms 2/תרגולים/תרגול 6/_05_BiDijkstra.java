import java.util.ArrayList;

public class _05_BiDijkstra {

	static int inf = 1000000;
	public static void main(String[] args) {
		int[][] mat = {{0 ,1 ,2 ,inf ,inf ,inf ,inf ,inf },
				{1 ,0 ,4 ,inf ,5 ,inf ,inf ,inf },
				{2 ,4 ,0 ,7 ,inf ,3 ,inf ,inf },
				{inf ,inf ,7 ,0 ,3 ,8 ,inf ,inf },
				{inf ,5 ,inf ,3 ,0 ,inf ,1 ,4 },
				{inf ,inf ,3 ,inf ,8 ,0 ,2 ,inf },
				{inf ,inf ,inf ,inf ,1 ,2 ,0 ,5 },
				{inf ,inf ,inf ,inf ,4 ,inf ,5 ,0 }};
		ArrayList<ArrayList<Integer>> G = InitializeGraph();
		ArrayList<ArrayList<Integer>> GR = InitializeGraphReverse();
		BiDijkstraAlgorithm(G, GR, 0, 7, mat);

	}
	private static void BiDijkstraAlgorithm(ArrayList<ArrayList<Integer>> G, ArrayList<ArrayList<Integer>> GR, int s,
			int t, int[][] weightMatrix) {

		int V = G.size();

		int[] dist_s = new int[V];
		int[] prev_s = new int[V];
		boolean[] visited_s  = new boolean[V];

		int[] dist_t = new int[V];
		int[] prev_t = new int[V];
		boolean[] visited_t  = new boolean[V];


		for (int i = 0; i < V; i++) {
			dist_s[i] = inf;
			prev_s[i] = -1;
			visited_s[i] = false;
			dist_t[i] = inf;
			prev_t[i] = -1;
			visited_t[i] = false;
		}
		dist_s[s] = 0;
		dist_t[t] = 0;

		int v_s, v_t;
		boolean inProcess = true;

		while(inProcess == true)
		{
			if (inProcess == true && ((v_s = ExtractMin(dist_s, visited_s)) != -1))
			{
				for (int u : G.get(v_s)) {
					if (visited_s[u] == false && (dist_s[u] > dist_s[v_s] + weightMatrix[v_s][u]))
					{
						dist_s[u] = dist_s[v_s] + weightMatrix[v_s][u];
						prev_s[u] = v_s;
					}
				}
				visited_s[v_s] = true;
				if (visited_s[v_s] == true &&  visited_t[v_s] == true)
				{
					inProcess = false;
				}
			}
			if (inProcess == true && ((v_t = ExtractMin(dist_t, visited_t)) != -1))
			{
				for (int u : G.get(v_t)) {
					if (visited_t[u] == false && (dist_t[u] > dist_t[v_t] + weightMatrix[v_t][u]))
					{
						dist_t[u] = dist_t[v_t] + weightMatrix[v_t][u];
						prev_t[u] = v_t;
					}
				}
				visited_t[v_t] = true;
				if (visited_s[v_t] == true &&  visited_t[v_t] == true)
				{
					inProcess = false;
				}
			}
		}

		int min = inf;
		int minIndex = -1;
		for (int i = 0; i < V; i++) {
			if ((visited_s[i] || visited_t[i]) && dist_s[i]!= inf && dist_t[i]!= inf)
			{
				if (min > dist_s[i] + dist_t[i])
				{
					min = dist_s[i] + dist_t[i];
					minIndex = i;
				}
			}
		}

		System.out.println("dist = " + min);

		int k = minIndex;
		String path = "";
		while (prev_s[k] != -1)
		{
			path = "->"+ k + path;
			k = prev_s[k];
		}
		path = k  + path;
		System.out.println("path = " + path);
		String pathR = "";
		k = minIndex;
		while (prev_t[k] != -1)
		{
			pathR = "->"+ k + pathR;
			k = prev_t[k];
		}
		pathR = k  + pathR;
		System.out.println("pathR = " + pathR);
		String pR[] = pathR.split("->");
		String path3 = path;
		for (int i = pR.length-2; i >= 0; i--) {
			path3 += "->" + pR[i];
		}
		System.out.println("Final path = " + path3);

	}

	private static int ExtractMin(int[] dist, boolean[] visited) {
		int minIndex = Integer.MAX_VALUE, MinValue = Integer.MAX_VALUE;
		int V = visited.length;
		for (int i = 0; i < V; i++) {
			if (visited[i] == false && dist[i]<MinValue)
			{
				minIndex = i;
				MinValue = dist[i];
			}
		}
		return minIndex;
	}
	private static ArrayList<ArrayList<Integer>> InitializeGraphReverse() {
		ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>();
		int numOfVertices = 8;

		for (int i = 0; i < numOfVertices; i++) {
			G.add(new ArrayList<Integer>());
		}

		G.get(1).add(0);
		G.get(2).add(0);

		G.get(0).add(1);
		G.get(2).add(1);
		G.get(4).add(1);

		G.get(0).add(2);
		G.get(1).add(2);
		G.get(3).add(2);
		G.get(5).add(2);

		G.get(2).add(3);
		G.get(4).add(3);
		G.get(5).add(3);

		G.get(1).add(4);
		G.get(3).add(4);
		G.get(7).add(4);

		G.get(2).add(5);
		G.get(3).add(5);
		G.get(6).add(5);

		G.get(4).add(6);
		G.get(5).add(6);
		G.get(7).add(6);

		G.get(4).add(7);
		G.get(6).add(7);

		return G;
	}
	public static ArrayList<ArrayList<Integer>> InitializeGraph()
	{
		ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>();
		int numOfVertices = 8;

		for (int i = 0; i < numOfVertices; i++) {
			G.add(new ArrayList<Integer>());
		}

		G.get(0).add(1);
		G.get(0).add(2);

		G.get(1).add(0);
		G.get(1).add(2);
		G.get(1).add(4);

		G.get(2).add(0);
		G.get(2).add(1);
		G.get(2).add(3);
		G.get(2).add(5);

		G.get(3).add(2);
		G.get(3).add(4);
		G.get(3).add(5);

		G.get(4).add(1);
		G.get(4).add(3);
		G.get(4).add(7);

		G.get(5).add(2);
		G.get(5).add(3);
		G.get(5).add(6);

		G.get(6).add(4);
		G.get(6).add(5);
		G.get(6).add(7);

		G.get(7).add(4);
		G.get(7).add(6);

		return G;
	}
}