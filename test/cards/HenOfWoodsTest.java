package cards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class HenOfWoodsTest {
	static HenOfWoods hwd;
	
	@BeforeAll
	public static void setUp() {
		hwd = new HenOfWoods(CardType.DAYMUSHROOM);
	}
	
	@Test
	public void testFlavourDay() {
		assertEquals(hwd.getFlavourPoints(),3);
	}
	
	@Test
	public void testSticksDay() {
		assertEquals(hwd.getSticksPerMushroom(),1);
	}

}
