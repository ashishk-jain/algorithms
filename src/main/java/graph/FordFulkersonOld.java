package graph;

import java.util.LinkedList;

public class FordFulkersonOld {
	public static final int V = 6;
	/**
	 * Given a graph which represents a flow network where every edge has a capacity.
	 * Also given two vertices source ‘s’ and sink ‘t’ in the graph, find the maximum possible flow from s to t with following constraints:
	 * a) Flow on an edge doesn't exceed the given capacity of the edge.
	 * b) Incoming flow is equal to outgoing flow for every vertex except s and t.
	 */
	/**
	 * Edmonds-Karp Algorithm because BFS always use minimum number of edges
	 * O(VE^2) O(EV&^2)
	 */
	/**
	 * https://www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem/?ref=leftbar-rightbar
	 */

	public static void main(String[] args) {
		int graph[][] = new int[][] {
						{ 0, 16, 13, 0, 0, 0 },
						{ 0, 0, 10, 12, 0, 0 },
						{ 0, 4, 0, 0, 14, 0 },
						{ 0, 0, 9, 0, 0, 20 },
						{ 0, 0, 0, 7, 0, 4 },
						{ 0, 0, 0, 0, 0, 0 }
		};
		FordFulkersonOld fordFulkerson = new FordFulkersonOld();
		System.out.println("Max flow for graph is:" + fordFulkerson.maxFlow(graph, 0, 5));
	}

	private int maxFlow(int[][] graph, int source, int target) {
		int[][] rGraph = new int[V][V];
		for(int u = 0; u < V; u++) {
			for (int v = 0; v < V; v++) {
				rGraph[u][v] = graph[u][v];
			}
		}
		int p[] = new int[V];
		int maxFlow = 0;

		while(bfs(rGraph, source, target,  p)) {
			int pathFlow = Integer.MAX_VALUE;
			for (int v = target; v != source; v = p[v]) {
				int u = p [v];
				pathFlow = Math.min(pathFlow, rGraph[u][v]);
			}
			for (int v = target; v != source; v = p[v]) {
				int u = p[v];
				rGraph[u][v] -= pathFlow;
				rGraph[v][u] += pathFlow;
			}
			maxFlow += pathFlow;
		}
		return maxFlow;
	}

	private boolean bfs(int[][] graph, int source, int target, int[] parent) {
		boolean[] visited = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(source);
		visited[source] = true;
		parent[source] = -1;
		while(!queue.isEmpty()) {
			int u = queue.poll();
			for (int i = 0; i < V; i++) {
				if (!visited[i] && graph[u][i] > 0 ) {
					if (i == target) {
						parent[i] = u;
						return true;
					}
					parent[i] = u;
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		return false;
	}


}
