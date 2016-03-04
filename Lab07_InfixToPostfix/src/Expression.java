import java.util.Scanner;
import java.util.Stack;

/**
 * Use a Stack to convert infix expressions into their postfix equivalent and a
 * different stack to evaluate that expression to its integer equivalent.
 * 
 * @author YOUR NAME
 */
public class Expression {
	private String infix;
	private String postfix;
	private int theValue;

	/**
	 * Construct an Expression object and set these the instance variables to
	 * the correct values
	 * 
	 * 1) infix: The same as the argument infixExpression
	 * 
	 * 2) postfix: The postfix version of infixExpression
	 * 
	 * 3) value: The value of the infixExpression as an integer
	 * 
	 */
	public Expression(String infixExpression) {
		infix = infixExpression;
		postfix = convertToPostfix();
		theValue = valueOf();
	}

	// The public methods are simple accessors because all
	// of the work is done immediately when this object is constructed.
	public String infix() {
		return infix;
	}

	public String postfix() {
		return postfix;
	}

	public int value() {
		return theValue;
	}

	// Use the infix expression and two other private helper methods:
	// processOperator
	// processRightParan
	// to convert the infix expression into its postfix equivalent
	private String post;
	private Stack<String> myStack;

	private String convertToPostfix() {
		myStack = new Stack<String>();
		post = "";
		Scanner scanner = new Scanner(infix);

		while (scanner.hasNext()) {
			String token = scanner.next();
			if (isOperand(token)) {
				while (!myStack.isEmpty() && !myStack.peek().equals("(")) {
					if (this.ComparePrecedence(myStack.peek(), token)) {
						post += myStack.pop() + " ";
					} else {
						break;
					}
				}
				myStack.push(token);
			} else if (isOpener(token)) {
				myStack.push(token);
			} else if (isCloser(token)) {
				while (!isOpener(myStack.peek())) {
					post += myStack.pop() + " ";
				}
				myStack.pop();
			} else {
				post += token + " ";
			}
		}

		while (!myStack.isEmpty()) {
			post += myStack.pop() + " ";
		}

		// System.out.println(post);

		return post.trim();
	}

	private boolean ComparePrecedence(String top, String token) {
		if (top.equals("+") && token.equals("*"))
			return false;

		if (top.equals("*") && token.equals("-")) {
			return true;
		}
		if (top.equals("+") && token.equals("-"))
			return true;

		if (top.equals("/") && token.equals("+")) {
			return true;
		}

		if (top.equals("+") && token.equals("/")) {
			return false;
		}
		if (top.equals("-") && token.equals("/")) {
			return false;
		}
		if (top.equals("-") && token.equals("*")) {
			return false;
		}

		if (top.equals("*") && token.equals("/")) {
			return true;
		}

		return true;
	}

	// Determine the integer value of the postfix expression
	private int valueOf() {
		// System.out.println(postfix);
		Stack<Integer> s = new Stack<Integer>();
		Scanner scanner = new Scanner(postfix);

		int result = Integer.MIN_VALUE;

		while (scanner.hasNext()) {
			String token = scanner.next();
			if (!isOperand(token)) {
				s.push(Integer.valueOf(token));
			} else {
				int op2 = s.pop();
				int op1 = s.pop();
				if (token.equals("+"))
					result = op1 + op2;
				else if (token.equals("-"))
					result = op1 - op2;
				else if (token.equals("*"))
					result = op1 * op2;
				else if (token.equals("/"))
					result = op1 / op2;

				s.push(new Integer(result)); // push post
			} // end else
		} // end for

		result = ((Integer) s.pop()).intValue(); // get answer

		scanner.close();

		return result;
	}

	private boolean isOperand(String token) {
		return "-+*/".indexOf(token) >= 0;
	}

	private boolean isOpener(String token) {
		return "(".indexOf(token) >= 0;
	}

	private boolean isCloser(String token) {
		return ")".indexOf(token) >= 0;
	}

} // end class Expression