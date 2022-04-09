package board;

import cards.*;

import java.util.ArrayList;

public class Player {
    private final Hand h = new Hand();
    private final Display d = new Display();
    private final int score;
    private int handlimit;
    private int sticks;

    public Player() {
        score = 0;
        handlimit = 8;
        sticks = 0;
        addCardtoDisplay(new Pan());
    }
    public int getScore(){
        return this.score;
    }
    public int getHandLimit(){
        return this.handlimit;
    }
    public int getStickNumber(){
        return this.sticks;
    }
    public void addSticks(int num){
        this.sticks+=num;
        for (int i=0;i<num;i++){
            getDisplay().add(new Stick());
        }
    }
    public void removeSticks(int num){
        this.sticks-=num;
        int count=0;
        int index=-1;
        while (count<num){
            for (int i=0;i<getDisplay().size();i++){
                if (getDisplay().getElementAt(i).getType()==CardType.STICK){
                    count++;
                    index=i;
                    break;
                }
            }
            if (index!=-1){
                getDisplay().removeElement(index);
                index=-1;
            }
        }
    }
    public Hand getHand(){
        return this.h;
    }

    public Display getDisplay() {
        return this.d;
    }

    public void addCardtoHand(Card card) {
        this.h.add(card);
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
        if (getHand().size() == getHandLimit()) {
            return false;
        }

        int basket_count = 0;
        for (int i = 0; i < Board.getDecayPile().size(); i++) {
            if (Board.getDecayPile().get(i).getType() == CardType.BASKET) {
                basket_count++;
            }
        }
        this.handlimit += basket_count * 2;

        int max_can_take = Math.min(this.handlimit - this.h.size(), Board.getDecayPile().size());
        for (int i = 0; i < max_can_take; i++) {
            if (Board.getDecayPile().get(0).getType() == CardType.BASKET) {
                this.d.add(Board.getDecayPile().remove(0));
            } else {
                this.h.add(Board.getDecayPile().remove(0));
            }
        }
        return true;
    }

    public boolean cookMushrooms(ArrayList<Card> cards) {
        boolean haspan = false;
        Card tmp = null;
        int card_count = 0;
        int butter_count=0;
        int cider_count=0;
        int flavourpoints=0;
        for (Card card : cards) {
            switch (card.getType()) {
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
                    if (tmp!=null && !tmp.getName().equals(card.getName())){
                        return false;
                    }else{
                        tmp = card;
                    }
                    card_count++;
                    //flavourpoints+=?
                    break;
                case NIGHTMUSHROOM:
                    if (tmp!=null && !tmp.getName().equals(card.getName())){
                        return false;
                    }else{
                        tmp = card;
                    }
                    card_count+=2;
                    break;
            }
        }
        for (int i=0;i<this.d.size();i++){
            if (this.d.getElementAt(i).getType()==CardType.PAN){
                haspan=true;
            }
        }

        if (!haspan || card_count<3) {
            return false;
        }
        if (butter_count>=1 && card_count<4){
            return false;
        }
        if (cider_count>=1 && card_count<5){
            return false;
        }
        return true;
    }

    public boolean sellMushrooms(String cardname, int number) {
        return false;
    }

    public boolean putPanDown() {
        int pan_index = -1;
        for (int i = 0; i < getHand().size(); i++) {
            if (getHand().getElementAt(i).getType() == CardType.PAN) {
                pan_index = i;
                break;
            }
        }
        if (pan_index == -1) {
            return false;
        }
        addCardtoDisplay(getHand().removeElement(pan_index));
        return true;
    }
}
