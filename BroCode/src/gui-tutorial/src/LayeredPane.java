import javax.swing.*;
import java.awt.*;

public class LayeredPane {
    public static void main (String[] args) {
        JLabel label1 = new JLabel();
        label1.setOpaque(true);
        label1.setBackground(Color.black);
        label1.setBounds(100, 100, 500, 500);

        JLabel label2 = new JLabel();
        label2.setOpaque(true);
        label2.setBackground(Color.blue);
        label2.setBounds(200, 200, 500, 500);

        JLabel label3 = new JLabel();
        label3.setOpaque(true);
        label3.setBackground(Color.green);
        label3.setBounds(350, 350, 500, 500);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0,1080, 1080);
//        layeredPane.add(label1, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(label1, Integer.valueOf(0));    // integer wrapper class use case.
        layeredPane.add(label2, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(label3, JLayeredPane.DRAG_LAYER);

        JFrame frame = new JFrame();
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1080, 1080);
        frame.setVisible(true);
    }
}