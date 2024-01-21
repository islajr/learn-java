import javax.swing.*;

public class Main {
    public static void main (String[] args) {
/*        JOptionPane.showMessageDialog(null, "Do not close me!", "Warning!", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Do not close me!", "Warning!", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "Do not close me!", "Warning!", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "Do not close me!", "Warning!", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Do not close me!", "Warning!", JOptionPane.QUESTION_MESSAGE);*/

//        JOptionPane.showConfirmDialog(null, "Are you a boy?", "Gender", JOptionPane.YES_NO_CANCEL_OPTION);
//        System.out.println(JOptionPane.showInputDialog("Who are you?"));    // stores the response inside of a string.
        String[] options = {"Yeah, I'm a senior dev", "Maybe?", "I'm not that smart."};
        JOptionPane.showOptionDialog(null, "Do you even code?",
                "Question",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,options, null);



    }
}