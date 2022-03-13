package board;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cards.Basket;
import cards.BirchBolete;
import cards.Butter;
import cards.Card;
import cards.CardType;
import cards.Chanterelle;
import cards.Cider;
import cards.HenOfWoods;
import cards.HoneyFungus;
import cards.Morel;
import cards.Pan;
import cards.Porcini;
import cards.Shiitake;

public class PlayerTest {
	
	private CardList fst;
	private static Player p;
	private static ArrayList<Card> cookingCards=new ArrayList<Card>();
	
	@BeforeEach
	public void setUpBefore(){
		Board.initialisePiles();
		fst = Board.getForest();
		p = new Player();
		p.getDisplay().removeElement(0);//remove the default pan
		Board.getDecayPile().clear();
		cookingCards.clear();
	}	
	public void setUpDisplay() {
		cookingCards.add(new Pan());
	}
	public void ccSetUp1() {
		cookingCards.add(new Morel(CardType.DAYMUSHROOM));
	}
	public void ccSetUp2() {
		cookingCards.add(new Morel(CardType.DAYMUSHROOM));
		cookingCards.add(new Morel(CardType.DAYMUSHROOM));
	}
	public void ccSetUp3() {
		cookingCards.add(new Morel(CardType.DAYMUSHROOM));
		cookingCards.add(new Morel(CardType.DAYMUSHROOM));
		cookingCards.add(new BirchBolete(CardType.DAYMUSHROOM));		
	}	
	public void ccSetUp4() {//1 flavour points
		cookingCards.add(new HoneyFungus(CardType.DAYMUSHROOM));
		cookingCards.add(new HoneyFungus(CardType.DAYMUSHROOM));
		cookingCards.add(new HoneyFungus(CardType.DAYMUSHROOM));		
	}
	public void ccSetUp5() {//2 flavour points
		cookingCards.add(new Shiitake(CardType.DAYMUSHROOM));
		cookingCards.add(new Shiitake(CardType.DAYMUSHROOM));
		cookingCards.add(new Shiitake(CardType.DAYMUSHROOM));		
	}
	public void ccSetUp6() {//3 flavour points
		cookingCards.add(new BirchBolete(CardType.DAYMUSHROOM));
		cookingCards.add(new BirchBolete(CardType.DAYMUSHROOM));
		cookingCards.add(new BirchBolete(CardType.DAYMUSHROOM));		
	}
	public void ccSetUp7() {//4 flavour points
		cookingCards.add(new Morel(CardType.DAYMUSHROOM));
		cookingCards.add(new Morel(CardType.DAYMUSHROOM));
		cookingCards.add(new Morel(CardType.DAYMUSHROOM));		
	}
	public void ccSetUp8() {
		cookingCards.add(new Morel(CardType.DAYMUSHROOM));
		cookingCards.add(new BirchBolete(CardType.DAYMUSHROOM));
		cookingCards.add(new Shiitake(CardType.DAYMUSHROOM));		
	}
	
	public void ccSetUp9() {		
		cookingCards.add(new BirchBolete(CardType.DAYMUSHROOM));
		cookingCards.add(new BirchBolete(CardType.NIGHTMUSHROOM));
	}
	public void ccSetUp10() {		
		cookingCards.add(new BirchBolete(CardType.NIGHTMUSHROOM));
		cookingCards.add(new BirchBolete(CardType.DAYMUSHROOM));
		cookingCards.add(new BirchBolete(CardType.DAYMUSHROOM));
	}
	
	public void ccSetUp11() {		
		cookingCards.add(new Chanterelle(CardType.DAYMUSHROOM));
		cookingCards.add(new Chanterelle(CardType.DAYMUSHROOM));
		cookingCards.add(new Chanterelle(CardType.DAYMUSHROOM));
	}
	
	public void forestSetUp1() {
		fst.add(new Morel(CardType.DAYMUSHROOM));fst.add(new Morel(CardType.DAYMUSHROOM));
		fst.add(new Morel(CardType.DAYMUSHROOM));fst.add(new Morel(CardType.DAYMUSHROOM));
		fst.add(new Morel(CardType.DAYMUSHROOM));fst.add(new Morel(CardType.DAYMUSHROOM));
		fst.add(new Morel(CardType.DAYMUSHROOM));fst.add(new Morel(CardType.DAYMUSHROOM));
	}
	
	public void forestSetUp2() {
		fst.add(new Basket());fst.add(new Basket());fst.add(new Basket());fst.add(new Basket());		
		fst.add(new Basket());fst.add(new Basket());fst.add(new Basket());fst.add(new Basket());
	}
	
	public void playerSetUp1() {//6 diverse cards
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new BirchBolete(CardType.DAYMUSHROOM));
		p.addCardtoHand(new BirchBolete(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Porcini(CardType.DAYMUSHROOM));
	}
	
	public void playerSetUp2() {//5 cards
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
	}
	
	public void playerSetUp3() {
		p.addSticks(5);
	}
	public void playerSetUp4() {
		p.addSticks(1);
	}
	public void playerSetUp5() {//8 cards
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
	}
	
	public void playerSetUp6() {//4 cards
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
	}
	public void playerSetUp7() {//one pan
		p.addCardtoHand(new Pan());
	}
	
