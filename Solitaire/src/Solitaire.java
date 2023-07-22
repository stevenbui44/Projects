package src;
import java.util.Scanner;

/**
 * Okay steven so this is the main file where you run the whole thing
 * 
 * Compile:     javac Solitaire.java
 * Run:         java Solitaire
 * 
 * Compile:     javac *.java
 * 
 */

public class Solitaire {
    public static void main(String[] args) {

        // // CHUNK ONE: Testing shuffle
        // // System.out.println("hi world :3");
        // Deck deck = new Deck();
        // // System.out.println(deck.toString());
        // deck.shuffle();
        // System.out.println(deck.toString());

        // CHUNK TWO: testing removeCard
        // for (int i = 0; i < 52; i++) {
        //     if (i % 13 == 0) {
        //         System.out.print("\n");
        //     }
        //     System.out.print(deck.removeCard());
        //     System.out.print("\t");
        // }
        // System.out.println(deck.size());



        Deck deck = new Deck();
        deck.shuffle();
        System.out.println(deck.toString());

        // we should automatically start the program with the piles being set up, the stock being full
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

        // System.out.println(deck.size());
        // System.out.println(deck.toString());

        // filling up the stock. The top of the stack is the END of the deck.
        while (!deck.isEmpty()) {
            stock.push(deck.removeCard());
        }
        
        /*  
            TODO: work on stock going to waste
            TODO: work on waste history (stacks and queues probably)
            TODO: work on piles going to foundation
            TODO: work on formatting the piles
            TODO: it's A not 1

            TODO: give OPTIONS instead of just outputting everything below. like say the user has
                  to type in "stock to waste" to do one option and then "quit" to quit
        */



        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayBasedStack<Card> tempStock = new ArrayBasedStack<Card>();
        ArrayBasedStack<Card> tempWaste = new ArrayBasedStack<Card>();
        ArrayBasedStack<Card> tempPile1 = new ArrayBasedStack<Card>();
        ArrayBasedStack<Card> tempPile2 = new ArrayBasedStack<Card>();
        ArrayBasedStack<Card> tempPile3 = new ArrayBasedStack<Card>();
        ArrayBasedStack<Card> tempPile4 = new ArrayBasedStack<Card>();
        ArrayBasedStack<Card> tempPile5 = new ArrayBasedStack<Card>();
        ArrayBasedStack<Card> tempPile6 = new ArrayBasedStack<Card>();
        ArrayBasedStack<Card> tempPile7 = new ArrayBasedStack<Card>();

        // CHUNK THREE: testing stock to waste

        while (!input.equals("quit")) {
            if (input.equals("1") || input.equals("stock to waste")) {
                moveStockToWaste();

                System.out.println("Stock:");
                tempStock = new ArrayBasedStack<Card>();
                while (!stock.isEmpty()) {
                    tempStock.push(stock.pop());
                }
                while (!tempStock.isEmpty()) {
                    stock.push(tempStock.pop());
                    System.out.print(stock.top() + "\t");
                }
                System.out.println();

                System.out.println("Waste:");
                tempWaste = new ArrayBasedStack<Card>();
                while (!waste.isEmpty()) {
                    tempWaste.push(waste.pop());
                }
                while (!tempWaste.isEmpty()) {
                    waste.push(tempWaste.pop());
                    System.out.print(waste.top() + "\t");
                }
                System.out.println("\n");

                input = scanner.nextLine();
            }
            else if (input.equals("2") || input.equals("waste to stock")) {
                moveWasteToStock();

                System.out.println("Stock:");
                tempStock = new ArrayBasedStack<Card>();
                while (!stock.isEmpty()) {
                    tempStock.push(stock.pop());
                }
                while (!tempStock.isEmpty()) {
                    stock.push(tempStock.pop());
                    System.out.print(stock.top() + "\t");
                }
                System.out.println();

                System.out.println("Waste:");
                tempWaste = new ArrayBasedStack<Card>();
                while (!waste.isEmpty()) {
                    tempWaste.push(waste.pop());
                }
                while (!tempWaste.isEmpty()) {
                    waste.push(tempWaste.pop());
                    System.out.print(waste.top() + "\t");
                }
                System.out.println("\n");

                input = scanner.nextLine();
            }
            else if (input.equals("piles")) {
                System.out.print("Pile 1:\t");
                tempPile1 = new ArrayBasedStack<Card>();
                while (!openPile1.isEmpty()) {
                    tempPile1.push(openPile1.pop());
                }
                while (!tempPile1.isEmpty()) {
                    openPile1.push(tempPile1.pop());
                    System.out.print(openPile1.top() + "\t");
                }
                System.out.println();

                System.out.print("Pile 2:\t");
                tempPile2 = new ArrayBasedStack<Card>();
                while (!openPile2.isEmpty()) {
                    tempPile2.push(openPile2.pop());
                }
                while (!tempPile2.isEmpty()) {
                    openPile2.push(tempPile2.pop());
                    System.out.print(openPile2.top() + "\t");
                }
                System.out.println();

                System.out.print("Pile 3:\t");
                tempPile3 = new ArrayBasedStack<Card>();
                while (!openPile3.isEmpty()) {
                    tempPile3.push(openPile3.pop());
                }
                while (!tempPile3.isEmpty()) {
                    openPile3.push(tempPile3.pop());
                    System.out.print(openPile3.top() + "\t");
                }
                System.out.println();

                System.out.print("Pile 4:\t");
                tempPile4 = new ArrayBasedStack<Card>();
                while (!openPile4.isEmpty()) {
                    tempPile4.push(openPile4.pop());
                }
                while (!tempPile4.isEmpty()) {
                    openPile4.push(tempPile4.pop());
                    System.out.print(openPile4.top() + "\t");
                }
                System.out.println();

                System.out.print("Pile 5:\t");
                tempPile5 = new ArrayBasedStack<Card>();
                while (!openPile5.isEmpty()) {
                    tempPile5.push(openPile5.pop());
                }
                while (!tempPile5.isEmpty()) {
                    openPile5.push(tempPile5.pop());
                    System.out.print(openPile5.top() + "\t");
                }
                System.out.println();

                System.out.print("Pile 6:\t");
                tempPile6 = new ArrayBasedStack<Card>();
                while (!openPile6.isEmpty()) {
                    tempPile6.push(openPile6.pop());
                }
                while (!tempPile6.isEmpty()) {
                    openPile6.push(tempPile6.pop());
                    System.out.print(openPile6.top() + "\t");
                }
                System.out.println();

                System.out.print("Pile 7:\t");
                tempPile7 = new ArrayBasedStack<Card>();
                while (!openPile7.isEmpty()) {
                    tempPile7.push(openPile7.pop());
                }
                while (!tempPile7.isEmpty()) {
                    openPile7.push(tempPile7.pop());
                    System.out.print(openPile7.top() + "\t");
                }
                System.out.println("\n");

                input = scanner.nextLine();
            }
            else if (input.equals("3") || input.equals("waste to pile")) {
                moveWasteToPile();

                System.out.println("Stock:");
                tempStock = new ArrayBasedStack<Card>();
                while (!stock.isEmpty()) {
                    tempStock.push(stock.pop());
                }
                while (!tempStock.isEmpty()) {
                    stock.push(tempStock.pop());
                    System.out.print(stock.top() + "\t");
                }
                System.out.println();

                System.out.println("Waste:");
                tempWaste = new ArrayBasedStack<Card>();
                while (!waste.isEmpty()) {
                    tempWaste.push(waste.pop());
                }
                while (!tempWaste.isEmpty()) {
                    waste.push(tempWaste.pop());
                    System.out.print(waste.top() + "\t");
                }
                System.out.println("\n");

                input = scanner.nextLine();
            }
            else {
                input = scanner.nextLine();
            }
        }


    }

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


