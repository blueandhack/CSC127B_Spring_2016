import static org.junit.Assert.*;

import org.junit.Test;

public class PostFix {

	@Test
	public void testValueOf() {
		assertEquals(8, valueOf("5 3 +"));
		assertEquals(15, valueOf("5 3 *"));
		assertEquals(2, valueOf("5 3 -"));
		assertEquals(1, valueOf("5 3 /"));
		assertEquals(10, valueOf("1 2 3 4 + + +"));
		assertEquals(120, valueOf("2 3 4 5 * * *"));
		// The example from slides
		assertEquals(-16, valueOf("3 4 - 5 3 * -"));
	}

	/**
	 * Determine the value of postfix expressions with integer operands
	 * 
	 * @param postfix
	 *            A postfix expression with integer operands and the five Java
	 *            operators: + - / *
	 * @return The value of the postfix expression as an integer.
	 */
	public int valueOf(String postfix) {
		Stack<Integer> s = new Stack<Integer>();
		String[] array = postfix.split(" ");
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals("+") || array[i].equals("-") || array[i].equals("*") || array[i].equals("/")) {
				int left = s.pop();
				int right = s.pop();
				if (array[i].equals("+")) {
					int sum = 0;
					sum = right + left;
					s.push(sum);
				}
				if (array[i].equals("-")) {
					int sum = 0;
					sum = right - left;
					s.push(sum);
				}
				if (array[i].equals("*")) {
					int sum = 0;
					sum = right * left;
					s.push(sum);
				}
				if (array[i].equals("/")) {
					int sum = 0;
					sum = right / left;
					s.push(sum);
				}
			} else {
				s.push(Integer.parseInt(array[i]));
			}
		}

		return s.peek();
	}

}
