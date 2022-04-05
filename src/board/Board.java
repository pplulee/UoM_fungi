package board;

import board.CardList;
import board.CardPile;
import cards.Card;

import java.util.ArrayList;

public class Board {
    private CardPile forestCardPile;
    private CardList forest;
    private ArrayList<Card> decayPile;
    public static void initialisePiles(){
        CardPile forestCardsPile = new CardPile();
        CardList forest = new CardList();
        ArrayList<Card> decayPile = new ArrayList<Card>();
    }
    public static void setUpCards(){

    }
    public static CardPile getForestCardsPile(){

    }
    public static CardList getForest(){

    }
    public static ArrayList<Card> getDecayPile(){

    }
    public static void updateDecayPile(){


    }
}
