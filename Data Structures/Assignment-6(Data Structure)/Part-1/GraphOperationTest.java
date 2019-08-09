package tree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GraphOperationTest {
/*
 *  public List<Integer> reachable(int vertex);
	 
 * */
@Test
	public void testIsConnected1() {
		int vertices=5;
		GraphOperation graph = new GraphOperation(vertices);
		graph.addEdgeToGraph(0, 1, 4);
		graph.addEdgeToGraph(0, 2, 3);
		graph.addEdgeToGraph(1, 2, 1);
		graph.addEdgeToGraph(1, 3, 2);
		graph.addEdgeToGraph(2, 3, 4);
		graph.addEdgeToGraph(3, 4, 2);
		graph.addEdgeToGraph(4, 2, 4);
		//graph.printGraph();
		//graph.dfsStack(0);
		assertTrue(graph.isConnected(0));
		// 0 is the source vertex
	}
	@Test
	public void testIsConnected2() {
		int vertices=5;
		GraphOperation graph = new GraphOperation(vertices);
		graph.addEdgeToGraph(0, 1, 4);
		graph.addEdgeToGraph(0, 2, 3);
		graph.addEdgeToGraph(1, 2, 1);
		graph.addEdgeToGraph(1, 3, 2);
		graph.addEdgeToGraph(2, 3, 4);
			assertFalse(graph.isConnected(0));
		// 0 is the source vertex
	}
	
	@Test
	public void testkruskalMST() {
		int vertices=5;
		GraphOperation graph = new GraphOperation(vertices);
		graph.addEdgeToGraph(0, 1, 4);
		graph.addEdgeToGraph(0, 2, 3);
		graph.addEdgeToGraph(1, 2, 1);
		graph.addEdgeToGraph(1, 3, 2);
		graph.addEdgeToGraph(2, 3, 4);
		graph.addEdgeToGraph(3, 4, 2);
		graph.addEdgeToGraph(4, 2, 4);
		List<Edge> edges = new ArrayList<Edge>();
		edges = graph.kruskalMST();
		
		int actual[][]=new int[edges.size()][3];
		for(int i=0;i<edges.size();i++)
		{
			actual[i][0]=edges.get(i).source;
			actual[i][1]=edges.get(i).destination;
	     	actual[i][2]=edges.get(i).weight;
		}
		int expected[][]=new int[][]{{1,2,1},{1,3,2},{3,4,2},{0,2,3}};
		assertArrayEquals(expected,actual);
	}
	
	
	
	
	@Test
	public void testDijkstraGetMinDistances() {
		int vertices=5;
		GraphOperation graph = new GraphOperation(vertices);
		graph.addEdgeToGraph(0, 1, 4);
		graph.addEdgeToGraph(0, 2, 3);
		graph.addEdgeToGraph(1, 2, 1);
		graph.addEdgeToGraph(1, 3, 2);
		graph.addEdgeToGraph(2, 3, 4);
		graph.addEdgeToGraph(3, 4, 2);
		graph.addEdgeToGraph(4, 2, 4);
		List<Integer> distances = new ArrayList<Integer>();
		distances=graph.dijkstraGetMinDistances(0);
int expected[]=new int[]{0,4,3,6,8};
int actual[]=new int[distances.size()];
for(int i=0;i<distances.size();i++)
{
	actual[i]=distances.get(i);
}
assertArrayEquals(expected,actual);
	
	}
	

	@Test
	public void testReachable() {
		int vertices=5;
		GraphOperation graph = new GraphOperation(vertices);
		graph.addEdgeToGraph(0, 1, 4);
		graph.addEdgeToGraph(0, 2, 3);
		graph.addEdgeToGraph(1, 2, 1);
		graph.addEdgeToGraph(1, 3, 2);
		graph.addEdgeToGraph(2, 3, 4);
		graph.addEdgeToGraph(3, 4, 2);
		graph.addEdgeToGraph(4, 2, 4);
		List<Integer> distances = new ArrayList<Integer>();
		distances=graph.reachable(0);
int expected[]=new int[]{0,1,2,3,4};
int actual[]=new int[distances.size()];
for(int i=0;i<distances.size();i++)
{
	actual[i]=distances.get(i);
}
assertArrayEquals(expected,actual);
	
	}
	
	
	
}
