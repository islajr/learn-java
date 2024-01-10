import javax.swing.*;
import java.awt.*;

public class Panel {
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        JPanel redPanel = panel();
        JPanel bluePanel = panel2();
        JPanel greenPanel = panel3();

        redPanel.add(label());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1080, 750);
        frame.setVisible(true);
        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);
    }

    private static JPanel panel () {
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0, 0, 250, 250);

        return redPanel;
    }

    private static JPanel panel2 () {
        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(250, 0, 250, 250);

        return bluePanel;
    }

    private static JPanel panel3 () {
        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(0, 250, 500, 250);

        return greenPanel;
    }

    private static JLabel label () {
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon("/home/isla-jr/Downloads/27243728.jpg");
        label.setText("Hello, Isla! ");
        label.setIcon(icon);

        return label;
    }
}