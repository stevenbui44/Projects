import java.util.*;

/** 
 * Represents hand of cards
 * @author Dan Longo
 * @author Suzanne Balik
 * @author Steven Bui
 */
public class Hand {

    /** Contains cards in hand */
    private Card[] hand;
    
    /** Number of cards a Hand holds in their hand at a time */
    public static final int CARDS_IN_HAND = 5;
    
    /** Four cards have the same value */
    public static final int FOUR_OF_A_KIND = 4;
    
    /** Three cards have the same value */
    public static final int TRIPLE = 3;
    
    /** Two cards have the same value */
    public static final int PAIRS = 2;
    
    /** Index of the first card in the hand */
    public static final int CARD_ONE_INDEX = 0;
    
    /** Index of the second card in the hand */
    public static final int CARD_TWO_INDEX = 1;
    
    /** Index of the third card in the hand */
    public static final int CARD_THREE_INDEX = 2;
    
    /** Index of the fourth card in the hand */
    public static final int CARD_FOUR_INDEX = 3;
    
    /** Index of the fifth card in the hand */
    public static final int CARD_FIVE_INDEX = 4;
    
    /** Value of the first card in a royal flush, a 10 */
    public static final int ROYAL_FLUSH_TEN = 10;
    
    /** Value of the second card in a royal flush, a jack */
    public static final int ROYAL_FLUSH_JACK = 11;
    
    /** Value of the third card in a royal flush, a queen */
    public static final int ROYAL_FLUSH_QUEEN = 12;
    
    /** Value of the fourth card in a royal flush, a king */
    public static final int ROYAL_FLUSH_KING = 13;
    
    /** Value of the fifth card in a royal flush, an ace */
    public static final int ROYAL_FLUSH_ACE = 14;
    
    /**
     * Counts the number of cards with each value in the hand
     * @return tally array containing number of cards of each value from 2 to 14.
     */
    public int[] getCounts() {
        int[] counts = new int[Card.HIGHEST_VALUE + 1];
        for (int i = 0; i < hand.length; i++) {
            counts[hand[i].getValue()]++;
        }
        return counts;
    }

    /**
     * Creates a copy of the hand sorted first by value, then by suit
     * @return copy of the hand sorted first by value, then by suit
     */
    public Card[] getSortedHand() {
        Card[] sortedHand = Arrays.copyOf(hand, hand.length);
        Arrays.sort(sortedHand);
        return sortedHand;
    }
    
    /**
     * Constructor that gets an array of Cards to be used as the hand
     *
     * @param hand array of Cards
     * @throws IllegalArgumentException if hand is null
     * @throws IllegalArgumentException if the hand array being passed to the constructor does 
     *         not have a length of 5
     * @throws IllegalArgumentException if one or more of the hand array elements is null
     */
    public Hand(Card[] hand) {
        if (hand == null) {
            throw new IllegalArgumentException("Null array");
        }
        if (hand.length != CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid array length");
        }
        for (int i = 0; i < CARDS_IN_HAND; i++) {
            if (hand[i] == null) {
                throw new IllegalArgumentException("Null element");
            }
        }
        this.hand = hand;
    }
    
    /**
     * Returns the card from the Hand array at a specified index
     *
     * @param index index of the card to be returned from the Hand array
     * @return the card from the Hand array at the given index
     * @throws IllegalArgumentException if the index is less than 0 or greater than 5
     */
    public Card getCard(int index) {
        if (index < 0 || index >= CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid index");
        }
        return hand[index];
    }
    
    /**
     * Replaces the card at the given index in the hand array with the card passed to the method
     *
     * @param index index of the card to be replaced
     * @param card new card replacing the previous card
     * @throws IllegalArgumentException if the index is less than 0 or greater than 5
     * @throws IllegalArgumentException if the card is null
     */
    public void replace(int index, Card card) {
        if (index < 0 || index >= CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid index");
        }
        if (card == null) {
            throw new IllegalArgumentException("Null card");
        }
        hand[index] = card;
    }
    
    /** 
     * Creates a String representation of the hand
     * @return a String representation of the hand
     */
    public String toString() {
        String s = "[";
        for (int i = 0; i < CARDS_IN_HAND - 1; i++) {
            s += hand[i].toString() + ", ";
        }
        s += hand[CARDS_IN_HAND - 1].toString() + "]";
        return s;
    }
    
    /**
     * Checks if this hand and another hand are equal to each other
     *
     * @param o the other hand
     * @return true if the two hands are equal
     *         false if the two hands are different
     */
    public boolean equals(Object o) {
        getSortedHand();
        int numSameCards = 0;
        Card[] sortedHand1 = getSortedHand();
        if (o instanceof Hand) {
            Hand other = (Hand)o;
            Card[] sortedHand2 = other.getSortedHand();
            for (int i = 0; i < CARDS_IN_HAND; i++) {
                if (sortedHand1[i].getSuit() == sortedHand2[i].getSuit() &&
                    sortedHand1[i].getValue() == sortedHand2[i].getValue()) {
                    numSameCards++;
                }
            }
        }
        if (numSameCards == CARDS_IN_HAND) {
            return true;
        }
        return false;
    }
    
