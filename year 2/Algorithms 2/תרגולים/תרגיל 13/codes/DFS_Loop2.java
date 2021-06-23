import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class DFS_Loop2 {
	public static void dfs(ArrayList<Integer>[] g, int s) {
		int n = g.length;
		boolean[] marked = new boolean[n];
		int timeFirst[] = new int[n];
		int timeLast[] = new int[n];
		int[] pred = new int[n];
		int nil = -1;
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			timeFirst[i] = 0;
			timeLast[i] = 0;
			pred[i] = nil;
			marked[i] = false;
		}
		int time = 0;
		Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[n];
		for (int j = 0; j < adj.length; j++) {
			adj[j] = g[j].iterator();
		}
		pred[s] = nil;
		marked[s] = true;
		st.push(s);
		timeFirst[s] = ++time;
		System.out.println(st);
		while(!st.isEmpty()){
			int u = st.peek();
			if(adj[u].hasNext()){
				int v = adj[u].next();
				if (!marked[v]){
					marked[v] = true;
					pred[v] = u;
					timeFirst[v] = ++time;
					st.push(v);
					System.out.println(st);
				}
			}
			else{
				st.pop();
				timeLast[u] = ++time;
				System.out.println(st);
			}
		}
		System.out.println("pred: "+Arrays.toString(pred));
		System.out.println("isVisited: "+Arrays.toString(marked));
		System.out.println("timeFirst: "+Arrays.toString(timeFirst));
		System.out.println("timeLast: "+Arrays.toString(timeLast));
	}
	public static void main(String[] args) {
		DFS_Loop2.dfs(GraphArrayListInit.initGraph2(), 0);
	}
}
