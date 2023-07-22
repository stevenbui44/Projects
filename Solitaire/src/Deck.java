package src;
import java.util.Random;

/**
 * Ight steven this is a deck which you're gonna need in order to shuffle
 */
public class Deck {
    
    /** Creates a 4 Suit deck */
    private Card[][] deck;

    private int size;

    /** Constructor to create a 4 Suit array */
    public Deck() {
        deck = new Card[4][13];
        
        Suit hearts = new Suit("H");
        for (int i = 0; i < 13; i++) {
            deck[0][i] = hearts.getCard(i);
        }

        Suit diamonds = new Suit("D");
        for (int i = 0; i < 13; i++) {
            deck[1][i] = diamonds.getCard(i);
        }

        Suit clubs = new Suit("C");
        for (int i = 0; i < 13; i++) {
            deck[2][i] = clubs.getCard(i);
        }

        Suit spades = new Suit("S");
        for (int i = 0; i < 13; i++) {
            deck[3][i] = spades.getCard(i);
        }

        size = 52;
    }

    /** Outputs the 4 Suit array as a String */
    public String toString() {
        String rtn = "";

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if (deck[i][j] == null) {
                    rtn = rtn + "null" + "\t";
                }
                else {
                    rtn = rtn + deck[i][j].toString() + "\t";
                }
            }
            rtn = rtn + "\n";
        }
        return rtn;
    }

    public void shuffle() {
        Card[][] tempDeck = new Card[4][13];

        Random random = new Random();

        // puts all of the cards in the deck into one long queue
        ArrayBasedQueue<Card> cardDeck = new ArrayBasedQueue<Card>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cardDeck.enqueue(deck[i][j]);
            }
        }

        int randomInt = random.nextInt(52);
        int row = randomInt / 13;
        int column = randomInt % 13;

        // do this until the temporary deck is empty
        while (!cardDeck.isEmpty()) {
            if (tempDeck[row][column] == null) {
                tempDeck[row][column] = cardDeck.dequeue();
            }
            else {
                randomInt = random.nextInt(52);
                row = randomInt / 13;
                column = randomInt % 13;
            }
        }
        deck = tempDeck;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Card removeCard() {
        if (!isEmpty()) {
            int row = 0;
            int column = 0;

            while (deck[row][column] == null) {
                if (column < 12) {
                    column++;
                }
                else {
                    column = 0;
                    row++;
                }
            }
            Card temp = deck[row][column];
            deck[row][column] = null;
            size--;
            return temp;

        }
        size--;
        return null;
    }
    
}
