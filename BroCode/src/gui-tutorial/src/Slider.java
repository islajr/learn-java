import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider extends JFrame implements ChangeListener {

    JPanel panel;
    JLabel label;
    JSlider slider;
    Slider () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Slider Demo");

        label = new JLabel();
        slider = new JSlider();
    }
    @Override
    public void stateChanged(ChangeEvent changeEvent) {

    }
}