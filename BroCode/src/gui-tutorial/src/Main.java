import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JLabel label = new JLabel();
        label.setText("Unlimited Void!");
        label.setIcon(new ImageIcon("/home/isla-jr/Pictures/a1dd6d200a0fe7cdd06c56202dc07249.jpg"));
        label.setHorizontalTextPosition(JLabel.RIGHT);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setForeground(Color.RED);
        label.setBackground(Color.BLACK);
        label.setFont(new Font("Hack", Font.PLAIN, 20));

        JFrame frame = new JFrame();
        frame.add(label);
        frame.setSize(1080, 720);
        frame.setTitle("My New Application");
        frame.setDefaultCloseOperation(3);
        frame.setResizable(true);
        frame.setVisible(true);

        ImageIcon image = new ImageIcon("/home/isla-jr/Downloads/27243728.jpg");
        frame.setIconImage(image.getImage());
//        frame.getContentPane().setBackground(new Color(0, 34, 123));
    }
}