	public void playerSetUp8() {//8 cards
		p.addCardtoHand(new Porcini(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Porcini(CardType.DAYMUSHROOM));
		p.addCardtoHand(new HenOfWoods(CardType.DAYMUSHROOM));
		p.addCardtoHand(new HenOfWoods(CardType.DAYMUSHROOM));
		p.addCardtoHand(new BirchBolete(CardType.DAYMUSHROOM));
		p.addCardtoHand(new BirchBolete(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
	}
	public void playerSetUp10() {//8 cards
		p.addCardtoHand(new Porcini(CardType.NIGHTMUSHROOM));
		p.addCardtoHand(new Porcini(CardType.DAYMUSHROOM));
		p.addCardtoHand(new HenOfWoods(CardType.NIGHTMUSHROOM));
		p.addCardtoHand(new HenOfWoods(CardType.DAYMUSHROOM));
		p.addCardtoHand(new BirchBolete(CardType.NIGHTMUSHROOM));
		p.addCardtoHand(new BirchBolete(CardType.DAYMUSHROOM));
	}
	public void playerSetUp11() {//8 cards
		p.addCardtoHand(new Porcini(CardType.NIGHTMUSHROOM));
		p.addCardtoHand(new HenOfWoods(CardType.NIGHTMUSHROOM));
		p.addCardtoHand(new BirchBolete(CardType.NIGHTMUSHROOM));
	}
	
	
	public void setUpDecay_1() {
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------
	// takeFromTheForest tests: 
	// (1) take more sticks than you can return; 
	// (2) consider the first two when taking instead of starting from 3; 
	// (3) check the number of sticks once used; 
	// (4) check the hand contains an extra card 
	// (5) check the display contains an extra basket
	// (6) check the addition of basket increases the hand size

	@ParameterizedTest
	@ValueSource(ints = {1, 2}) // feet with no sticks 
	public void takeFromForest_position12(int n){
		forestSetUp1();
		assertTrue(p.takeCardFromTheForest(n));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {3, 4, 5, 7, 8}) // deep forest with no sticks
	public void takeFromForest_position3to8(int n){
		forestSetUp1();
		assertFalse(p.takeCardFromTheForest(n));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2}) // feet with 5 sticks 
	public void takeFromForest_position12_5sticks(int n){
		forestSetUp1();
		playerSetUp3();
		assertTrue(p.takeCardFromTheForest(n));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {3, 4, 5, 6, 7}) // deep forest with 5 sticks
	public void takeFromForest_position3to7_5sticks(int n){
		forestSetUp1();
		playerSetUp3();
		assertTrue(p.takeCardFromTheForest(n));
	}
	
	@Test
	public void takeFromForest_position3to7_5sticks(){//5 sticks when you need 6
		forestSetUp1();
		playerSetUp3();
		assertFalse(p.takeCardFromTheForest(8));
	}
	
	@Test
	public void takeFromForest_position3_1stick(){//deep forest with one stick
		forestSetUp1();
		playerSetUp4();
		assertTrue(p.takeCardFromTheForest(3));
	}
	
	// (3) check the number of sticks once used;
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 4, 5, 6, 7, 8}) // check the number of sticks when not used due to feet or not able to tale
	public void takeFromForest_position1to8_1stick_checksticks(int n){
		forestSetUp1();
		playerSetUp4();
		int sticksBefore = p.getStickNumber();
		p.takeCardFromTheForest(n);
		int sticksLater = p.getStickNumber();
		assertEquals(sticksBefore,sticksLater);
	}
	
	@Test
	public void takeFromForest_position3_1stick_checksticks(){// check the number of sticks when using one
		forestSetUp1();
		playerSetUp4();
		int sticksBefore = p.getStickNumber();
		p.takeCardFromTheForest(3);
		int sticksLater = p.getStickNumber();
		assertEquals(sticksBefore,sticksLater+1);
	}	
	
	@ParameterizedTest
	@ValueSource(ints = {3, 4, 5, 6, 7}) // check the number of sticks when having more than 5 on fores
	public void takeFromForest_37_checksticks(int n){
		forestSetUp1();
		playerSetUp3();
		int sticksBefore = p.getStickNumber();
		p.takeCardFromTheForest(n);
		int sticksLater = p.getStickNumber();
		assertEquals(sticksBefore,sticksLater+n-2);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1,2}) //  check the number of sticks when having more than 5 on feet
	public void takeFromForest_12_checksticks(int n){
		forestSetUp1();
		playerSetUp3();
		int sticksBefore = p.getStickNumber();
		p.takeCardFromTheForest(n);
		int sticksLater = p.getStickNumber();
		assertEquals(sticksBefore,sticksLater);
	}
	
