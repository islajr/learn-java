import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBox extends JFrame implements ActionListener {

    JComboBox comboBox;
    ComboBox () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        // list of items to be in the combo box
        String[] strikers = {"Cristiano", "Benzema", "Suarez", "Lewandowski"};
        comboBox = new JComboBox(strikers);

        this.add(comboBox);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent actionEvent) {

    }
}