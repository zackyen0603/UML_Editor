package UML_Mode;

import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;

public class SelectMode extends Mode{

    private int mouse_start_x , mouse_start_y ;
    private int move_x , move_y ;

    public SelectMode(String str) {
        super(str);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = canvas.getGraphics();
        g.setColor(Color.red);
        move_x = e.getX() ;
        move_y = e.getY() ;
        canvas.setDragPoint(mouse_start_x,mouse_start_y,e.getX(),e.getY());
        if (canvas.modeNow.strModeType.equals("select")) {
            canvas.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.mouse_start_x = e.getX() ;
        this.mouse_start_y = e.getY() ;
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        canvas.reverseDragLock() ;
        canvas.repaint();
    }


}
