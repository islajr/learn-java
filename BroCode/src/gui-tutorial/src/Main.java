import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    JButton button;
    public static void main (String[] args) {
        ImageIcon icon = new ImageIcon("/home/isla-jr/Pictures/3075c07db8ccf996bfa1b9e4dd09ac07.png");
        JFrame frame = new JFrame();
        JLabel image = new JLabel();
        image.setIcon(icon);
        image.setVisible(false);
        JButton button = new JButton("Click me!");

        button.setBounds(250, 250, 100, 50);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                System.out.println("I'm active!");
                image.setVisible(true);
                frame.add(image);
            }
        });
//        button.addActionListener(actionEvent -> System.out.println("I'm active!"));
        button.setText("Click me!");
        button.setFocusable(false);

        frame.setLayout(null);
        frame.setSize(1080, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button);
//        frame.add(image);
        frame.setVisible(true);
    }


}