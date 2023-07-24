package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardTest {

	@Test
	public void testConstructor() {
		// testing a regular face card
		Card card = new Card("10", "H");
		assertEquals("10", card.getValue());
		assertEquals("H", card.getFace());
		assertTrue(card.getColor());
		
		// testing an irregular face card
		Card card2 = new Card("Steven", "Bui");
		assertEquals("Steven", card2.getValue());
		assertEquals("Bui", card2.getFace());
		assertFalse(card2.getColor());
	}
	
	@Test
	public void testToString() {
		// testing a red card
		Card card = new Card("10", "H");
		assertEquals("\u001B[31m10 H\u001B[0m", card.toString());
		
		// testing a black card
		Card card2 = new Card("4", "S");
		assertEquals("4 S", card2.toString());
	}
	
	@Test
	public void testUpdateValue() {
		// king face card
		Card card = new Card("K", "H");
		assertEquals("K", card.getValue());
		assertEquals("13", card.updateValue());
		
		// queen face card
		Card card2 = new Card("Q", "H");
		assertEquals("Q", card2.getValue());
		assertEquals("12", card2.updateValue());
		
		// jack face card
		Card card3 = new Card("J", "H");
		assertEquals("J", card3.getValue());
		assertEquals("11", card3.updateValue());
		
		// ace face card
		Card card4 = new Card("A", "H");
		assertEquals("A", card4.getValue());
		assertEquals("1", card4.updateValue());
		
		// regular face card
		Card card5 = new Card("5", "H");
		assertEquals("5", card5.getValue());
		assertEquals("5", card5.updateValue());
	}

}
