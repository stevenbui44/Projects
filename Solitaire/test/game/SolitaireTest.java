package game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import structures.ArrayBasedStack;

class SolitaireTest {
	
	/*
	 	2-H		4-D		A C		5 C		3-D		4 S		Q C		3-H		8 S		4-H		J C		10 C	8 C	
		J-H		A S		7-D		K-D		A-H		9-D		10 S	3 S		7 C		8-H		2 C		6-H		J-D		
		6-D		K C		K S		10-D	2-D		Q-H		A-D		2 S		6 S		3 C		9-H		9 S		5-H		
		7 S		5-D		Q-D		K-H		Q S		5 S		4 C		7-H		J S		9 C		10-H	6 C		8-D
	 */
	
	public Solitaire game;
	
	@BeforeEach
	public void setUp() {
//		solitaire = new Solitaire("1");
//		String[] array = {"1"};
//		Solitaire.main(array);
//		System.out.println(solitaire.getStack("deck"));
		
		game = new Solitaire("1");
	}
	
	// outputs a stack without tabs or color, easier to test
	private String stackToString(ArrayBasedStack<Card> stack) {
		
		if (stack == null) {
			return "null";
		}
		if (stack.isEmpty()) {
			return "empty";
		}
		
		ArrayBasedStack<Card> temp = new ArrayBasedStack<Card>();
		
		String rtn = "";
		
	    while (!stack.isEmpty()) {
	        temp.push(stack.pop());
	        rtn = rtn + temp.top().getValue();
	        
	        if (temp.top().getColor()) {
	        	rtn = rtn + "-";
	        }
	        else {
	        	rtn = rtn + " ";
	        }
	        
	        rtn = rtn + temp.top().getFace() + "   ";
	    }
	    while (!temp.isEmpty()) {
	        stack.push(temp.pop());
	    }
		
		return rtn;
	}
	
	private void state() {
		System.out.println("Stock: " + stackToString(game.getStack("stock")));
		System.out.println("Waste: " + stackToString(game.getStack("waste")));
		System.out.println("Pile1: " + stackToString(game.getStack("openPile1")));
		System.out.println("Pile2: " + stackToString(game.getStack("openPile2")));
		System.out.println("Pile3: " + stackToString(game.getStack("openPile3")));
		System.out.println("Pile4: " + stackToString(game.getStack("openPile4")));
		System.out.println("Pile5: " + stackToString(game.getStack("openPile5")));
		System.out.println("Pile6: " + stackToString(game.getStack("openPile6")));
		System.out.println("Pile7: " + stackToString(game.getStack("openPile7")) + "\n");
	}

	@Test
	public void testGetStack() {
		// tests stock and waste
		assertNotNull(game.getStack("stock"));
		assertEquals(24, game.getStack("stock").size());

		assertNotNull(game.getStack("waste"));
		assertEquals(0, game.getStack("waste").size());
		
		// tests foundation
		assertNotNull(game.getStack("hearts"));
		assertEquals(0, game.getStack("hearts").size());
		
		// tests open and closed piles
		assertNotNull(game.getStack("openPile1"));
		assertEquals(1, game.getStack("openPile1").size());
		
		assertNotNull(game.getStack("openPile2"));
		assertEquals(1, game.getStack("openPile2").size());
		
		assertNotNull(game.getStack("closedPile2"));
		assertEquals(1, game.getStack("closedPile2").size());
		
		assertNotNull(game.getStack("openPile7"));
		assertEquals(1, game.getStack("openPile7").size());
		
		assertNotNull(game.getStack("closedPile7"));
		assertEquals(6, game.getStack("closedPile7").size());
		
		
	}
	
	@Test
	public void testMoveStockToWaste() {
//		System.out.println("Stock: " + stackToString(game.getStack("stock")));
//		System.out.println("Waste: " + stackToString(game.getStack("waste")) + "\n");
		
		// before moving stock to waste
		assertEquals(24, game.getStack("stock").size());
		assertEquals(0, game.getStack("waste").size());
		
		assertEquals("8", game.getStack("stock").top().getValue());
		assertEquals("D", game.getStack("stock").top().getFace());
		try {
			assertNull(game.getStack("waste").top());
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof EmptyStackException);
		}
		
		
		
		// moving stock to waste once
		game.moveStockToWaste();
		
//		System.out.println("Stock: " + stackToString(game.getStack("stock")));
//		System.out.println("Waste: " + stackToString(game.getStack("waste")) + "\n");
		
		assertEquals(23, game.getStack("stock").size());
		assertEquals(1, game.getStack("waste").size());
		
		assertEquals("6", game.getStack("stock").top().getValue());
		assertEquals("C", game.getStack("stock").top().getFace());
		assertEquals("8", game.getStack("waste").top().getValue());
		assertEquals("D", game.getStack("waste").top().getFace());
		
		
		
		// moving stock to waste once
		game.moveStockToWaste();
		
//		System.out.println("Stock: " + stackToString(game.getStack("stock")));
//		System.out.println("Waste: " + stackToString(game.getStack("waste")) + "\n");
		
		assertEquals(22, game.getStack("stock").size());
		assertEquals(2, game.getStack("waste").size());
		
		assertEquals("10", game.getStack("stock").top().getValue());
		assertEquals("H", game.getStack("stock").top().getFace());
		assertEquals("6", game.getStack("waste").top().getValue());
		assertEquals("C", game.getStack("waste").top().getFace());
		
		
		
