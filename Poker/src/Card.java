/**
 * Creates a card object representing a single playing card in Video Poker
 * @author Steven Bui
 */
public class Card implements Comparable<Card> {
    
    /** Value of the card */
    private int value;
    
    /** Suit of the card */
    private char suit;
    
    /** Clubs suit of cards */
    public static final char CLUBS = 'c';
    
    /** Diamonds suit of cards */
    public static final char DIAMONDS = 'd';
    
    /** Spades suit of cards */
    public static final char SPADES = 's';
    
    /** Hearts suit of cards */
    public static final char HEARTS = 'h';
    
    /** Lowest value of a card, given to a 2 card */
    public static final int LOWEST_VALUE = 2;
    
    /** Highest value of a card, given to an ace */
    public static final int HIGHEST_VALUE = 14;
    
    /**
     * Constructor that creates a card given its value and suit
     *
     * @param value value of the card
     * @param suit suit of the card
     * @throws IllegalArgumentException if value is higher or lower than accepted card values
     * @throws IllegalArgumentException if suit is not clubs, diamonds, spades, or hearts
     */
    public Card (int value, char suit) {
        if (value > HIGHEST_VALUE || value < LOWEST_VALUE) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (suit != 'c' && suit != 'd' && suit != 's' && suit != 'h') {
            throw new IllegalArgumentException("Invalid suit");
        }
        this.value = value;
        this.suit = suit;
    }
    
    /**
     * Gets the value of the card
     * @return value value of the card
     */
    public int getValue() {
        return this.value;
    }
    
    /**
     * Gets the suit of the card
     * @return suit suit of the card
     */
    public char getSuit() {
        return this.suit;
    }
    
    /**
     * Checks if two cards are equal to each other
     *
     * @param o other card object
     * @return true if the two card objects have the same value and suit
     *         false if the two cards do not have the same value and suit
     */
    public boolean equals(Object o) {
        if (o instanceof Card) {
            Card other = (Card)o;
            if (value == other.value && suit == other.suit) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    /**
     * Creates a string containing the suit and value of the card
     * @return the suit and value of the card
     */
    public String toString() {
        String s = "" + suit + value;
        return s;
    }
    
    /**
     * This method is used for sorting the cards in a player's hand in a game of
     * Poker. Cards are sorted first by value, then by suit.
     * 
     * @param other
     *            The Card object to which this Card is being compared.
     * @return negative value if this Card should be before the other Card,
     *         positive value if this Card should be after the other Card.
     */
    public int compareTo(Card other) {
        if (this.value != other.value) {
            return this.value - other.value;
        } else {
            return this.suit - other.suit;
        }
    }
}
