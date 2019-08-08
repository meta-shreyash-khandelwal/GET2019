package tree;
import java.util.*;
public class GraphOperation implements GraphInterface{
	LinkedList<Edge> []adjacencyList;
	int vertices;
	public GraphOperation(int vertices)
	{
		this.vertices=vertices;
		adjacencyList=new LinkedList[vertices];
		for(int i=0;i<vertices;i++)
		{
			adjacencyList[i]=new LinkedList<>();
		}
		
	}
	public void addEdgeToGraph(int source,int destination,int weight)
	{
		Edge edge=new Edge(source,destination,weight);
		adjacencyList[source].add(edge);
	}
	   public void printGraph(){
           for (int i = 0; i <vertices ; i++) {
               LinkedList<Edge> list = adjacencyList[i];
               for (int j = 0; j <list.size() ; j++) {
                   System.out.println("vertex-" + i + " is connected to " +
                           list.get(j).destination + " with weight " +  list.get(j).weight);
               }
           }}
	   
	   public boolean isConnected()
	   {
		   
		   return true;
		   
	   }
	   
	   
	   
	   public  void dfsStack(int source)
		{
			Stack<Integer> stack=new  Stack<Integer>();
			stack.push(source);
			
			
			
		}
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	
	
	   public static void main(String[] args) {
           int vertices = 5;
           GraphOperation graph = new GraphOperation(vertices);
           graph.addEdgeToGraph(0, 1, 4);
           graph.addEdgeToGraph(0, 2, 3);
           graph.addEdgeToGraph(1, 3, 2);
           graph.addEdgeToGraph(1, 2, 5);
           graph.addEdgeToGraph(2, 3, 7);
           graph.addEdgeToGraph(3, 4, 2);
           graph.addEdgeToGraph(4, 0, 4);
           graph.addEdgeToGraph(4, 1, 4);
           graph.addEdgeToGraph(4, 5, 6);
           graph.printGraph();
       }
}
