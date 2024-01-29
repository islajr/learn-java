import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Slider extends JFrame implements ChangeListener, KeyListener {

    JPanel panel;
    JLabel label;
    JSlider slider;
    JTextField field;

    int sliderValue;
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

        sliderValue = slider.getValue();
        field = new JTextField("Temperature: " + sliderValue + "C.");
        field.setFont(new Font("SF Pro Display", Font.BOLD, 15));
        field.addKeyListener(this);

        slider.addChangeListener(this);

        panel.add(slider);
        panel.add(field);

        this.add(panel);
        this.setSize(720, 720);
        this.setVisible(true);
    }
    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        field.setText("Temperature: " + slider.getValue() + "C.");
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.equals("Backspace")) {
            slider.setValue(sliderValue);
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}