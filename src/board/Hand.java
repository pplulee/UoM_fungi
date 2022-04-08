package board;

import cards.Card;

import java.util.ArrayList;

public class Hand implements Displayable {
    private final ArrayList<Card> handList = new ArrayList<>();

    @Override
    public void add(Card card) {
        handList.add(card);
    }

    @Override
    public int size() {
        return handList.size();
    }

    @Override
    public Card getElementAt(int num) {
        return handList.get(num);
    }

    @Override
    public Card removeElement(int num) {
        return handList.remove(num);
    }
}
