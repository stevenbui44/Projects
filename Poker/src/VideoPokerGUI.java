import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Video Poker Game Graphical User Interface
 * @author Dan Longo
 * @author Suzanne Balik
 *
 */
public class VideoPokerGUI extends JFrame implements ActionListener {

    /** Width of GUI */
    public static final int WIDTH = 480;

    /** Height of GUI */
    public static final int HEIGHT = 315;

    /** x coordinate of upper lefthand corner of GUI */
    public static final int X = 100;

    /** y coordinate of upper lefthand corner of GUI */
    public static final int Y = 100;
    
    /** Font size of text */
    public static final int FONT_SIZE = 15;

    /** Width of text */
    public static final int TEXT_WIDTH = 10;

    /** Displays number of points */
    private JLabel lblPoints;
    
    /** Displays type of hand */
    private JTextField txtScore;

    /** Cards to be displayed */
    private JLabel[] cards;
    
    /** Icons (images) for cards */
    private ImageIcon[] icons;
    
    /** Replace buttons for cards */
    private JButton[] btnCards;

    /** Score Hand button */
    private JButton btnScoreHand;

    /** New Game button */
    private JButton btnNewGame;

    /** Quit button */
    private JButton btnQuit;

    /** Video Poker game model */
    private VideoPoker pm;

