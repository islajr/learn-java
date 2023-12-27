import javax.swing.JOptionPane;

public class GuiIntro {

    public static void main(String[] args) {
        // This is a document or class aimed at learning how to build simple gui applications in java
        String name = JOptionPane.showInputDialog("Enter your name! ");
        JOptionPane.showMessageDialog(null, "Hello, " + name);

        int age = Integer.parseInt(JOptionPane.showInputDialog("How old are you? "));
        JOptionPane.showMessageDialog(null, "You are " +  age + " years old!");

        double height = Double.parseDouble(JOptionPane.showInputDialog("How tall are you? "));
        JOptionPane.showMessageDialog(null, "You are " + height + "cm tall.");
    }
    
}

/* NOTES
 * USING THE JOPTIONPANE CLASS
 * this can be found in the javax.swing package and it has to be imported.
 * the JOptionPane class is used to develop gui applications
 *
 * A simple gui application can be developed with the .showInputDialog method of the JOptionPane class.
 * this typically takes in a message  and returns a string.
 * In cases where the .showInputDialog is to be used to take in an integer type, the Integer.parseInt method should be used to convert such an integer into a string actionable on by the method.
 * This method is called Integer Parsing
 * This is also possible with Doubles and other primitive datatypes.
 * 
 * to display a message in a gui dialog box, the .showMessageDialog method is used.
 * this takes in two arguments: null and the message to be displayed.
 * 
 * 
 * 
 *
 * */
