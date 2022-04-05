package cards;

public class Mushroom extends EdibleItem{
    protected int sticksPerMushroom;
    private CardType cardType;
    private String cardName;

    public Mushroom(CardType type, String name){
        super(type, name);
    }
    public int getSticksPerMushroom(){
        return this.sticksPerMushroom;
    }
}
