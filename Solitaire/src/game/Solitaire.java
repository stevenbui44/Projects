package game;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import structures.ArrayBasedStack;

/**
 * Okay steven so this is the main file where you run the whole thing
 * 
 * Compile:     javac Solitaire.java
 * Run:         java Solitaire
 * 
 * Compile:     javac *.java
 * 
 * Terminal:	cd git/Projects/Solitaire/src/game
 * 
 */

/*
 * IDEAS FOR UPDATES
 * 1. you can choose a manual mode instead of auto mode, where you choose which stack a card goes to
 * 2. points system, figure that out
 * 3. 3 card mode instead of 1 card mode, way harder to implement
 */

public class Solitaire {

    /** 
     * Stock is where you pull out new cards from. Stack data structure since you remove one card 
     * at a time, and you use a queue to reset it. The top of the stack is the END of the deck.
     */
    private static ArrayBasedStack<Card> stock;

    /** 
     * Waste is where you put new cards from the stock. Stack data structure since the most recent
     * card you add onto the waste is the one you can remove.
     */
    private static ArrayBasedStack<Card> waste;

    /**
     * Hearts is part of the foundation, where hearts cards go. Stack data structure since first in 
     * first out.
     */
    private static ArrayBasedStack<Card> hearts;
    private static ArrayBasedStack<Card> diamonds;
    private static ArrayBasedStack<Card> clubs;
    private static ArrayBasedStack<Card> spades;

    private static ArrayBasedStack<Card> openPile1;
    private static ArrayBasedStack<Card> openPile2;
    private static ArrayBasedStack<Card> openPile3;
    private static ArrayBasedStack<Card> openPile4;
    private static ArrayBasedStack<Card> openPile5;
    private static ArrayBasedStack<Card> openPile6;
    private static ArrayBasedStack<Card> openPile7;

    private static ArrayBasedStack<Card> closedPile2;
    private static ArrayBasedStack<Card> closedPile3;
    private static ArrayBasedStack<Card> closedPile4;
    private static ArrayBasedStack<Card> closedPile5;
    private static ArrayBasedStack<Card> closedPile6;
    private static ArrayBasedStack<Card> closedPile7;
    
    private static Map<String, ArrayBasedStack<Card>> stackMap;


    public Solitaire(String seed) {
    	
    	Deck deck = new Deck();
        
        if (seed != null) {
        	try {
        		int intSeed = Integer.parseInt(seed);
        		deck.shuffle(intSeed);
        	}
        	catch (NumberFormatException e) {
        		System.err.println("Enter a number for the seed");
        		System.exit(1);
        	}
        }
        else {
        	deck.shuffle();
        }
        
//        System.out.println(deck.toString());

        // creating the piles, stock, waste, and foundation
        openPile1 = new ArrayBasedStack<Card>();
        openPile2 = new ArrayBasedStack<Card>();
        openPile3 = new ArrayBasedStack<Card>();
        openPile4 = new ArrayBasedStack<Card>();
        openPile5 = new ArrayBasedStack<Card>();
        openPile6 = new ArrayBasedStack<Card>();
        openPile7 = new ArrayBasedStack<Card>();

        closedPile2 = new ArrayBasedStack<Card>();
        closedPile3 = new ArrayBasedStack<Card>();
        closedPile4 = new ArrayBasedStack<Card>();
        closedPile5 = new ArrayBasedStack<Card>();
        closedPile6 = new ArrayBasedStack<Card>();
        closedPile7 = new ArrayBasedStack<Card>();

        stock = new ArrayBasedStack<Card>();
        waste = new ArrayBasedStack<Card>();

        hearts = new ArrayBasedStack<Card>();
        diamonds = new ArrayBasedStack<Card>();
        clubs = new ArrayBasedStack<Card>();
        spades = new ArrayBasedStack<Card>();

        // filling up the 7 piles
        openPile1.push(deck.removeCard());
        
        closedPile2.push(deck.removeCard());
        openPile2.push(deck.removeCard());

        closedPile3.push(deck.removeCard());
        closedPile3.push(deck.removeCard());
        openPile3.push(deck.removeCard());

        closedPile4.push(deck.removeCard());
        closedPile4.push(deck.removeCard());
        closedPile4.push(deck.removeCard());
        openPile4.push(deck.removeCard());

        closedPile5.push(deck.removeCard());
        closedPile5.push(deck.removeCard());
        closedPile5.push(deck.removeCard());
        closedPile5.push(deck.removeCard());
        openPile5.push(deck.removeCard());

        closedPile6.push(deck.removeCard());
        closedPile6.push(deck.removeCard());
        closedPile6.push(deck.removeCard());
        closedPile6.push(deck.removeCard());
        closedPile6.push(deck.removeCard());
        openPile6.push(deck.removeCard());

        closedPile7.push(deck.removeCard());
        closedPile7.push(deck.removeCard());
        closedPile7.push(deck.removeCard());
        closedPile7.push(deck.removeCard());
        closedPile7.push(deck.removeCard());
        closedPile7.push(deck.removeCard());
        openPile7.push(deck.removeCard());

        // filling up the stock (top of stack = END of the deck)
        while (!deck.isEmpty()) {
            stock.push(deck.removeCard());
        }
        
        // filling up the map to use for testing
        stackMap = new HashMap<>();
        stackMap.put("stock", stock);
        stackMap.put("waste", waste);
        stackMap.put("hearts", hearts);
        stackMap.put("diamonds", diamonds);
        stackMap.put("clubs", clubs);
        stackMap.put("spades", spades);
        stackMap.put("openPile1", openPile1);
        stackMap.put("openPile2", openPile2);
        stackMap.put("openPile3", openPile3);
        stackMap.put("openPile4", openPile4);
        stackMap.put("openPile5", openPile5);
        stackMap.put("openPile6", openPile6);
        stackMap.put("openPile7", openPile7);
        stackMap.put("closedPile2", closedPile2);
        stackMap.put("closedPile3", closedPile3);
        stackMap.put("closedPile4", closedPile4);
        stackMap.put("closedPile5", closedPile5);
        stackMap.put("closedPile6", closedPile6);
        stackMap.put("closedPile7", closedPile7);
    }
    
