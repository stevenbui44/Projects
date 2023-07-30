package game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import structures.ArrayBasedStack;

// TODO: this is just testing the auto play feature, as an update you should add a manual feature where you choose what stack the card goes in

public class SolitaireTest {
	
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
		
		StringBuilder rtn = new StringBuilder();
		
	    while (!stack.isEmpty()) {
	        temp.push(stack.pop());
//	        String value = temp.top().getValue();
//	        String face = temp.top().getFace();
//	        boolean color = temp.top().getColor();
	        
	        
//	        rtn = rtn + temp.top().getValue();
//	        
//	        if (temp.top().getColor()) {
//	        	rtn = rtn + "-";
//	        }
//	        else {
//	        	rtn = rtn + " ";
//	        }
//	        
//	        rtn = rtn + temp.top().getFace();
//	        
//	        if (temp.top().getValue().equals("10")) {
//	        	rtn = rtn + "  ";
//	        }
//	        else {
//	        	rtn = rtn + "   ";
//	        }
	    	
	    	
	    }
	    while (!temp.isEmpty()) {
	        stack.push(temp.pop());
	        
	        String value = stack.top().getValue();
	        String face = stack.top().getFace();
	        boolean color = stack.top().getColor();
	        
	        rtn.append( value + (color ? "-" : " "));
	        rtn.append(face);
	        rtn.append( (value.equals("10") ? "  " : "   ") );
	        
	    }
		
		return rtn.toString();
	}
	
//	private void state() {
//		System.out.println("Stock: " + stackToString(game.stock()));
//		System.out.println("Waste: " + stackToString(game.waste()));
//		System.out.println("- - - - -");
//		System.out.println("Closed 1: " + stackToString(game.closedTableau()[0]));
//		System.out.println("Closed 2: " + stackToString(game.closedTableau()[1]));
//		System.out.println("Closed 3: " + stackToString(game.closedTableau()[2]));
//		System.out.println("Closed 4: " + stackToString(game.closedTableau()[3]));
//		System.out.println("Closed 5: " + stackToString(game.closedTableau()[4]));
//		System.out.println("Closed 6: " + stackToString(game.closedTableau()[5]));
//		System.out.println("Closed 7: " + stackToString(game.closedTableau()[6]));
//		System.out.println("- - - - -");
//		System.out.println("Open 1: " + stackToString(game.openTableau()[0]));
//		System.out.println("Open 2: " + stackToString(game.openTableau()[1]));
//		System.out.println("Open 3: " + stackToString(game.openTableau()[2]));
//		System.out.println("Open 4: " + stackToString(game.openTableau()[3]));
//		System.out.println("Open 5: " + stackToString(game.openTableau()[4]));
//		System.out.println("Open 6: " + stackToString(game.openTableau()[5]));
//		System.out.println("Open 7: " + stackToString(game.openTableau()[6]));
//		System.out.println("- - - - -");
//		System.out.println("Hearts:   " + stackToString(game.foundation()[0]));
//		System.out.println("Diamonds: " + stackToString(game.foundation()[1]));
//		System.out.println("Clubs:    " + stackToString(game.foundation()[2]));
//		System.out.println("Spades:   " + stackToString(game.foundation()[3]) + "\n\n\n");
//	}
	
	public void state() {
		state(game);
	}
	
	
	
	private void state(Solitaire game) {
		System.out.println("Stock: " + stackToString(game.stock()));
		System.out.println("Waste: " + stackToString(game.waste()));
		System.out.println("- - - - -");
		System.out.println("Closed 1: " + stackToString(game.closedTableau()[0]));
		System.out.println("Closed 2: " + stackToString(game.closedTableau()[1]));
		System.out.println("Closed 3: " + stackToString(game.closedTableau()[2]));
		System.out.println("Closed 4: " + stackToString(game.closedTableau()[3]));
		System.out.println("Closed 5: " + stackToString(game.closedTableau()[4]));
		System.out.println("Closed 6: " + stackToString(game.closedTableau()[5]));
		System.out.println("Closed 7: " + stackToString(game.closedTableau()[6]));
		System.out.println("- - - - -");
		System.out.println("Open 1: " + stackToString(game.openTableau()[0]));
		System.out.println("Open 2: " + stackToString(game.openTableau()[1]));
		System.out.println("Open 3: " + stackToString(game.openTableau()[2]));
		System.out.println("Open 4: " + stackToString(game.openTableau()[3]));
		System.out.println("Open 5: " + stackToString(game.openTableau()[4]));
		System.out.println("Open 6: " + stackToString(game.openTableau()[5]));
		System.out.println("Open 7: " + stackToString(game.openTableau()[6]));
		System.out.println("- - - - -");
		System.out.println("Hearts:   " + stackToString(game.foundation()[0]));
		System.out.println("Diamonds: " + stackToString(game.foundation()[1]));
		System.out.println("Clubs:    " + stackToString(game.foundation()[2]));
		System.out.println("Spades:   " + stackToString(game.foundation()[3]) + "\n\n\n");
	}
	
	

	@Test
	public void testGetStack() {
		// tests stock and waste
		assertNotNull(game.stock());
		assertEquals(24, game.stock().size());

		assertNotNull(game.waste());
		assertEquals(0, game.waste().size());
		
		// tests foundation
		assertNotNull(game.foundation()[0]);
		assertEquals(0, game.foundation()[0].size());
		
		// tests open and closed piles
		assertNotNull(game.openTableau()[0]);
		assertEquals(1, game.openTableau()[0].size());
		
		assertNull(game.closedTableau()[0]);
		
		assertNotNull(game.openTableau()[1]);
		assertEquals(1, game.openTableau()[1].size());
		
		assertNotNull(game.closedTableau()[1]);
		assertEquals(1, game.closedTableau()[1].size());
		
		assertNotNull(game.openTableau()[6]);
		assertEquals(1, game.openTableau()[6].size());
		
		assertNotNull(game.closedTableau()[6]);
		assertEquals(6, game.closedTableau()[6].size());
		
//		state();
	}
	
	@Test
	public void testMoveStockToWaste() {
//		System.out.println("Stock: " + stackToString(game.getStack("stock")));
//		System.out.println("Waste: " + stackToString(game.getStack("waste")) + "\n");
		
		// before moving stock to waste
		assertEquals(24, game.stock().size());
		assertEquals(0, game.waste().size());
		
		assertEquals("8", game.stock().top().getValue());
		assertEquals("D", game.stock().top().getFace());
		try {
			assertNull(game.waste().top());
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof EmptyStackException);
		}
	
		
		
		
		// moving stock to waste once
		game.moveStockToWaste();
		
