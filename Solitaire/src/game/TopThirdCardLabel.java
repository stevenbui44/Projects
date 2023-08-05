package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopThirdCardLabel extends JLabel {
    private ImageIcon cardImage;

    public TopThirdCardLabel(ImageIcon cardImage) {
        this.cardImage = cardImage;
        setIcon(cardImage);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int height = getHeight();
        int topThirdHeight = height / 3;
        g.drawImage(cardImage.getImage(), 0, 0, getWidth(), topThirdHeight, null);
    }
}