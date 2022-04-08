package board;

import cards.*;

import java.util.ArrayList;

public class Board {
    private static CardPile forestCardPile;
    private static CardList forest;
    private static ArrayList<Card> decayPile;

    public static void initialisePiles() {
        forestCardPile = new CardPile();
        forest = new CardList();
        decayPile = new ArrayList<>();
    }

    public static void setUpCards() {
        //Honey fungus
        for (int i = 0; i < 10; i++) {
            forestCardPile.addCard(new HoneyFungus(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new HoneyFungus(CardType.NIGHTMUSHROOM));
        //Tree ear
        for (int i = 0; i < 8; i++) {
            forestCardPile.addCard(new TreeEar(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new TreeEar(CardType.NIGHTMUSHROOM));
        //Lawyer's wig
        for (int i = 0; i < 6; i++) {
            forestCardPile.addCard(new LawyersWig(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new LawyersWig(CardType.NIGHTMUSHROOM));
        //Shiitake
        for (int i = 0; i < 5; i++) {
            forestCardPile.addCard(new Shiitake(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new Shiitake(CardType.NIGHTMUSHROOM));
        //Hen of Woods
        for (int i = 0; i < 5; i++) {
            forestCardPile.addCard(new HenOfWoods(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new HenOfWoods(CardType.NIGHTMUSHROOM));
        //Birch bolete
        for (int i = 0; i < 4; i++) {
            forestCardPile.addCard(new BirchBolete(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new BirchBolete(CardType.NIGHTMUSHROOM));
        //Porcini
        for (int i = 0; i < 4; i++) {
            forestCardPile.addCard(new Porcini(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new Porcini(CardType.NIGHTMUSHROOM));
        //Chanterelle
        for (int i = 0; i < 4; i++) {
            forestCardPile.addCard(new Chanterelle(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new Chanterelle(CardType.NIGHTMUSHROOM));
        //Morel
        for (int i = 0; i < 3; i++) {
            forestCardPile.addCard(new Morel(CardType.DAYMUSHROOM));
        }
        //Butter
        for (int i = 0; i < 3; i++) {
            forestCardPile.addCard(new Butter());
        }
        //Cider
        for (int i = 0; i < 3; i++) {
            forestCardPile.addCard(new Cider());
        }
        //Pan
        for (int i = 0; i < 11; i++) {
            forestCardPile.addCard(new Pan());
        }
        //Basket
        for (int i = 0; i < 5; i++) {
            forestCardPile.addCard(new Basket());
        }
    }
    public static CardPile getForestCardsPile(){
        return forestCardPile;
    }
    public static CardList getForest(){
        return forest;
    }
    public static ArrayList<Card> getDecayPile(){
        return decayPile;
    }
    public static void updateDecayPile() {
        if (decayPile.size() == 4) {
            decayPile.clear();
        }
        decayPile.add(forest.getElementAt(7));
        forest.removeCardAt(1);
        forest.add(forestCardPile.drawCard());
    }
}