    // private void refillStack(ArrayBasedStack<Card> stack) {

    // }

    public static void moveStockToWaste() {
        if (!stock.isEmpty()) {
            waste.push(stock.pop());
        }
        else {
            // throw an exception or something
            // actually if it's a GUI you can have a card that says refill or something
        }
    }

    // NOTE: only use this whenever the stock is empty, this should never be an option for the player
    private static void moveWasteToStock() {
        while (!waste.isEmpty()) {
            stock.push(waste.pop());
        }
    }

    // TODO: also account for if there are no cards in the open or closed piles
    public static void moveWasteToPile() {
        String tempWasteValue = waste.top().updateValue();
        boolean color = waste.top().getColor();
        
        if (tempWasteValue == openPile1.top().updateValue() + 1 && color != openPile1.top().getColor()) {
            openPile1.push(waste.pop());
        }
        else if (tempWasteValue == openPile2.top().updateValue() + 1 && color != openPile2.top().getColor()) {
            openPile2.push(waste.pop());
        }
        else if (tempWasteValue == openPile3.top().updateValue() + 1 && color != openPile3.top().getColor()) {
            openPile3.push(waste.pop());
        }
        else if (tempWasteValue == openPile4.top().updateValue() + 1 && color != openPile4.top().getColor()) {
            openPile4.push(waste.pop());
        }
        else if (tempWasteValue == openPile5.top().updateValue() + 1 && color != openPile5.top().getColor()) {
            openPile5.push(waste.pop());
        }
        else if (tempWasteValue == openPile6.top().updateValue() + 1 && color != openPile6.top().getColor()) {
            openPile6.push(waste.pop());
        }
        else if (tempWasteValue == openPile7.top().updateValue() + 1 && color != openPile7.top().getColor()) {
            openPile7.push(waste.pop());
        }
    }

    public static void moveWasteToFoundation(ArrayBasedStack<Card> a, ArrayBasedStack<Card> b) {
        
    }

    public static void movePileToPile(ArrayBasedStack<Card> a, ArrayBasedStack<Card> b) {

    }

    public static void movePileToFoundation(ArrayBasedStack<Card> a, ArrayBasedStack<Card> b) {
        
    }

    public static void moveFoundationToPile(ArrayBasedStack<Card> a, ArrayBasedStack<Card> b) {
        
    }
}
