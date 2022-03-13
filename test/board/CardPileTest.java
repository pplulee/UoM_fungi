package board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cards.CardType;
import cards.HoneyFungus;
import cards.LawyersWig;
import cards.Shiitake;
import cards.TreeEar;

public class CardPileTest{
	CardPile cp1,cp2;

	@Before
	public void setUp() throws Exception {
		 cp1 = new CardPile();
		 cp2 = new CardPile();

		 HoneyFungus hf1 = new HoneyFungus(CardType.DAYMUSHROOM);
		 HoneyFungus hf2 = new HoneyFungus(CardType.DAYMUSHROOM);
		 TreeEar te3 = new TreeEar(CardType.DAYMUSHROOM);
		 TreeEar te4 = new TreeEar(CardType.DAYMUSHROOM);
		 LawyersWig lw5 = new LawyersWig(CardType.DAYMUSHROOM);
		 cp1.addCard(hf1);cp2.addCard(hf1);
		 cp1.addCard(hf2);cp2.addCard(hf2);
		 cp1.addCard(te3);cp2.addCard(te3);
		 cp1.addCard(te4);cp2.addCard(te4);
		 cp1.addCard(lw5);cp2.addCard(lw5);
	}

	@Test
	public void testAddCardEquals() {
		Shiitake s = new Shiitake(CardType.DAYMUSHROOM);
		cp1.addCard(s);
		assertEquals(s,cp1.drawCard());
	}

	@Test
	public void testAddCardNonEquals() {
		Shiitake s1 = new Shiitake(CardType.DAYMUSHROOM);
		Shiitake s2 = new Shiitake(CardType.DAYMUSHROOM);
		cp1.addCard(s1);
		assertNotEquals(s2,cp1.drawCard());
	}

	@Test
	public void testAddCardIncreasesSize() {
		Shiitake s1 = new Shiitake(CardType.DAYMUSHROOM);
		int sizeBefore = cp1.pileSize();
		cp1.addCard(s1);
		int sizeAfter = cp1.pileSize();
		assertEquals(sizeBefore+1,sizeAfter);
	}

	@Test
	public void testDrawCardReducesSize() {
		int sizeBefore = cp1.pileSize();
		cp1.drawCard();
		int sizeAfter = cp1.pileSize();
		assertEquals(sizeBefore,sizeAfter+1);
	}

	//Tests if two piles are different after shuffling
	@Test
	public void testNotShuffledPile() {
		boolean same = true;
		while (!cp1.isEmpty()) {
			if (!cp1.drawCard().equals(cp2.drawCard())) {
				same = false;
				break;
			}
		}
		assertTrue(same);
	}

	//Tests if two piles are different after shuffling. This is to check shuffling works
	@Test
	public void testShuffledPile() {
		boolean same = true;
		cp1.shufflePile();cp2.shufflePile();
		while (!cp1.isEmpty()) {
			if (!cp1.drawCard().equals(cp2.drawCard())) {
				same = false;
				break;
			}
		}
		assertFalse("Shuffling piles randomizes the card order",same);
	}

	@Test
	public void testPileSizeEquals() {
		assertEquals(cp1.pileSize(),5);
	}

	@Test
	public void testPileSizeNotEqualsAfterDrawing() {
		cp1.drawCard();cp1.drawCard();
		assertEquals(cp1.pileSize(),3);
	}

}
