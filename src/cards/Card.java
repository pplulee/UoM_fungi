package cards;

import board.CardList;
import board.CardPile;

public class Card {
    protected CardType type;
    protected String cardName;
    public Card(CardType type, String cardName) {
        this.type = type;
        this.cardName = cardName;
        CardPile cardpile = new CardPile();
        CardList cardlist = new CardList();
    }
    public CardType getType() {
        return type;
    }
    public String getName() {
        return cardName;
    }

}
