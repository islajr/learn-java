import javax.swing.JFrame;

public class DragFrame extends JFrame {

    DragPanel dragpanel = new DragPanel();

    DragFrame() {
        this.setTitle("Drag and Drop Demo");
        this.setSize(720, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(dragpanel);
        this.setVisible(true);
    }
}