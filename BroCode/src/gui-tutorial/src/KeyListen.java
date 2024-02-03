import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class KeyListen extends JFrame implements KeyListener {

    KeyListen () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(720, 720);
        this.addKeyListener(this);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        System.out.println("you pressed: " + keyEvent.getKeyChar());
        System.out.println("");
    }
}