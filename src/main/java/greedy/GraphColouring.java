package greedy;

import java.util.*;

public class GraphColouring {
	private int V;
	private LinkedList<Integer> adj[];

	public GraphColouring(int v) {
		V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public static void main(String[] args) {
		GraphColouring g1 = new GraphColouring(5);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 2);
		g1.addEdge(1, 3);
		g1.addEdge(2, 3);
		g1.addEdge(3, 4);
		System.out.println("Coloring of graph 1");
		g1.greedyColoring();

		System.out.println();
		GraphColouring g2 = new GraphColouring(5);
		g2.addEdge(0, 1);
		g2.addEdge(0, 2);
		g2.addEdge(1, 2);
		g2.addEdge(1, 4);
		g2.addEdge(2, 4);
		g2.addEdge(4, 3);
		System.out.println("Coloring of graph 2 ");
		g2.greedyColoring();
	}

	private void greedyColoring() {
		int [] results = new int[V];
		Arrays.fill(results, -1);
		results[0] = 0;
		boolean available[] = new boolean[V];
		Arrays.fill(available, true);
		for (int u = 1; u < V; u++) {
			final Iterator<Integer> iterator = adj[u].iterator();
			while(iterator.hasNext()) {
				int i = iterator.next();
				if (results[i] != -1) {
					available[results[i]] = false;
				}
			}
			int cr;
			for (cr = 0; cr < V; cr++) {
				if (available[cr]) {
					break;
				}
			}
			results[u] = cr;
		/*	for (Integer i : adj[u]) {
				if (results[i] != -1) {
					available[results[i]] = true;
				}
			}*/
			Arrays.fill(available, true);
		}
		for (int u = 0; u < V; u++)
			System.out.println("Vertex " + u + " --->  Color "
							+ results[u]);
	}

	private void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
}
