package board;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class ForestTest {
	public Board f;
	
	@Before
	public void setUpForest() {
		f = new Board();
		f.initialisePiles();
	}

	@Test
	public void numberOfDayMushroomCardsBeforeCardSetUp() {
		assertEquals(f.getForestCardsPile().pileSize(),0);
	}

	@Test
	public void numberOfDayMushroomCardsAfterCardSetUp() {
		f.setUpCards();
		assertEquals(f.getForestCardsPile().pileSize(),79);
	}
}