    public ArrayBasedStack<Card> getStack(String stack) {
    	return stackMap.get(stack);
    }
    
    public void moveStockToWaste() {
        if (!stock.isEmpty()) {
            waste.push(stock.pop());
        }
        else {
            throw new IllegalStateException();
            // actually if it's a GUI you can have a card that says refill or something
        }
    }

    // NOTE: only use this whenever the stock is empty, this should never be an option for the player
    public void moveWasteToStock() {
        if (!stock.isEmpty()) {
        	throw new IllegalStateException();
        }
    	while (!waste.isEmpty()) {
            stock.push(waste.pop());
        }
    }

    public void moveWasteToPile() {
    	
    	/*
    	 * CASES TO CONSIDER:
    	 * 1. moving waste to a pile with cards
    	 * 2. moving waste to a pile with no cards (move King only)
    	 */
    	
    	if (waste.isEmpty()) {
    		throw new IllegalStateException();
    	}
    	
        String tempWasteValue = waste.top().updateValue();
        boolean color = waste.top().getColor();
        
        // moving waste to a pile with cards
        if (!openPile1.isEmpty() && Integer.parseInt(tempWasteValue) == (Integer.parseInt(openPile1.top().updateValue()) - 1) && color != openPile1.top().getColor()) {
            openPile1.push(waste.pop());
        }
        else if (!openPile2.isEmpty() && Integer.parseInt(tempWasteValue) == (Integer.parseInt(openPile2.top().updateValue()) - 1) && color != openPile2.top().getColor()) {
            openPile2.push(waste.pop());
        }
        else if (!openPile3.isEmpty() && Integer.parseInt(tempWasteValue) == (Integer.parseInt(openPile3.top().updateValue()) - 1) && color != openPile3.top().getColor()) {
            openPile3.push(waste.pop());
        }
        else if (!openPile4.isEmpty() && Integer.parseInt(tempWasteValue) == (Integer.parseInt(openPile4.top().updateValue()) - 1) && color != openPile4.top().getColor()) {
            openPile4.push(waste.pop());
        }
        else if (!openPile5.isEmpty() && Integer.parseInt(tempWasteValue) == (Integer.parseInt(openPile5.top().updateValue()) - 1) && color != openPile5.top().getColor()) {
            openPile5.push(waste.pop());
        }
        else if (!openPile6.isEmpty() && Integer.parseInt(tempWasteValue) == (Integer.parseInt(openPile6.top().updateValue()) - 1) && color != openPile6.top().getColor()) {
            openPile6.push(waste.pop());
        }
        else if (!openPile7.isEmpty() && Integer.parseInt(tempWasteValue) == (Integer.parseInt(openPile7.top().updateValue()) - 1) && color != openPile7.top().getColor()) {
            openPile7.push(waste.pop());
        }
        
        // moving waste to a pile with no cards
        // NOTE: we won't have to worry about closedPile being empty since they would just be openPile
        else if (openPile1.isEmpty() && tempWasteValue.equals("13")) {
        	openPile1.push(waste.pop());
        }
        else if (openPile2.isEmpty() && tempWasteValue.equals("13")) {
        	openPile1.push(waste.pop());
        }
        else if (openPile3.isEmpty() && tempWasteValue.equals("13")) {
        	openPile1.push(waste.pop());
        }
        else if (openPile4.isEmpty() && tempWasteValue.equals("13")) {
        	openPile1.push(waste.pop());
        }
        else if (openPile5.isEmpty() && tempWasteValue.equals("13")) {
        	openPile1.push(waste.pop());
        }
        else if (openPile6.isEmpty() && tempWasteValue.equals("13")) {
        	openPile1.push(waste.pop());
        }
        else if (openPile7.isEmpty() && tempWasteValue.equals("13")) {
        	openPile1.push(waste.pop());
        }
        else {
        	throw new IllegalStateException();
        }
        
    }

