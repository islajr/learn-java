import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtons extends JFrame implements ActionListener {

    JRadioButton pizza;
    JRadioButton hamburger;
    JRadioButton hotdog;

    RadioButtons() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        pizza = new JRadioButton("Pizza");
        hamburger = new JRadioButton("Hamburger");
        hotdog = new JRadioButton("Hot dog");

        ButtonGroup lunchGroup = new ButtonGroup();
        lunchGroup.add(pizza);
        lunchGroup.add(hamburger);
        lunchGroup.add(hotdog);

        this.add(pizza);
        this.add(hamburger);
        this.add(hotdog);

        pizza.addActionListener(this);
        hamburger.addActionListener(this);
        hotdog.addActionListener(this);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == pizza)
            System.out.println("You ordered pizza!");
        else if (actionEvent.getSource() == hamburger)
            System.out.println("You ordered a hamburger!");
        else if (actionEvent.getSource() == hotdog)
            System.out.println("You ordered a hot dog!");
    }
}