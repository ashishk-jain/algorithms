package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphBfs {
	private int v; // number of vertices
	private List<Integer> adjacency[];

	public GraphBfs(int v) {
		this.v = v;
		this.adjacency = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			this.adjacency[i] = new LinkedList<>();
		}
	}



	void bfs(int root) {
		boolean visited[] = new boolean[this.v];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(root);
		visited[root] = true;
		while (queue.size() != 0) {
			final Integer front = queue.poll();
			System.out.println(front + " ");
			final List<Integer> edges = adjacency[front];
			for (Integer edge : edges) {
				if (!visited[edge]) {
					visited[edge] = true;
					queue.add(edge);
				}
			}
		}
	}

	public static void main(String[] args) {
		GraphBfs g = new GraphBfs(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(1, 3);
		g.addEdge(3, 2);

		System.out.println(
						"Following is Depth First Traversal "
										+ "(starting from vertex 2)");

		g.bfs(3);
	}

	private void addEdge(int start, int end) {
		adjacency[start].add(end);
	}
}
