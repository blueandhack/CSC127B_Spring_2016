import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

	@Test
	public void test() {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);

		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}
