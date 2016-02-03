/*
 * CSc 127B Spring 2016, Project 04
 *
 * Project Name: GuitarString
 *
 * SL Letter: C 
 * Author: Yujia Lin 
 * SL Name: Cody Jensen
 *
 * ---
 * The class is a test class. It tests ArrayQueue class, and it checks every situation.
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class GuitarStringTest {

	// Test create GuitarString object, then test some methods.
	@Test
	public void testToShowMostMethods() {
		double[] init = { 0.4, 0.2, -0.1 };

		GuitarString gs = new GuitarString(init);
		assertEquals(3, gs.getCapacity());

		assertEquals(0.4, gs.sample(), 0.0001);
		assertEquals(0, gs.time());

		gs.tic(); // Apply the Karplus-Strong update.

		assertEquals(1, gs.time());
		assertEquals(0.2, gs.sample(), 0.0001);

		gs.tic();
		assertEquals(-0.1, gs.sample(), 0.0001);

		gs.tic(); // See the first once that was multiplied by the factor
		assertEquals(0.2988, gs.sample(), 0.0001);
	}

	// Test some methods with pluck method, but we can not predict result.
	@Test
	public void testToMethods() {

		GuitarString gs = new GuitarString(100.0);
		assertEquals(441, gs.getCapacity());
		assertEquals(0.0, gs.sample(), 0.0001);
		gs.pluck();

		double[] init = { 0.4, 0.2, -0.1 };

		gs = new GuitarString(init);
		assertEquals(3, gs.getCapacity());

	}

	// Test other constructor
	@Test
	public void testToMethodsTwo() {

		GuitarString gs = new GuitarString(99999999.0); // It will create a
														// object, it just has
														// one capacity.
		assertEquals(1, gs.getCapacity());

	}

}