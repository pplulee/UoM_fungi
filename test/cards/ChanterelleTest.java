package cards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class ChanterelleTest {
	static Chanterelle cd;
	
	@BeforeAll
	public static void setUp() {
		 cd = new Chanterelle(CardType.DAYMUSHROOM);
	}
	
	@Test
	public void testFlavourDay() {
		assertEquals(cd.getFlavourPoints(),4);
	}
	
	@Test
	public void testSticksDay() {
		assertEquals(cd.getSticksPerMushroom(),2);
	}

}
