import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Slider extends JFrame implements ChangeListener {

    JPanel panel;
    JLabel label;
    JSlider slider;
    JTextField field;
    Slider () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Slider Demo");

        label = new JLabel();
        panel = new JPanel();
        slider = new JSlider(0, 100, 50);
        slider.setPreferredSize(new Dimension(700, 400));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(20);
        slider.setPaintLabels(true);
        slider.setFont(new Font("SF Pro Display", Font.BOLD, 15 ));
        slider.setOrientation(SwingConstants.VERTICAL);

        field = new JTextField("Temp: " + slider.getValue() + "C.");
//        field.setText("Temperature is " + slider.getValue() + "C.");
        field.setFont(new Font("SF Pro Display", Font.BOLD, 15));
//        field.setLayout(new FlowLayout());
//        field.setPreferredSize(new Dimension(100, 100));

        slider.addChangeListener(this);

        panel.add(slider);
        panel.add(label);
        panel.add(field);

        this.add(panel);
        this.setSize(720, 720);
        this.setVisible(true);
    }
    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        label.setText("Temperature is " + slider.getValue() + "C.");
    }
}