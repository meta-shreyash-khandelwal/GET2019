package dataStructure;
import java.util.Stack;
public class InfixEvaluation {
/**
 * This method evaluates the infix expression using stack thereby returning top of stack
 * @param expression is the Infix expression in String form
 * @return the complete evaluation containing the result
 */
	public static int evaluateInfix(String expression) {
		char[] tokens = expression.toCharArray();
		Stack<Integer> values = new Stack<Integer>();		// Stack for numbers
		Stack<Character> operator = new Stack<Character>();		// Stack for Operators
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] == ' ')		// Current token is a whitespace, skip it
				continue;
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer digit = new StringBuffer();
				while (i < tokens.length && tokens[i] >= '0'// There may be more than one digits in number
						&& tokens[i] <= '9')
					digit.append(tokens[i++]);
				values.push(Integer.parseInt(digit.toString()));
			} else if (tokens[i] == '(')
				operator.push(tokens[i]);
			else if (tokens[i] == ')') {
				while (operator.peek() != '(')
					values.push(applyOperation(operator.pop(), values.pop(),
							values.pop()));
				operator.pop();
			} else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*'   				
					|| tokens[i] == '/' || tokens[i] == '<' || tokens[i] == '>') {/* While top of 'operator' has same or greater precedence to
				 current token, which is an operator. Apply operator on top of 'operator'
				 to top two elements in values stack*/
				while (!operator.empty()
						&& hasPrecedence(tokens[i], operator.peek()))
					values.push(applyOperation(operator.pop(), values.pop(),
							values.pop()));
				operator.push(tokens[i]);
			}
		}
		// Entire expression has been parsed at this point, apply remaining operator
		while (!operator.empty())
			values.push(applyOperation(operator.pop(), values.pop(),
					values.pop()));
		return values.pop();
	}
/**
 * This method checks which operator has a higher precedence
 * @param operator1 is the first operator 
 * @param operator2 is the second operator
 * @return true if operator1 has lesser precedence than operator second otherwise returns false
 */
	public static boolean hasPrecedence(char operator1, char operator2) {
		if (operator2 == '(' || operator2 == ')')
			return false;
		if ((operator1 == '*' || operator1 == '/')
				&& (operator2 == '+' || operator2 == '-'))
			return false;
		if ((operator1 == '*' || operator1 == '/' || operator1 == '+' || operator1 == '-')
				&& (operator2 == '<' || operator2 == '>'))
			return false;
		else
			return true;
	}
/**
 * This method applies the operation after taking operator , firstNumber and secondNumber
 * @param operator is the char containing operator
 * @param secondNumber is the integer value of second number
 * @param firstNumber is the integer value of first number
 * @return the result after applying the operation appropriately
 */
	public static int applyOperation(char operator, int secondNumber,
			int firstNumber) {
		switch (operator) {
		case '+':
			return firstNumber + secondNumber;
		case '-':
			return firstNumber - secondNumber;

		case '<':
			if (secondNumber < firstNumber)
				return 1;
			else
				return 0;
		case '>':
			if (firstNumber > secondNumber)
				return 0;
			else
				return 1;

		case '*':
			return firstNumber * secondNumber;
		case '/':
			try {
				if (secondNumber == 0)
					throw new Exception("Cannot divide by zero");
			} catch (Exception e) {
				System.out.println("Cant divide by 0");
			}
			return firstNumber / secondNumber;
		}
		return 0;
	}

	/*
	 * // Driver method to test above methods public static void main(String[]
	 * args) {
	 * System.out.println(InfixEvaluation.evaluateInfix("( 5 + ( 8 < 6 ) )"));
	 * System.out.println(InfixEvaluation.evaluateInfix("100 * 2 + 12"));
	 * System.out.println(InfixEvaluation.evaluateInfix("100 * ( 2 + 12 )"));
	 * System
	 * .out.println(InfixEvaluation.evaluateInfix("100 * ( 2 + 12 ) / 14")); }
	 */
}
