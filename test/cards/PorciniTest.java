package cards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class PorciniTest {
	static Porcini pd;
	
	@BeforeAll
	public static void setUp() {
		 pd = new Porcini(CardType.DAYMUSHROOM);
	}
	
	@Test
	public void testFlavourDay() {
		assertEquals(pd.getFlavourPoints(),3);
	}
	
	@Test
	public void testSticksDay() {
		assertEquals(pd.getSticksPerMushroom(),3);
	}
}
