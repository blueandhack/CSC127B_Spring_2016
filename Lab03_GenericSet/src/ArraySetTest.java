import static org.junit.Assert.*;

import org.junit.Test;

public class ArraySetTest {

	@Test
	public void test() {
		GenericSet set = new ArraySet();
		assertTrue(set.isEmpty());
		assertEquals(0, set.size());
		assertFalse(set.contains(123));
		set.add(123);
		assertFalse(set.isEmpty());
		assertEquals(1, set.size());
		assertTrue(set.contains(123));
		set.add("Can add any type");
	}

}
