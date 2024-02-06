import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

public class DragPanel extends JPanel {

    final int width = 100;
    final int height = 100;

    DragPanel() {
        this.setBackground(Color.black);
    }

    private class ClickListener extends MouseAdapter {

    }

    private class DragListener extends MouseMotionAdapter {

    }
}