    /**
     * Checks if all the cards in the hand have the same suit
     * @return true if all the cards in the hand have the same suit
     *         false otherwise
     */
    public boolean isFlush() {
        char referenceSuit = hand[0].getSuit();
        int numCards = 0;
        for (int i = 1; i < CARDS_IN_HAND; i++) {
            if (hand[i].getSuit() == referenceSuit) {
                numCards++;
            }
        }
        if (numCards == CARDS_IN_HAND - 1) {
            return true;
        }
        return false;
    }
    
    /**
     * Checks if the values of the cards in the hand are in sequence
     * @return true if the values of the cards in the hand are in sequence
     *         false otherwise
     */
    public boolean isStraight() {
        Card[] sortedHand = getSortedHand();
        int value = sortedHand[0].getValue();
        int numCards = 0;
        for (int i = 1; i < CARDS_IN_HAND; i++) {
            if (sortedHand[i].getValue() == (value + i)) {
                numCards++;
            }
        }
        if (numCards == CARDS_IN_HAND - 1) {
            return true;
        }
        return false;
    }
    
    /**
     * Checks if the cards in the hand have the same suit and are in sequence
     * @return true if the cards in the hand have the same suit and are in sequence
     *         false otherwise
     */
    public boolean isStraightFlush() {
        boolean flush = isFlush();
        boolean straight = isStraight();
        if (flush == true && straight == true) {
            return true;
        }
        return false;
    }
    
    /**
     * Checks if the cards in the hand have the same suit and the values 10, 11, 12, 13, 14
     * @return true if the cards in the hand have the same suit and the values 10, 11, 12, 13, 14
     *         false otherwise
     */
    public boolean isRoyalFlush() {
        Card[] sortedHand = getSortedHand();
        boolean flush = isFlush();
        if (flush == true) {
            if (sortedHand[CARD_ONE_INDEX].getValue() == ROYAL_FLUSH_TEN &&
                sortedHand[CARD_TWO_INDEX].getValue() == ROYAL_FLUSH_JACK &&
                sortedHand[CARD_THREE_INDEX].getValue() == ROYAL_FLUSH_QUEEN &&
                sortedHand[CARD_FOUR_INDEX].getValue() == ROYAL_FLUSH_KING &&
                sortedHand[CARD_FIVE_INDEX].getValue() == ROYAL_FLUSH_ACE) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the hand has four cards with the same value
     * @return true if the hand has four cards with the same value
     *         false otherwise
     */
    public boolean hasFourOfAKind() {
        for (int i = 0; i < CARDS_IN_HAND; i++) {
            int value = hand[i].getValue();
            int numCards = 0;
            for (int j = 0; j < CARDS_IN_HAND; j++) {
                if (hand[j].getValue() == value) {
                    numCards++;
                }
            } 
            if (numCards >= FOUR_OF_A_KIND) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the hand has exactly three cards with the same value
     * @return true if the hand has exactly three cards with the same value
     *         false otherwise
     */
    public boolean hasThreeOfAKind() {
        for (int i = 0; i < CARDS_IN_HAND; i++) {
            int value = hand[i].getValue();
            int numCards = 0;
            for (int j = 0; j < CARDS_IN_HAND; j++) {
                if (hand[j].getValue() == value) {
                    numCards++;
                }
            } 
            if (numCards == TRIPLE) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the hand has exactly two pairs
     * @return true if the hand has exactly two pairs
     *         false otherwise
     */
    public boolean hasTwoPairs() {
        int[] counts = getCounts();
        int numPairs = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == PAIRS) {
                numPairs++;
            }
        }
        if (numPairs == PAIRS) {
            return true;
        }
        return false;
    }
    
    /**
     * Checks if the hand contains exactly one pair
     * @return true if the hand contains exactly one pair
     *         false otherwise
     */
    public boolean hasOnePair() {
        int[] counts = getCounts();
        int numPairs = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == PAIRS) {
                numPairs++;
            }
        }
        if (numPairs == 1) {
            return true;
        }
        return false;
    }
    
    /**
     * Checks if the hand contains three cards with the same value and two other cards with the 
     * same value, but different from that of the three cards
     * @return true if the hand contains three cards with the same value and two other cards with 
     *         the same value, but different from that of the three cards
     *         false otherwise
     */
    public boolean isFullHouse() {
        int[] counts = getCounts();
        int numPairs = 0;
        int numTriples = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == PAIRS) {
                numPairs++;
            }
            if (counts[i] == TRIPLE) {
                numTriples++;
            }
        }
        if (numPairs == 1 && numTriples == 1) {
            return true;
        }
        return false;
    }
}
