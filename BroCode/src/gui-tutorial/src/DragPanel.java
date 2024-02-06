import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DragPanel extends JPanel {

    ImageIcon image = new ImageIcon("/home/isla-jr/Pictures/smiley.jpg");
    final int HEIGHT = image.getIconHeight();
    final int WIDTH = image.getIconWidth();
    Point imageCorner;
    Point prevPoint;

    DragPanel() {
        this.setBackground(Color.black);
        imageCorner = new Point(0, 0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();

        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
    }

    public void paintComponent(Graphics graphic) {
        // re-paints the image after the position is updated.
        super.paintComponent(graphic);
        image.paintIcon(this, graphic, (int)imageCorner.getX(), (int)imageCorner.getY());
    }

    private class ClickListener extends MouseAdapter {

        public void mousePressed(MouseEvent mouseEvent) {
            prevPoint = mouseEvent.getPoint();
        }
    }

    private class DragListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent mouseEvent) {
            Point currentPoint = mouseEvent.getPoint();
            imageCorner.translate((int)(currentPoint.getX() - prevPoint.getX()), (int)(currentPoint.getY() - prevPoint.getY()));
            prevPoint = currentPoint;
            repaint();
        }
    }
}