    public void moveWasteToFoundation() {
        
    	if (waste.isEmpty()) {
    		throw new IllegalStateException();
    	}
    	
    	String tempWasteValue = waste.top().updateValue();
    	
        // if there are already cards in the foundation
        if (!hearts.isEmpty() && Integer.parseInt(tempWasteValue) == (Integer.parseInt(hearts.top().updateValue()) + 1) && waste.top().getFace().equals("H")) {
            hearts.push(waste.pop());
        }
        else if (!diamonds.isEmpty() && Integer.parseInt(tempWasteValue) == (Integer.parseInt(diamonds.top().updateValue()) + 1) && waste.top().getFace().equals("D")) {
        	diamonds.push(waste.pop());
        }
        else if (!clubs.isEmpty() && Integer.parseInt(tempWasteValue) == (Integer.parseInt(clubs.top().updateValue()) + 1) && waste.top().getFace().equals("C")) {
        	clubs.push(waste.pop());
        }
        else if (!spades.isEmpty() && Integer.parseInt(tempWasteValue) == (Integer.parseInt(spades.top().updateValue()) + 1) && waste.top().getFace().equals("S")) {
        	spades.push(waste.pop());
        }
    	
        // if there are no cards in foundation, only move Ace
        else if (hearts.isEmpty() && Integer.parseInt(tempWasteValue) == 1 && waste.top().getFace().equals("H")) {
        	hearts.push(waste.pop());
        }
        else if (diamonds.isEmpty() && Integer.parseInt(tempWasteValue) == 1 && waste.top().getFace().equals("D")) {
        	diamonds.push(waste.pop());
        }
        else if (clubs.isEmpty() && Integer.parseInt(tempWasteValue) == 1 && waste.top().getFace().equals("C")) {
        	clubs.push(waste.pop());
        }
        else if (spades.isEmpty() && Integer.parseInt(tempWasteValue) == 1 && waste.top().getFace().equals("S")) {
        	spades.push(waste.pop());
        }
        else {
        	throw new IllegalStateException();
        }
        
    }

    public void movePileToPile() {

    }

    public void movePileToFoundation() {
    	
    	if (!openPile1.isEmpty() && openPile1.top().getFace().equals("H") && Integer.parseInt(openPile1.top().updateValue()) == Integer.parseInt(hearts.top().updateValue() + 1)) {
    		hearts.push(openPile1.pop());
    	}
    	
    	// TODO: maybe consider using an ArrayBasedList for piles and foundation and all that, or perhaps just an array
    	// it probably makes sense to use an array
    	
    	// TODO: do something about if there is only 1 card in the openPile, remove a card from closedPile and add it to openPile
    	// TODO: do 28 of these
    }

    public void moveFoundationToPile() {
        
    }
}
