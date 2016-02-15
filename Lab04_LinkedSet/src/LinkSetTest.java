import static org.junit.Assert.*;

import org.junit.Test;



public class LinkSetTest {

  @Test
  public void test_addLast_size_toString_and_contains() {
    // class LinkedSet needs a type parameter like <E>
    // Constructor takes zero arguments.
    LinkedSet<String> listA = new LinkedSet<String>();

    // Size returns the number of unique elements in this set
    assertEquals(0, listA.size());

    // addLast places the element at the end of the list
    listA.addLast("A");
    assertEquals(1, listA.size());
    listA.addLast("B");
    assertEquals(2, listA.size());
    listA.addLast("C");
    assertEquals(3, listA.size());
    
    // toString returns all elements with a space between.  Would be good to trim the final space.
    assertEquals("A B C", listA.toString().trim());

    // contains returns true if the argument is in this set or false if element is not found
    assertTrue(listA.contains("A"));
    assertTrue(listA.contains("B"));
    assertTrue(listA.contains("C"));
    assertFalse(listA.contains("Not Here"));
    assertFalse(listA.contains("a"));
    assertFalse(listA.contains("c"));
  }

  @Test
  public void test_addLast_size_and_toString_with_attempt_to_add_duplicates() {
    LinkedSet<String> listA = new LinkedSet<String>();
    listA.addLast("A");
    listA.addLast("B");
    listA.addLast("C");
    assertEquals(3, listA.size());
    assertEquals("A B C", listA.toString().trim());

    // try adding the same three elements two more times
    listA.addLast("A");
    listA.addLast("A");
    listA.addLast("B");
    listA.addLast("B");
    listA.addLast("C");
    listA.addLast("C");

    // The size and toString should be the same
    assertEquals("A B C", listA.toString().trim());
    assertEquals(3, listA.size());
    
  }

}