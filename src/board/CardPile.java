package board;

import cards.Card;

import java.util.Stack;

public class CardPile {
    private final Stack<Card> cPile;

    public CardPile() {
        cPile = new Stack<Card>();
    }

    public void addCard(Card card) {
        cPile.push(card);
    }

    public Card drawCard() {
        return cPile.pop();
    }

    public void shufflePile() {
        cPile.shuffle();
    }

    public int pileSize() {
        return cPile.size();
    }

    public boolean isEmpty() {
        return cPile.isEmpty();
    }
}

