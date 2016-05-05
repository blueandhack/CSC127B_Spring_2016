
/*
 * CSc 127B Spring 2016, Project 12
 *
 * Project Name: ProbText
 *
 * SL Letter: C 
 * Author: Yujia Lin 
 * SL Name: Cody Jensen
 *
 * ---
 * A unit test for OrderedMap<K,V> that has tests for get, put, and containsKey.
 * One @Test demonstrates how to map an nGram to a List<Character>
 * 
 * @author Rick Mercer and Yujia Lin
 */

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class OrderedMapTest {

	// test four methods
	@Test
	public void showAllFourMethods() {
		OrderedMap<Integer, String> ranking = new OrderedMap<Integer, String>();
		assertEquals(0, ranking.size());

		assertNull(ranking.put(1, "Kim"));
		ranking.put(2, "Chris");
		ranking.put(3, "Devon");

		assertEquals(3, ranking.size());

		assertEquals("Devon", ranking.put(3, "Dakota"));
		assertEquals(3, ranking.size());
		assertNull(ranking.get(99));

		assertEquals("Kim", ranking.get(1));
		assertEquals("Chris", ranking.get(2));
		assertNotNull("Dakota", ranking.get(3));

		assertFalse(ranking.containsKey(-99));
		assertTrue(ranking.containsKey(1));
	}

	// test NGram as the key and list as the value
	@Test
	public void showNGramAsTheKeyAndListAsTheValue() {
		String nGram = "the";

		ArrayList<Character> followers = new ArrayList<Character>();
		followers.add('m');
		followers.add(' ');
		followers.add('n');

		OrderedMap<String, ArrayList<Character>> map = new OrderedMap<>();
		map.put(nGram, followers);
		assertEquals(3, map.get(nGram).size());
		assertEquals('m', (char) map.get(nGram).get(0));
		assertEquals('n', (char) map.get(nGram).get(2));
		map.get(nGram).add('r');
		assertEquals('r', (char) map.get(nGram).get(3));
	}

	// test when map is empty
	@Test
	public void testEmptyMap() {
		OrderedMap<String, ArrayList<Character>> map = new OrderedMap<>();
		assertFalse(map.containsKey("a"));
		assertNull(map.get("a"));
	}

	// test put, get and containsKey methods
	@Test
	public void testPutGetAndContainsKey() {
		OrderedMap<Integer, String> ranking = new OrderedMap<Integer, String>();
		assertEquals(0, ranking.size());
		assertNull(ranking.put(1, "Kim"));
		ranking.put(3, "Chris");
		ranking.put(2, "Devon");
		assertEquals(3, ranking.size());
		assertEquals("Devon", ranking.put(2, "Dakota"));
		ranking.put(8, "ASU");
		ranking.put(5, "UofA");
		assertEquals(5, ranking.size());
		assertEquals("UofA", ranking.get(5));
		assertTrue(ranking.containsKey(5));
	}
}