import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBox extends JFrame implements ActionListener {
    JCheckBox checker;
    CheckBox() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        checker = new JCheckBox("Boy");
        checker.setFocusable(false);
        checker.setPreferredSize(new Dimension(100, 100));
        checker.addActionListener(this);
        checker.setFont(new Font("Noto Serif", Font.BOLD, 15));

        this.add(checker);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == checker) {
            checker.setEnabled(false);
            System.out.println("This is a " + checker.getText());
        }
    }
}