//		System.out.println("Stock: " + stackToString(game.getStack("stock")));
//		System.out.println("Waste: " + stackToString(game.getStack("waste")) + "\n");
		
		assertEquals(23, game.stock().size());
		assertEquals(1, game.waste().size());
		
		assertEquals("6", game.stock().top().getValue());
		assertEquals("C", game.stock().top().getFace());
		assertEquals("8", game.waste().top().getValue());
		assertEquals("D", game.waste().top().getFace());
		
		
		
		// moving stock to waste once
		game.moveStockToWaste();
		
//		System.out.println("Stock: " + stackToString(game.getStack("stock")));
//		System.out.println("Waste: " + stackToString(game.getStack("waste")) + "\n");
		
		assertEquals(22, game.stock().size());
		assertEquals(2, game.waste().size());
		
		assertEquals("10", game.stock().top().getValue());
		assertEquals("H", game.stock().top().getFace());
		assertEquals("6", game.waste().top().getValue());
		assertEquals("C", game.waste().top().getFace());
		
		
		
		// moving stock to waste once all of stock is depleted
		for (int i = 0; i < 22; i++) {
			game.moveStockToWaste();
		}
		
//		System.out.println("Stock: " + stackToString(game.getStack("stock")));
//		System.out.println("Waste: " + stackToString(game.getStack("waste")) + "\n");
		
		try {
			assertNull(game.stock().top());
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof EmptyStackException);
		}
		assertEquals("K", game.waste().top().getValue());
		assertEquals("S", game.waste().top().getFace());
		
		
		
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
		
		assertEquals(0, game.stock().size());
		assertEquals(24, game.waste().size());
	
		assertEquals("K", game.waste().top().getValue());
		assertEquals("S", game.waste().top().getFace());
		
		game.moveWasteToStock();
		
