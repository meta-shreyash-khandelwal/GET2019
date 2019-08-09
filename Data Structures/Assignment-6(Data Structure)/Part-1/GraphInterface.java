
package tree;

import java.util.List;

public interface GraphInterface {
	 public boolean isConnected(int source);
	  public List<Integer> reachable(int vertex);
	  public List<Edge> kruskalMST();
	  public void dijkstraGetMinDistances(int sourceVertex);
}


