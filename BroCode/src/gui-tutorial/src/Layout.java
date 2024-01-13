import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Layout {
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 720);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // instantiating each panel
        JPanel north = new JPanel();
        JPanel south = new JPanel();
        JPanel east = new JPanel();
        JPanel west = new JPanel();
        JPanel center = new JPanel();

        // setting colors for each panel
        north.setBackground(Color.red);
        south.setBackground(Color.yellow);
        center.setBackground(Color.black);
        east.setBackground(Color.green);
        west.setBackground(Color.blue);

        north.setPreferredSize(new Dimension(100, 100));
        east.setPreferredSize(new Dimension(100, 100));
        west.setPreferredSize(new Dimension(100, 100));
        south.setPreferredSize(new Dimension(100, 100));
        center.setPreferredSize(new Dimension(100, 100));

        frame.add(north, BorderLayout.NORTH);
        frame.add(south, BorderLayout.SOUTH);
        frame.add(east, BorderLayout.EAST);
        frame.add(west, BorderLayout.WEST);
        frame.add(center, BorderLayout.CENTER);


    }
}