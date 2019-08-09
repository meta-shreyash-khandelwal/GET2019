package tree;
import java.util.*;
public class GraphOperation implements GraphInterface{
	LinkedList<Edge> []adjacencyList;
	int vertices;
	 boolean visited[];
	 List<Edge> allEdges;
		public GraphOperation(int vertices)
	{
		this.vertices=vertices;
		adjacencyList=new LinkedList[vertices];
		 visited=new boolean[vertices];
			
		for(int i=0;i<vertices;i++)
		{
			adjacencyList[i]=new LinkedList<>();
		}
		allEdges=new ArrayList<Edge>();
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
	   
	   public void printMSTGraph(List<Edge> list){
		   int total=0;
           for (int i = 0; i <list.size() ; i++) {
                   System.out.println("vertex-" + list.get(i).source + " is connected to " +
                           list.get(i).destination + " with weight " +  list.get(i).weight);
           total+= list.get(i).weight;   
           }
           System.out.println("The total weight of minimum spanning tree is "+total);
           }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
   public boolean isConnected(int source)
	   {
		   dfsStack(source);
		   int counter=0;
		   for(int j=0;j<vertices;j++)
		   {
			   if(visited[j])
			   {
				   counter++;
			   }
		   }
		   if(counter==vertices)
		   return true;
		   else
			return false;
	   }
	   
	
	   
	   public  void dfsStack(int source)
		{ 
		 	Stack<Integer> stack=new  Stack<Integer>();
			stack.push(source);
			while(stack.empty()==false)
			{
				source=stack.peek();
				stack.pop();
				if(visited[source]==false)
				{
					System.out.println("SOURCE-->"+source);
					visited[source]=true;
				}
				Iterator<Edge> iterate=adjacencyList[source].iterator();
				while(iterate.hasNext())
				{
					int vertex=iterate.next().destination;
					if(!visited[vertex])
					{
						stack.push(vertex);
					}
				}
				
			}
			
			
		}
	   
	   public List<Integer> reachable(int vertex)
	   {
		   List<Integer> reach=new ArrayList<Integer>();
		   for(int j=0;j<vertices;j++)
		   {
			   if(vertex==j)
			   {
				      LinkedList<Edge> list = adjacencyList[j];
			     for(int i=0;i<list.size();i++)
		   {
			   //reach[i]=list.get(i).destination;
			    	 reach.add(list.get(i).destination);
		   }
			   }
		   }
		   return reach;
		   
		   
	   }
	   
	   
	   public void addEdges()
	   {
		   
		   
		   for (int i = 0; i <vertices ; i++) {
               LinkedList<Edge> list = adjacencyList[i];
               for (int j = 0; j <list.size() ; j++) {
                  allEdges.add(list.get(j));
               }
		   
		   
	   }}
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   public List<Edge> kruskalMST(){
		   addEdges();
		   PriorityQueue<Edge> queue = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));
           //add all the edges to priority queue, //sort the edges on weights
           for (int i = 0; i <allEdges.size() ; i++) {
        	   queue.add(allEdges.get(i));
           }
           //System.out.println("Here size"+pq.size());
           int [] parent = new int[vertices];   //create a parent []
           makeSet(parent);//Creating set of parent

           ArrayList<Edge> mstList = new ArrayList<>();

           //process vertices - 1 edges
           int index = 0;
           while(index<vertices-1){
               Edge edge = queue.remove(); //check if adding this edge creates a cycle
               int xSet = find(parent, edge.source);
               int ySet = find(parent, edge.destination);

               if(xSet==ySet){
                   //ignore, will create cycle
               }else {
                   mstList.add(edge);  //add it to our final result
              	   index++;
                   union(parent,xSet,ySet);
               }
           }
           return mstList;
       }
/**
 *creating a new element with a parent pointer to itself.
 * @param parent
 */
       public void makeSet(int [] parent){
           for (int i = 0; i <vertices ; i++) {
               parent[i] = i;
           }
       }
/**
 *         //chain of parent pointers from x upwards through the tree
           // until an element is reached whose parent is itself
   
 * @param parent
 * @param vertex
 * @return
 */
       public int find(int [] parent, int vertex){
           if(parent[vertex]!=vertex)
               return find(parent, parent[vertex]);;
           return vertex;
       }

       public void union(int [] parent, int x, int y){
           int x_set_parent = find(parent, x);
           int y_set_parent = find(parent, y);
           //make x as parent of y
           parent[y_set_parent] = x_set_parent;
       }
  
	}











//get the vertex with minimum distance which is not included in SPT
int getMinimumVertex(boolean [] mst, int [] key){
    int minKey = Integer.MAX_VALUE;
    int vertex = -1;
    for (int i = 0; i <vertices ; i++) {
        if(mst[i]==false && minKey>key[i]){
            minKey = key[i];
            vertex = i;
        }
    }
    return vertex;
}

public void dijkstra_GetMinDistances(int sourceVertex){
    boolean[] spt = new boolean[vertices];
    int [] distance = new int[vertices];
    int INFINITY = Integer.MAX_VALUE;

    //Initialize all the distance to infinity
    for (int i = 0; i <vertices ; i++) {
        distance[i] = INFINITY;
    }

    //start from the vertex 0
    distance[sourceVertex] = 0;

    //create SPT
    for (int i = 0; i <vertices ; i++) {

        //get the vertex with the minimum distance
        int vertex_U = getMinimumVertex(spt, distance);

        //include this vertex in SPT
        spt[vertex_U] = true;

        //iterate through all the adjacent vertices of above vertex and update the keys
        for (int vertex_V = 0; vertex_V <vertices ; vertex_V++) {
            //check of the edge between vertex_U and vertex_V
            if(matrix[vertex_U][vertex_V]>0){
                //check if this vertex 'vertex_V' already in spt and
                // if distance[vertex_V]!=Infinity

                if(spt[vertex_V]==false && matrix[vertex_U][vertex_V]!=INFINITY){
                    //check if distance needs an update or not
                    //means check total weight from source to vertex_V is less than
                    //the current distance value, if yes then update the distance

                    int newKey =  matrix[vertex_U][vertex_V] + distance[vertex_U];
                    if(newKey<distance[vertex_V])
                        distance[vertex_V] = newKey;
                }
            }
        }
    }
    //print shortest path tree
    printDijkstra(sourceVertex, distance);
}

public void printDijkstra(int sourceVertex, int [] key){
    System.out.println("Dijkstra Algorithm: (Adjacency Matrix)");
    for (int i = 0; i <vertices ; i++) {
        System.out.println("Source Vertex: " + sourceVertex + " to vertex " +   + i +
                " distance: " + key[i]);
    }
}
}





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
         //graph.addEdgeToGraph(4, 5, 6);
         graph.printGraph();
         graph.dfsStack(0);
          System.out.println(graph.isConnected(0));
          List<Integer> list=new ArrayList<Integer>();
         list=graph.reachable(1);
          for(int i=0;i<list.size();i++)
          	System.out.println("Reached-->"+list.get(i));
        System.out.println("Minimum Spanning Tree: ");
        graph.kruskalMST();
        List<Edge> edges=new ArrayList<Edge>();
        edges=graph.kruskalMST();
     graph.printMSTGraph(edges);
          
      
	   }
}











