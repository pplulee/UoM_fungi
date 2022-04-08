package board;

import cards.Card;
import cards.CardType;

import java.util.ArrayList;

public class Player {
    private Hand h;
    private Display d;
    private int score;
    private int handlimit;
    private int sticks;

    public Player() {
        this.h = new Hand();
        this.d = new Display();
        this.score = 0;
        this.handlimit = 8;
        this.sticks = 0;
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
    }
    public void removeSticks(int num){
        this.sticks-=num;
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
        if (position < 1 || position > 8 || this.h.size() == this.handlimit) {
            return false;
        } else {
            Card card = Board.getForest().getElementAt(8 - position);
            if (card.getType() == CardType.BASKET) {
                this.d.add(card);
                this.handlimit += 2;
            } else if (card.getType() == CardType.STICK) {
                sticks++;
            } else if (card.getType() == CardType.DAYMUSHROOM || card.getType() == CardType.NIGHTMUSHROOM) {
                if (position >= 3) {
                    if (this.sticks >= position - 2) {
                        this.sticks -= position - 2;
                    } else {
                        return false;
                    }
                    this.h.add(card);
                }
            }
        }
        Board.getForest().removeCardAt(position);
        return true;
    }

    public boolean takeFromDecay() {
        if (this.h.size() == this.handlimit) {
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
        return false;
    }

    public boolean cookMushrooms(ArrayList<Card> cards) {
        return false;
    }

    public boolean sellMushrooms(String cardname, int number) {
        return false;
    }

    public boolean putPanDown() {
        return false;
    }
}
