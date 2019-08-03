package dataStructure;

import java.util.*;

public class StringCharacter {
	Map<String, Integer> operate;
	Set<Character> uniqueCharacter;

	public StringCharacter() {
		operate = new HashMap<String, Integer>();

	}

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
