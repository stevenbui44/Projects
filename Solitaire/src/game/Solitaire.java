package game;
import structures.ArrayBasedStack;

/**
 * Okay steven so this is the main file where you run the whole thing
 */

/*
 * IDEAS FOR UPDATES
 * 1. you can choose a manual mode instead of auto mode, where you choose which stack a card goes to
 * 2. points system, figure that out
 * 3. 3 card mode instead of 1 card mode, way harder to implement
 * 4. give in a specific seed to get a deck where you can win the game almost instantly, like all hearts in order in foundation
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

    private static ArrayBasedStack<Card>[] foundation;
    private static ArrayBasedStack<Card>[] openTableau;
    private static ArrayBasedStack<Card>[] closedTableau;


    @SuppressWarnings("unchecked")
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
        
        foundation = new ArrayBasedStack[4];
        for (int i = 0; i < 4; i++) {
        	foundation[i] = new ArrayBasedStack<Card>();
        }
        
        openTableau = new ArrayBasedStack[7];
        for (int i = 0; i < 7; i++) {
        	openTableau[i] = new ArrayBasedStack<Card>();
        }
        
        closedTableau = new ArrayBasedStack[7];
        for (int i = 0; i < 7; i++) {
        	closedTableau[i] = new ArrayBasedStack<Card>();
        }
        
        stock = new ArrayBasedStack<Card>();
        waste = new ArrayBasedStack<Card>();

        closedTableau[0] = null;
        openTableau[0].push(deck.removeCard());
        
        closedTableau[1].push(deck.removeCard());
        openTableau[1].push(deck.removeCard());

        closedTableau[2].push(deck.removeCard());
        closedTableau[2].push(deck.removeCard());
        openTableau[2].push(deck.removeCard());

        closedTableau[3].push(deck.removeCard());
        closedTableau[3].push(deck.removeCard());
        closedTableau[3].push(deck.removeCard());
        openTableau[3].push(deck.removeCard());

        closedTableau[4].push(deck.removeCard());
        closedTableau[4].push(deck.removeCard());
        closedTableau[4].push(deck.removeCard());
        closedTableau[4].push(deck.removeCard());
        openTableau[4].push(deck.removeCard());

        closedTableau[5].push(deck.removeCard());
        closedTableau[5].push(deck.removeCard());
        closedTableau[5].push(deck.removeCard());
        closedTableau[5].push(deck.removeCard());
        closedTableau[5].push(deck.removeCard());
        openTableau[5].push(deck.removeCard());

        closedTableau[6].push(deck.removeCard());
        closedTableau[6].push(deck.removeCard());
        closedTableau[6].push(deck.removeCard());
        closedTableau[6].push(deck.removeCard());
        closedTableau[6].push(deck.removeCard());
        closedTableau[6].push(deck.removeCard());
        openTableau[6].push(deck.removeCard());

        while (!deck.isEmpty()) {
            stock.push(deck.removeCard());
        }
    }
    
    public ArrayBasedStack<Card> stock() {
    	return stock;
    }
    
    public ArrayBasedStack<Card> waste() {
    	return waste;
    }
    
    public ArrayBasedStack<Card>[] foundation() {
    	return foundation;
    }
    
    public ArrayBasedStack<Card>[] openTableau() {
    	return openTableau;
    }
    
    public ArrayBasedStack<Card>[] closedTableau() {
    	return closedTableau;
    }
    
    public void moveStockToWaste() {
        if (!stock.isEmpty()) {
            waste.push(stock.pop());
        }
        else {
            throw new IllegalStateException();
        }
    }

    public void moveWasteToStock() {
        if (!stock.isEmpty()) {
        	throw new IllegalStateException();
        }
    	while (!waste.isEmpty()) {
            stock.push(waste.pop());
        }
    }

    public void moveWasteToPile() {
    	if (waste.isEmpty()) {
    		throw new IllegalStateException();
    	}
    	
        String tempWasteValue = waste.top().updateValue();
        boolean color = waste.top().getColor();
        
        for (int i = 0; i < 7; i++) {
        	// moving waste to a pile with cards
        	if (!openTableau[i].isEmpty() && Integer.parseInt(tempWasteValue) == (Integer.parseInt(openTableau[i].top().updateValue()) - 1) && color != openTableau[i].top().getColor()) {
        		openTableau[i].push(waste.pop());
        		return;
        	}
        	// moving waste to a pile with no cards
        	if (openTableau[i].isEmpty() && tempWasteValue.equals("13")) {
        		openTableau[i].push(waste.pop());
        		return;
        	}
        }
        
        throw new IllegalStateException();
    }

    public void moveWasteToFoundation() {
    	if (waste.isEmpty()) {
    		throw new IllegalStateException();
    	}
    	
    	String tempWasteValue = waste.top().updateValue();
    	
    	String[] array = {"H", "D", "C", "S"};
        
        for (int i = 0; i < 4; i++) {
        	// if there are already cards in the foundation
        	if (!foundation[i].isEmpty() && Integer.parseInt(tempWasteValue) == (Integer.parseInt(foundation[i].top().updateValue()) + 1) && waste.top().getFace().equals(array[i])) {
        		foundation[i].push(waste.pop());
        		return;
        	}
        	
        	// if there are no cards in foundation, only move Ace
        	if (foundation[i].isEmpty() && Integer.parseInt(tempWasteValue) == 1 && waste.top().getFace().equals(array[i])) {
        		foundation[i].push(waste.pop());
        		return;
        	}
        }
        
        throw new IllegalStateException();
    }

    public void movePileToFoundation() {
    	String[] array = {"H", "D", "C", "S"};
    	
    	for (int i = 0; i < 7; i++) {
    		for (int j = 0; j < 4; j++) {
    			    			
    			// if a pile is NOT empty
    			if (!openTableau[i].isEmpty() && openTableau[i].top().getFace().equals(array[j])) {
    				
    				boolean found = false;
    				
    				// if the foundation has cards already, add a card other than Ace
    				if (!foundation[j].isEmpty() && Integer.parseInt(openTableau[i].top().updateValue()) == Integer.parseInt(foundation[j].top().updateValue()) + 1) {
    					foundation[j].push(openTableau[i].pop());
    					found = true;
    				}
    				// if the foundation has no cards, you can only add Ace
    				else if (foundation[j].isEmpty() && Integer.parseInt(openTableau[i].top().updateValue()) == 1) {
    					foundation[j].push(openTableau[i].pop());
    					found = true;
    				}
    				
    				// if open pile only had 1 card (empty now), get a card from closed pile
    				if (openTableau[i].isEmpty() && closedTableau[i] != null && !closedTableau[i].isEmpty()) {
    					openTableau[i].push(closedTableau[i].pop());
    				}
    				
    				if (found) {
    					return;
    				}
    			}
    		}
    	}
    	throw new IllegalStateException();
    }
    
    

    public void moveFoundationToPile() {
    	    	
        for (int i = 0; i < 4; i++) {
        	for (int j = 0; j < 7; j++) {
        		
        		// if the foundation is not empty and the top of foundation can go onto the top of a pile (the foundation's card is the same face and 1 value lower than the pile's card)
        		if (!foundation()[i].isEmpty() && !openTableau[j].isEmpty() && (foundation()[i].top().getColor() != openTableau[j].top().getColor()) && Integer.parseInt(foundation()[i].top().updateValue()) == Integer.parseInt(openTableau[j].top().updateValue()) - 1) {
        			openTableau[j].push(foundation()[i].pop());
        			return;
        		}
        		
        		// if the foundation is empty and the pile is empty, you can add a King from foundation (not sure why you would do this but you can)
        		if (!foundation()[i].isEmpty() && openTableau[j].isEmpty() && foundation()[i].top().getValue().equals("K")) {
        			openTableau[j].push(foundation()[i].pop());
        			return;
        		}
        	}
        }
        
        throw new IllegalStateException();
    }
    
    
 // outputs a stack without tabs or color, easier to test
// 	private String stackToString(ArrayBasedStack<Card> stack) {
// 		
// 		if (stack == null) {
// 			return "null";
// 		}
// 		if (stack.isEmpty()) {
// 			return "empty";
// 		}
// 		
// 		ArrayBasedStack<Card> temp = new ArrayBasedStack<Card>();
// 		
// 		StringBuilder rtn = new StringBuilder();
// 		
// 	    while (!stack.isEmpty()) {
// 	        temp.push(stack.pop());
// 	    }
// 	    while (!temp.isEmpty()) {
// 	        stack.push(temp.pop());
// 	        
// 	        String value = stack.top().getValue();
// 	        String face = stack.top().getFace();
// 	        boolean color = stack.top().getColor();
// 	        
// 	        rtn.append( value + (color ? "-" : " "));
// 	        rtn.append(face);
// 	        rtn.append( (value.equals("10") ? "  " : "   ") );
// 	        
// 	    }
// 		
// 		return rtn.toString();
// 	}
 	
// 	private void state() {
// 		System.out.println("Stock: " + stackToString(stock()));
// 		System.out.println("Waste: " + stackToString(waste()));
// 		System.out.println("- - - - -");
// 		System.out.println("Closed 1: " + stackToString(closedTableau()[0]));
// 		System.out.println("Closed 2: " + stackToString(closedTableau()[1]));
// 		System.out.println("Closed 3: " + stackToString(closedTableau()[2]));
// 		System.out.println("Closed 4: " + stackToString(closedTableau()[3]));
// 		System.out.println("Closed 5: " + stackToString(closedTableau()[4]));
// 		System.out.println("Closed 6: " + stackToString(closedTableau()[5]));
// 		System.out.println("Closed 7: " + stackToString(closedTableau()[6]));
// 		System.out.println("- - - - -");
// 		System.out.println("Open 1: " + stackToString(openTableau()[0]));
// 		System.out.println("Open 2: " + stackToString(openTableau()[1]));
// 		System.out.println("Open 3: " + stackToString(openTableau()[2]));
// 		System.out.println("Open 4: " + stackToString(openTableau()[3]));
// 		System.out.println("Open 5: " + stackToString(openTableau()[4]));
// 		System.out.println("Open 6: " + stackToString(openTableau()[5]));
// 		System.out.println("Open 7: " + stackToString(openTableau()[6]));
// 		System.out.println("- - - - -");
// 		System.out.println("Hearts:   " + stackToString(foundation()[0]));
// 		System.out.println("Diamonds: " + stackToString(foundation()[1]));
// 		System.out.println("Clubs:    " + stackToString(foundation()[2]));
// 		System.out.println("Spades:   " + stackToString(foundation()[3]) + "\n\n\n");
// 	}
    
    
    public void movePileToPile() {
    	
//    	// pseudocode
//    	for int i to 7
//    		if openTableau[i] is empty, skip it
//    		
//    		for int j to 7
//				if i = j, skip this
//
//				while openTableau[i] is NOT empty
//    		
//	    			if openTableau[j] is NOT empty
//	    				if openTableau[i].top can go onto openTableau[j].top (different number and color)
//	    					move openTableau[i].top to openTableau[j]
//	    							
//	    					if openTableau[i] is empty now
//		    					this means that the top of the pile can go on the other pile, so empty the temp stack onto the other pile
//		    					move whatever is in the stack into openTableau[j];
//	    						if closedTableau[i] is not null and closedTableau[i] is not empty
//	    							put a new card from closedTableau[i] onto openTableau[i]
//	    						
//	    						
//	    					if foundation is empty and openTableau[i].top is an Ace
//	    						move it, since it can go to foundation										// FINISH
//	    						
//    						else if foundation is not empty and openTableau[i].top can go to foundation (different number, same face)
//	    						add openTableau[i].top to foundation
//	    						move whatever is in the stack into openTableau[j]							// FINISH 
//	    								
//    						else 
//    							put openTableau[j].top back onto openTableau[i], NOT the stack
//    							
//						else
//							you just ignore it
//	    							
//	    							
//	    			if openTableau[j] is empty
//	    				if openTableau[i].top is a King
//	    					move openTableau[i].top to openTableau[j]
//	    					move whatever is in stack into openTableau[j]									// FINISH
//	    							
//	    			remove a card from openTableau[i] and put it in the stack
//	    			
//	    			
//	    		at this point, open Tableau[i] is empty and done evaluating for a specific j
//	    		while stack is NOT empty
//	    			put all of the cards from stack back onto openTableau[i]
    				
    			
    	
    	// TODO: if the bottom of the stack is a king AND there is something in closed pile, only then do you move it
    	
    	ArrayBasedStack<Card> stack = new ArrayBasedStack<Card>();
    	
//    	System.out.println("ORIGINAL");
//    	state();
	    					
	    for (int i = 0; i < 7; i++) {
	    	if (openTableau[i].isEmpty()) {
	    		continue;
	    	}
	    	
//	    	state();
	    	
	    	for (int j = 0; j < 7; j++) {
	    		if (i == j) {
	    			continue;
	    		}
	    		
//	    		if (i == 1) {
//		    		System.out.println("i=" + i + " j=" + j);
//		    		state();
//	    		}
	    		
//	    		System.out.println("here");
	    		
	    		while (!openTableau[i].isEmpty()) {
	    			if (!openTableau[j].isEmpty()) {
	    				
	    				if (Integer.parseInt(openTableau[i].top().updateValue()) == Integer.parseInt(openTableau[j].top().updateValue()) - 1 && openTableau[i].top().getColor() != openTableau[j].top().getColor()) {
	    					
	    					openTableau[j].push(openTableau[i].pop());
	    					
	    					if (openTableau[i].isEmpty()) {
//	    						openTableau[i].push(openTableau[j].pop());
	    						while (!stack.isEmpty()) {
	    							openTableau[j].push(stack.pop());
	    						}
	    						if (closedTableau[i] != null && !closedTableau[i].isEmpty()) {
	    							openTableau[i].push(closedTableau[i].pop());
	    						}
	    						return;
	    					}
	    					else {
	    						
//	    						System.out.println("here");
//	    						System.out.println("i=" + openTableau()[i].top());
//	    						System.out.println("j=" + openTableau()[j].top());
//	    						
//	    						System.out.println(openTableau()[i].size());
//	    						System.out.println(openTableau()[j].size());
//	    						System.out.println(stack.size());
	    						
//	    						System.out.println("here");
	    						
	    						
			    				String[] array = {"H", "D", "C", "S"};
			    				for (int k = 0; k < 4; k++) {
			    					if (foundation[k].isEmpty() && openTableau[i].top().getFace().equals(array[k]) && Integer.parseInt(openTableau[i].top().updateValue()) == 1) {
			    						foundation[k].push(openTableau[i].pop());
			    						return;
			    					}
			    					
			    					else if (!foundation[k].isEmpty() && openTableau[i].top().getFace().equals(array[k]) && Integer.parseInt(openTableau[i].top().updateValue()) == Integer.parseInt(foundation[k].top().updateValue()) + 1) {
//			    						foundation[k].push(openTableau[i].pop());
			    						
			    						// TODO: i got rid of this line here
			    						
			    						while (!stack.isEmpty()) {
			    							openTableau[j].push(stack.pop());
			    						}
			    						return;
			    					}
			    					else {
			    						if (k == 3) {
			    							openTableau[i].push(openTableau[j].pop());
//				    						System.out.println("here\n");
				    						break;
			    						}
			    						else {
			    							continue;
			    						}
			    					}
			    				}
	    					}
	    				}
	    				else {
	    					// nothing
	    				}
	    			}
	    			if (openTableau[j].isEmpty()) {
	    				
//	    				System.out.println(stackToString(stack));
	    				
	    				if (Integer.parseInt(openTableau[i].top().updateValue()) == 13 && closedTableau[i] != null && !closedTableau[i].isEmpty()) {
	    					openTableau[j].push(openTableau[i].pop());
	    					openTableau[i].push(closedTableau[i].pop());
	    					while (!stack.isEmpty()) {
    							openTableau[j].push(stack.pop());
    						}
	    					return;
	    				}
	    				
	    			}
	    			
	    			stack.push(openTableau[i].pop());
	    			
	    		}
	    		
	    		while (!stack.isEmpty()) {
	    			openTableau[i].push(stack.pop());
	    		}
	    	}
	    }
    	throw new IllegalStateException();
    }
    
    
    
    
    
    /*
     * ORDER:
     * 
     * movePileToFoundation
     * moveWasteToFoundation
     * 
     * movePileToPile
     * 
     * moveWasteToPile
     * moveStockToWaste
     * moveWasteToStock
     * 
     */
    public int run() {
	
		int moves = 0;
		
		boolean moved = false;
		int oldStockSize = 0;
		
		boolean playing = true;
		
		while (playing) {
			
			// if the call was successful, you increase moves by 1 and show the new state of the game
			try {
				movePileToFoundation();
				moved = true;
				moves++;
				
				if (foundation[0].size() == 13 && foundation[1].size() == 13 && foundation[2].size() == 13 && foundation[3].size() == 13) {
					// win!
					return 1;
				}
				
				continue;
			}
			// the game didn't need the call
			catch (Exception e) {
				// if the call was not successful, it is expected to call an IllegalStateException
				if (e instanceof IllegalStateException == true) {
					// expected
				}
				// if the call was not successful and does not throw an IllegalStateException, you have an error with the method
				else {
					// debugging issue
					break;
				}
			}
			
			
			
			try {
				moveWasteToFoundation();
				moved = true;
				moves++;
				
				if (foundation[0].size() == 13 && foundation[1].size() == 13 && foundation[2].size() == 13 && foundation[3].size() == 13) {
					// win!
					return 1;
				}
				
				continue;
			}
			// the game didn't need the call
			catch (Exception e) {
				// if the call was not successful, it is expected to call an IllegalStateException
				if (e instanceof IllegalStateException == true) {
					// expected
				}
				// if the call was not successful and does not throw an IllegalStateException, you have an error with the method
				else {
					// debugging issue
					break;
				}
			}
			
			
			
			try {
				movePileToPile();
				moved = true;
				moves++;
				continue;
			}
			// the game didn't need the call
			catch (Exception e) {
				// if the call was not successful, it is expected to call an IllegalStateException
				if (e instanceof IllegalStateException == true) {
					// expected
				}
				// if the call was not successful and does not throw an IllegalStateException, you have an error with the method
				else {
					// debugging issue
					break;
				}
			}
			
			
			
			try {
				moveWasteToPile();
				moved = true;
				moves++;
				continue;
			}
			// the game didn't need the call
			catch (Exception e) {
				// if the call was not successful, it is expected to call an IllegalStateException
				if (e instanceof IllegalStateException == true) {
					// expected
				}
				// if the call was not successful and does not throw an IllegalStateException, you have an error with the method
				else {
					// debugging issue
					break;
				}
			}
			
			
			
			
			try {
				moveStockToWaste();
				moves++;
				continue;
			}
			// the game didn't need the call
			catch (Exception e) {
				// if the call was not successful, it is expected to call an IllegalStateException
				if (e instanceof IllegalStateException == true) {
					// expected
				}
				// if the call was not successful and does not throw an IllegalStateException, you have an error with the method
				else {
					// debugging issue
					break;
				}
			}
			
			
			
			// you only call this if the entire stock is empty
			try {
				moveWasteToStock();
				
				if (!moved && oldStockSize == stock().size()) {
					// you're probably repeating over and over = you lose basically = break
					break;
				}
				
				moved = false;
				oldStockSize = stock().size();
				moves++;
				continue;
			}
			// the game didn't need the call
			catch (Exception e) {
				// if the call was not successful, it is expected to call an IllegalStateException
				if (e instanceof IllegalStateException == true) {
					// expected
				}
				// if the call was not successful and does not throw an IllegalStateException, you have an error with the method
				else {
					// debugging issue
					break;
				}
			}
			
			
			
			// no moves work = you lose = break
			break;
		}

		return 0;
	}
    
}
