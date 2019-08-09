package tree;

import java.util.ArrayList;
import java.util.List;

public class GraphMain {
	public static void main(String[] args) {
		int vertices = 5;
		GraphOperation graph = new GraphOperation(vertices);
		graph.addEdgeToGraph(0, 1, 4);
		graph.addEdgeToGraph(0, 2, 3);
		graph.addEdgeToGraph(1, 2, 1);
		graph.addEdgeToGraph(1, 3, 2);
		graph.addEdgeToGraph(2, 3, 4);
		graph.addEdgeToGraph(3, 4, 2);
		graph.addEdgeToGraph(4, 2, 4);
		// graph.addEdgeToGraph(4, 1, 4);
		// graph.addEdgeToGraph(4, 5, 6);
		graph.printGraph();
		graph.dfsStack(0);
		System.out.println(graph.isConnected(0));
		List<Integer> list = new ArrayList<Integer>();
		list = graph.reachable(1);
		for (int i = 0; i < list.size(); i++)
			System.out.println("Reached-->" + list.get(i));
		System.out.println("Minimum Spanning Tree: ");
		graph.kruskalMST();
		List<Edge> edges = new ArrayList<Edge>();
		edges = graph.kruskalMST();
		graph.printMSTGraph(edges);
		graph.dijkstraGetMinDistances(0);
	}
}
