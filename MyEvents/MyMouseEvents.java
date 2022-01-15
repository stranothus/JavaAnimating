package MyEvents;
import java.awt.event.*;
import javax.swing.JComponent;
import java.awt.*;

public class MyMouseEvents extends JComponent implements MouseListener {
    static Boolean mouseIn = false;

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {
        mouseIn = true;
    }
    @Override
    public void mouseExited(MouseEvent e) {
        Rectangle r = e.getComponent().getBounds();
        Point p = e.getPoint();

        if (p.x < 5 || p.x >= r.width - 5 ||  p.y < 5 || p.y >= r.height - 5) {
            mouseIn = false;
        }
    }
}