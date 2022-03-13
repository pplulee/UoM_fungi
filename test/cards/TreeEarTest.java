package cards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class TreeEarTest {

	static TreeEar ted;
	
	@BeforeAll
	public static void setUp() {
		 ted = new TreeEar(CardType.DAYMUSHROOM);
	}
	
	@Test
	public void testFlavourDay() {
		assertEquals(ted.getFlavourPoints(),1);
	}
	
	@Test
	public void testSticksDay() {
		assertEquals(ted.getSticksPerMushroom(),2);
	}

	
}
