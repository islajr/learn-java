import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Slider extends JFrame implements ChangeListener {

    JPanel panel;
    JLabel label;
    JSlider slider;
    Slider () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Slider Demo");

        label = new JLabel();
        panel = new JPanel();
        slider = new JSlider(0, 100, 50);
        slider.setSize(new Dimension(720, 420));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(20);
        slider.setPaintLabels(true);

        panel.add(slider);
        panel.add(label);

        this.add(panel);
        this.setSize(720, 720);
        this.setVisible(true);
    }
    @Override
    public void stateChanged(ChangeEvent changeEvent) {

    }
}