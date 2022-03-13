package cards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class LawyersWigTest {
	static LawyersWig lwd;
	
	@BeforeAll
	public static void setUp() {
		 lwd = new LawyersWig(CardType.DAYMUSHROOM);
	}
	
	@Test
	public void testFlavourDay() {
		assertEquals(lwd.getFlavourPoints(),2);
	}
	
	@Test
	public void testSticksDay() {
		assertEquals(lwd.getSticksPerMushroom(),1);
	}
}
