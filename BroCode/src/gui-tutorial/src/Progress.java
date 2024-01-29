import javax.swing.*;
import java.awt.*;

public class Progress extends JFrame {
    JProgressBar progress;

    Progress () {

        progress = new JProgressBar(0, 100);
//        progress.setValue(0);
        progress.setBounds(0, 0, 420, 50);
        progress.setStringPainted(true);
        progress.setFont(new Font("SF Display Pro", Font.BOLD, 16));
        progress.setForeground(Color.BLACK);
        progress.setBackground(Color.WHITE);

        this.add(progress);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(420, 420));
        this.setLayout(null);
        this.pack();
        this.setVisible(true);

        fill();
    }

    private void fill () {
        for (int i = 100; i >= 0; i-=10) {
            progress.setValue(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        progress.setString("Dead!");
    }

}