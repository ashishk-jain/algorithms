package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBfs2 {
	private int v; // number of vertices
	private List<Integer> adjacency[];

	public GraphBfs2(int v) {
		this.v = v;
		this.adjacency = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			this.adjacency[i] = new LinkedList<>();
		}
	}




	public static void main(String[] args) {
		GraphBfs2 g = new GraphBfs2(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(1, 0);
		g.addEdge(3, 2);

		System.out.println(
						"Following is Depth First Traversal "
										+ "(starting from vertex 2)");

		g.bfs(2);
	}

	private void bfs(int root) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		boolean visited[] = new boolean[this.v];
		visited[root] = true;
		linkedList.add(root);
		while(true) {
			if (linkedList.isEmpty()) {
				break;
			}
			final Integer current = linkedList.poll();
			final List<Integer> edges = this.adjacency[current];
			System.out.print(current +  " ");
			for (Integer edge : edges) {
				if (!visited[edge]) {
					visited[edge]= true ;
					linkedList.add(edge);
				}
			}
		}
	}

	private void addEdge(int start, int end) {
		adjacency[start].add(end);
	}
}
