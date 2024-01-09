import javax.swing.*;
import java.awt.*;

public class Panel {
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        JPanel panels = panel();
        JPanel bluePanel = panel2();
        frame.setDefaultCloseOperation(3);
        frame.setLayout(null);
        frame.setSize(1080, 750);
        frame.setVisible(true);
        frame.add(panels);
        frame.add(bluePanel);
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
        bluePanel.setBounds(256, 0, 250, 250);

        return bluePanel;
    }
}