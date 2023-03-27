package UML_Editor;

import UML_Mode.*;
import UML_Object.BasicShape;
import UML_Object.ShapeClass;
import UML_Object.ShapeUseCase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

//enum ModeNow{Select,Associate,Generalize,Compose,Class,UseCase}
public class Canvas extends JPanel implements MouseListener, MouseMotionListener {
    public Mode modeNow = null ;
    public List<BasicShape> shapes = new ArrayList<BasicShape>() ;
    private static Canvas instance = null; // for singleton

    private EventListener listener = null;

    //dragLock用來處理拖曳更新
    private boolean dragLock = true ;
    private int mouse_start_x , mouse_start_y ;
    private int move_x , move_y ;
    /* Singleton design pattern */
    private Canvas() {
        // Exists only to defeat instantiation.
//        this.setBackground(Color.white);
        System.out.println("Canvas!!!");
//        addMouseListener(this);
//        addMouseMotionListener(this);
    }

    public static Canvas getInstance() {
        if (instance == null) {
            instance = new Canvas();
        }
        return instance;
    }

    public void addShape(BasicShape shape){
        if(shape==null) return;
        if(shape.objName.equals("Class Name")||shape.objName.equals("Use Case Name")){
            shapes.add(shape);
        }
        else {
            System.out.println(shape.objName+"cannot be add to ShapeList");
        }
    }

    public void setModeNow(String modeNow){
        System.out.println("IsSetting: " + modeNow );
        if(modeNow.equals("select")){
            this.modeNow = new SelectMode("select");
        }
        if(modeNow.equals("class")||modeNow.equals("usecase")){
            this.modeNow = new CreateShapeMode(modeNow);
        }
        if(modeNow.equals("associate")||modeNow.equals("composite")||modeNow.equals("general")){
            this.modeNow = new CreateLineMode(modeNow);
        }
        this.modeNow.strModeType = modeNow ;

        removeMouseListener((MouseListener) listener);
        removeMouseMotionListener((MouseMotionListener) listener);
        listener = this.modeNow;
        addMouseListener((MouseListener) listener);
        addMouseMotionListener((MouseMotionListener) listener);
    }



    public void setDragPoint(int x1,int y1,int x2 , int y2){
        mouse_start_x = x1 ;
        mouse_start_y = y1 ;
        move_x = x2 ;
        move_y = y2 ;
    }
//    1:fill/0:clear
    public void draggingPaint(Graphics g,Color color,int option){
        System.out.println("Entered!!!!!!!");
        g.setColor(color);
        int originX = Math.min(mouse_start_x,move_x);
        int originY = Math.min(mouse_start_y,move_y);
        int h = Math.abs(mouse_start_y-move_y) ;
        int w = Math.abs(mouse_start_x-move_x) ;
        if(option!=0) g.fillRect( originX, originY , w, h );
        else g.clearRect( originX, originY , w, h );

    }
   public void reverseDragLock(){
        this.dragLock = ! dragLock ;
   }

    @Override
    public void paint(Graphics g) {
//        super.paint(g);


        /* set canvas area */
        Dimension dim = getSize();
        /*設定背景*/
        g.setColor(new Color(35, 37, 37));
        g.fillRect(0, 0, dim.width, dim.height);
        /* set painting color */
        g.setColor(Color.white);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1));

        System.out.println("test:"+modeNow.strModeType);
        if(modeNow.strModeType.equals("select")) {

            draggingPaint(g, new Color(30, 255, 255, 60), 1);
            if (!dragLock) {
                draggingPaint(g, new Color(35, 37, 37), 1);
                reverseDragLock();
            }
        }
        System.out.println("Shape個數："+shapes.size());
        //對每個shape做事
        if(shapes!=null){
            for(BasicShape s:shapes){
                if(s==null) continue;
                s.draw(g);
                System.out.println(s.objName+"("+s.getX1()+","+s.getY1()+")");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        Graphics g =getGraphics();
//        g.setColor(Color.red);
//        g.fillOval(e.getX(),e.getY(),2,2);
        //繪製所有圖形
        System.out.println("ClickedPoint:("+e.getX()+','+e.getY()+")");
//        this.addShape(new ShapeUseCase(e.getX(),e.getY()));
//        this.repaint();

        this.mouse_start_x = e.getX() ;
        this.mouse_start_y = e.getY() ;
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        Graphics g =getGraphics();
//        g.setColor(Color.red);
//        g.fillOval(e.getX(),e.getY(),2,2);

//        System.out.println("PointDragging:("+e.getX()+','+e.getY()+")");
        this.mouse_start_x = e.getX() ;
        this.mouse_start_y = e.getY() ;

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        dragLock = !dragLock ;
        Graphics g =getGraphics();
//        g.clearRect();

        int originX = Math.min(mouse_start_x,move_x);
        int originY = Math.min(mouse_start_y,move_y);
        int h = Math.abs(mouse_start_y-move_y) ;
        int w = Math.abs(mouse_start_x-move_x) ;
//        g.fillOval(e.getX(),e.getY(),2,2);
//        System.out.println("PointEXIT:("+e.getX()+','+e.getY()+")");
        //繪製所有圖形
        System.out.println("EEEEEEPoint:("+e.getX()+','+e.getY()+")-> "+this.modeNow.strModeType);
        ObjectFactory factory = new ObjectFactory();
        if(this.modeNow.strModeType.equals("class")||
           this.modeNow.strModeType.equals("usecase")){
            this.addShape(factory.createShape(this.modeNow.strModeType,e.getPoint()));
        }


        this.repaint();


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
//        g.fillOval(e.getX(),e.getY(),2,2);
//        System.out.println("Dragging+++PointEXIT:()");
        move_x = e.getX() ;
        move_y = e.getY() ;
//        draggingPaint(g,e.getPoint());
//        this.repaint();
        if (this.modeNow.strModeType.equals("select")) {
            System.out.println("eeeeeee");
            repaint();
        }
//        repaint();


    }

    @Override
    public void mouseMoved(MouseEvent e) {


//        System.out.println("DragFFFFging+++PointEXIT:()");

    }




}
