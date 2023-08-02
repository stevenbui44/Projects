import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Card class
 * @author Suzanne Balik
 * @author Steven Bui
 */
public class CardTest {

    /** card two of hearts for testing */
    private Card twoOfHearts;
    
    /** card three of spades for testing */
    private Card threeOfSpades;

    /**
     * Create cards for testing
     */
    @BeforeEach
    public void setUp() {
        twoOfHearts = new Card(2, 'h');
        threeOfSpades = new Card(3, 's');
    }

    /**
     * Tests that constants are correct
     */
    @Test
    public void testConstants() {
        // The following tests test that constants are defined as specified
        assertEquals('c', Card.CLUBS, "CLUBS");
        assertEquals('d', Card.DIAMONDS, "DIAMONDS");
        assertEquals('s', Card.SPADES, "SPADES");
        assertEquals('h', Card.HEARTS, "HEARTS");
        assertEquals(2, Card.LOWEST_VALUE, "LOWEST_VALUE");
        assertEquals(14, Card.HIGHEST_VALUE, "HIGHEST_VALUE");
    }

    /**
     * Tests getValue with two of hearts
     */
    @Test
    public void testGetValueTwoOfHearts() {
        assertEquals(2, twoOfHearts.getValue(), "twoOfHearts value");
    }

    /**
     * Tests getValue with three of spades
     */
    @Test
    public void testGetValueThreeOfSpades() {
        assertEquals(3, threeOfSpades.getValue(), "threeOfSpades value");
    }

    /**
     * Tests getSuit with two of hearts
     */
    @Test
    public void testGetSuitTwoOfHearts() {
        assertEquals('h', twoOfHearts.getSuit(), "twoOfHearts suit");
    }
    
    /**
     * Tests getSuit for three of spades
     */
    @Test
    public void testGetSuitThreeOfSpades() {
        assertEquals('s', threeOfSpades.getSuit(), "threeOfSpades suit");
    }

    /**
     * Tests toString with two of hearts
     */
    @Test
    public void testToStringTwoOfHearts() {
        assertEquals("h2", twoOfHearts.toString(), "twoOfHearts toString");
    }
    
    /**
     * Tests toString with three of spades
     */
    @Test
    public void testToStringThreeOfSpades() {
        assertEquals("s3", threeOfSpades.toString(), "threeOfSpades toString");
    }

    /**
     * Tests equals with two of hearts
     */
    @Test
    public void testEqualsTwoOfHearts() {
        assertTrue(twoOfHearts.equals(twoOfHearts), "twoOfHearts equals with same instance");
        assertTrue(twoOfHearts.equals(new Card(2, 'h')), 
                   "twoOfHearts equals with different instances");
        assertFalse(twoOfHearts.equals(new Card(4, 'h')), "twoOfHearts with different value");
        assertFalse(twoOfHearts.equals(new Card(2, 's')), "twoOfHearts with different suit");
        assertFalse(twoOfHearts.equals(new Card(5, 'c')), 
                    "twoOfHearts with different value and suit");
        assertFalse(twoOfHearts.equals(null), "twoOfHearts compared to null object");
        assertFalse(twoOfHearts.equals("twoOfHearts"), "twoOfHearts compared to String");
    }
    
    /**
     * Tests equals with three of spades
     */
    @Test
    public void testEqualsThreeOfSpades() {
        assertTrue(threeOfSpades.equals(threeOfSpades), "threeOfSpades equals with same instance");
        assertTrue(threeOfSpades.equals(new Card(3, 's')), 
                   "threeOfSpades equals with different instances");
        assertFalse(threeOfSpades.equals(new Card(4, 's')), "threeOfSpades with different value");
        assertFalse(threeOfSpades.equals(new Card(3, 'd')), "threeOfSpades with different suit");
        assertFalse(threeOfSpades.equals(new Card(5, 'c')), 
                    "threeOfSpades with different value and suit");
        assertFalse(threeOfSpades.equals(null), "threeOfSpades compared to null object");
        assertFalse(threeOfSpades.equals("threeOfSpades"), "threeOfSpades compared to String");
    }

    /**
     * Tests exceptions
     */
    @Test
    public void testExceptions() {
        // Testing constructor with low invalid value
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> new Card(1, 'h'), "Constructor value 1");
        assertEquals("Invalid value", exception.getMessage(),
                "Testing value 1 message");
                
        // Testing constructor with high invalid value
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card(15, 's'), "Constructor value 15");
        assertEquals("Invalid value", exception.getMessage(),
                "Testing value 15 message");
                
        // Testing constructor with invalid value and invalid suit
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card(0, 'w'), "Constructor value 0 suit w");
        assertEquals("Invalid value", exception.getMessage(),
                "Testing value 0 suit w message");
                
        // Testing constructor with invalid lowercase suit
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card(5, 'x'), "Constructor suit x");
        assertEquals("Invalid suit", exception.getMessage(),
                "Testing suit x message");
                
        // Testing constructor with invalid uppercase suit
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card(5, 'D'), "Constructor suit D");
        assertEquals("Invalid suit", exception.getMessage(),
                "Testing suit D message");
    }
}
