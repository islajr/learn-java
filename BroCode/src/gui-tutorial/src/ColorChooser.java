import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChooser extends JFrame implements ActionListener {

    JButton button;
    JLabel label;
    ColorChooser() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Pick a colour");
        button.addActionListener(this);

        label = new JLabel();
        label.setBackground(Color.WHITE);
        label.setOpaque(true);
        label.setText("This is some text");
        label.setFont(new Font("SF Display Pro", Font.BOLD, 100));

        this.add(button);
        this.add(label);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvenet) {
        if (actionEvenet.getSource() == button) {
            JColorChooser chooser = new JColorChooser();

            Color color = JColorChooser.showDialog(null, "Pick a Color", Color.black);
        }
    }
}