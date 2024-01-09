import javax.swing.*;
import java.awt.*;

public class Panel {
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        JPanel panels = panel();
        frame.setDefaultCloseOperation(3);
        frame.setLayout(null);
        frame.setSize(1080, 750);
        frame.setVisible(true);
        frame.add(panels);
    }

    private static JPanel panel () {
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0, 0, 250, 250);

        return redPanel;
    }
}