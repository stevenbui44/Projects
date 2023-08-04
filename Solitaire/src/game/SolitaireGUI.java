package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SolitaireGUI extends JFrame{

	// six game modes, one start
	private JButton regularButton, autoSlowButton, autoMedButton, autoFastButton, autoVeryFastButton, startButton;
	
	// controls, foundation, stock + waste, tableau
    private JPanel controlPanel, foundationPanel, stockWastePanel, tableauPanel;
    
    // four piles in foundation
    private JLabel[] foundationPiles;
    
    // TODO: not sure if we need this
    private JLabel stockPile, wastePile;
    
    // button to refill the stock after it is depleted
    private JButton refillButton;
    
    // TODO: don't we need seven piles in tableau, like foundation
	
	
	
	
	
	
	
	
	public SolitaireGUI() {
//		setSize(800, 800);
//		setLocation(50, 50);
//		setTitle("Solitaire");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		Container c = getContentPane();
//		
//		btnRegular = new JButton("Regular");
//		btnAutoSlow = new JButton("Auto - Slow");
//		btnAutoMed = new JButton("Auto - Medium");
//		btnAutoFast = new JButton("Auto - Fast");
//		btnAutoZoom = new JButton("Auto - Zoom");
//		
//		setVisible(true);
		
		
		
		
		
		// Default stuff
        setSize(800, 600);
        setLocation(100, 100);
        setTitle("Solitaire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        // Create panels for different parts of the game
        controlPanel = new JPanel();
        tableauPanel = new JPanel(new GridLayout(2, 7)); // Adjust layout as needed
        foundationPanel = new JPanel(new GridLayout(1, 4));
        stockWastePanel = new JPanel(new FlowLayout());

        
        
        
        
        
        // TODO: fix this
        // Create and add cards to the game panel
        for (int i = 0; i < 7; i++) {
            JPanel pilePanel = new JPanel();
            pilePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            gamePanel.add(pilePanel);
        }
        
        // Create and add foundation piles
        for (int i = 0; i < 4; i++) {
            JPanel foundationPilePanel = new JPanel();
            foundationPilePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            foundationPanel.add(foundationPilePanel);
        }

        
        
        
        
        
        // TODO: create buttons for game modes (Regular, Autos)
        
        
        
        
        // Create buttons for controls
        startButton = new JButton("New Game");
        startButton.setEnabled(false);
        
        // Add controls to the control panel
        controlPanel.add(regularButton);
        controlPanel.add(autoSlowButton);
        controlPanel.add(autoMedButton);
        controlPanel.add(autoFastButton);
        controlPanel.add(autoVeryFastButton);
        controlPanel.add(startButton);
        
        
        
        
        // TODO: Create foundation pile labels
        
        
        
        
        
        // TODO: Create stock and waste piles
        
        
        
        
        
        // TODO: Create tableau cards
        
        

        
        // Add panels to the frame
        add(controlPanel, BorderLayout.WEST);
        add(foundationPanel, BorderLayout.NORTH);
        add(stockWastePanel, BorderLayout.CENTER);
        add(tableauPanel, BorderLayout.SOUTH);

        
        
        
        
        
        // TODO: Set up action listeners for buttons
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle new game logic
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        
        
        
        // Set up action listeners for start button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        
        
        // Set up action listeners for refill button
        refillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refillStock();
            }
        });


        setVisible(true);
		
	}
	
	
	
	
	
	
	
	private void startGame() {
		// TODO: game logic here
	}
	
	private void refillStock() {
		// TODO: game logic here
	}
	
	
	
//	private void newRegularGame() {
//		
//	}
//	
//	private void newSpeedOne() {
//		
//	}
//	
//	private void newSpeedTwo() {
//		
//	}
//	
//	private void newSpeedThree() {
//		
//	}
//	
//	private void newSpeedFour() {
//		
//	}
	
	
	
	
	
	
	
	
	
	// create a new game
	public static void main(String[] args) {
		new SolitaireGUI();
	}
}
