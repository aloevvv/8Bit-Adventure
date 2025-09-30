import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoveSprite extends JPanel implements KeyListener {
    private int x = 300, y = 200; // Initial position
    private int speed = 10;       // Move speed
    private Image sprite;

    public MoveSprite() {
        setPreferredSize(new Dimension(640, 480));
        setBackground(Color.WHITE);
        addKeyListener(this);
        setFocusable(true);
        sprite = new ImageIcon("8bit.png").getImage(); // Load image
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(sprite, x, y, 40, 40, this); // Draw sprite
    }

    // Arrow key events
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) x -= speed;
        if (key == KeyEvent.VK_RIGHT) x += speed;
        if (key == KeyEvent.VK_UP) y -= speed;
        if (key == KeyEvent.VK_DOWN) y += speed;
        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Move the Character!");
        MoveSprite gamePanel = new MoveSprite();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel);
        frame.pack();
        frame.setVisible(true);
        gamePanel.requestFocusInWindow();
    }
}