	// (4) check the hand contains an extra card on success
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})//on success 
	public void takeFromForest_17_checkhand(int n){
		forestSetUp1();
		playerSetUp3();
		int handSizeBefore = p.getHand().size();
		p.takeCardFromTheForest(n);
		int handSizeAfter = p.getHand().size();
		assertEquals(handSizeBefore,handSizeAfter-1);
	}
	@ParameterizedTest
	@ValueSource(ints = {1, 2})//on success basket goes to display
	public void takeFromForest_12_checkdisplay_basket(int n){
		forestSetUp2();//8 baskets
		playerSetUp3();//5 sticks
		int displaySizeBefore = p.getDisplay().size();
		p.takeCardFromTheForest(n);
		int displaySizeAfter = p.getDisplay().size();//remove one stick but adds a basket
		assertEquals(displaySizeBefore,displaySizeAfter-1);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {3, 4, 5, 6, 7})//on success basket goes to display
	public void takeFromForest_37_checkdisplay_basket(int n){
		forestSetUp2();//8 baskets
		playerSetUp3();//5 sticks
		int displaySizeBefore = p.getDisplay().size();
		p.takeCardFromTheForest(n);
		int displaySizeAfter = p.getDisplay().size();//remove n stick but adds a basket: n-2 is the number of sticks used + 1 basket
		assertEquals(displaySizeBefore,displaySizeAfter + (n-2) -1);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})//on success basket doesn't go to hand
	public void takeFromForest_17_checkhand_basket(int n){
		forestSetUp2();
		playerSetUp3();
		int handSizeBefore = p.getHand().size();
		p.takeCardFromTheForest(n);
		int handSizeAfter = p.getHand().size();
		assertEquals(handSizeBefore,handSizeAfter);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})//on success and basket taken hand size increases +2
	public void takeFromForest_17_checkhandmaxsize_basket(int n){
		forestSetUp2();
		playerSetUp3();
		int maxHandSizeBefore = p.getHandLimit();
		p.takeCardFromTheForest(n);
		int maxHandSizeAfter = p.getHandLimit();
		assertEquals(maxHandSizeBefore,maxHandSizeAfter-2);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {3, 4, 5, 6, 7, 8})//on basket capture failure due to lack of sticks 
	public void takeFromForest_checkmaxhand_fail_nosticks_basket(int n){
		forestSetUp2();
		playerSetUp1();
		int maxHandSizeBefore = p.getHandLimit();
		p.takeCardFromTheForest(n);
		int maxHandSizeAfter = p.getHandLimit();
		assertEquals(maxHandSizeBefore,maxHandSizeAfter);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {3, 4, 5, 6, 7, 8})//on failure due to lack of sticks 
	public void takeFromForest_checkhand_fail_nosticks(int n){
		forestSetUp1();
		playerSetUp1();
		int handSizeBefore = p.getHand().size();
		p.takeCardFromTheForest(n);
		int handSizeAfter = p.getHand().size();
		assertEquals(handSizeBefore,handSizeAfter);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})//on failure due to hand size 
	public void takeFromForest_17_checkhand_fail_hsize(int n){
		forestSetUp1();
		playerSetUp3();//5 sticks
		playerSetUp5();//8 cards on hand
		int handSizeBefore = p.getHand().size();
		p.takeCardFromTheForest(n);
		int handSizeAfter = p.getHand().size();
		assertEquals(handSizeBefore,handSizeAfter);
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------
	// takeFromDecay tests and decay pile: 
	// (1) different hand limits 
	// (2) different sizes of decay pile
	// (3) Combination of (1) and (2)
	// (4) baskets on decay (1,2,3,4)
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4})//default hand limit 
	public void decayLegit_1(int n){
		playerSetUp6();//4 cards on hand
		for (int i=0; i<n;i++) {
			Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		}
		assertTrue(p.takeFromDecay());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4})//default hand limit 
	public void decayNotLegit_1(int n){
		playerSetUp5();//8 cards on hand
		for (int i=0; i<n;i++) {
			Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		}
		assertFalse(p.takeFromDecay());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {3, 4})//default hand limit 
	public void decayNotLegit_2(int n){
		playerSetUp1();//6 cards on hand
		for (int i=0; i<n;i++) {
			Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		}
		assertFalse(p.takeFromDecay());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2})//default hand limit 
	public void decayLegit_2(int n){
		playerSetUp1();//6 cards on hand
		for (int i=0; i<n;i++) {
			Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		}
		assertTrue(p.takeFromDecay());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2, 3, 4})//default hand limit 
	public void decayNotLegit_3(int n){
		playerSetUp1();//6 cards on hand
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		for (int i=0; i<n;i++) {
			Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		}
		assertFalse(p.takeFromDecay());
	}
	
	@Test//default hand limit 
	public void decayLegit_3(){
		playerSetUp1();//6 cards on hand
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		assertTrue(p.takeFromDecay());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2})
	public void decayLegit_4(int n){
		playerSetUp5();//8 cards on hand
		p.addCardtoHand(new Basket());//hand limit: 10 
		for (int i=0; i<n;i++) {
			Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		}
		assertTrue(p.takeFromDecay());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {3, 4})//default hand limit 
	public void decayNotLegit_4(int n){
		playerSetUp5();//8 cards on hand
		p.addCardtoHand(new Basket());//hand limit: 10 
		for (int i=0; i<n;i++) {
			Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		}
		assertFalse(p.takeFromDecay());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4})
	public void decayNotLegit_5(int n){
		playerSetUp5();//8 cards on hand
		p.addCardtoHand(new Basket());//hand limit: 10 
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));//10 cards 
		for (int i=0; i<n;i++) {
			Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		}
		assertFalse(p.takeFromDecay());
	}
	@ParameterizedTest
	@ValueSource(ints = {1, 2})
	public void decayLegit_5(int n){
		playerSetUp5();//8 cards on hand
		p.addCardtoHand(new Basket());p.addCardtoHand(new Basket());//hand limit: 12 
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));//10 cards 
		for (int i=0; i<n;i++) {
			Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		}
		assertTrue(p.takeFromDecay());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {3, 4})
	public void decayNotLegit_6(int n){
		playerSetUp5();//8 cards on hand
		p.addCardtoHand(new Basket());p.addCardtoHand(new Basket());//hand limit: 12 
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));//10 cards 
		for (int i=0; i<n;i++) {
			Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		}
		assertFalse(p.takeFromDecay());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4})
	public void decayWithBasketsHandLimit(int n){//check hand limit increases as baskets are taken from decay
		playerSetUp5();//8 cards on hand
		for (int i=0; i<n;i++) {
			Board.getDecayPile().add(new Basket());
		}
		p.takeFromDecay();
		assertEquals(p.getHandLimit(), 8+(n*2));
	}
	
	@Test
	public void decayWithBaskets_1(){//check hand limit increases as baskets are taken from decay
		playerSetUp5();//8 cards on hand
		Board.getDecayPile().add(new Basket());//hand limit: 10
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		assertTrue(p.takeFromDecay());
	}
	
	@Test
	public void decayWithBaskets_2(){//check hand limit increases as baskets are taken from decay
		playerSetUp5();//8 cards on hand
		Board.getDecayPile().add(new Basket());//hand limit: 10
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));//10 cards
		assertFalse(p.takeFromDecay());
	}
	
	@Test
	public void decayWithBaskets_3(){//check hand limit increases as baskets are taken from decay
		playerSetUp1();//6 cards on hand
		Board.getDecayPile().add(new Basket());//hand limit: 10
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		assertTrue(p.takeFromDecay());
	}
	
	@Test
	public void decayWithBaskets_4(){//check hand limit increases as baskets are taken from decay
		playerSetUp5();//8 cards on hand
		Board.getDecayPile().add(new Basket());//hand limit: 10
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		assertFalse(p.takeFromDecay());
	}
	//
	
	@Test
	public void decayWithBaskets_5(){//check hand limit increases as baskets are taken from decay
		playerSetUp5();//8 cards on hand
		p.addCardtoHand(new Basket());//hand limit: 10
		Board.getDecayPile().add(new Basket());//hand limit: 12
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		assertTrue(p.takeFromDecay());
	}
	
	@Test
	public void decayWithBaskets_6(){//check hand limit increases as baskets are taken from decay
		playerSetUp5();//8 cards on hand
		p.addCardtoHand(new Basket());//hand limit: 10
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));//9 cards
		Board.getDecayPile().add(new Basket());//hand limit: 12
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		assertTrue(p.takeFromDecay());
	}
	
	@Test
	public void decayWithBaskets_7(){//check hand limit increases as baskets are taken from decay
		playerSetUp5();//8 cards on hand
		p.addCardtoHand(new Basket());//hand limit: 10
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));//10 cards
		Board.getDecayPile().add(new Basket());//hand limit: 12
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		assertFalse(p.takeFromDecay());
	}
	
	@Test
	public void decayWithBaskets_8(){//check hand limit increases as baskets are taken from decay
		playerSetUp5();//8 cards on hand
		p.addCardtoHand(new Basket());//hand limit: 10
		p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));p.addCardtoHand(new Morel(CardType.DAYMUSHROOM));//10 cards
		Board.getDecayPile().add(new Basket());//hand limit: 12
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));
		assertTrue(p.takeFromDecay());
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------
	// Update decay pile depending on its size
		
	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	public void decayPileUpdate(int n){
		forestSetUp1();
		for (int i=0; i<n;i++) {
			Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));// to create decay piles of 0..4 size
			Board.getForestCardsPile().addCard(new Morel(CardType.DAYMUSHROOM));//this is necessary from update to work
		}
		int beforeUpdate=Board.getDecayPile().size();
		Board.updateDecayPile();
		int afterUpdate=Board.getDecayPile().size();
		assertEquals(beforeUpdate,afterUpdate-1);
	}
	@Test
	public void decayPileUpdateWhenFull(){
		forestSetUp1();
		for (int i=0; i<4;i++) {
			Board.getDecayPile().add(new Morel(CardType.DAYMUSHROOM));// to create decay piles of 0..4 size
			Board.getForestCardsPile().addCard(new Morel(CardType.DAYMUSHROOM));//this is necessary from update to work
		}
		Board.updateDecayPile();
		assertEquals(Board.getDecayPile().size(),1);
	}

	//------------------------------------------------------------------------------------------------------------------------------------------
	// putPanDown
	// (1) put pan down when you don't have one
	// (2) put pan down when you have it
	// (3) check the pan is in the display and removed from hand when moved
	
	@Test
	public void panDown_noPan() {
		playerSetUp1();
		assertFalse(p.putPanDown());
	}
	
	@Test
	public void panDown_onePan() {
		playerSetUp1();playerSetUp7();
		assertTrue(p.putPanDown());
	}
	
	@Test
	public void panDown_onePan_PanRemovedfromHand() {
		playerSetUp1();playerSetUp7();
		int hSizeBefore=p.getHand().size();
		p.putPanDown();
		int hSizeAfter=p.getHand().size();
		assertEquals(hSizeBefore-1,hSizeAfter);
	}
	
	@Test
	public void panDown_onePan_PanOnDisplay() {
		playerSetUp1();playerSetUp7();
		int dSizeBefore=p.getDisplay().size();
		p.putPanDown();
		int dSizeAfter=p.getDisplay().size();
		assertEquals(dSizeBefore+1,dSizeAfter);
	}
	
	@Test
	public void panDown_twoPans() {
		playerSetUp1();playerSetUp7();playerSetUp7();
		assertTrue(p.putPanDown());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2,3,4})//more pans
	public void panDown_Pan_PanRemovedfromHand(int n) {
		playerSetUp1();
		for (int i=0;i<n;i++) {
			playerSetUp7();
		}
		int hSizeBefore=p.getHand().size();
		p.putPanDown();
		int hSizeAfter=p.getHand().size();
		assertEquals(hSizeBefore-1,hSizeAfter);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2,3,4})//more pans
	public void panDown_Pan_PanOnDisplay(int n) {
		playerSetUp1();
		for (int i=0;i<n;i++) {
			playerSetUp7();
		}
		int dSizeBefore=p.getDisplay().size();
		p.putPanDown();
		int dSizeAfter=p.getDisplay().size();
		assertEquals(dSizeBefore+1,dSizeAfter);
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------
	// sellMushrooms(String type, int number)//you only need two!
	// (1) sell one you don't have or does not exist 
	// (2) sell mushrooms you have 
	// (3) consider night mushrooms
	// (4) check the number of sticks received
	// (5) check sticks are on display and not on hand
	// (6) check the hand after selling
	
	@Test
	public void sellMushrooms_youdonthave() {
		playerSetUp1();
		assertFalse(p.sellMushrooms("porcini",1));
	}
	
	@Test
	public void sellMushrooms_notExistingMushroom1() {
		playerSetUp1();
		assertFalse(p.sellMushrooms("mushroom",1));
	}
	
	@Test
	public void sellMushrooms_notExistingMushroom2() {
		playerSetUp1();
		assertFalse(p.sellMushrooms("fly agaric",1));
	}
	
	@Test
	public void sellMushrooms_notExistingMushroom3() {
		playerSetUp1();
		assertFalse(p.sellMushrooms("",1));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"birchbolete","chanterelle","henofwoods","honeyfungus","lawyerswig","porcini","shiitake","treeEar","mushroom"})
	public void sellMushrooms_notThisMushroom1(String s) {
		playerSetUp2();
		assertFalse(p.sellMushrooms(s,1));
	}
	@ParameterizedTest
	@ValueSource(strings = {"birchbolete","chanterelle","henofwoods","honeyfungus","lawyerswig","porcini","shiitake","treeEar","mushroom"})
	public void sellMushrooms_notThisMushroom2(String s) {
		playerSetUp2();
		assertFalse(p.sellMushrooms(s,2));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"birchbolete","chanterelle","henofwoods","honeyfungus","lawyerswig","porcini","shiitake","treeEar","mushroom"})
	public void sellMushrooms_notThisMushroom3(String s) {
		playerSetUp2();
		assertFalse(p.sellMushrooms(s,1));
	}
	@ParameterizedTest
	@ValueSource(strings = {"birchbolete","chanterelle","henofwoods","honeyfungus","lawyerswig","porcini","shiitake","treeEar","mushroom"})
	public void sellMushrooms_notThisMushroom4(String s) {
		playerSetUp5();
		assertFalse(p.sellMushrooms(s,2));
	}

	// (2) sell mushrooms you have but you don't have enough
	@Test
	public void sellMushrooms_notEnough0() {
		playerSetUp10();
		assertFalse(p.sellMushrooms("Porcini",1));
	}
	
	@Test
	public void sellMushrooms_notEnough1() {//one you have
		playerSetUp1();
		assertFalse(p.sellMushrooms("Porcini",1));
	}

	
	@Test
	public void sellMushrooms_notEnough2() {
		playerSetUp1();
		assertFalse(p.sellMushrooms("Porcini",2));
	}
	
	@Test
	public void sellMushrooms_notEnough21() {//one you have but wrong number
		playerSetUp1();
		assertFalse(p.sellMushrooms("birchbolete",3));
	}	
	
	// (2) sell mushrooms you have
	@ParameterizedTest
	@ValueSource(strings = {"henofwoods","birchbolete","porcini","morel"})
	public void sellMushrooms(String s) {
		playerSetUp8();
		assertTrue(p.sellMushrooms(s,2));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"hen of woods","birch bolete","porcini","morel"})//with non-trimmed name
	public void sellMushrooms2(String s) {
		playerSetUp8();
		assertTrue(p.sellMushrooms(s,2));
	}
	
	// (3) consider night mushrooms
	@ParameterizedTest
	@ValueSource(strings = {"hen of woods","birch bolete","porcini"})
	public void sellMushrooms1Night(String s) {
		playerSetUp11();
		assertTrue(p.sellMushrooms(s,2));
	}

	@ParameterizedTest
	@ValueSource(strings = {"hen of woods","birch bolete","porcini"})//night mushrooms and day ones
	public void sellMushrooms1Mixed1(String s) {
		playerSetUp10();
		assertTrue(p.sellMushrooms(s,2));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"hen of woods","birch bolete","porcini"})//night mushrooms and day ones
	public void sellMushrooms1Mixed2(String s) {
		playerSetUp10();
		assertTrue(p.sellMushrooms(s,3));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"hen of woods","birch bolete","porcini"})//night mushrooms and day ones
	public void sellMushrooms1Mixed3(String s) {
		playerSetUp10();
		assertFalse(p.sellMushrooms(s,4));
	}
	
	// (4) check the number of sticks received
		
	@Test
	public void sellMushroomsSticks1() {
		playerSetUp8();
		int sticksBefore = p.getStickNumber();
		p.sellMushrooms("henofwoods",2);
		int sticksAfter = p.getStickNumber();
		assertEquals(sticksBefore,sticksAfter-2);
	}
	
	@Test
	public void sellMushroomsSticks2() {
		playerSetUp8();
		int sticksBefore = p.getStickNumber();
		p.sellMushrooms("birchbolete",2);
		int sticksAfter = p.getStickNumber();
		assertEquals(sticksBefore,sticksAfter-4);
	}
	
	@Test
	public void sellMushroomsSticks3() {
		playerSetUp8();
		int sticksBefore = p.getStickNumber();
		p.sellMushrooms("porcini",2);
		int sticksAfter = p.getStickNumber();
		assertEquals(sticksBefore,sticksAfter-6);
	}
	
	@Test
	public void sellMushroomsSticks4() {
		playerSetUp8();
		int sticksBefore = p.getStickNumber();
		p.sellMushrooms("morel",2);
		int sticksAfter = p.getStickNumber();
		assertEquals(sticksBefore,sticksAfter-8);
	}
	
	@Test
	public void sellMushrooms1NightSticks1() {
		playerSetUp11();
		int sticksBefore = p.getStickNumber();
		p.sellMushrooms("hen of woods",2);
		int sticksAfter = p.getStickNumber();
		assertEquals(sticksBefore,sticksAfter-2);
	}
	
	@Test
	public void sellMushrooms1NightSticks2() {
		playerSetUp11();
		int sticksBefore = p.getStickNumber();
		p.sellMushrooms("birch bolete",2);
		int sticksAfter = p.getStickNumber();
		assertEquals(sticksBefore,sticksAfter-4);
	}
	
	@Test
	public void sellMushrooms1NightSticks3() {
		playerSetUp11();
		int sticksBefore = p.getStickNumber();
		p.sellMushrooms("porcini",2);
		int sticksAfter = p.getStickNumber();
		assertEquals(sticksBefore,sticksAfter-6);
	}
	
	public void sellMushrooms1MixedNightSticks1() {
		playerSetUp10();
		int sticksBefore = p.getStickNumber();
		p.sellMushrooms("hen of woods",2);
		int sticksAfter = p.getStickNumber();
		assertEquals(sticksBefore,sticksAfter-2);
	}
	
	@Test
	public void sellMushrooms1MixedNightSticks2() {
		playerSetUp10();
		int sticksBefore = p.getStickNumber();
		p.sellMushrooms("birch bolete",2);
		int sticksAfter = p.getStickNumber();
		assertEquals(sticksBefore,sticksAfter-4);
	}
	
	@Test
	public void sellMushrooms1MixedNightSticks3() {
		playerSetUp10();
		int sticksBefore = p.getStickNumber();
		p.sellMushrooms("porcini",2);
		int sticksAfter = p.getStickNumber();
		assertEquals(sticksBefore,sticksAfter-6);
	}
	public void sellMushrooms1MixedNightSticks4() {
		playerSetUp10();
		int sticksBefore = p.getStickNumber();
		p.sellMushrooms("hen of woods",3);
		int sticksAfter = p.getStickNumber();
		assertEquals(sticksBefore,sticksAfter-3);
	}
	
	@Test
	public void sellMushrooms1MixedNightSticks5() {
		playerSetUp10();
		int sticksBefore = p.getStickNumber();
		p.sellMushrooms("birch bolete",3);
		int sticksAfter = p.getStickNumber();
		assertEquals(sticksBefore,sticksAfter-6);
	}
	
	@Test
	public void sellMushrooms1MixedNightSticks6() {
		playerSetUp10();
		int sticksBefore = p.getStickNumber();
		p.sellMushrooms("porcini",3);
		int sticksAfter = p.getStickNumber();
		assertEquals(sticksBefore,sticksAfter-9);
	}	

	// (5) check sticks are on display
	@Test
	public void sellMushroomsSticks1D() {
		playerSetUp8();
		int sticksBefore = p.getDisplay().size();
		p.sellMushrooms("henofwoods",2);
		int sticksAfter = p.getDisplay().size();
		assertEquals(sticksBefore,sticksAfter-2);
	}
	
	@Test
	public void sellMushroomsSticks2D() {
		playerSetUp8();
		int sticksBefore = p.getDisplay().size();
		p.sellMushrooms("birchbolete",2);
		int sticksAfter = p.getDisplay().size();
		assertEquals(sticksBefore,sticksAfter-4);
	}
	
	@Test
	public void sellMushroomsSticks3D() {
		playerSetUp8();
		int sticksBefore = p.getDisplay().size();
		p.sellMushrooms("porcini",2);
		int sticksAfter = p.getDisplay().size();
		assertEquals(sticksBefore,sticksAfter-6);
	}
	
	@Test
	public void sellMushroomsSticks4D() {
		playerSetUp8();
		int sticksBefore = p.getDisplay().size();
		p.sellMushrooms("morel",2);
		int sticksAfter = p.getDisplay().size();
		assertEquals(sticksBefore,sticksAfter-8);
	}
	
	@Test
	public void sellMushrooms1NightSticks1D() {
		playerSetUp11();
		int sticksBefore = p.getDisplay().size();
		p.sellMushrooms("hen of woods",2);
		int sticksAfter = p.getDisplay().size();
		assertEquals(sticksBefore,sticksAfter-2);
	}
	
	@Test
	public void sellMushrooms1NightSticks2D() {
		playerSetUp11();
		int sticksBefore = p.getDisplay().size();
		p.sellMushrooms("birch bolete",2);
		int sticksAfter = p.getDisplay().size();
		assertEquals(sticksBefore,sticksAfter-4);
	}
	
	@Test
	public void sellMushrooms1NightSticks3D() {
		playerSetUp11();
		int sticksBefore = p.getDisplay().size();
		p.sellMushrooms("porcini",2);
		int sticksAfter = p.getDisplay().size();
		assertEquals(sticksBefore,sticksAfter-6);
	}
	
	public void sellMushrooms1MixedNightSticks1D() {
		playerSetUp10();
		int sticksBefore = p.getDisplay().size();
		p.sellMushrooms("hen of woods",2);
		int sticksAfter = p.getDisplay().size();
		assertEquals(sticksBefore,sticksAfter-2);
	}
	
	@Test
	public void sellMushrooms1MixedNightSticks2D() {
		playerSetUp10();
		int sticksBefore = p.getDisplay().size();
		p.sellMushrooms("birch bolete",2);
		int sticksAfter = p.getDisplay().size();
		assertEquals(sticksBefore,sticksAfter-4);
	}
	
	@Test
	public void sellMushrooms1MixedNightSticks3D() {
		playerSetUp10();
		int sticksBefore = p.getDisplay().size();
		p.sellMushrooms("porcini",2);
		int sticksAfter = p.getDisplay().size();
		assertEquals(sticksBefore,sticksAfter-6);
	}
	public void sellMushrooms1MixedNightSticks4D() {
		playerSetUp10();
		int sticksBefore = p.getDisplay().size();
		p.sellMushrooms("hen of woods",3);
		int sticksAfter = p.getDisplay().size();
		assertEquals(sticksBefore,sticksAfter-3);
	}
	
	@Test
	public void sellMushrooms1MixedNightSticks5D() {
		playerSetUp10();
		int sticksBefore = p.getDisplay().size();
		p.sellMushrooms("birch bolete",3);
		int sticksAfter = p.getDisplay().size();
		assertEquals(sticksBefore,sticksAfter-6);
	}
	
	@Test
	public void sellMushrooms1MixedNightSticks6D() {
		playerSetUp10();
		int sticksBefore = p.getDisplay().size();
		p.sellMushrooms("porcini",3);
		int sticksAfter = p.getDisplay().size();
		assertEquals(sticksBefore,sticksAfter-9);
	}
	// (6) check the hand after selling
	@ParameterizedTest
	@ValueSource(strings = {"henofwoods","birchbolete","porcini","morel"})
	public void sellMushroomsCheckHand1(String s) {
		playerSetUp8();
		int handSizeBefore = p.getHand().size();
		p.sellMushrooms(s,2);
		int handSizeAfter = p.getHand().size();
		assertEquals(handSizeBefore,handSizeAfter+2);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"henofwoods","birchbolete","porcini"})
	public void sellMushroomsCheckHand2(String s) {
		playerSetUp11();
		int handSizeBefore = p.getHand().size();
		p.sellMushrooms(s,2);
		int handSizeAfter = p.getHand().size();
		assertEquals(handSizeBefore,handSizeAfter+1);
	}
	
