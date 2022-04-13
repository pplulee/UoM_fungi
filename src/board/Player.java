package board;

import cards.*;

import java.util.ArrayList;

public class Player {
    private final Hand h = new Hand();
    private final Display d = new Display();
    private int score;
    private int handlimit;
    private int sticks;

    public Player() {
        score = 0;
        handlimit = 8;
        sticks = 0;
        addCardtoDisplay(new Pan());
    }

    public int getScore() {
        return this.score;
    }

    public int getHandLimit() {
        return this.handlimit;
    }

    public int getStickNumber() {
        return this.sticks;
    }

    public void addSticks(int num) {
        this.sticks += num;
        for (int i = 0; i < num; i++) {
            getDisplay().add(new Stick());
        }
    }

    public void removeSticks(int num) {
        this.sticks -= num;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < getDisplay().size(); j++) {
                if (getDisplay().getElementAt(j).getType() == CardType.STICK) {
                    getDisplay().removeElement(j);
                    break;
                }
            }
        }
    }

    public Hand getHand() {
        return this.h;
    }

    public Display getDisplay() {
        return this.d;
    }

    public void addCardtoHand(Card card) {
        if (card.getType() == CardType.BASKET) {
            this.d.add(card);
            this.handlimit += 2;
        } else {
            this.h.add(card);
        }
    }

    public void addCardtoDisplay(Card card) {
        this.d.add(card);
    }

    public boolean takeCardFromTheForest(int position) {
        if (position < 1 || position > 8) {
            return false;
        }
        Card card = Board.getForest().getElementAt(8 - position);
        if (getHand().size() == getHandLimit() && card.getType() != CardType.BASKET && card.getType() != CardType.STICK) {
            return false;
        }
        if (position >= 3) {
            if (getStickNumber() >= position - 2) {
                removeSticks(position - 2);
            } else {
                //sticks not enough
                return false;
            }
        }
        switch (card.getType()) {
            case BASKET:
                addCardtoDisplay(card);
                handlimit += 2;
                break;
            case STICK:
                addSticks(1);
                break;
            case PAN:
                addCardtoDisplay(card);
                break;
            default:
                addCardtoHand(card);
                break;
        }
        Board.getForest().removeCardAt(position);
        return true;
    }

    public boolean takeFromDecay() {
        int basket_count = 0;
        for (int i = 0; i < Board.getDecayPile().size(); i++) {
            if (Board.getDecayPile().get(i).getType() == CardType.BASKET) {
                basket_count++;
            }
        }
        if ((basket_count == 0 && getHandLimit() == getHand().size()) || getHandLimit() - getHand().size() + (basket_count * 2) < Board.getDecayPile().size() - basket_count) {
            //no basket and hand is full
            return false;
        }
        int cycle = Board.getDecayPile().size();
        for (int i = 0; i < cycle; i++) {
            switch (Board.getDecayPile().get(0).getType()) {
                case BASKET:
                    addCardtoDisplay(Board.getDecayPile().remove(0));
                    handlimit += 2;
                    break;
                case STICK:
                    addSticks(1);
                    Board.getDecayPile().remove(0);
                    break;
                default:
                    addCardtoHand(Board.getDecayPile().remove(0));
                    break;
            }
        }
        return true;
    }

    public boolean cookMushrooms(ArrayList<Card> cards) {
        boolean haspan = false;
        Card tmp = null;
        int day_card_count = 0;
        int night_card_count = 0;
        int butter_count = 0;
        int cider_count = 0;
        int flavourpoints = 0;
        for (Card card : cards) {
            switch (card.getType()) {
                case BASKET:
                    return false;
                case PAN:
                    haspan = true;
                    break;
                case BUTTER:
                    butter_count++;
                    break;
                case CIDER:
                    cider_count++;
                    break;
                case DAYMUSHROOM:
                    if (tmp != null && !tmp.getName().equals(card.getName())) {
                        //not same type
                        return false;
                    } else {
                        tmp = card;
                    }
                    day_card_count++;
                    flavourpoints += new EdibleItem(card.getType(), card.getName()).getFlavourPoints();
                    break;
                case NIGHTMUSHROOM:
                    if (tmp != null && !tmp.getName().equals(card.getName())) {
                        //not same type
                        return false;
                    } else {
                        tmp = card;
                    }
                    night_card_count += 1;
                    flavourpoints += new EdibleItem(card.getType(), card.getName()).getFlavourPoints() * 2;
                    break;
            }
        }
        for (int i = 0; i < getDisplay().size(); i++) {
            if (getDisplay().getElementAt(i).getType() == CardType.PAN) {
                haspan = true;
                break;
            }
        }

        if (!haspan || 2 * night_card_count + day_card_count < 3) {
            //no pan found or cards not enough
            return false;
        }
        if (butter_count + cider_count != 0) {
            if (4 * butter_count + 5 * cider_count > 2 * night_card_count + day_card_count) {
                //butter or cider not enough
                return false;
            } else {
                flavourpoints += butter_count * 3 + cider_count * 5;
            }
        }
        score += flavourpoints;
        //remove mushroom card from hand
        for (int i=0;i<cards.size();i++){
            for (int j = 0; j < getHand().size(); j++) {
                if (getHand().getElementAt(j)==cards.get(j)) {
                    getHand().removeElement(j);
                    break;
                }
            }
        }
        //remove pan
        putPanDown();
        return true;
    }

    public boolean sellMushrooms(String cardname, int number) {
        int day_card_count = 0;
        int night_card_count = 0;
        int stick_gain = 0;
        cardname = cardname.toLowerCase().replace(" ", "").replace("'", "");
        for (int i = 0; i < getHand().size(); i++) {
            if (getHand().getElementAt(i).getName().equals(cardname)) {
                if (getHand().getElementAt(i).getType() == CardType.DAYMUSHROOM) {
                    day_card_count += 1;
                } else if (getHand().getElementAt(i).getType() == CardType.NIGHTMUSHROOM) {
                    night_card_count += 1;
                }
            }
        }
        if (day_card_count + (night_card_count * 2) < number || number < 2) {
            return false;
        }
        //Sell night mushroom first
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < getHand().size(); j++) {
                if (getHand().getElementAt(j).getName().equals(cardname) && getHand().getElementAt(j).getType() == CardType.NIGHTMUSHROOM) {
                    stick_gain += new Mushroom(getHand().getElementAt(j).getType(), getHand().getElementAt(j).getName()).getSticksPerMushroom() * 2;
                    getHand().removeElement(j);
                    break;
                }
            }
        }
        if (number - night_card_count * 2 > 0) {
            for (int i = 0; i < number - night_card_count; i++) {
                for (int j = 0; j < getHand().size(); j++) {
                    if (getHand().getElementAt(j).getName().equals(cardname) && getHand().getElementAt(j).getType() == CardType.DAYMUSHROOM) {
                        stick_gain += new Mushroom(getHand().getElementAt(j).getType(), getHand().getElementAt(j).getName()).getSticksPerMushroom();
                        getHand().removeElement(j);
                        break;
                    }
                }
            }
        }
        addSticks(stick_gain);
        return true;
    }

    public boolean putPanDown() {
        for (int i = 0; i < getHand().size(); i++) {
            if (getHand().getElementAt(i).getType() == CardType.PAN) {
                addCardtoDisplay(getHand().removeElement(i));
                return true;
            }
        }
        return false;
    }
}
