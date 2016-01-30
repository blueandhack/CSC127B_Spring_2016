import static org.junit.Assert.*;

import org.junit.Test;

public class PiggyBankTest {

	  @Test
	  public void testGetters() {
	    PiggyBank oinky = new PiggyBank();
	    assertEquals(0, oinky.getTotalNumberOfCoins());
	    assertEquals(0, oinky.getTotalCashInBank(), 0.00001);
	    oinky.addDimes(10);
	    oinky.addNickels(10);
	    oinky.addPennies(10);
	    assertEquals(10*(0.1+0.01+0.05), oinky.getTotalCashInBank(),0.00001);
	    assertEquals(30, oinky.getTotalNumberOfCoins());
	    oinky.addDimes(100);
	    assertEquals(130, oinky.getTotalNumberOfCoins());
	    oinky.drainTheBank();
	    assertEquals(0, oinky.getTotalNumberOfCoins());
	    assertEquals(0, oinky.getTotalCashInBank(), 0.00001);
	  } 
	  // More @Test methods need here ...  Think at least one @Test method to test each method.
	
}
