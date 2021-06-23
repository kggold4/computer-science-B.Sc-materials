public class TestDFS2 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DFS_Loop2.dfs(GraphArrayListInit.initGraph3(), 0);
		System.out.println();
		DFSRecurs2 obj = new DFSRecurs2(GraphArrayListInit.initGraph3());
		obj.dfs(0);
		obj.print();
		System.out.println(obj.dfsPath(0, 2));
		System.out.println(obj.dfsCycle());
	}

}
