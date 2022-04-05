package board;

import board.Display;
import board.Hand;

public class Player {
    private Hand h;
    private Display d;
    private int score;
    private int handlimit;
    private int sticks;
    public Player(){
        h = new Hand();
        d = new Display();
        score = 0;
        handlimit = 5;
        sticks = 0;
    }
}
