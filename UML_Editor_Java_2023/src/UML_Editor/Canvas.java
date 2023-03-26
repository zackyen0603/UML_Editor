package UML_Editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

//enum ModeNow{Select,Associate,Generalize,Compose,Class,UseCase}
public class Canvas extends JPanel implements MouseListener, MouseMotionListener {
    public String modeNow ;
    private static Canvas instance = null; // for singleton

    /* Singleton design pattern */
    private Canvas() {
        // Exists only to defeat instantiation.
        this.setBackground(Color.white);
        System.out.println("Canvas!!!");
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public static Canvas getInstance() {
        if (instance == null) {
            instance = new Canvas();
        }
        return instance;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Graphics g =getGraphics();
        g.setColor(Color.red);
        g.fillOval(e.getX(),e.getY(),20,20);
        System.out.println("Point:("+e.getX()+','+e.getY()+")");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Graphics g =getGraphics();
        g.setColor(Color.red);
        g.fillOval(e.getX(),e.getY(),20,20);

        System.out.println("PointDragging:("+e.getX()+','+e.getY()+")");

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        Graphics g =getGraphics();
        g.setColor(Color.red);
        g.fillOval(e.getX(),e.getY(),20,20);
        System.out.println("PointEXIT:("+e.getX()+','+e.getY()+")");

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g =getGraphics();
        g.setColor(Color.red);
        g.fillOval(e.getX(),e.getY(),20,20);
        System.out.println("Dragging+++PointEXIT:()");


    }

    @Override
    public void mouseMoved(MouseEvent e) {


        System.out.println("DragFFFFging+++PointEXIT:()");

    }




}
