import javax.swing.*;
import java.awt.*;

public class Grid {
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        JPanel myPanel = panel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());
        frame.setSize(1080, 1080);
        frame.add(myPanel);
        frame.setVisible(true);

    }

    private static JPanel panel () {
        JPanel panel = new JPanel(new GridLayout(9, 1, 10, 10));
        panel.setPreferredSize(new Dimension());
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        panel.setBackground(Color.black);

        return panel;

    }
}