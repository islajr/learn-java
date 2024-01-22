import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextField extends JFrame implements ActionListener {
    JTextField field;
    JButton submit;
    TextField() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        field = new JTextField();
        field.setPreferredSize(new Dimension(250, 25));

        submit = new JButton("Submit");
        submit.addActionListener(this);

        this.add(field);
        this.add(submit);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == submit) {
            System.out.println(field.getText());
        }
    }
}