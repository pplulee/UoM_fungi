package board;

import cards.Card;

import java.util.ArrayList;

public class CardList {
    private final ArrayList<Card> cList;

    public CardList() {
        cList = new ArrayList<Card>();
    }

    public void add(Card card) {
        cList.add(card);
    }

    public int size() {
        return cList.size();
    }

    public Card getElementAt(int index) {
        return cList.get(index);
    }

    public Card removeCardAt(int index) {
        Card cardtype = cList.get(index);
        cList.remove(index);
        return cardtype;
    }
}
