import javax.swing.*;
import java.awt.*;

public class Progress extends JFrame {
    JProgressBar progress;

    Progress () {

        progress = new JProgressBar();
        progress.setValue(0);
        progress.setBounds(0, 0, 420, 50);
        progress.setStringPainted(true);

        this.add(progress);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(420, 420));
        this.setLayout(null);
        this.pack();
        this.setVisible(true);
    }

}