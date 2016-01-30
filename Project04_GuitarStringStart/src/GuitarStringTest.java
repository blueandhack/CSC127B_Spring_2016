import static org.junit.Assert.*;

import org.junit.Test;

public class GuitarStringTest {

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
  
  // TODO: Add more tests

  // More @Tests needed here.  No exception test are needed in this project

}