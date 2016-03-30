
/*
 * A unit test for ExpressionTree
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class ExpressionTreeTest {

	@Test
	public void testInfixWithZeroOrOneOperands() {
		ExpressionTree et0 = new ExpressionTree("");
		assertEquals("", et0.inFix());
		ExpressionTree et1 = new ExpressionTree("99");
		assertEquals("99", et1.inFix());
	}

	@Test
	public void testPrefixWithZeroMoreThanOneOperand() {
		ExpressionTree et3 = new ExpressionTree("- 500 900");
		assertEquals("500 - 900", et3.inFix());
		ExpressionTree et7 = new ExpressionTree("- * 99 88 / 55 44");
		assertEquals("99 * 88 - 55 / 44", et7.inFix());
	}

	@Test
	public void testValueOf() {
		ExpressionTree et0 = new ExpressionTree("");
		assertEquals(0, et0.valueOf());
		ExpressionTree et1 = new ExpressionTree("99");
		assertEquals(99, et1.valueOf());
		ExpressionTree et2 = new ExpressionTree("- 500 900");
		assertEquals(-400, et2.valueOf());

		ExpressionTree et3 = new ExpressionTree("+ 5 9");
		assertEquals(14, et3.valueOf());

		ExpressionTree et4 = new ExpressionTree("* 5 -9");
		assertEquals(-45, et4.valueOf());

		ExpressionTree et5 = new ExpressionTree("/ 89 25 ");
		assertEquals(3, et5.valueOf());

		ExpressionTree et6 = new ExpressionTree("% 89 25 ");
		assertEquals(14, et6.valueOf());

		ExpressionTree et7 = new ExpressionTree("- * / 4 3 5 6");
		assertEquals(-1, et7.valueOf());

		ExpressionTree et8 = new ExpressionTree("- + * 12 11 10 / %  9 8 7");
		assertEquals("12 * 11 + 10 - 9 % 8 / 7", et8.inFix());
		//
		// root-> "-"
		// / \
		// "+" "/"
		// / \ / \
		// "*" "10" "%" "7"
		// / \ / \
		// "12" "11" "9" "8"
		//
		assertEquals(142, et8.valueOf());
	}

	@Test
	public void testNodeCode() {
		ExpressionTree et1 = new ExpressionTree("99");
		assertEquals(1, et1.nodeCount());
		ExpressionTree et7 = new ExpressionTree("- * / 4 3 5 6");
		assertEquals(7, et7.nodeCount());
	}

	@Test
	public void testLeafCount() {
		ExpressionTree et7 = new ExpressionTree("- + * 12 11 10 / %  9 8 7");
		assertEquals(6, et7.leafCount());

	}

	@Test
	public void testPreOrder() {
		ExpressionTree et7 = new ExpressionTree("- + * 12 11 10 / %  9 8 7");
		assertEquals("-+*121110/%987", et7.preOrder());

	}

	@Test
	public void testPostOrder() {
		ExpressionTree et7 = new ExpressionTree("- + * 12 11 10 / %  9 8 7");
		assertEquals("1211*10+98%7/-", et7.postOrder());

	}

	@Test
	public void testIsFull() {
		ExpressionTree et7 = new ExpressionTree("- + * 12 11 10 / %  9 8 7");
		assertTrue(et7.isFull());
		ExpressionTree et8 = new ExpressionTree("- 9");
		assertFalse(et8.isFull());
	}

	@Test
	public void testAtLevel() {
		ExpressionTree et7 = new ExpressionTree("- + * 12 11 10 / %  9 8 7");
		assertEquals(4, et7.nodesAtLevel(3));

	}
}