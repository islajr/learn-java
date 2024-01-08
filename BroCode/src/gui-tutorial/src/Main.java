import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JLabel label = getjLabel();

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

    private static JLabel getjLabel() {
        JLabel label = new JLabel();
        Border border = BorderFactory.createLineBorder(Color.GREEN, 10);
        label.setText("UNLIMITED VOID!");
        label.setIcon(new ImageIcon("/home/isla-jr/Pictures/a1dd6d200a0fe7cdd06c56202dc07249.jpg"));
        label.setHorizontalTextPosition(JLabel.RIGHT);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setOpaque(true);
        label.setFont(new Font("Liberation Serif", Font.PLAIN, 20));
        label.setIconTextGap(50);
        label.setBorder(border);
        return label;
    }
}