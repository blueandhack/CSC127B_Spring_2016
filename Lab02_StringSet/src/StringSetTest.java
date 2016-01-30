import static org.junit.Assert.*;

import org.junit.Test;

public class StringSetTest {

	@Test
	public void testInsertInOrderWithToString() {
		StringSet set = new StringSet();
		assertEquals("[]", set.toString());
		set.insertInOrder("C");
		assertEquals("[C]", set.toString());
		set.insertInOrder("Gee");
		assertEquals("[C, Gee]", set.toString());
		set.insertInOrder("B");
		assertEquals("[B, C, Gee]", set.toString());
		assertTrue(set.insertInOrder("A"));
		assertEquals("[A, B, C, Gee]", set.toString());
		assertTrue(set.insertInOrder("65"));
		assertEquals("[65, A, B, C, Gee]", set.toString());
	}

	@Test
	public void testIsEmptyWithToString() {
		StringSet set = new StringSet();
		assertTrue(set.isEmpty());

		set.insertInOrder("C");

		assertFalse(set.isEmpty());
	}

	@Test
	public void testSize() {
		StringSet set = new StringSet();
		set.insertInOrder("C");
		set.insertInOrder("Gee");
		set.insertInOrder("B");
		assertTrue(set.insertInOrder("A"));
		assertTrue(set.insertInOrder("65"));

		assertEquals(5, set.size());
	}

	@Test
	public void testContains() {
		StringSet set = new StringSet();
		set.insertInOrder("C");
		set.insertInOrder("Gee");
		set.insertInOrder("B");
		assertTrue(set.insertInOrder("A"));
		assertTrue(set.insertInOrder("65"));

		assertTrue(set.contains("A"));
		assertFalse(set.contains("Z"));

	}

	@Test
	public void testRemoveWithToString() {
		StringSet set = new StringSet();
		set.insertInOrder("C");
		set.insertInOrder("Gee");
		set.insertInOrder("B");
		assertTrue(set.insertInOrder("A"));
		assertTrue(set.insertInOrder("65"));
		assertFalse(set.insertInOrder("65"));
		assertFalse(set.insertInOrder("65"));
		assertFalse(set.insertInOrder("65"));
		assertFalse(set.insertInOrder("A"));

		assertTrue(set.remove("65"));
		assertEquals("[A, B, C, Gee]", set.toString());
		assertTrue(set.remove("B"));
		assertEquals("[A, C, Gee]", set.toString());
		assertTrue(set.remove("Gee"));
		assertEquals("[A, C]", set.toString());
		assertFalse(set.remove("XXXX"));

	}

	@Test
	public void testUnion() {
		StringSet set = new StringSet();
		StringSet set2 = new StringSet();
		set.insertInOrder("C");
		set.insertInOrder("C");
		set.insertInOrder("O");

		StringSet set1 = new StringSet();
		set1.insertInOrder("A");
		set1.insertInOrder("C");

		set2 = set.union(set1);

		assertEquals(3, set2.size());

	}

	@Test
	public void testUnionTwo() {
		StringSet set = new StringSet();
		StringSet set2 = new StringSet();
		set.insertInOrder("C");
		set.insertInOrder("C");
		set.insertInOrder("O");

		StringSet set1 = new StringSet();
		set1.insertInOrder("A");
		set1.insertInOrder("C");
		set1.insertInOrder("R");

		set2 = set.union(set1);

		assertEquals(4, set2.size());

	}


}