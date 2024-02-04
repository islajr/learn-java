import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class KeyListen extends JFrame implements KeyListener {

    JLabel label;

    KeyListen () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(720, 720);
        this.addKeyListener(this);
        this.setLayout(null);

        label = new JLabel();
        label.setBounds(0, 0, 100, 100);
        label.setBackground(Color.red);
        label.setOpaque(true);

        this.add(label);
        this.getContentPane().setBackground(Color.black);

        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        switch (keyEvent.getKeyChar()) {
            case 'a':
                label.setLocation(label.getX() - 5, label.getY());
                break;
            
            case 'd':
                label.setLocation(label.getX() + 5, label.getY());
                break;

            case 'w':
                label.setLocation(label.getX(), label.getY() - 5);
                break;

            case 's':
                label.setLocation(label.getX(), label.getY() + 5);
                break;

            default:
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 37:
                label.setLocation(label.getX() - 5, label.getY());
                break;
            
            case 39:
                label.setLocation(label.getX() + 5, label.getY());
                break;

            case 38:
                label.setLocation(label.getX(), label.getY() - 5);
                break;

            case 40:
                label.setLocation(label.getX(), label.getY() + 5);
                break;

            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        
    }
}