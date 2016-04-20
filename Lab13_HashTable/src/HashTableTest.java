import static org.junit.Assert.*;

import org.junit.Test;

public class HashTableTest {

	@Test
	public void testPutAndGetWithNodeCollisions() {
		HashTable<Integer, String> map = new HashTable<>();

		assertNull(map.put(1, "Arizona"));
		assertNull(map.put(5, "Penn State"));
		assertNull(map.put(998, "ASU"));
		// Assuming 10 lists of lists, collisions occur
		assertNull(map.put(15, "Collision One"));
		assertNull(map.put(11, "Collision Two"));
		assertNull(map.put(10001, "Collision Tre"));
		// System.out.println(map);

		assertEquals("ASU", map.get(998));
		assertEquals("Arizona", map.get(1));
		assertNull(map.get(2));
	}
}
