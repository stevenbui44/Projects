package game;

/**
 * Ight steven this is a suit which is basically the 13 cards of the same face
 */
public class Suit {

    /** Creates a 13 Card array of a given face */
    private Card[] suit;

    /** Constructor to create a 13 Card array of a given face */
    public Suit(String face) {
        suit = new Card[13];

        for (int i = 1; i <= 10; i++) {
            suit[i - 1] = new Card("" + i, face);
        }
        
        suit[10] = new Card("J", face);
        suit[11] = new Card("Q", face);
        suit[12] = new Card("K", face);
    }

    /** Outputs the 13 Card array as a String */
    public String toString() {
        String rtn = "";
        for (int i = 0; i < 13; i++) {
            rtn = rtn + suit[i].toString() + "\t";
        }
        return rtn;
    }

    public Card getCard(int index) {
        return suit[index];
    }
}