		// moving stock to waste once all of stock is depleted
		for (int i = 0; i < 22; i++) {
			game.moveStockToWaste();
		}
		
//		System.out.println("Stock: " + stackToString(game.getStack("stock")));
//		System.out.println("Waste: " + stackToString(game.getStack("waste")) + "\n");
		
		try {
			assertNull(game.getStack("stock").top());
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof EmptyStackException);
		}
		assertEquals("K", game.getStack("waste").top().getValue());
		assertEquals("S", game.getStack("waste").top().getFace());
		
		
		
		// moving stock to waste after all of stock is depleted
		try {
			game.moveStockToWaste();
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		
		
		
	}
	
	@Test
	public void testMoveWasteToStock() {
//		System.out.println("Stock: " + stackToString(game.getStack("stock")));
//		System.out.println("Waste: " + stackToString(game.getStack("waste")) + "\n");
		
		// trying to call this method with no cards in waste
		try {
			game.moveWasteToStock();
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		
		
		
		// trying to call this method with some cards in waste
		game.moveStockToWaste();
		
		try {
			game.moveWasteToStock();
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		
		
		
		// calling this method with stock empty
		for (int i = 0; i < 23; i++) {
			game.moveStockToWaste();
		}
		
//		System.out.println("Stock: " + stackToString(game.getStack("stock")));
//		System.out.println("Waste: " + stackToString(game.getStack("waste")) + "\n");
		
		assertEquals(0, game.getStack("stock").size());
		assertEquals(24, game.getStack("waste").size());
	
		assertEquals("K", game.getStack("waste").top().getValue());
		assertEquals("S", game.getStack("waste").top().getFace());
		
		game.moveWasteToStock();
		
//		System.out.println("Stock: " + stackToString(game.getStack("stock")));
//		System.out.println("Waste: " + stackToString(game.getStack("waste")) + "\n");
		
		assertEquals(24, game.getStack("stock").size());
		assertEquals(0, game.getStack("waste").size());
	
		assertEquals("8", game.getStack("stock").top().getValue());
		assertEquals("D", game.getStack("stock").top().getFace());
		
	}
	
	@Test
	public void testMoveWasteToPile() {
//		state();
		
		// try moving waste to pile if there are no cards in waste
		assertEquals(24, game.getStack("stock").size());
		assertEquals(0, game.getStack("waste").size());
		assertEquals(1, game.getStack("openPile1").size());
		assertEquals(1, game.getStack("openPile2").size());
		assertEquals(1, game.getStack("openPile3").size());
		assertEquals(1, game.getStack("openPile4").size());
		assertEquals(1, game.getStack("openPile5").size());
		assertEquals(1, game.getStack("openPile6").size());
		assertEquals(1, game.getStack("openPile7").size());
	
		try {
			game.moveWasteToPile();
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		
		
		
		// try moving waste to pile when the waste cannot go in any piles
		game.moveStockToWaste();
//		state();
		
		assertEquals(23, game.getStack("stock").size());
		assertEquals(1, game.getStack("waste").size());
		assertEquals(1, game.getStack("openPile1").size());
		assertEquals(1, game.getStack("openPile2").size());
		assertEquals(1, game.getStack("openPile3").size());
		assertEquals(1, game.getStack("openPile4").size());
		assertEquals(1, game.getStack("openPile5").size());
		assertEquals(1, game.getStack("openPile6").size());
		assertEquals(1, game.getStack("openPile7").size());
		
		try {
			game.moveWasteToPile();
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		
		
		
		// try moving waste to pile when the waste can go into a pile
		for (int i = 0; i < 10; i++) {
			game.moveStockToWaste();
		}
//		state();
		
		assertEquals(13, game.getStack("stock").size());
		assertEquals(11, game.getStack("waste").size());
		assertEquals(1, game.getStack("openPile1").size());
		assertEquals(1, game.getStack("openPile2").size());
		assertEquals(1, game.getStack("openPile3").size());
		assertEquals(1, game.getStack("openPile4").size());
		assertEquals(1, game.getStack("openPile5").size());
		assertEquals(1, game.getStack("openPile6").size());
		assertEquals(1, game.getStack("openPile7").size());
		
		game.moveWasteToPile();
		
		assertEquals(13, game.getStack("stock").size());
		assertEquals(10, game.getStack("waste").size());
		assertEquals(1, game.getStack("openPile1").size());
		assertEquals(1, game.getStack("openPile2").size());
		assertEquals(1, game.getStack("openPile3").size());
		assertEquals(1, game.getStack("openPile4").size());
		assertEquals(1, game.getStack("openPile5").size());
		assertEquals(1, game.getStack("openPile6").size());
		assertEquals(2, game.getStack("openPile7").size());
		
		assertEquals("Q", game.getStack("openPile7").top().getValue());
		assertEquals("D", game.getStack("openPile7").top().getFace());
		
		
		
		
		
		
		
		// try moving waste to pile when the pile is empty and waste is not a king
		
		// try moving waste to pile when the pile is empty and waste is a king
		
		
		
		
	}
	
	@Test
	public void testMoveWasteToFoundation() {
		
	}
	
	@Test
	public void testMovePileToPile() {
		
	}
	
	@Test
	public void testMovePileToFoundation() {
		
	}
	
	@Test
	public void testMoveFoundationToPile() {
		
	}

}