    /**
     * Creates instance of PokerGUI class
     * @param seed if -1, a random game is played, otherwise the same game is played, in that
     * the deck will be shuffled the same way, whenever the seed is the same.
     */
    public VideoPokerGUI(int seed) {
    	
    	/*
    	 * NOTES:
    	 * The playing field itself must be a JPanel
    	 * JPanels can contain other JPanels (JPanels just hold stuff)
    	 */

    	// creates the new game, which gets called in other methods
        pm = new VideoPoker(seed);

        // default stuff you need
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocation(X, Y);
        setTitle("Video Poker");
        
        
        // Container = contains top row, playing field, and bottom row 
        											// Container
        Container c = getContentPane();

        
        // pnlScore = top row						// JPanel
        // lblPoints = Points: 100					// JLabel
        // txtScore = Press New Game to Start!		// JTextField
        JPanel pnlScore = new JPanel();
        pnlScore.setLayout(new GridLayout(1,2));
        
        lblPoints = new JLabel("Points: " + pm.getPoints());
        lblPoints.setFont(new Font("SansSerif",Font.BOLD,FONT_SIZE));
        
        txtScore = new JTextField("",TEXT_WIDTH); 
        txtScore.setFont(new Font("SansSerif",Font.BOLD,FONT_SIZE)); 
        txtScore.setHorizontalAlignment(JTextField.CENTER);
        txtScore.setEditable(false);
        txtScore.setBackground(Color.WHITE);
        txtScore.setText("Press New Game to Start!");
        pnlScore.add(lblPoints);
        pnlScore.add(txtScore);

        
        // pnlCards = playing field					// JPanel
        // cards = where cards should be			// JLabel[]
        // icons = the picture of the cards			// ImageIcon[]
        // btnCards = Replace						// JButton[]
        JPanel pnlCards = new JPanel();
        pnlCards.setLayout(new GridLayout(2,VideoPoker.CARDS_IN_HAND));
        cards = new JLabel[VideoPoker.CARDS_IN_HAND];
        icons = new ImageIcon[VideoPoker.CARDS_IN_HAND];
        btnCards = new JButton[VideoPoker.CARDS_IN_HAND];

        
        // gives a picture to the icon[i], which goes to card[i] using setIcon()
        // panel = panel containing one card		// JPanel
        for(int i = 0; i < VideoPoker.CARDS_IN_HAND; i++) {
            icons[i] = new ImageIcon("cards/h" + (i + 10) + ".gif");
            cards[i] = new JLabel();
            cards[i].setIcon(icons[i]);
            JPanel panel = new JPanel();
            panel.add(cards[i]);
            pnlCards.add(panel);
        }

        // creates 5 Replace buttons in btnCards[]
        for(int i = 0; i < VideoPoker.CARDS_IN_HAND; i++) {
            btnCards[i] = new JButton("Replace");
            btnCards[i].setBackground(Color.RED);
            btnCards[i].addActionListener (this);
            btnCards[i].setEnabled(false);
            pnlCards.add(btnCards[i]);
        }

        
        // pnlButtons = bottom row					// JPanel
        // btnScoreHand = Score Hand				// JButton
        // btnNewGame = New Game					// JButton
        // btnQuit = Quit							// JButton
        JPanel pnlButtons = new JPanel();
        pnlButtons.setLayout(new GridLayout(1,3));
        
        btnScoreHand = new JButton("Score Hand");
        btnScoreHand.setFont(new Font("SansSerif",Font.BOLD,FONT_SIZE));
        btnScoreHand.addActionListener(this);
        btnScoreHand.setEnabled(false);
        
        btnNewGame = new JButton("New Game");
        btnNewGame.setFont(new Font("SansSerif",Font.BOLD,FONT_SIZE));
        btnNewGame.addActionListener(this);
        
        btnQuit = new JButton("Quit");
        btnQuit.setFont(new Font("SansSerif",Font.BOLD,FONT_SIZE));
        btnQuit.addActionListener (this);
        pnlButtons.add(btnScoreHand);
        pnlButtons.add(btnNewGame);
        pnlButtons.add(btnQuit);

        
        // c = Container to contain everything
        c.add(pnlScore,BorderLayout.NORTH);
        c.add(pnlCards,BorderLayout.CENTER);
        c.add(pnlButtons,BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * Executes action based on event
     * @param e event (button press, etc.)
     */
    public void actionPerformed(ActionEvent e) {
    	
    	// This method only exists because we implement ActionListener

    	
    	// if the user presses on New Game, work with pm (VideoPoker class)
        if(e.getSource() == btnNewGame) {

        	// Press New Game to Start! disappears
            txtScore.setText("");

            // creates a new game
            pm.newGame();

            // Score Hand (previously disabled) now enabled
            btnScoreHand.setEnabled(true);

            // sets card pictures
            for(int i = 0; i < VideoPoker.CARDS_IN_HAND; i++) {
            	
            	// gets the .gif name by calling VideoPoker method
                icons[i] = new ImageIcon(pm.getCardFileName(i));
                
                // sets the icon to that card
                cards[i].setIcon(icons[i]);
                
                // Replace = enabled
                btnCards[i].setEnabled(true);
            }

            // update Points: 100
            lblPoints.setText("Points: " + pm.getPoints());
        }

        
        
        // if the user presses on Score Hand
        else if(e.getSource() == btnScoreHand) {
        	
        	// Replace = disabled
            for(int i = 0; i < VideoPoker.CARDS_IN_HAND; i++) {
                btnCards[i].setEnabled(false);
            }

            // Score Hand = disabled
            btnScoreHand.setEnabled(false);

            // sets card pictures again (their implementation)
            for(int i = 0; i < VideoPoker.CARDS_IN_HAND; i++) {
            	
            	// gets the .gif name by calling VideoPoker method
                icons[i] = new ImageIcon(pm.getCardFileName(i));
                
                // sets the icon to tha card
                cards[i].setIcon(icons[i]);
            }
            
            // Press New Game to Start! turns to whatever they got
            txtScore.setText(pm.scoreHand());
            
            // update Points: 100
            lblPoints.setText("Points: " + pm.getPoints());
        }
        
        
        
        // if the user presses on Quit
        else if (e.getSource() == btnQuit) {
            System.exit(1);
        }
        
        
        
        // if the user presses on a card
        else {
            for (int i = 0; i < VideoPoker.CARDS_IN_HAND; i++) {
            	
            	// if the user pressed Replace
                if(e.getSource() == btnCards[i]) {
                    pm.replaceCard(i);
                    
                    // disable Replace
                    btnCards[i].setEnabled(false);
                }
            }
        }
    }

    /**
     * Starts up Video Poker game
     * @param args args[0] optional seed used for testing which determines how the deck is shuffled
     */
    public static void main(String[] args) {

        if (args.length == 1) {
            try {
                new VideoPokerGUI(Integer.parseInt(args[0]));
            } catch (NumberFormatException e) {
                System.out.println("Usage: java -cp bin VideoPokerGUI <seed>");
            }
        } else if (args.length == 0) {
            new VideoPokerGUI(VideoPoker.RANDOM_GAME);
        } else {
            System.out.println("Usage: java -cp bin VideoPokerGUI <seed>");
        }
    }
}
