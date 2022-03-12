package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GraphDfs {
	private int v; // number of vertices
	private List<Integer> adjacency[];

	public GraphDfs(int v) {
		this.v = v;
		this.adjacency = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			this.adjacency[i] = new LinkedList<>();
		}
	}

	void dfsUtil(int v, boolean[] visited, List<Integer> pathStack, int dest) {
		visited[v] = true;

//		System.out.print(v + " ");
		if(v == dest) {
			System.out.println(pathStack);
			visited[v] = false;
			return;
		}
		for (Integer adjOfV : adjacency[v]) {
			if (!visited[adjOfV]) {
				pathStack.add(adjOfV);
				System.out.println("array:" + pathStack);
				dfsUtil(adjOfV, visited, pathStack, dest);
				pathStack.remove(adjOfV);
			}
		}
		visited[v] = false;
	}

	void dfs(int root, int dest) {
		boolean visited[] = new boolean[this.v];
		List<Integer> pathStack = new ArrayList<>();
		pathStack.add(root);
		dfsUtil(root, visited, pathStack, dest);
	}

	public static void main(String[] args) {
		GraphDfs g = new GraphDfs(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(1, 3);

		System.out.println(
						"Following is Depth First Traversal "
										+ "(starting from vertex 2)");

		g.dfs(2,3);
	}

	private void addEdge(int start, int end) {
		adjacency[start].add(end);
	}
}
