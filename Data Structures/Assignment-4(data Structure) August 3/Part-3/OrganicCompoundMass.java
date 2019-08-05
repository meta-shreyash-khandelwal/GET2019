package varunkumar;
import java.util.*;
public class OrganicCompoundMass {
	private Map<Character, Integer> knownElement;
	private Stack<Integer> operation;//For storing without braces
	private Stack<Integer> subOperate;//For storing with braces
	public OrganicCompoundMass() {
		knownElement = new HashMap<Character, Integer>();//Known elements
		knownElement.put('C', 12);
		knownElement.put('O', 16);
		knownElement.put('H', 1);
		operation = new Stack<Integer>();
			}
/**
 * This method calculates mass of the compound according to formula	
 * @param compound is the Chemical compound in String form
 * @return the calculated mass
 */
	public int calculateMass(String compound) {
		int sumOfMass = 0;
		int sumBrace = 0;
		int totalElements = 0;
		for (int i = 0; i < compound.length(); i++) {
			sumBrace = 0;
			if (compound.charAt(i) == '(') {
				operation.push(-1);
			} else if (compound.charAt(i) == 'C' || compound.charAt(i) == 'H'
					|| compound.charAt(i) == 'O') {
				operation.push(knownElement.get(compound.charAt(i)));//Pushing the molecular weights
			} else if (compound.charAt(i) >= '1' && compound.charAt(i) <= '9') {
				StringBuffer digit = new StringBuffer();
				while (i < compound.length() && compound.charAt(i) >= '0'// There may be more than one digits in number
						&& compound.charAt(i) <= '9')
					digit.append(compound.charAt(i++));
				//subOperate.push();//For calculating in braces
				int topElement = Integer.parseInt(digit.toString());
				int topElement2 = operation.pop();
				operation.push(topElement2 * topElement);//Value after closing brace on basis of two stacks
				if (i >= compound.length())
					break;
				i--;
			} else if (compound.charAt(i) == ')') {//Pop until -1 to calculate value
				while (operation.peek() != -1) {
					sumBrace += operation.pop();
				}
				operation.pop();
				operation.push(sumBrace);
			}
		}
		totalElements = operation.size();
		for (int i = 0; i < totalElements; i++) {
			sumOfMass += (operation.pop());
		}
		return sumOfMass;
	}
}
