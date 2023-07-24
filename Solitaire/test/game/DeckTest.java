package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	public void testConstructor() {
		Deck deck = new Deck();
		assertEquals(52, deck.size());
		
		Suit hearts = new Suit("H");
		Suit diamonds = new Suit("D");
		Suit clubs = new Suit("C");
		Suit spades = new Suit("S");
		
		for (int i = 0; i < 13; i++) {
			assertTrue(deck.contains(hearts.getCard(i)));
			assertTrue(deck.contains(diamonds.getCard(i)));
			assertTrue(deck.contains(clubs.getCard(i)));
			assertTrue(deck.contains(spades.getCard(i)));
		}
	}
	
	@Test
	public void testToString() {
		// TODO: implement this after you finish the project and you don't have to worry about ansi messing up with formatting. this seems annoying
	}
	
	@Test
	public void shuffle() {
		// this tests that two unshuffled decks have the same cards in the same order
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		
		for (int i = 0; i < 52; i++) {
			Card card1 = deck1.removeCard();
			Card card2 = deck2.removeCard();
			assertEquals(card1.getFace(), card2.getFace());
			assertEquals(card1.getValue(), card2.getValue());
		}
		
		// this tests that two shuffled decks have the same cards in a (likely) different order
		Deck deck3 = new Deck();
		Deck deck4 = new Deck();
		deck4.shuffle();
		
		boolean different = false;
		for (int i = 0; i < 52; i++) {
			Card card3 = deck3.removeCard();
			Card card4 = deck4.removeCard();
			if (!card3.getFace().equals(card4.getFace()) || !card3.getValue().equals(card4.getValue())) {
				different = true;
			}
		}
		
		assertTrue(different);
		
	}
	
	@Test
	public void shuffleWithSeed() {
		Deck deck = new Deck();
		deck.shuffle(1);
				
		Card card1 = deck.removeCard();
		assertEquals("2", card1.getValue());
		assertEquals("H", card1.getFace());
		
		Card card2 = deck.removeCard();
		assertEquals("4", card2.getValue());
		assertEquals("D", card2.getFace());
		
		Card card3 = deck.removeCard();
		assertEquals("A", card3.getValue());
		assertEquals("C", card3.getFace());
	}
	
	@Test
	public void testRemoveCard() {
		Deck deck = new Deck();
		assertFalse(deck.isEmpty());
		assertEquals(52, deck.size());
		
		for (int i = 0; i < 52; i++) {
			deck.removeCard();
		}
		
		assertTrue(deck.isEmpty());
		assertEquals(0, deck.size());
		
		Card temp = deck.removeCard();
		assertNull(temp);
	}
	
	@Test
	public void testContains() {
		Deck deck = new Deck();
		
		Suit hearts = new Suit("H");
		Suit diamonds = new Suit("D");
		Suit clubs = new Suit("C");
		Suit spades = new Suit("S");
		
		for (int i = 0; i < 13; i++) {
			assertTrue(deck.contains(hearts.getCard(i)));
			assertTrue(deck.contains(diamonds.getCard(i)));
			assertTrue(deck.contains(clubs.getCard(i)));
			assertTrue(deck.contains(spades.getCard(i)));
		}
		
		assertFalse(deck.contains(new Card("Steven", "Bui")));
		
	}

}
