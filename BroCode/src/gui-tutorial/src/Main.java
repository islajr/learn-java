import javax.swing.*;

public class Main {
    public static void main (String[] args) {
/*        JOptionPane.showMessageDialog(null, "Do not close me!", "Warning!", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Do not close me!", "Warning!", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "Do not close me!", "Warning!", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "Do not close me!", "Warning!", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Do not close me!", "Warning!", JOptionPane.QUESTION_MESSAGE);*/

        JOptionPane.showConfirmDialog(null, "Are you a boy?", "Gender", JOptionPane.YES_NO_OPTION);
        System.out.println(JOptionPane.showInputDialog("Who are you?"));    // stores the response inside of a string.


    }
}