package UML_Mode;

import UML_Editor.Canvas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public abstract class Mode implements MouseListener, MouseMotionListener {
    protected Canvas canvas = Canvas.getInstance();   // Canvas is singleton
    public String strModeType ;

    public Mode(String str){
        this.strModeType = str ;
    }


    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseDragged(MouseEvent e) {
    }
    public void mouseClicked(MouseEvent e) {
    }
    public void mouseMoved(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
}



