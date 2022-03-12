package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BiPartite {

	// RE-ATTEMPT USING BFS https://www.geeksforgeeks.org/bipartite-graph/
	private int v; // number of vertices
	private List<Integer> adjacency[];
	private int[] colors = {0, 1};
	private boolean[] completedNodes;
	private boolean[] neighbourColors = new boolean[2];
	private int[] assignedColors;

	public BiPartite(int v) {
		this.v = v;
		this.adjacency = new LinkedList[v];
		completedNodes = new boolean[v];
		assignedColors = new int[v];
		for (int i = 0; i < v; i++) {
			this.adjacency[i] = new LinkedList<>();
			assignedColors[i] = -1;
		}
		neighbourColors[0] = false;
		neighbourColors[1] = false;

	}

	private void addEdge(int start, int end) {
		adjacency[start].add(end);
		// undirected graph
		adjacency[end].add(start);
	}

	public static void main(String[] args) {
		BiPartite g = new BiPartite(6);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);

		g.addEdge(4, 1);
		g.addEdge(4, 2);
		g.addEdge(4, 3);

		g.addEdge(5, 1);
		g.addEdge(5, 2);
		g.addEdge(5, 3);

		assertThat(g.isBiPartite(0), is(true));
	}

	private boolean isBiPartite(int root) {
		if (assignedColors[root] != -1) {
			return true;
		}
		neighbourColors[0] = false;
		neighbourColors[1] = false;

		final Iterator<Integer> iterator = adjacency[root].iterator();
		while(iterator.hasNext()) {
			final int value = iterator.next();
			if (completedNodes[value]) {
				neighbourColors[assignedColors[value]] = true;
			}
		}
		boolean assigned = false;
		for (int i = 0; i < neighbourColors.length; i++) {
			if (!neighbourColors[i]) {
				assignedColors[root] = i;
				completedNodes[root] = true;
				assigned = true;
				break;
			}
		}
		if (!assigned) {
			System.out.println("Graph is not bi-partite");
			return false;
		}
		neighbourColors[0] = false;
		neighbourColors[1] = false;
		for (int integer : adjacency[root]) {
			if (assignedColors[integer] == -1) {
				return isBiPartite(integer);
			}
		}
		boolean completed = true;
		for (int assignedColor : assignedColors) {
			if (assignedColor == -1) {
				completed = false;
			}
		}
		if (completed) {
			System.out.println("Graph is bi-partite");
			return true;
		}
		return true;
	}

}
