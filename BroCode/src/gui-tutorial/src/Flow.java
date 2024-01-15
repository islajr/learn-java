import javax.swing.*;
import java.awt.*;

public class Flow {
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 720);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        panel.setPreferredSize(new Dimension(250, 250));
        panel.setBackground(Color.black);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        panel.add(new JButton("10"));

        frame.add(panel);
        frame.setVisible(true);

    }
}