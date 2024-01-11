import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    JButton button;
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton("Click me!");

        button.setBounds(250, 250, 100, 50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("I'm active!");
            }
        });

        frame.setLayout(null);
        frame.setSize(1080, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button);
        frame.setVisible(true);
    }


}