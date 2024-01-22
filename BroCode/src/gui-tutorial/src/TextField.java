import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
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
        field.setPreferredSize(new Dimension(250, 25)); // sets the size of the text field.
        field.setFont(new Font("Times New Roman", Font.BOLD, 16));  // sets the font of the field.
        field.setBorder(new SoftBevelBorder(1));    // changes the border type of the textfield.
        field.setText("What's on your mind?");  // sets placeholder
        field.setEditable(true);   // makes the field editable (or not) - set to true by default.

        submit = new JButton("Submit");
        submit.setFont(new Font("Times New Roman", Font.BOLD, 16));
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
            field.setEditable(false);   // disables the text field after a text has been sent.
            submit.setEnabled(false);   // disables the button after the text has been submitted.
        }
    }
}