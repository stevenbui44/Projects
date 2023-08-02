import java.util.*;

/**
 * Creates a deck object representing a deck of 52 playing cards in Video Poker
 * @author Steven Bui
 */
public class Deck {
    
    /** Number of cards in the deck */
    public static final int CARDS_IN_DECK = 52;
    
    /** Array of cards used to manage 52 cards in the deck */
    private Card[] cards;
    
    /** Integer holding the index of the next card to be dealt from the array of Cards */
    private int next;
    
    /** Integer maintaining the random seed provided for testing*/
    private int seed;
    
    /**
     * Constructor that creates a deck of 52 cards in the order clubs, diamonds, hearts, and spades
     * @param seed the random seed used for testing
     */
    public Deck(int seed) {
        this.seed = seed;
        cards = new Card[CARDS_IN_DECK];
        int k = 0;
        
        for (int j = Card.LOWEST_VALUE; j <= Card.HIGHEST_VALUE; j++) {
            cards[k] = new Card(j, Card.CLUBS);
            k++;
        }
        for (int j = Card.LOWEST_VALUE; j <= Card.HIGHEST_VALUE; j++) {
            cards[k] = new Card(j, Card.DIAMONDS);
            k++;
        }
        for (int j = Card.LOWEST_VALUE; j <= Card.HIGHEST_VALUE; j++) {
            cards[k] = new Card(j, Card.HEARTS);
            k++;
        }
        for (int j = Card.LOWEST_VALUE; j <= Card.HIGHEST_VALUE; j++) {
            cards[k] = new Card(j, Card.SPADES);
            k++;
        }
    }
    
   /**
    * Resets the deck for a new hand to be played by generating random numbers
    */ 
    public void shuffle() {
	this.next = 0;
	if (seed == -1) {
            Random rand = new Random();
        
            for (int i = CARDS_IN_DECK - 1; i >= 1; i--) {
                int randomNumber = rand.nextInt(i + 1);
                Card temp = cards[i];
                cards[i] = cards[randomNumber];
                cards[randomNumber] = temp;
            }
        }
        else {
            Random rand = new Random(seed);
            
            for (int i = CARDS_IN_DECK - 1; i >= 1; i--) {
                int randomNumber = rand.nextInt(i + 1);
                Card temp = cards[i];
                cards[i] = cards[randomNumber];
                cards[randomNumber] = temp;
            }
        }
    }
    
    /**
     * Returns the next card in the deck based on the next instance variable
     *
     * @return the next card in the deck
     * @throws IllegalStateException if next is greater than the number of cards in the deck
     */
    public Card nextCard() {
        if (next >= CARDS_IN_DECK) {
            throw new IllegalStateException("No more cards");
        }
        return cards[next++];
    }
    
    /**
     * Checks if this deck and another deck of cards are equal to each other
     *
     * @param o the other deck of cards
     * @return true if the two decks of cards are equal
     *         false if the two decks of cards are different
     */
    public boolean equals(Object o) {
        if (o instanceof Deck) {
            Deck other = (Deck)o;
            for (int i = 0; i < CARDS_IN_DECK; i++) {
                if (cards[i].equals(other.cards[i])
                    && next == other.next
                    && seed == other.seed) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }
    
    /**
     * Creates and returns a String representation of the deck
     * @return the String representation of the deck
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < CARDS_IN_DECK; i++) {
            s += "card " + i + ": " + cards[i].toString() + "\n";
        }
        return s;
    }
}
