import java.util.*;

public class StringCharacter {
	Map<String, Integer> operate;//For Caching
	Set<Character> uniqueCharacter;//For unique characters

	public StringCharacter() {
		operate = new HashMap<String, Integer>();

	}
/**
 * This method finds all the unique character present in the String and also caches with help of Map
 * @param element is the String in which character is to be found
 * @return the length of unique character 
 */
public int findUniqueCharacter(String element) {
		uniqueCharacter = new HashSet<Character>();
		int uniqueLength = 0;

		if (!operate.containsKey(element)) {
			for (int i = 0; i < element.length(); i++) {
				uniqueCharacter.add(element.charAt(i));
			}
			operate.put(element, uniqueCharacter.size());
			uniqueLength = uniqueCharacter.size();
		} else {
			System.out.println("Already contains");
			uniqueLength = operate.get(element);
		}
		return uniqueLength;
	}
}
