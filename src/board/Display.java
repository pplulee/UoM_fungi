package board;

import cards.Card;

import java.util.ArrayList;

public class Display implements Displayable {
    private final ArrayList<Card> displayList = new ArrayList<>();

    @Override
    public void add(Card card) {
        displayList.add(card);
    }

    @Override
    public int size() {
        return displayList.size();
    }

    @Override
    public Card getElementAt(int num) {
        return displayList.get(num);
    }

    @Override
    public Card removeElement(int num) {
        return displayList.remove(num);
    }
}
