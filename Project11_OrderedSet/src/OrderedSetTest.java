
/*
 * CSc 127B Spring 2016, Project 11
 *
 * Project Name: OrderedSet
 *
 * SL Letter: C 
 * Author: Yujia Lin 
 * SL Name: Cody Jensen
 *
 * ---
 * The class is a test cases for OrderedSet
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class OrderedSetTest {

	// test insert
	@Test
	public void testInsertSizeAndTostringinorder() {
		OrderedSet<String> bst = new OrderedSet<String>();
		assertEquals("", bst.toStringInorder());
		assertTrue(bst.insert("d"));
		assertTrue(bst.insert("b"));
		assertTrue(bst.insert("e"));
		assertFalse(bst.insert("e"));
		assertTrue(bst.insert("a"));
		assertEquals(4, bst.size());
		assertEquals("a b d e", bst.toStringInorder());
		assertTrue(bst.contains("a"));
		assertFalse(bst.contains("f"));
		assertEquals("e", bst.max());
		assertEquals(1, bst.nodesAtLevel(0));
		assertEquals(2, bst.nodesAtLevel(1));
		assertEquals(1, bst.nodesAtLevel(2));
	}

	// test subset
	@Test
	public void testSubSet() {

		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(50);
		bst.insert(25);
		bst.insert(12);
		bst.insert(75);
		bst.insert(65);
		bst.insert(90);
		assertEquals("12 25 50 65 75 90", bst.toStringInorder());
		assertEquals("12 25", bst.subset(1, 49).toStringInorder());
		assertEquals("25 50 65", bst.subset(25, 75).toStringInorder());
		assertEquals("", bst.subset(12, 12).toStringInorder());
	}

	// test bst is null
	@Test
	public void testBSTisNull() {
		OrderedSet<Integer> bstOne = new OrderedSet<Integer>();
		assertEquals(null, bstOne.max());
		assertEquals(0, bstOne.nodesAtLevel(0));
	}

	// test intersection
	@Test
	public void testIntersection() {
		OrderedSet<Integer> bstOne = new OrderedSet<Integer>();
		bstOne.insert(50);
		bstOne.insert(25);
		bstOne.insert(12);
		bstOne.insert(75);
		bstOne.insert(65);
		bstOne.insert(90);
		OrderedSet<Integer> bstTwo = new OrderedSet<Integer>();
		bstTwo.insert(50);
		bstTwo.insert(25);
		bstTwo.insert(12);
		bstTwo.insert(33);
		bstTwo.insert(22);
		bstTwo.insert(88);
		OrderedSet<Integer> bstThree = bstOne.intersection(bstTwo);
		assertEquals("12 25 50", bstThree.toStringInorder());
	}

	// test union
	@Test
	public void testUnion() {
		OrderedSet<Integer> bstOne = new OrderedSet<Integer>();
		bstOne.insert(50);
		bstOne.insert(25);
		bstOne.insert(12);
		bstOne.insert(75);
		bstOne.insert(65);
		bstOne.insert(90);
		OrderedSet<Integer> bstTwo = new OrderedSet<Integer>();
		bstTwo.insert(50);
		bstTwo.insert(25);
		bstTwo.insert(12);
		bstTwo.insert(33);
		bstTwo.insert(22);
		bstTwo.insert(88);
		OrderedSet<Integer> bstThree = bstOne.union(bstTwo);
		assertEquals("12 22 25 33 50 65 75 88 90", bstThree.toStringInorder());
	}

	// test sameStructure
	@Test
	public void testSameStructure() {
		OrderedSet<String> bstOne = new OrderedSet<String>();
		bstOne.insert("M");
		bstOne.insert("B");
		bstOne.insert("R");
		bstOne.insert("F");
		bstOne.insert("Z");

		OrderedSet<String> bstTwo = new OrderedSet<String>();
		bstTwo.insert("P");
		bstTwo.insert("F");
		bstTwo.insert("Q");
		bstTwo.insert("J");
		bstTwo.insert("R");
		assertTrue(bstOne.sameStructure(bstTwo));
	}

	// test sameStructure one
	@Test
	public void testNotSameStructure() {
		OrderedSet<String> bstOne = new OrderedSet<String>();
		bstOne.insert("M");
		bstOne.insert("B");
		bstOne.insert("R");
		bstOne.insert("F");
		bstOne.insert("Z");

		OrderedSet<String> bstTwo = new OrderedSet<String>();
		bstTwo.insert("M");
		bstTwo.insert("B");
		bstTwo.insert("Z");
		bstTwo.insert("F");
		bstTwo.insert("R");
		assertFalse(bstOne.sameStructure(bstTwo));
	}

	// test sameStructure two
	@Test
	public void testNotSameStructureTwo() {
		OrderedSet<String> bstOne = new OrderedSet<String>();
		bstOne.insert("M");
		bstOne.insert("B");
		bstOne.insert("R");
		bstOne.insert("F");
		bstOne.insert("Z");

		OrderedSet<String> bstTwo = new OrderedSet<String>();
		bstTwo.insert("M");
		bstTwo.insert("B");
		bstTwo.insert("Z");
		bstTwo.insert("F");
		assertFalse(bstOne.sameStructure(bstTwo));
	}

	// test sameStructure three
	@Test
	public void testNotSameStructureThree() {
		OrderedSet<String> bstOne = new OrderedSet<String>();
		bstOne.insert("M");
		bstOne.insert("B");
		bstOne.insert("Z");
		bstOne.insert("F");
		bstOne.insert("R");

		OrderedSet<String> bstTwo = new OrderedSet<String>();

		bstTwo.insert("M");
		bstTwo.insert("B");
		bstTwo.insert("R");
		bstTwo.insert("F");
		bstTwo.insert("Z");
		assertFalse(bstOne.sameStructure(bstTwo));
	}

	// test remove when element not found
	@Test
	public void testRemoveWhenElementNotFound() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(50);
		bst.insert(25);
		bst.insert(12);
		bst.insert(75);
		bst.insert(65);
		bst.insert(90);
		assertFalse(bst.remove(44));
		assertEquals("12 25 50 65 75 90", bst.toStringInorder());
	}

	// test remove root
	@Test
	public void testRemoveWhenRootRemovedWithNoLeftChild() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(50);
		bst.insert(70);
		bst.insert(61);
		bst.insert(99);
		assertTrue(bst.remove(50));
		assertEquals("61 70 99", bst.toStringInorder());
	}

	// test remove empty
	@Test
	public void testRemoveWhenEmpty() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		assertFalse(bst.remove(44));
		assertEquals("", bst.toStringInorder());
	}

	// test remove when not root not left child
	@Test
	public void testRemoveWhenNotRootNoLeftChildOne() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(51);
		bst.insert(23);
		bst.insert(10);
		bst.insert(62);
		bst.insert(81);
		bst.insert(97);
		bst.insert(99);
		bst.insert(100);
		bst.insert(200);
		assertTrue(bst.remove(97));
		assertEquals("10 23 51 62 81 99 100 200", bst.toStringInorder());
	}

	// test remove when not root not left child
	@Test
	public void testRemoveWhenNotRootNoLeftChildTwo() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(51);
		bst.insert(23);
		bst.insert(9);
		bst.insert(70);
		bst.insert(80);
		bst.insert(77);
		bst.insert(79);
		assertTrue(bst.remove(77));
		assertEquals("9 23 51 70 79 80", bst.toStringInorder());
		assertFalse(bst.remove(1));
	}

	// test remove when root and left child
	@Test
	public void testRemoveWhenRootAndLeftChild() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(51);
		bst.insert(22);
		bst.insert(9);
		bst.insert(73);
		bst.insert(100);
		bst.insert(78);
		bst.insert(79);
		assertTrue(bst.remove(51));
		assertEquals("9 22 73 78 79 100", bst.toStringInorder());
	}

	// test remove when not root and left child
	@Test
	public void testRemoveWhenNotRootAndLeftChildOne() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(51);
		bst.insert(26);
		bst.insert(31);
		bst.insert(76);
		bst.insert(81);
		bst.insert(96);
		bst.insert(100);
		bst.insert(86);
		bst.insert(83);
		bst.insert(91);
		bst.insert(88);
		assertTrue(bst.remove(96));
		assertEquals("26 31 51 76 81 83 86 88 91 100", bst.toStringInorder());
		assertTrue(bst.remove(100));
		assertEquals("26 31 51 76 81 83 86 88 91", bst.toStringInorder());
		assertTrue(bst.remove(51));
		assertEquals("26 31 76 81 83 86 88 91", bst.toStringInorder());
		assertTrue(bst.remove(81));
		assertEquals("26 31 76 83 86 88 91", bst.toStringInorder());
	}

	// test remove when not root and left child
	@Test
	public void testRemoveWhenNotRootAndLeftChildTwo() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(51);
		bst.insert(26);
		bst.insert(31);
		bst.insert(77);
		bst.insert(80);
		bst.insert(92);
		bst.insert(100);
		bst.insert(85);
		bst.insert(82);
		assertTrue(bst.remove(92));
		assertEquals("26 31 51 77 80 82 85 100", bst.toStringInorder());
		assertTrue(bst.remove(77));
		assertEquals("26 31 51 80 82 85 100", bst.toStringInorder());
	}

}
