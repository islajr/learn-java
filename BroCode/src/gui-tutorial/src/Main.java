import javax.swing.*;

public class Main {
    public static void main (String[] args) {
        JOptionPane.showMessageDialog(null, "Do not close me!", "Warning!", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Do not close me!", "Warning!", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "Do not close me!", "Warning!", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "Do not close me!", "Warning!", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Do not close me!", "Warning!", JOptionPane.QUESTION_MESSAGE);

    }
}