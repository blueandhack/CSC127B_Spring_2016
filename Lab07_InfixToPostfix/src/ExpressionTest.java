import static org.junit.Assert.*;

import org.junit.Test;

public class ExpressionTest {

	@Test
	public void testInfix2() {
		Expression e = new Expression("55");
		assertEquals("55", e.infix());
	}

	@Test
	public void testInfix3() {
		Expression e = new Expression("( 4 )");
		assertEquals("( 4 )", e.infix());
	}

	@Test
	public void testInfix4() {
		Expression e0 = new Expression("51 + 32");
		assertEquals("51 + 32", e0.infix());
	}

	// Postfix

	@Test
	public void testPostFixEasy6() {
		Expression e0 = new Expression("5 + 3");
		assertEquals("5 3 +", e0.postfix());
	}

	@Test
	public void testPostFixEasy7() {
		Expression e1 = new Expression("5 / 3");
		assertEquals("5 3 /", e1.postfix());
	}

	@Test
	public void testPostFixEasy_7() {
		Expression e1 = new Expression("55 + 44 * 33 / 222");
		assertEquals("55 44 33 * 222 / +", e1.postfix());
	}

	@Test
	public void testValueParens11() {
		Expression e0 = new Expression("( ( ( ( 321 ) ) ) )");
		assertEquals("321", e0.postfix());
	}

	@Test
	public void testValueParens12() {
		Expression e1 = new Expression("( ( ( ( 333 + 444 ) ) ) )");
		assertEquals("333 444 +", e1.postfix());
	}

	@Test
	public void testValueParens14() {
		Expression e2 = new Expression("( 3 * ( 1 + 2 ) )");
		assertEquals("3 1 2 + *", e2.postfix());
	}

	@Test
	public void test16() {
		Expression e1 = new Expression("( 32 + 43 ) / 2");
		assertEquals("32 43 + 2 /", e1.postfix());
		assertEquals(37, e1.value());
	}

	@Test
	public void testValueParens15() {
		Expression e2 = new Expression("( 100 + 2 * ( 3 - 4 ) )");
		assertEquals("100 2 3 4 - * +", e2.postfix());
		assertEquals(98, e2.value());
	}

	@Test
	public void testValueOfEasy10() {
		Expression e1 = new Expression("3 - 5");
		assertEquals(-2, e1.value());
	}

	@Test
	public void test17() {
		Expression e1 = new Expression("( 3 + 4 ) / 2");
		assertEquals("3 4 + 2 /", e1.postfix());
	}

	@Test
	public void test18() {
		Expression e1 = new Expression("( 3 + 4 ) / 2");
		assertEquals(3, e1.value());
	}

	@Test
	public void test20() {
		Expression e = new Expression("( 3 + 4 ) * ( 5 - 6 ) / 7");
		assertEquals("3 4 + 5 6 - * 7 /", e.postfix());
	}

	@Test
	public void testPostFixEasy8() {
		Expression e3 = new Expression("0");
		assertEquals("Failed value with new Expression(\"0\")", 0, e3.value());
	}

	@Test
	public void testValueOfEasy9() {
		Expression e0 = new Expression("500 + 311");
		assertEquals(811, e0.value());
	}

	@Test
	public void testValue22() {
		Expression e = new Expression("1 + 2 - 3 * 4 / 5");
		assertEquals("1 2 + 3 4 * 5 / -", e.postfix());
		assertEquals(1, e.value());
	}

	@Test
	public void testValue23() {
		Expression e = new Expression("1 + 2 - 3 * 4 / 5");
		assertEquals("1 2 + 3 4 * 5 / -", e.postfix());
	}

	@Test
	public void testValue24() {
		Expression e = new Expression("1 + 2 - 3 * 4 / 5");
		assertEquals("1 + 2 - 3 * 4 / 5", e.infix());
	}

	@Test
	public void testValue25() {
		Expression e = new Expression(" ( 2 * ( 3 + 4 * 5 ) ) / ( 6 - 7 )");
		assertEquals("Failed value", -46, e.value());
	}

	@Test
	public void testValue26() {
		Expression e = new Expression("( 2 * ( 3 + 4 * 5 ) ) / ( 6 - 7 )");
		assertEquals("Failed postfix", "2 3 4 5 * + * 6 7 - /", e.postfix());
	}

	@Test
	public void testFailedSomething() {
		Expression e = new Expression("( 2 * ( 3 + 4 * 5 ) ) / ( 6 - 7 )");
		assertEquals("( 2 * ( 3 + 4 * 5 ) ) / ( 6 - 7 )", e.infix());
		assertEquals("2 3 4 5 * + * 6 7 - /", e.postfix());
		assertEquals(-46, e.value());
	}

	@Test
	public void testValue28() {
		Expression e = new Expression(" 2 * ( 3 * 4 + 5 ) / 6 - 7");
		assertEquals("Failed postfix", "2 3 4 * 5 + * 6 / 7 -", e.postfix());
		assertEquals("Failed value", -2, e.value());
	}

	@Test
	public void testValue29() {
		Expression e = new Expression("1 + 2 * 3 / 4");
		assertEquals("Failed value", 2, e.value());
	}

	@Test
	public void testFailedOneOfThreeMethodsAgain() {
		Expression e1 = new Expression("1 + 2");
		assertEquals("1 + 2", e1.infix());
		assertEquals("1 2 +", e1.postfix());
		assertEquals(3, e1.value());
	}

	@Test
	public void testFailedOneOfThreeMethods() {
		Expression e = new Expression("( 3 + 4 ) * ( 5 - 6 ) / 7");
		assertEquals("( 3 + 4 ) * ( 5 - 6 ) / 7", e.infix());
		assertEquals("3 4 + 5 6 - * 7 /", e.postfix());
		assertEquals(-1, e.value());
	}

}