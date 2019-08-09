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
					//System.out.println("SOURCE-->"+source);
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
       
       
       
       static class HeapNode{
           int vertex;
           int distance;
       }
       static class MinHeap{
           int capacity;
           int currentSize;
           HeapNode[] mHeap;
           int [] indexes; //will be used to decrease the distance
        public MinHeap(int capacity) {
               this.capacity = capacity;
               mHeap = new HeapNode[capacity + 1];
               indexes = new int[capacity];
               mHeap[0] = new HeapNode();
               mHeap[0].distance = Integer.MIN_VALUE;
               mHeap[0].vertex=-1;
               currentSize = 0;
           }
/*
           public void display() {
               for (int i = 0; i <=currentSize; i++) {
                   System.out.println(" " + mH[i].vertex + "   distance   " + mH[i].distance);
               }
               System.out.println("________________________");
           }
*/
           public void insert(HeapNode x) {
               currentSize++;
               int idx = currentSize;
               mHeap[idx] = x;
               indexes[x.vertex] = idx;
               bubbleUp(idx);
           }

           public void bubbleUp(int pos) {
               int parentIdx = pos/2;
               int currentIdx = pos;
               while (currentIdx > 0 && mHeap[parentIdx].distance > mHeap[currentIdx].distance) {
                   HeapNode currentNode = mHeap[currentIdx];
                   HeapNode parentNode = mHeap[parentIdx];
                   indexes[currentNode.vertex] = parentIdx;                   //swap the positions
                   indexes[parentNode.vertex] = currentIdx;
                   swap(currentIdx,parentIdx);
                   currentIdx = parentIdx;
                   parentIdx = parentIdx/2;
               }
           }

           public HeapNode extractMin() {
               HeapNode min = mHeap[1];
               HeapNode lastNode = mHeap[currentSize];
//               update the indexes[] and move the last node to the top
               indexes[lastNode.vertex] = 1;
               mHeap[1] = lastNode;
               mHeap[currentSize] = null;
               sinkDown(1);
               currentSize--;
               return min;
           }

           public void sinkDown(int k) {
               int smallest = k;
               int leftChildIdx = 2 * k;
               int rightChildIdx = 2 * k+1;
               if (leftChildIdx < heapSize() && mHeap[smallest].distance > mHeap[leftChildIdx].distance) {
                   smallest = leftChildIdx;
               }
               if (rightChildIdx < heapSize() && mHeap[smallest].distance > mHeap[rightChildIdx].distance) {
                   smallest = rightChildIdx;
               }
               if (smallest != k) {

                   HeapNode smallestNode = mHeap[smallest];
                   HeapNode kNode = mHeap[k];

                   //swap the positions
                   indexes[smallestNode.vertex] = k;
                   indexes[kNode.vertex] = smallest;
                   swap(k, smallest);
                   sinkDown(smallest);
               }
           }

           public void swap(int a, int b) {
               HeapNode temp = mHeap[a];
               mHeap[a] = mHeap[b];
               mHeap[b] = temp;
           }

           public boolean isEmpty() {
               return currentSize == 0;
           }

           public int heapSize(){
               return currentSize;
           }
       }
           
           
       
       public void dijkstraGetMinDistances(int sourceVertex){
           int INFINITY = Integer.MAX_VALUE;
           boolean[] SPT = new boolean[vertices];

//         //create heapNode for all the vertices
           HeapNode [] heapNodes = new HeapNode[vertices];
           for (int i = 0; i <vertices ; i++) {
               heapNodes[i] = new HeapNode();
               heapNodes[i].vertex = i;
               heapNodes[i].distance = INFINITY;
           }
           //decrease the distance for the first index
           heapNodes[sourceVertex].distance = 0;

           //add all the vertices to the MinHeap
           MinHeap minHeap = new MinHeap(vertices);
           for (int i = 0; i <vertices ; i++) {
               minHeap.insert(heapNodes[i]);
           }
           //while minHeap is not empty
           while(!minHeap.isEmpty()){
               HeapNode extractedNode = minHeap.extractMin();               //extract the min
               int extractedVertex = extractedNode.vertex;               //extracted vertex
               SPT[extractedVertex] = true;

               //iterate through all the adjacent vertices
               LinkedList<Edge> list = adjacencyList[extractedVertex];
               for (int i = 0; i <list.size() ; i++) {
                   Edge edge = list.get(i);
                   int destination = edge.destination;
                   //only if  destination vertex is not present in SPT
                   if(SPT[destination]==false ) {
                       ///check if distance needs an update or not
                       //means check total weight from source to vertex_V is less than
                       //the current distance value, if yes then update the distance
                       int newKey =  heapNodes[extractedVertex].distance + edge.weight ;
                       int currentKey = heapNodes[destination].distance;
                       if(currentKey>newKey){
                           decreaseKey(minHeap, newKey, destination);
                           heapNodes[destination].distance = newKey;
                       }
                   }
               }
           }
           printDijkstra(heapNodes, sourceVertex);
       }

       public void decreaseKey(MinHeap minHeap, int newKey, int vertex){
           int index = minHeap.indexes[vertex];  //get the index which distance's needs a decrease;
           HeapNode node = minHeap.mHeap[index];           //get the node and update its value

           node.distance = newKey;
           minHeap.bubbleUp(index);
       }

       public void printDijkstra(HeapNode[] resultSet, int sourceVertex){
           System.out.println("Dijkstra Algorithm: (Adjacency List + Min Heap)");
           for (int i = 0; i <vertices ; i++) {
               System.out.println("Source Vertex: " + sourceVertex + " to vertex " +   + i +
                       " distance: " + resultSet[i].distance);
           }
       }
   }
 
   
