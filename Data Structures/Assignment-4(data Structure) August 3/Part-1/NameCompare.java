package varunk;
import java.util.*;
public class NameCompare implements Comparator<Employee> {
	//Over-riding compare method
	public int compare(Employee object1, Employee object2) 
    { 
        return object1.getName().compareTo(object2.getName()); 
    } 
}