//	@ParameterizedTest
//	@ValueSource(strings = {"henofwoods","birchbolete","porcini"})
//	public void sellMushroomsCheckHand3(String s) {
//		playerSetUp10();
//		int handSizeBefore = p.getHand().size();
//		p.sellMushrooms(s,2);
//		int handSizeAfter = p.getHand().size();
//		assertEquals(handSizeBefore,handSizeAfter+1);
//	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------
	// cookMushrooms
	// (0) no pan on display or hand --> false
	// (1) Not enough mushrooms of the same type < 3
	// (2) >= mushrooms but not of the same type
	// (3) Night mushrooms
	// (4) Non edible things added (basket)
	// (5) Include cider and butter
	// (6) Check scores on success and failure
	
	// (0) no pan on display or hand --> false
	// (1) Not enough mushrooms of the same type < 3
	@Test
	public void cookMushroomsNotEnough0withPanonH() {
		cookingCards.add(new Pan());
		assertFalse(p.cookMushrooms(cookingCards));
	}
	@Test
	public void cookMushroomsNotEnough1withPanonH() {
		ccSetUp1();
		cookingCards.add(new Pan());
		assertFalse(p.cookMushrooms(cookingCards));
	}
	@Test
	public void cookMushroomsNotEnough2withPanonH() {
		ccSetUp2();
		cookingCards.add(new Pan());
		assertFalse(p.cookMushrooms(cookingCards));
	}
	@Test
	public void cookMushroomsNotEnough0withPanonD() {
		setUpDisplay();
		assertFalse(p.cookMushrooms(cookingCards));
	}
	@Test
	public void cookMushroomsNotEnough1withPanonD() {
		ccSetUp1();
		setUpDisplay();
		assertFalse(p.cookMushrooms(cookingCards));
	}
	@Test
	public void cookMushroomsNotEnough2withPanonD() {
		ccSetUp2();
		setUpDisplay();
		assertFalse(p.cookMushrooms(cookingCards));
	}
	@Test
	public void cookMushroomsNotEnough0withNoPan() {
		assertFalse(p.cookMushrooms(cookingCards));
	}
	@Test
	public void cookMushroomsNotEnough1withNoPan() {
		ccSetUp1();
		assertFalse(p.cookMushrooms(cookingCards));
	}
	@Test
	public void cookMushroomsNotEnough2withNoPan() {
		ccSetUp2();
		assertFalse(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookMushroomsEnoughNoPanonHand() {
		ccSetUp5();
		assertFalse(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookMushroomsEnoughNoPanonDisplay() {
		ccSetUp6();
		assertFalse(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookNotEnoughMushrooms() {
		ccSetUp8();
		cookingCards.add(new Pan());
		assertFalse(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookMushroomsEnoughPanonHand() {
		ccSetUp5();
		cookingCards.add(new Pan());
		assertTrue(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookMushroomsEnoughPanonDisplay() {
		ccSetUp6();
		p.addCardtoDisplay(new Pan());
		assertTrue(p.cookMushrooms(cookingCards));
	}

	// (2) >= mushrooms but not of the same type
	@Test
	public void cookNotSameMushroomsDespiteHavingEnough() {
		ccSetUp7();
		cookingCards.add(new Pan());
		cookingCards.add(new Shiitake(CardType.DAYMUSHROOM));
		assertFalse(p.cookMushrooms(cookingCards));
	}

	// (3) Night mushrooms

	@Test
	public void cookNightMushrooms1() {
		ccSetUp9();
		cookingCards.add(new Pan());
		assertTrue(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookNightMushrooms2() {
		ccSetUp10();
		p.addCardtoDisplay(new Pan());
		assertTrue(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookNightMushrooms1D() {
		ccSetUp9();
		p.addCardtoDisplay(new Pan());
		assertTrue(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookNightMushrooms2D() {
		ccSetUp10();
		cookingCards.add(new Pan());
		assertTrue(p.cookMushrooms(cookingCards));
	}
	
	@Test//not the same type
	public void cookNightMushrooms3() {
		ccSetUp10();
		cookingCards.add(new Pan());
		cookingCards.add(new Shiitake(CardType.DAYMUSHROOM));
		assertFalse(p.cookMushrooms(cookingCards));
	}
	@Test
	public void cookNightMushrooms1noPan() {
		ccSetUp9();
		assertFalse(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookNightMushrooms2noPan() {
		ccSetUp10();
		assertFalse(p.cookMushrooms(cookingCards));
	}
	
	// (4) Non coockable things added (basket)
	@Test
	public void cookNightMushrooms1DNonEd() {
		ccSetUp9();
		p.addCardtoDisplay(new Pan());
		cookingCards.add(new Basket());
		assertFalse(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookNightMushrooms2DNonEd() {
		ccSetUp10();
		cookingCards.add(new Pan());
		cookingCards.add(new Basket());
		assertFalse(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookNightMushrooms1NonEd() {
		ccSetUp9();
		cookingCards.add(new Pan());
		cookingCards.add(new Basket());
		assertFalse(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookNightMushrooms2NonEd() {
		ccSetUp10();
		p.addCardtoDisplay(new Pan());
		cookingCards.add(new Basket());
		assertFalse(p.cookMushrooms(cookingCards));
	}
	@Test
	public void cookMushroomsEnoughPanonHandNonEd() {
		ccSetUp5();
		cookingCards.add(new Pan());
		cookingCards.add(new Basket());
		assertFalse(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookMushroomsEnoughPanonDisplayNonEd() {
		ccSetUp6();
		p.addCardtoDisplay(new Pan());
		cookingCards.add(new Basket());
		assertFalse(p.cookMushrooms(cookingCards));
	}
	// (5) Include cider (5m) and butter (4m)
	@Test
	public void cookMushroomsButter1() {
		ccSetUp10();
		p.addCardtoDisplay(new Pan());
		cookingCards.add(new Butter());
		assertTrue(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookMushroomsButter2() {
		ccSetUp10();
		p.addCardtoDisplay(new Pan());
		cookingCards.add(new Butter());
		cookingCards.add(new BirchBolete(CardType.DAYMUSHROOM));
		assertTrue(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookMushroomsCider() {
		ccSetUp10();
		p.addCardtoDisplay(new Pan());
		cookingCards.add(new Cider());
		cookingCards.add(new BirchBolete(CardType.DAYMUSHROOM));
		assertTrue(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookMushroomsCiderandButter() {
		ccSetUp10();ccSetUp10();
		cookingCards.add(new BirchBolete(CardType.DAYMUSHROOM));
		p.addCardtoDisplay(new Pan());
		cookingCards.add(new Cider());
		cookingCards.add(new Butter());
		assertTrue(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookMushroomsCiderandButterNotEnough() {
		ccSetUp10();ccSetUp10();
		p.addCardtoDisplay(new Pan());
		cookingCards.add(new Cider());
		cookingCards.add(new Butter());
		assertFalse(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookMushroomsButterNotEnough1() {
		ccSetUp4();
		p.addCardtoDisplay(new Pan());
		cookingCards.add(new Butter());
		assertFalse(p.cookMushrooms(cookingCards)); 
	}
	
	@Test
	public void cookMushroomsCidreNotEnough1() {
		ccSetUp4();
		p.addCardtoDisplay(new Pan());
		cookingCards.add(new Cider());
		assertFalse(p.cookMushrooms(cookingCards));
	}
	
	@Test
	public void cookMushroomsCidreNotEnough2() {
		ccSetUp10();
		p.addCardtoDisplay(new Pan());
		cookingCards.add(new Cider());
		assertFalse(p.cookMushrooms(cookingCards));
	}
	// (6) Check scores on success and failure
	@Test
	public void cookMushroomsEnoughPanonHandScoreHF() {
		ccSetUp4();
		cookingCards.add(new Pan());
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();
		assertEquals(scoreBefore,scoreAfter-3);
	}
	
	@Test
	public void cookMushroomsEnoughPanonHandScoreHF_NoPan() {
		ccSetUp4();
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();
		assertEquals(scoreBefore,scoreAfter);
	}
	
	@Test
	public void cookMushroomsEnoughPanonHandScoreSH() {
		ccSetUp5();
		cookingCards.add(new Pan());
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();
		assertEquals(scoreBefore,scoreAfter-6);
	}
	
	@Test
	public void cookMushroomsEnoughPanonHandScoreSH_NoPan() {
		ccSetUp5();
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();
		assertEquals(scoreBefore,scoreAfter);
	}
	
	@Test
	public void cookMushroomsEnoughPanonHandScoreBB() {
		ccSetUp6();
		cookingCards.add(new Pan());
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();
		assertEquals(scoreBefore,scoreAfter-9);
	}
	
	@Test
	public void cookMushroomsEnoughPanonHandScoreBB_NoPan() {
		ccSetUp6();
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();
		assertEquals(scoreBefore,scoreAfter);
	}
	
	@Test
	public void cookMushroomsEnoughPanonHandScoreCH() {
		ccSetUp11();
		cookingCards.add(new Pan());
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();
		assertEquals(scoreBefore,scoreAfter-12);
	}
	
	@Test
	public void cookMushroomsEnoughPanonHandScoreCH_NoPan() {
		ccSetUp11();
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();
		assertEquals(scoreBefore,scoreAfter);
	}
	
	
	@Test
	public void cookMushroomsEnoughPanonHandScoreMO() {
		ccSetUp7();
		cookingCards.add(new Pan());
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();
		assertEquals(scoreBefore,scoreAfter-18);
	}
	
	@Test
	public void cookMushroomsEnoughPanonHandScoreMO_NoPan() {
		ccSetUp7();
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();
		assertEquals(scoreBefore,scoreAfter);
	}
	
	@Test
	public void cookMushroomsEnoughPanonHandScoreHF_N() {
		ccSetUp4();
		cookingCards.add(new Pan());
		cookingCards.add(new HoneyFungus(CardType.NIGHTMUSHROOM));
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();
		assertEquals(scoreBefore,scoreAfter-5);
	}
	
	@Test
	public void cookMushroomsEnoughPanonHandScoreSH_N() {
		ccSetUp5();
		cookingCards.add(new Pan());
		cookingCards.add(new Shiitake(CardType.NIGHTMUSHROOM));
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();
		assertEquals(scoreBefore,scoreAfter-10);
	}
	
	@Test
	public void cookMushroomsEnoughPanonHandScoreBB_N() {
		ccSetUp6();
		cookingCards.add(new Pan());
		cookingCards.add(new BirchBolete(CardType.NIGHTMUSHROOM));
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();
		assertEquals(scoreBefore,scoreAfter-15);
	}
	
	@Test
	public void cookMushroomsEnoughPanonHandScoreCH_N() {
		ccSetUp11();
		cookingCards.add(new Pan());
		cookingCards.add(new Chanterelle(CardType.NIGHTMUSHROOM));
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();
		assertEquals(scoreBefore,scoreAfter-20);
	}
	
	@Test
	public void cookMushroomsEnoughPanonHandScoreMO_N() {
		ccSetUp7();
		cookingCards.add(new Pan());
		cookingCards.add(new Morel(CardType.NIGHTMUSHROOM));
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();
		assertEquals(scoreBefore,scoreAfter-30);
	}
	

	@Test
	public void cookMushroomsButter1Score() {
		ccSetUp10();//4 cards x 3 flavour points
		p.addCardtoDisplay(new Pan());
		cookingCards.add(new Butter());//+3
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();	
		assertEquals(scoreBefore,scoreAfter-15);	
	}
	
	@Test
	public void cookMushroomsButter2Score() {
		ccSetUp10();
		p.addCardtoDisplay(new Pan());
		cookingCards.add(new Butter());
		cookingCards.add(new BirchBolete(CardType.DAYMUSHROOM));
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();	
		assertEquals(scoreBefore,scoreAfter-18);	
	}
	
	@Test
	public void cookMushroomsCiderScore() {
		ccSetUp10();
		p.addCardtoDisplay(new Pan());
		cookingCards.add(new Cider());
		cookingCards.add(new BirchBolete(CardType.DAYMUSHROOM));
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();	
		assertEquals(scoreBefore,scoreAfter-20);	
	}
	
	@Test
	public void cookMushroomsCiderandButterScore() {
		ccSetUp10();ccSetUp10();//24
		cookingCards.add(new BirchBolete(CardType.DAYMUSHROOM));
		p.addCardtoDisplay(new Pan());
		cookingCards.add(new Cider());
		cookingCards.add(new Butter());
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();	
		assertEquals(scoreBefore,scoreAfter-35);	
	}

	@Test
	public void cookMushroomsCiderandButterScoreFailNoPan() {
		ccSetUp10();ccSetUp10();//24
		cookingCards.add(new BirchBolete(CardType.DAYMUSHROOM));
		cookingCards.add(new Cider());
		cookingCards.add(new Butter());
		int scoreBefore=p.getScore();
		p.cookMushrooms(cookingCards);
		int scoreAfter=p.getScore();	
		assertEquals(scoreBefore,scoreAfter);	
	}
	
	
	
}
