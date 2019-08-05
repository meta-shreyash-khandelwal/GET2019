package bst;

import java.util.List;

public interface BinarySearchTreeInterface {
	public Entry insertNode(int key, String value);
	public String getValueFromKey(int key);
	public void removeNode(int key);
	public List<Entry> sortedOrderGeneral();
	public List<Entry> sortedOrderFixed(int key1, int key2);
}
