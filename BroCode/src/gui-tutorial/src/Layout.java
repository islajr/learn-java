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

        // creating subpanels
        JPanel subPanel1 = new JPanel();
        JPanel subPanel2 = new JPanel();
        JPanel subPanel3 = new JPanel();
        JPanel subPanel4 = new JPanel();

        center.setLayout(new BorderLayout(10, 10));

        subPanel1.setBackground(Color.magenta);
        subPanel2.setBackground(Color.white);
        subPanel3.setBackground(Color.orange);
        subPanel4.setBackground(Color.cyan);


        subPanel1.setPreferredSize(new Dimension(40, 40));
        subPanel2.setPreferredSize(new Dimension(40, 40));
        subPanel3.setPreferredSize(new Dimension(40, 40));
        subPanel4.setPreferredSize(new Dimension(40, 40));

        center.add(subPanel1, BorderLayout.NORTH);
        center.add(subPanel2, BorderLayout.SOUTH);
        center.add(subPanel3, BorderLayout.EAST);
        center.add(subPanel4, BorderLayout.WEST);

    }
}