package cards;

public class Morel extends Mushroom {
    public Morel(CardType type) {
        super(type, "morel");
        super.flavourPoints = 6;
        super.sticksPerMushroom = 4;
    }
}
