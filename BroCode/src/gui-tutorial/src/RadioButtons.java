import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtons extends JFrame implements ActionListener {

    RadioButtons() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JRadioButton pizza = new JRadioButton("Pizza");
        JRadioButton hamburger = new JRadioButton("Hamburger");
        JRadioButton hotdog = new JRadioButton("Hot dog");

        this.add(pizza);
        this.add(hamburger);
        this.add(hotdog);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}