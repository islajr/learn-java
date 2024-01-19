import javax.swing.*;
import java.awt.*;

public class NewWindow {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Hello");
    NewWindow() {

        label.setBounds(0, 0, 100, 50);
        label.setFont(new Font("Hack", Font.PLAIN, 25));

        frame.setLayout(null);
        frame.add(label);
        frame.setSize(720, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}