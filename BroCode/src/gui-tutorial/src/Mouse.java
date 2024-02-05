import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class Mouse extends JFrame implements MouseListener {

    JLabel label;

    Mouse(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);

        label = new JLabel();
        label.setBounds(0, 0, 100, 100);
        label.setBackground(Color.red);
        label.setOpaque(true);
        label.addMouseListener(this);

        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        // System.out.println("You Clicked?");
    }

    @Override
    public void mousePressed(MouseEvent event) {
        // System.out.println("you pressed?");
        label.setBackground(Color.yellow);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        // System.out.println("you released?");
        label.setBackground(Color.red);
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        System.out.println("welcome, anon");
    }

    @Override
    public void mouseExited(MouseEvent event) {
        System.out.println("sorry to see you leave.");
    }
}