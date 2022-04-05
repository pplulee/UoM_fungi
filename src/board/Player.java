package board;

import board.Display;
import board.Hand;
import cards.Card;
import cards.CardType;

public class Player {
    private Hand h;
    private Display d;
    private int score;
    private int handlimit;
    private int sticks;
    public Player(){
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
    public Display getDisplay(){
        return this.d;
    }
    public void addCardtoHand(Card card){
        this.h.add(card);
    }
    public void addCardtoDisplay(Card card){
        this.d.add(card);
    }
    public boolean takeCardFromTheForest(int num){
        if (num>8 || num<0 || num>this.handlimit){
            return false;
        }
        if (this.h.getElementAt(num).getType()==CardType.BASKET){
            this.d.add(this.h.getElementAt(num));
        }else{
            this.h.add(this.h.getElementAt(num));
        }
    }


}
