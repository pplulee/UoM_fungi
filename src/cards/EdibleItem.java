package cards;

public class EdibleItem extends Card {
    protected int flavourPoints;
    public EdibleItem(CardType type, String name){
        super(type, name);
    }
    public int getFlavourPoints(){
        return flavourPoints;
    }
}
