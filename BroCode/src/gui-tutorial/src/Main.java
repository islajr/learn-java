import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    JButton button;
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton();

        button.setBounds(250, 250, 100, 50);
        button.addActionListener();

        frame.setLayout(null);
        frame.setSize(1080, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("I am working!");
        }
    }
}