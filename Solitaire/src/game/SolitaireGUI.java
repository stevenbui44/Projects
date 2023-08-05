package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLayeredPane;

public class SolitaireGUI extends JFrame {

	// six game modes, one start
	// JButton = Replace
	private JButton btnRegular;
	private JButton btnAuto1;
	private JButton btnAuto2;
	private JButton btnAuto3;
	private JButton btnStart;
	
	private JButton btnRefill;
	
	// controls, foundation, stock + waste, tableau
	// JPanel = top row, playing field, bottom row, panel containing one card
    private JPanel pnlControl;
    private JPanel pnlFoundation;
    private JPanel pnlStockWaste;
    private JPanel pnlTableau;
    private JPanel pnlTopRow;
    
    // four piles in foundation
    // JLabel[] = where cards should be 
    private JLabel[] foundation;
    
    // JLabel[] = where cards should be
    // ImageIcon[] = picture of cards
    private JLabel[] tableau;
    private ImageIcon[] icons;
    
    private List<List<JLabel>> piles;
    
    // TODO: not sure if we need this
    // JLabel = Points: 100
    private JLabel stock;
    private JLabel waste;
    
    private JLayeredPane layeredPane;
    
    
    // TODO: we need seven piles in tableau, like foundation
	
	private Solitaire game;
	
	
	
	
	
	
	public SolitaireGUI(String seed) {
		
		// creates the new game
		game = new Solitaire(seed);
		
		// Container = contains everything
		Container c = getContentPane();
		
        initialize();

        
        // controlPanel = play buttons + start			// JPanel
        // tableauPanel = playing field 				// JPanel
        // foundationPanel = foundation					// JPanel
        // stockWastePanel = stock + waste				// JPanel
        // TODO: create a panel like pnlScore that contains foundationPanel and stockWastePanel
        pnlControl = new JPanel(new GridLayout(5, 1));		// 5 buttons on the left
        pnlTableau = new JPanel(new GridLayout(1, 7)); 		// 7 piles of GridLayout(15, 1)
        pnlFoundation = new JPanel(new GridLayout(1, 4));		// 4 piles at the top
        pnlStockWaste = new JPanel(new GridLayout(1, 3));		// 2 piles at the top, 1 for refill
        pnlTopRow = new JPanel(new GridLayout(1, 2));			// foundation + stock waste
        
        
        makeFoundation();
        
        makeStockWaste();
        
        
        
        
        
        // Populate piles[][] with cards
        layeredPane = new JLayeredPane();
        
        c.add(layeredPane, BorderLayout.CENTER);
        
        piles = new ArrayList<>();
        
        // creating piles with closed cards and 1 open card
        for (int i = 0; i < 7; i++) {
            piles.add(new ArrayList<>());
            for (int j = 0; j < i; j++) {
                addClosedCardToPile(i);
            }
            addOpenCardToPile(i, new ImageIcon("cards/h2.gif")); // Example: 2 of hearts
        }
        
        
        // adding piles to the pnlTableau
        for (List<JLabel> pile : piles) {
            JPanel pilePanel = new JPanel();
            pilePanel.setLayout(new BoxLayout(pilePanel, BoxLayout.Y_AXIS)); // Stack cards vertically
            for (JLabel cardLabel : pile) {
                pilePanel.add(cardLabel);
            }
            pnlTableau.add(pilePanel);
        }
        
        
        
        
        // Buttons for everything
        btnRegular = new JButton("Regular");
        btnRegular.setEnabled(true);
        
        btnAuto1 = new JButton ("Auto - Slow");
        btnAuto1.setEnabled(true);
        
        btnAuto2 = new JButton ("Auto - Medium");
        btnAuto2.setEnabled(true);
        
        btnAuto3 = new JButton ("Auto - Fast");
        btnAuto3.setEnabled(true);
        
        btnStart = new JButton("New Game");
        btnStart.setEnabled(false);
        
        btnRefill = new JButton("Refill");
        btnRefill.setEnabled(false);
        
        
        
        
        // Add controls to the control panel
        pnlControl.add(btnRegular);
        pnlControl.add(btnAuto1);
        pnlControl.add(btnAuto2);
        pnlControl.add(btnAuto3);
        pnlControl.add(btnStart);
        
        
        
        
        // TODO: Create foundation pile labels
        
        
        
        
        
        // TODO: Create stock and waste piles
        
        
        
        
        
        // TODO: Create tableau cards
        
        
        
        
        // Create a panel for the controls
        JPanel pnlControlsContainer = new JPanel(new BorderLayout());
        pnlControlsContainer.add(pnlControl, BorderLayout.PAGE_START);
        pnlControlsContainer.add(new JPanel(), BorderLayout.CENTER); // Add an empty panel to fill remaining space

        // Create a panel for the playing field
        JPanel pnlPlayingField = new JPanel(new BorderLayout());
        pnlPlayingField.add(pnlTopRow, BorderLayout.NORTH);
        pnlPlayingField.add(pnlTableau, BorderLayout.CENTER);

        // Add the control and playing field panels to the main content pane
        c.setLayout(new BorderLayout());
        c.add(pnlControlsContainer, BorderLayout.WEST);
        c.add(pnlPlayingField, BorderLayout.CENTER);

        // Make everything visible
        setVisible(true);
		
	}
	
	
	private void initialize() {
		setSize(800, 600);
        setLocation(100, 100);
        setTitle("Solitaire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	private void makeFoundation() {
        foundation = new JLabel[4];
        for (int i = 0; i < 4; i++) {
        	foundation[i] = new JLabel();
        	foundation[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        	pnlFoundation.add(foundation[i]);
        }
        pnlTopRow.add(pnlFoundation);
	}
	
	private void makeStockWaste() {
        waste = new JLabel("Waste");
        waste.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pnlStockWaste.add(waste);
        
        stock = new JLabel("Stock");
        stock.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pnlStockWaste.add(stock);
        
        btnRefill = new JButton("Refill Stock");
        btnRefill.setEnabled(false);
        pnlStockWaste.add(btnRefill);
        
        pnlTopRow.add(pnlStockWaste);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegular) {
			// not implemented yet
		}
		
		else if (e.getSource() == btnAuto1) {
			
		}
		
		else if (e.getSource() == btnAuto2) {
			
		}
		
		else if (e.getSource() == btnAuto3) {
	
		}
		
		else if (e.getSource() == btnStart) {
	
		}
		
		else if (e.getSource() == btnRefill) {
			
		}
	}
	
	
	
	
	// create a new game
	public static void main(String[] args) {
		
//		if (args.length == 1) {
//			try {
//				new SolitaireGUI(args[0]);
//			}
//			catch (Exception e) {
//				System.out.println("Couldn't use args[0]");
//			}
//		}
//		else if (args.length == 0) {
//			// TODO: we can select from a random bank of seeds that we know work
//			
//			Random random = new Random();
//			String seed = "" + random.nextInt();
//			new SolitaireGUI(seed);
//		}
//		else {
//			System.out.println("Give a seed");
//		}
		
//		System.out.println("here");
		
		new SolitaireGUI("1");
	}
	
	
	private void addClosedCardToPile(int pileIndex) {
	    ImageIcon closedCardImage = new ImageIcon("cards/back.gif");
	    Image scaledImage = closedCardImage.getImage().getScaledInstance(50, 75, Image.SCALE_SMOOTH); // Adjust the dimensions as needed
	    ImageIcon scaledClosedCardImage = new ImageIcon(scaledImage);
	    JLabel closedCard = new JLabel(scaledClosedCardImage);
	    piles.get(pileIndex).add(closedCard);
	}
	
	private void addOpenCardToPile(int pileIndex, ImageIcon cardImage) {
	    Image scaledImage = cardImage.getImage().getScaledInstance(50, 75, Image.SCALE_SMOOTH); // Adjust the dimensions as needed
	    ImageIcon scaledCardImage = new ImageIcon(scaledImage);
	    JLabel openCard = new JLabel(scaledCardImage);
	    piles.get(pileIndex).add(openCard);
	}
	
}