//		System.out.println("Stock: " + stackToString(game.getStack("stock")));
//		System.out.println("Waste: " + stackToString(game.getStack("waste")) + "\n");
		
		assertEquals(24, game.stock().size());
		assertEquals(0, game.waste().size());
	
		assertEquals("8", game.stock().top().getValue());
		assertEquals("D", game.stock().top().getFace());
		
	}
	
	@Test
	public void testMoveWasteToPile() {
//		state();
		
		// try moving waste to pile if there are no cards in waste
		assertEquals(24, game.stock().size());
		assertEquals(0, game.waste().size());
		assertEquals(1, game.openTableau()[0].size());
		assertEquals(1, game.openTableau()[1].size());
		assertEquals(1, game.openTableau()[2].size());
		assertEquals(1, game.openTableau()[3].size());
		assertEquals(1, game.openTableau()[4].size());
		assertEquals(1, game.openTableau()[5].size());
		assertEquals(1, game.openTableau()[6].size());
	
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
		
		assertEquals(23, game.stock().size());
		assertEquals(1, game.waste().size());
		assertEquals(1, game.openTableau()[0].size());
		assertEquals(1, game.openTableau()[1].size());
		assertEquals(1, game.openTableau()[2].size());
		assertEquals(1, game.openTableau()[3].size());
		assertEquals(1, game.openTableau()[4].size());
		assertEquals(1, game.openTableau()[5].size());
		assertEquals(1, game.openTableau()[6].size());
		
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
		
		assertEquals(13, game.stock().size());
		assertEquals(11, game.waste().size());
		assertEquals(1, game.openTableau()[0].size());
		assertEquals(1, game.openTableau()[1].size());
		assertEquals(1, game.openTableau()[2].size());
		assertEquals(1, game.openTableau()[3].size());
		assertEquals(1, game.openTableau()[4].size());
		assertEquals(1, game.openTableau()[5].size());
		assertEquals(1, game.openTableau()[6].size());
		
		game.moveWasteToPile();
		
		assertEquals(13, game.stock().size());
		assertEquals(10, game.waste().size());
		assertEquals(1, game.openTableau()[0].size());
		assertEquals(1, game.openTableau()[1].size());
		assertEquals(1, game.openTableau()[2].size());
		assertEquals(1, game.openTableau()[3].size());
		assertEquals(1, game.openTableau()[4].size());
		assertEquals(1, game.openTableau()[5].size());
		assertEquals(2, game.openTableau()[6].size());
		
		assertEquals("Q", game.openTableau()[6].top().getValue());
		assertEquals("D", game.openTableau()[6].top().getFace());
		
		
		
		
		
		
		
		// try moving waste to pile when the pile is empty and waste is not a king
		
		// try moving waste to pile when the pile is empty and waste is a king
		
		// TODO: not done
		
		
		
		
	}
	
	@Test
	public void testMoveWasteToFoundation() {
		
//		state();
		
		// try moving waste to foundation when waste is empty
		assertEquals(24, game.stock().size());
		assertEquals(0, game.waste().size());
		assertEquals(0, game.foundation()[0].size());
		assertEquals(0, game.foundation()[1].size());
		assertEquals(0, game.foundation()[2].size());
		assertEquals(0, game.foundation()[3].size());
		
		try {
			game.moveWasteToFoundation();
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		
		
		
		// try moving waste to foundation when the waste can't go into foundation
		game.moveStockToWaste();
//		state();
		
		assertEquals(23, game.stock().size());
		assertEquals(1, game.waste().size());
		assertEquals(0, game.foundation()[0].size());
		assertEquals(0, game.foundation()[1].size());
		assertEquals(0, game.foundation()[2].size());
		assertEquals(0, game.foundation()[3].size());
		
		try {
			game.moveWasteToFoundation();
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		
		
		
		
		// try moving waste to foundation when the waste can go into foundation and foundation is empty
//		state();
		for (int i = 0; i < 19; i++) {
			game.moveStockToWaste();
		}
//		state();
		
		assertEquals(4, game.stock().size());
		assertEquals(20, game.waste().size());
		assertEquals(0, game.foundation()[0].size());
		assertEquals(0, game.foundation()[1].size());
		assertEquals(0, game.foundation()[2].size());
		assertEquals(0, game.foundation()[3].size());
		
		game.moveWasteToFoundation();
		
		assertEquals(4, game.stock().size());
		assertEquals(19, game.waste().size());
		assertEquals(0, game.foundation()[0].size());
		assertEquals(1, game.foundation()[1].size());
		assertEquals(0, game.foundation()[2].size());
		assertEquals(0, game.foundation()[3].size());
		
		assertEquals("A", game.foundation()[1].top().getValue());
		assertEquals("D", game.foundation()[1].top().getFace());
		
		
		
		// try moving waste to foundation when the waste can go into foundation and foundation already has cards
		for (int i = 0; i < 2; i++) {
			game.moveStockToWaste();
		}
//		state();
		
		assertEquals(2, game.stock().size());
		assertEquals(21, game.waste().size());
		assertEquals(0, game.foundation()[0].size());
		assertEquals(1, game.foundation()[1].size());
		assertEquals(0, game.foundation()[2].size());
		assertEquals(0, game.foundation()[3].size());
		
		game.moveWasteToFoundation();
		
		assertEquals(2, game.stock().size());
		assertEquals(20, game.waste().size());
		assertEquals(0, game.foundation()[0].size());
		assertEquals(2, game.foundation()[1].size());
		assertEquals(0, game.foundation()[2].size());
		assertEquals(0, game.foundation()[3].size());
		
		assertEquals("2", game.foundation()[1].top().getValue());
		assertEquals("D", game.foundation()[1].top().getFace());
		
//		state();
		
		
	}
	
//	@Test
//	public void testMovePile() {
////		state();
//		
//		// moving a pile with one card to another pile, where pile A goes empty
//		assertEquals(24, game.stock().size());
//		assertEquals(0, game.waste().size());
//		
//		assertEquals(0, game.foundation()[0].size());
//		assertEquals(0, game.foundation()[1].size());
//		assertEquals(0, game.foundation()[2].size());
//		assertEquals(0, game.foundation()[3].size());
//		
//		assertEquals(1, game.openTableau()[0].size());
//		assertEquals(1, game.openTableau()[1].size());
//		assertEquals(1, game.openTableau()[2].size());
//		assertEquals(1, game.openTableau()[3].size());
//		assertEquals(1, game.openTableau()[4].size());
//		assertEquals(1, game.openTableau()[5].size());
//		assertEquals(1, game.openTableau()[6].size());
//		
//		assertNull(game.closedTableau()[0]);
//		assertEquals(1, game.closedTableau()[1].size());
//		assertEquals(2, game.closedTableau()[2].size());
//		assertEquals(3, game.closedTableau()[3].size());
//		assertEquals(4, game.closedTableau()[4].size());
//		assertEquals(5, game.closedTableau()[5].size());
//		assertEquals(6, game.closedTableau()[6].size());
//		
//		assertEquals("2-H   ", stackToString(game.openTableau()[0]));
//		assertEquals("3 S   ", stackToString(game.openTableau()[5]));
//		
//		game.movePileToPile();
//		
//		assertEquals(24, game.stock().size());
//		assertEquals(0, game.waste().size());
//		
//		assertEquals(0, game.foundation()[0].size());
//		assertEquals(0, game.foundation()[1].size());
//		assertEquals(0, game.foundation()[2].size());
//		assertEquals(0, game.foundation()[3].size());
//		
//		assertEquals(0, game.openTableau()[0].size());
//		assertEquals(1, game.openTableau()[1].size());
//		assertEquals(1, game.openTableau()[2].size());
//		assertEquals(1, game.openTableau()[3].size());
//		assertEquals(1, game.openTableau()[4].size());
//		assertEquals(2, game.openTableau()[5].size());
//		assertEquals(1, game.openTableau()[6].size());
//		
//		assertNull(game.closedTableau()[0]);
//		assertEquals(1, game.closedTableau()[1].size());
//		assertEquals(2, game.closedTableau()[2].size());
//		assertEquals(3, game.closedTableau()[3].size());
//		assertEquals(4, game.closedTableau()[4].size());
//		assertEquals(5, game.closedTableau()[5].size());
//		assertEquals(6, game.closedTableau()[6].size());
//		
//		assertEquals("empty", stackToString(game.openTableau()[0]));
//		assertEquals("3 S   2-H   ", stackToString(game.openTableau()[5]));
//		
//		
//		
//		// moving a king card to a pile with no cards
////		state();
//		
//		assertEquals("empty", stackToString(game.openTableau()[0]));
//		assertEquals("K C   ", stackToString(game.openTableau()[6]));
//		assertEquals(0, game.openTableau()[0].size());
//		assertEquals(1, game.openTableau()[6].size());
//		assertNull(game.closedTableau()[0]);
//		assertEquals(6, game.closedTableau()[6].size());
//		assertEquals("7 C   8-H   2 C   6-H   J-D   6-D   ", stackToString(game.closedTableau()[6]));
//
//		game.movePileToPile();
//		
//		assertEquals("K C   ", stackToString(game.openTableau()[0]));
//		assertEquals("6-D   ", stackToString(game.openTableau()[6]));
//		assertEquals(1, game.openTableau()[0].size());
//		assertEquals(1, game.openTableau()[6].size());
//		assertNull(game.closedTableau()[0]);
//		assertEquals(5, game.closedTableau()[6].size());
//		assertEquals("7 C   8-H   2 C   6-H   J-D   ", stackToString(game.closedTableau()[6]));
//				
//		
//		
//		// moving a pile with one card to another pile, where pile A gets from closed pile
////		state();
//		
//		assertEquals("A C   ", stackToString(game.openTableau()[1]));
//		assertEquals("3 S   2-H   ", stackToString(game.openTableau()[5]));
//		assertEquals(1, game.openTableau()[1].size());
//		assertEquals(2, game.openTableau()[5].size());
//		assertEquals(1, game.closedTableau()[1].size());
//		assertEquals(5, game.closedTableau()[5].size());
//		assertEquals("4-D   ", stackToString(game.closedTableau()[1]));
//		
//		game.movePileToPile();
//		
//		assertEquals("4-D   ", stackToString(game.openTableau()[1]));
//		assertEquals("3 S   2-H   A C   ", stackToString(game.openTableau()[5]));
//		assertEquals(1, game.openTableau()[1].size());
//		assertEquals(3, game.openTableau()[5].size());
//		assertEquals(0, game.closedTableau()[1].size());
//		assertEquals(5, game.closedTableau()[5].size());
//		assertEquals("empty", stackToString(game.closedTableau()[1]));
//		
////		state();
//		
//		
//		// moving an entire pile with multiple cards to another pile
//		
//		// try to open pile 6 to open pile 2 (not 4, you want 2 to get the pile empty faster)
////		game.movePileToPile();
//
//
//		
//		
//		// TODO: maybe implement later
//		// moving middle of pile to another pile (you use this if you have to move a card to foundation)
//		
//	}
	
	@Test
	public void testMovePileToFoundation() {
//		state();
		
		// moving pile to foundation when there are cards in pile that can go in foundation when foundation is empty
		assertEquals(24, game.stock().size());
		assertEquals(0, game.waste().size());
		
		assertEquals(0, game.foundation()[0].size());
		assertEquals(0, game.foundation()[1].size());
		assertEquals(0, game.foundation()[2].size());
		assertEquals(0, game.foundation()[3].size());
		
		assertEquals(1, game.openTableau()[0].size());
		assertEquals(1, game.openTableau()[1].size());
		assertEquals(1, game.openTableau()[2].size());
		assertEquals(1, game.openTableau()[3].size());
		assertEquals(1, game.openTableau()[4].size());
		assertEquals(1, game.openTableau()[5].size());
		assertEquals(1, game.openTableau()[6].size());
		
		assertNull(game.closedTableau()[0]);
		assertEquals(1, game.closedTableau()[1].size());
		assertEquals(2, game.closedTableau()[2].size());
		assertEquals(3, game.closedTableau()[3].size());
		assertEquals(4, game.closedTableau()[4].size());
		assertEquals(5, game.closedTableau()[5].size());
		assertEquals(6, game.closedTableau()[6].size());
		
		game.movePileToFoundation();		
		
		assertEquals(24, game.stock().size());
		assertEquals(0, game.waste().size());
		
		assertEquals(0, game.foundation()[0].size());
		assertEquals(0, game.foundation()[1].size());
		assertEquals(1, game.foundation()[2].size());
		assertEquals(0, game.foundation()[3].size());
		
		assertEquals(1, game.openTableau()[0].size());
		assertEquals(1, game.openTableau()[1].size());
		assertEquals(1, game.openTableau()[2].size());
		assertEquals(1, game.openTableau()[3].size());
		assertEquals(1, game.openTableau()[4].size());
		assertEquals(1, game.openTableau()[5].size());
		assertEquals(1, game.openTableau()[6].size());
		
		assertNull(game.closedTableau()[0]);
		assertEquals(0, game.closedTableau()[1].size());
		assertEquals(2, game.closedTableau()[2].size());
		assertEquals(3, game.closedTableau()[3].size());
		assertEquals(4, game.closedTableau()[4].size());
		assertEquals(5, game.closedTableau()[5].size());
		assertEquals(6, game.closedTableau()[6].size());
		
		game.movePileToFoundation();		
		
		assertEquals(24, game.stock().size());
		assertEquals(0, game.waste().size());
		
		assertEquals(0, game.foundation()[0].size());
		assertEquals(0, game.foundation()[1].size());
		assertEquals(1, game.foundation()[2].size());
		assertEquals(1, game.foundation()[3].size());
		
		assertEquals(1, game.openTableau()[0].size());
		assertEquals(1, game.openTableau()[1].size());
		assertEquals(1, game.openTableau()[2].size());
		assertEquals(1, game.openTableau()[3].size());
		assertEquals(1, game.openTableau()[4].size());
		assertEquals(1, game.openTableau()[5].size());
		assertEquals(1, game.openTableau()[6].size());
		
		assertNull(game.closedTableau()[0]);
		assertEquals(0, game.closedTableau()[1].size());
		assertEquals(2, game.closedTableau()[2].size());
		assertEquals(3, game.closedTableau()[3].size());
		assertEquals(3, game.closedTableau()[4].size());
		assertEquals(5, game.closedTableau()[5].size());
		assertEquals(6, game.closedTableau()[6].size());
		
		
		
		// moving pile to foundation when there are cards in pile that can go in foundation when foundation is not empty
//		state();
				
		for (int i = 0; i < 19; i++) {
			game.moveStockToWaste();
		}
		
//		state();
		assertEquals(5, game.stock().size());
		assertEquals(19, game.waste().size());
		
		assertEquals(0, game.foundation()[0].size());
		assertEquals(0, game.foundation()[1].size());
		assertEquals(1, game.foundation()[2].size());
		assertEquals(1, game.foundation()[3].size());
		
		assertEquals(1, game.openTableau()[0].size());
		assertEquals(1, game.openTableau()[1].size());
		assertEquals(1, game.openTableau()[2].size());
		assertEquals(1, game.openTableau()[3].size());
		assertEquals(1, game.openTableau()[4].size());
		assertEquals(1, game.openTableau()[5].size());
		assertEquals(1, game.openTableau()[6].size());
		
		assertNull(game.closedTableau()[0]);
		assertEquals(0, game.closedTableau()[1].size());
		assertEquals(2, game.closedTableau()[2].size());
		assertEquals(3, game.closedTableau()[3].size());
		assertEquals(3, game.closedTableau()[4].size());
		assertEquals(5, game.closedTableau()[5].size());
		assertEquals(6, game.closedTableau()[6].size());
		
		game.moveWasteToFoundation();
		
		assertEquals("A S   2 S   ", stackToString(game.foundation()[3]));
		assertEquals("3 S   ", stackToString(game.openTableau()[5]));
//		state();
		
		game.movePileToFoundation();
		assertEquals("A S   2 S   3 S   ", stackToString(game.foundation()[3]));
		
		game.movePileToFoundation();
		assertEquals("A S   2 S   3 S   4 S   ", stackToString(game.foundation()[3]));
		
		
		
		// moving pile to foundation when there are no cards in pile that can go in foundation
//		state();
		
		assertEquals(5, game.stock().size());
		assertEquals(18, game.waste().size());
		
		assertEquals(0, game.foundation()[0].size());
		assertEquals(0, game.foundation()[1].size());
		assertEquals(1, game.foundation()[2].size());
		assertEquals(4, game.foundation()[3].size());
		
		assertEquals(1, game.openTableau()[0].size());
		assertEquals(1, game.openTableau()[1].size());
		assertEquals(1, game.openTableau()[2].size());
		assertEquals(1, game.openTableau()[3].size());
		assertEquals(1, game.openTableau()[4].size());
		assertEquals(1, game.openTableau()[5].size());
		assertEquals(1, game.openTableau()[6].size());
		
		assertNull(game.closedTableau()[0]);
		assertEquals(0, game.closedTableau()[1].size());
		assertEquals(1, game.closedTableau()[2].size());
		assertEquals(3, game.closedTableau()[3].size());
		assertEquals(3, game.closedTableau()[4].size());
		assertEquals(4, game.closedTableau()[5].size());
		assertEquals(6, game.closedTableau()[6].size());
		
		try {
			game.movePileToFoundation();
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		
		
		
		
		
		
		// moving a pile to foundation when there are multiple cards in pile, so you don't have to change closedPile
		// TODO: test after implementing movePileToPile
		
		
		
	}
//	
//	
//	
//	
//	
	@Test
	public void testMoveFoundationToPile() {
		
		// moving foundation to pile when foundation is empty = exception
//		state();
		
		assertEquals(24, game.stock().size());
		assertEquals(0, game.waste().size());
		
		assertEquals(0, game.foundation()[0].size());
		assertEquals(0, game.foundation()[1].size());
		assertEquals(0, game.foundation()[2].size());
		assertEquals(0, game.foundation()[3].size());
		
		assertEquals(1, game.openTableau()[0].size());
		assertEquals(1, game.openTableau()[1].size());
		assertEquals(1, game.openTableau()[2].size());
		assertEquals(1, game.openTableau()[3].size());
		assertEquals(1, game.openTableau()[4].size());
		assertEquals(1, game.openTableau()[5].size());
		assertEquals(1, game.openTableau()[6].size());
		
		assertNull(game.closedTableau()[0]);
		assertEquals(1, game.closedTableau()[1].size());
		assertEquals(2, game.closedTableau()[2].size());
		assertEquals(3, game.closedTableau()[3].size());
		assertEquals(4, game.closedTableau()[4].size());
		assertEquals(5, game.closedTableau()[5].size());
		assertEquals(6, game.closedTableau()[6].size());
		
		try {
			game.moveFoundationToPile();
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		
		
		
		
		// moving foundation to pile when no cards can go from foundation to pile
		
		// moving some Ace to the foundation
		game.movePileToFoundation();
		
		// putting 2-H on top of 3 S
		game.movePileToPile();
		
		// putting A S on top of 2-H, now Ace in foundation cannot go anywhere
		game.movePileToPile();
		
//		state();
		assertEquals(24, game.stock().size());
		assertEquals(0, game.waste().size());
		
		assertEquals(0, game.foundation()[0].size());
		assertEquals(0, game.foundation()[1].size());
		assertEquals(1, game.foundation()[2].size());
		assertEquals(0, game.foundation()[3].size());
		
		assertEquals(0, game.openTableau()[0].size());
		assertEquals(1, game.openTableau()[1].size());
		assertEquals(1, game.openTableau()[2].size());
		assertEquals(1, game.openTableau()[3].size());
		assertEquals(1, game.openTableau()[4].size());
		assertEquals(3, game.openTableau()[5].size());
		assertEquals(1, game.openTableau()[6].size());
		
		assertNull(game.closedTableau()[0]);
		assertEquals(0, game.closedTableau()[1].size());
		assertEquals(2, game.closedTableau()[2].size());
		assertEquals(3, game.closedTableau()[3].size());
		assertEquals(3, game.closedTableau()[4].size());
		assertEquals(5, game.closedTableau()[5].size());
		assertEquals(6, game.closedTableau()[6].size());
		
		try {
			game.moveFoundationToPile();
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		
		
		
		
		// moving foundation to pile when a card can go from foundation to pile
//		state();
		
		assertEquals("empty", stackToString(game.foundation()[0]));
		assertEquals("empty", stackToString(game.foundation()[1]));
		assertEquals("A C   ", stackToString(game.foundation()[2]));
		assertEquals("empty", stackToString(game.foundation()[3]));
		assertEquals("3 S   2-H   A S   ", stackToString(game.openTableau()[5]));
		
		game.movePileToFoundation();
		
//		state();
		assertEquals("empty", stackToString(game.foundation()[0]));
		assertEquals("empty", stackToString(game.foundation()[1]));
		assertEquals("A C   ", stackToString(game.foundation()[2]));
		assertEquals("A S   ", stackToString(game.foundation()[3]));
		assertEquals("3 S   2-H   ", stackToString(game.openTableau()[5]));
		
		game.moveFoundationToPile();
		
//		state();
		assertEquals("empty", stackToString(game.foundation()[0]));
		assertEquals("empty", stackToString(game.foundation()[1]));
		assertEquals("empty", stackToString(game.foundation()[2]));
		assertEquals("A S   ", stackToString(game.foundation()[3]));
		assertEquals("3 S   2-H   A C   ", stackToString(game.openTableau()[5]));
		
		
		
		
		// moving foundation to pile when a King card can go from foundation to an empty pile

//		int seed = findSeed("S");
//		System.out.println(seed);
//		state(new Solitaire("633092"));
		
		Solitaire game2 = new Solitaire("633092");
//		state(game2);
		
		// put all spades into foundation
		while (game2.foundation()[3].size() != 13) {
			
			game2.moveStockToWaste();
			
			try {
				game2.moveWasteToFoundation();
			}
			catch (Exception e) {
				assertTrue(e instanceof IllegalStateException);
//				System.out.println("got to here");
			}
			
			try {
				game2.moveWasteToStock();
			}
			catch (Exception e) {
				assertTrue(e instanceof IllegalStateException);
			}
		}
		
//		state(game2);
		
		// make Open Pile 2 empty so a King can go in there
		game2.movePileToPile();
		game2.movePileToPile();
		assertEquals(0, game2.openTableau()[1].size());
		assertEquals(13, game2.foundation()[3].size());
		assertEquals("empty", stackToString(game2.openTableau()[1]));
		assertEquals("A S   2 S   3 S   4 S   5 S   6 S   7 S   8 S   9 S   10 S  J S   Q S   K S   ", stackToString(game2.foundation()[3]));
		
//		state(game2);
		
		game2.moveFoundationToPile();
		
//		state(game2);
		
		assertEquals(1, game2.openTableau()[1].size());
		assertEquals(12, game2.foundation()[3].size());
		assertEquals("K S   ", stackToString(game2.openTableau()[1]));
		assertEquals("A S   2 S   3 S   4 S   5 S   6 S   7 S   8 S   9 S   10 S  J S   Q S   ", stackToString(game2.foundation()[3]));
		
	}
	
	
	
	// returns the seed of a game with all of the cards of the face in the stock
	private int findSeed(String face) {
		
		int seed = 0;
		boolean seedFound = false;
		
		while (!seedFound) {
			Solitaire newGame = new Solitaire("" + seed);
			int counter = 0;
			
		    while (!newGame.stock().isEmpty()) {
		    	Card card = newGame.stock().pop();
		    	if (card.getFace().equals(face)) {
		    		counter++;
		    	}
		    }
			
		    if (counter == 13) {
		    	break;
		    }
			seed++;
		}
		
		return seed;
	}
	
	@Test
	public void testMovePileToPile() {
//		state();
		
		// moving a pile with one card to another pile, where pile A goes empty
		assertEquals(24, game.stock().size());
		assertEquals(0, game.waste().size());
		
		assertEquals(0, game.foundation()[0].size());
		assertEquals(0, game.foundation()[1].size());
		assertEquals(0, game.foundation()[2].size());
		assertEquals(0, game.foundation()[3].size());
		
		assertEquals(1, game.openTableau()[0].size());
		assertEquals(1, game.openTableau()[1].size());
		assertEquals(1, game.openTableau()[2].size());
		assertEquals(1, game.openTableau()[3].size());
		assertEquals(1, game.openTableau()[4].size());
		assertEquals(1, game.openTableau()[5].size());
		assertEquals(1, game.openTableau()[6].size());
		
		assertNull(game.closedTableau()[0]);
		assertEquals(1, game.closedTableau()[1].size());
		assertEquals(2, game.closedTableau()[2].size());
		assertEquals(3, game.closedTableau()[3].size());
		assertEquals(4, game.closedTableau()[4].size());
		assertEquals(5, game.closedTableau()[5].size());
		assertEquals(6, game.closedTableau()[6].size());
		
		assertEquals("2-H   ", stackToString(game.openTableau()[0]));
		assertEquals("3 S   ", stackToString(game.openTableau()[5]));
		assertEquals(1, game.openTableau()[0].size());
		assertEquals(1, game.openTableau()[5].size());
		assertNull(game.closedTableau()[0]);
		assertEquals(5, game.closedTableau()[5].size());
		
		game.movePileToPile();
		
		assertEquals("empty", stackToString(game.openTableau()[0]));
		assertEquals("3 S   2-H   ", stackToString(game.openTableau()[5]));
		assertEquals(0, game.openTableau()[0].size());
		assertEquals(2, game.openTableau()[5].size());
		assertNull(game.closedTableau()[0]);
		assertEquals(5, game.closedTableau()[5].size());
		
		
		
		
		
		// moving a pile with one card to another pile, where pile A gets from closed pile
		
//		state();

		assertEquals("A C   ", stackToString(game.openTableau()[1]));
		assertEquals("3 S   2-H   ", stackToString(game.openTableau()[5]));
		assertEquals(1, game.openTableau()[1].size());
		assertEquals(2, game.openTableau()[5].size());
		assertEquals(1, game.closedTableau()[1].size());
		assertEquals(5, game.closedTableau()[5].size());
		assertEquals("4-D   ", stackToString(game.closedTableau()[1]));
		
		game.movePileToPile();
		
		assertEquals("4-D   ", stackToString(game.openTableau()[1]));
		assertEquals("3 S   2-H   A C   ", stackToString(game.openTableau()[5]));
		assertEquals(1, game.openTableau()[1].size());
		assertEquals(3, game.openTableau()[5].size());
		assertEquals(0, game.closedTableau()[1].size());
		assertEquals(5, game.closedTableau()[5].size());
		assertEquals("empty", stackToString(game.closedTableau()[1]));
		
		
		
		
		// moving an entire pile with multiple cards to another pile
//		state();
		
		assertEquals("4-D   ", stackToString(game.openTableau()[1]));
		assertEquals("3 S   2-H   A C   ", stackToString(game.openTableau()[5]));
		assertEquals(1, game.openTableau()[1].size());
		assertEquals(3, game.openTableau()[5].size());
		assertEquals(0, game.closedTableau()[1].size());
		assertEquals(5, game.closedTableau()[5].size());
		assertEquals("7-D   K-D   A-H   9-D   10 S  ", stackToString(game.closedTableau()[5]));
		
		game.movePileToPile();
		
		assertEquals("4-D   3 S   2-H   A C   ", stackToString(game.openTableau()[1]));
		assertEquals("10 S  ", stackToString(game.openTableau()[5]));
		assertEquals(4, game.openTableau()[1].size());
		assertEquals(1, game.openTableau()[5].size());
		assertEquals(0, game.closedTableau()[1].size());
		assertEquals(4, game.closedTableau()[5].size());
		assertEquals("7-D   K-D   A-H   9-D   ", stackToString(game.closedTableau()[5]));
		
		
		
		
		// moving a king card to a pile with no cards
		
//		state();
		
		assertEquals("empty", stackToString(game.openTableau()[0]));
		assertEquals("K C   ", stackToString(game.openTableau()[6]));
		assertEquals(0, game.openTableau()[0].size());
		assertEquals(1, game.openTableau()[6].size());
		assertNull(game.closedTableau()[0]);
		assertEquals(6, game.closedTableau()[6].size());
		assertEquals("7 C   8-H   2 C   6-H   J-D   6-D   ", stackToString(game.closedTableau()[6]));
		
		game.movePileToPile();
		
		assertEquals("K C   ", stackToString(game.openTableau()[0]));
		assertEquals("6-D   ", stackToString(game.openTableau()[6]));
		assertEquals(1, game.openTableau()[0].size());
		assertEquals(1, game.openTableau()[6].size());
		assertNull(game.closedTableau()[0]);
		assertEquals(5, game.closedTableau()[6].size());
		assertEquals("7 C   8-H   2 C   6-H   J-D   ", stackToString(game.closedTableau()[6]));
		
		
		
		
		// not being able to move any cards = exception
		
//		state();
		
		try {
			game.movePileToPile();
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		
		
		
	
		// moving middle of pile to another pile (you use this if you have to move a card to foundation)
		
//		state();
		// move A C to foundation, so Open 2: 4-D   3 S   2-H   A C
		game.movePileToFoundation();
		
//		state();
		// move A S to foundation
		game.movePileToFoundation();
		
//		state();
		
		// move A C back onto Open 2 to test that it actually works
		game.moveFoundationToPile();
		
//		state();
		
		// move a bunch of stock to waste until you get 3 C
		for (int i = 0; i < 17; i++) {
			game.moveStockToWaste();
		}
//		state();
		
		// put 3 C from waste in open pile 4, so Open 4: 4-H   3 C
		game.moveWasteToPile();
		
//		state();
		
		assertEquals("4-D   3 S   2-H   A C   ", stackToString(game.openTableau()[1]));
		assertEquals("4-H   3 C   ", stackToString(game.openTableau()[3]));
		assertEquals("A S   ", stackToString(game.foundation()[3]));
		
		for (int i = 0; i < 2; i++) {
			game.moveStockToWaste();
		}
//		state();
		
		// move a bunch of stock to waste until you get 2 S, which you put in foundation
		game.moveWasteToFoundation();
		
		assertEquals("4-D   3 S   2-H   A C   ", stackToString(game.openTableau()[1]));
		assertEquals("4-H   3 C   ", stackToString(game.openTableau()[3]));
		assertEquals("A S   2 S   ", stackToString(game.foundation()[3]));

		// at this point try calling game.movePileToPile, which should move 3 S to foundation and 2-H   A C    to 4-H   3 C
		
		// this will move 10 S to J-H (scared me for a second lol)
		game.movePileToPile();
		
//		state();
		
		// this will move 9-D to 10 S (scared me for a second lol)
		game.movePileToPile();
		
//		state();
		
		
		
		// this SHOULD move the "2-H   A C   " from Open 2 onto the "4-H   3 C   " from Open 4
		
//		System.out.println("STARTING ROUND 5");
//		for (int i = 0; i < 100; i++) {
//			System.out.println();
//		}
//		System.out.println("STARTING ROUND 5");
		
//		state();
		
		game.movePileToPile();
		
//		state();
		
		assertEquals("4-D   3 S   ", stackToString(game.openTableau()[1]));
		assertEquals("4-H   3 C   2-H   A C   ", stackToString(game.openTableau()[3]));
		assertEquals("A S   2 S   ", stackToString(game.foundation()[3]));
		
		
		
		
		
		
//		state();
		
		// START: NOTHING
		
//		System.out.println("STARTING ROUND 1");
//		game.movePileToPile();
		
//		state();
		// AFTER ROUND 1: Open 6: 3 S   2-H
		
		
		
		
//		System.out.println("STARTING ROUND 2");
//		game.movePileToPile();
		
//		state();
		// AFTER ROUND 2: Open 6: 3 S   2-H   A C
		
		
		
		
//		System.out.println("STARTING ROUND 3");
//		game.movePileToPile();
		
//		state();
		// AFTER ROUND 3: Open 2: 4-D   3 S   2-H   A C
		
		
		
		
//		System.out.println("STARTING ROUND 4");
//		game.movePileToPile();
		
//		state();
		
		
		
//		System.out.println("STARTING ROUND 5");
//		game.movePile();
		
		// TODO: move method into movePileToPile, then thoroughly test it here
		
		
	}
	
	

}
