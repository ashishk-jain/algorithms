package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSortNew {
	private int V;
	private List<Integer>[] adjacency;

	public TopologicalSortNew(int v) {
		this.V = v;
		adjacency = new LinkedList[V];
		for (int i = 0; i < v; i++) {
				adjacency[i] = new LinkedList<>();
		}
	}

	private void addEdge(int u, int v) {
		adjacency[u].add(v);
	}

	private void topologicalSort(int root) {
		LinkedList<Integer> stack = new LinkedList<>();
		List<Integer> sortedList = new ArrayList<>(this.V);
		stack.push(root);
		while (sortedList.size() < this.V){
			sort(stack, sortedList);
			if (sortedList.size() < this.V) {
				for (int i = 0; i < this.V; i++) {
					if (!sortedList.contains(i)) {
						stack.push(i);
					}
				}
			}
		}
	}

	private void sort(LinkedList<Integer> stack, List<Integer> sortedList) {
		final Integer u = stack.peek();
		for (Integer v : adjacency[u]) {
			System.out.print(" a");
			if (!sortedList.contains(v)) {
				stack.push(v);
				sort(stack, sortedList);
			}
		}
		sortedList.add(u);
		System.out.print(" " + stack.poll());
	}

	public static void main(String[] args) {
		TopologicalSortNew g = new TopologicalSortNew(7);
			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(1, 2);
			g.addEdge(1, 3);
			g.addEdge(1, 5);
			g.addEdge(2, 4);
			g.addEdge(2, 5);
			g.addEdge(3, 5);
			g.addEdge(3, 6);
			g.addEdge(5, 6);
			g.topologicalSort(6);
		}


}

