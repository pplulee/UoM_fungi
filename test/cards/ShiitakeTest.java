package cards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;


public class ShiitakeTest {
	static Shiitake sd;
	
	@BeforeAll
	public static void setUp() {
		 sd = new Shiitake(CardType.DAYMUSHROOM);
	}
	
	@Test
	public void testFlavourDay() {
		assertEquals(sd.getFlavourPoints(),2);
	}
	
	@Test
	public void testSticksDay() {
		assertEquals(sd.getSticksPerMushroom(),2);
	}
}
