package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SuitTest {

	@Test
	public void testConstructor() {
		Suit suit = new Suit("H");
		assertEquals("A", suit.getCard(0).getValue());
		assertEquals("2", suit.getCard(1).getValue());
		assertEquals("3", suit.getCard(2).getValue());
		assertEquals("4", suit.getCard(3).getValue());
		assertEquals("5", suit.getCard(4).getValue());
		assertEquals("6", suit.getCard(5).getValue());
		assertEquals("7", suit.getCard(6).getValue());
		assertEquals("8", suit.getCard(7).getValue());
		assertEquals("9", suit.getCard(8).getValue());
		assertEquals("10", suit.getCard(9).getValue());
		assertEquals("J", suit.getCard(10).getValue());
		assertEquals("Q", suit.getCard(11).getValue());
		assertEquals("K", suit.getCard(12).getValue());
		
		for (int i = 0; i < 13; i++) {
			assertEquals("H", suit.getCard(i).getFace());
		}
	}
	
	@Test
	public void testToString() {
		// black suit
		Suit suit = new Suit("S");
		String blackSuit = "";
		blackSuit = blackSuit + "A S\t"; 
		blackSuit = blackSuit + "2 S\t"; 
		blackSuit = blackSuit + "3 S\t"; 
		blackSuit = blackSuit + "4 S\t"; 
		blackSuit = blackSuit + "5 S\t"; 
		blackSuit = blackSuit + "6 S\t"; 
		blackSuit = blackSuit + "7 S\t"; 
		blackSuit = blackSuit + "8 S\t"; 
		blackSuit = blackSuit + "9 S\t"; 
		blackSuit = blackSuit + "10 S\t"; 
		blackSuit = blackSuit + "J S\t"; 
		blackSuit = blackSuit + "Q S\t"; 
		blackSuit = blackSuit + "K S\t"; 
		
		assertEquals(blackSuit, suit.toString());
		
		// red suit
		Suit suit2 = new Suit("H");
		String redSuit = "";
		redSuit = redSuit + "\u001B[31m" + "A H" + "\u001B[0m" + "\t";
		redSuit = redSuit + "\u001B[31m" + "2 H" + "\u001B[0m" + "\t";
		redSuit = redSuit + "\u001B[31m" + "3 H" + "\u001B[0m" + "\t";
		redSuit = redSuit + "\u001B[31m" + "4 H" + "\u001B[0m" + "\t";
		redSuit = redSuit + "\u001B[31m" + "5 H" + "\u001B[0m" + "\t";
		redSuit = redSuit + "\u001B[31m" + "6 H" + "\u001B[0m" + "\t";
		redSuit = redSuit + "\u001B[31m" + "7 H" + "\u001B[0m" + "\t";
		redSuit = redSuit + "\u001B[31m" + "8 H" + "\u001B[0m" + "\t";
		redSuit = redSuit + "\u001B[31m" + "9 H" + "\u001B[0m" + "\t";
		redSuit = redSuit + "\u001B[31m" + "10 H" + "\u001B[0m" + "\t";
		redSuit = redSuit + "\u001B[31m" + "J H" + "\u001B[0m" + "\t";
		redSuit = redSuit + "\u001B[31m" + "Q H" + "\u001B[0m" + "\t";
		redSuit = redSuit + "\u001B[31m" + "K H" + "\u001B[0m" + "\t";

		assertEquals(redSuit, suit2.toString());
	}

}
