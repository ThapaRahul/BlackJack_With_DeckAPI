import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;


public class Hand {

    private ObservableList<Node> cards;
    private SimpleIntegerProperty value = new SimpleIntegerProperty(0);

    private int aces = 0;

    public Hand(ObservableList<Node> cards) {
        this.cards = cards;
    }

    public void takeCard(Card card) {
        cards.add(card);

        if (card.rank == card.rank.Ace) {
            aces++;
        }

        if (value.get() + card.rank.getValue() > 21 && aces > 0) {
            value.set(value.get() + card.rank.getValue() - 10);    //then count ace as '1' not '11'
            aces--;
        }
        else {
            value.set(value.get() + card.rank.getValue());
        }
    }

    public void reset() {
        cards.clear();
        value.set(0);
        aces = 0;
    }

    public SimpleIntegerProperty valueProperty() {
        return value;
    }
}