import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

public class KeyBinding {

    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;
    
    JFrame frame;
    JLabel label;
    KeyBinding() {
        frame = new JFrame("Key Binding Demo");
        label = new JLabel();
        upAction = new UpAction();
        downAction = new DownAction();
        leftAction = new LeftAction();
        rightAction = new RightAction();

        label.setBackground(Color.red);
        label.setBounds(200, 200, 100, 100);
        label.setOpaque(true);

        label.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
        label.getActionMap().put(upAction, upAction);

        label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        label.getActionMap().put(downAction, downAction);

        label.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        label.getActionMap().put(leftAction, leftAction);

        label.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        label.getActionMap().put(rightAction, rightAction);

        frame.add(label); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 720);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public class UpAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            label.setLocation(label.getX(), label.getY() - 10);
        }
    }

    public class DownAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            label.setLocation(label.getX(), label.getY() + 10);
        }
    }

    public class LeftAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            label.setLocation(label.getX() - 10, label.getY());
        }
    }

    public class RightAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            label.setLocation(label.getX() + 10, label.getY());
        }
    }
}