package bst;

import java.util.List;

public interface BinarySearchTreeInterface {
	public Entry Insert(int key, String value);
	public String getVakueFromKey(int key);
	public void Remove(int key);
	public List<Entry> sortedOrderGeneral();
	public List<Entry> sortedOrderFixed(int key1,int key2);
}
