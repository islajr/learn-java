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
        field.setFont(new Font("Times New Roman", Font.BOLD, 16));

        submit = new JButton("Submit");
        submit.setFont(new Font(null, Font.BOLD, 17));
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