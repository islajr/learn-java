import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1080, 720);
        frame.setTitle("My New Application");
        frame.setDefaultCloseOperation(3);
        frame.setResizable(true);
        frame.setVisible(true);

        ImageIcon image = new ImageIcon("/home/isla-jr/Downloads/27243728.jpg");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(0, 34, 123));
    }
}