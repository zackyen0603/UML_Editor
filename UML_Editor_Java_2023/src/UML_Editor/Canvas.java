package UML_Editor;

import UML_Mode.*;
import UML_Object.BasicLine;
import UML_Object.BasicShape;
import UML_Object.Group;

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
    public BaseMode modeNow = null ;
    public List<BasicShape> shapes = new ArrayList<BasicShape>() ;
    public List<BasicLine> lines = new ArrayList<BasicLine>() ;
    private static Canvas instance = null; // for singleton

    private EventListener listener = null;

    public BasicLine tempLine = null ;

    public BasicShape singleSelectedShape = null ;


    //dragLock用來處理拖曳更新
    private boolean dragLock = true ;
    private int mouse_start_x , mouse_start_y ;
    private int move_x , move_y ;
    /* Singleton design pattern */
    private Canvas() {
        // Exists only to defeat instantiation.
//        this.setBackground(Color.white);
        System.out.println("Canvas!!!");
        repaint();
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

    public void addGroup(){
        List<BasicShape> ipt = new ArrayList<>();
        for(BasicShape shape:shapes){
            if(shape.isSelected){
                ipt.add(shape);
                shape.isGrouped += 1 ;
            }
        }
        shapes.add(new Group(ipt));
        this.repaint();
    }
    public void removeGroup(){
        for(BasicShape shape:shapes){
            if(shape.isSelected){
                shapes.remove(shape);
            }
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

    public void changeShapeName(String str){
        System.out.println(str);
        this.singleSelectedShape.objName = str ;
        this.repaint();
    }



    public void setDragPoint(int x1,int y1,int x2 , int y2){
        mouse_start_x = x1 ;
        mouse_start_y = y1 ;
        move_x = x2 ;
        move_y = y2 ;
    }
//    1:fill/0:clear
    public void draggingPaint(Graphics g,Color color,int option){
//        System.out.println("Entered!!!!!!!");
        g.setColor(color);
        int originX = Math.min(mouse_start_x,move_x);
        int originY = Math.min(mouse_start_y,move_y);
        int h = Math.abs(mouse_start_y-move_y) ;
        int w = Math.abs(mouse_start_x-move_x) ;
        if(option!=0) {
            g.fillRect(originX, originY, w, h);
//            g.setColor(Color.WHITE);
//            g.drawRect(originX+1, originY+1, w-2, h-2);
            g.setColor(color);
        }
        else g.clearRect( originX, originY , w, h );
    }

    public void linkingPainting(int x1,int y1,int x2,int y2,Graphics g){
//        Graphics g = this.getGraphics();
        g.setColor(Color.white);
        g.drawLine(x1,y1,x2,y2);
    }
    public void linkingPaintingDelete(int x1,int y1,int x2,int y2){
        Graphics g = this.getGraphics();
        g.setColor(new Color(35, 37, 37));
        g.drawLine(x1,y1,x2,y2);
    }

    //處理滑鼠拖曳圖形界面
   public void reverseDragLock(){
        this.dragLock = ! dragLock ;
   }

   public void update() {
        //更新所有的物件深度
        int depthCnt = shapes.size() - 1 ;
        for(BasicShape s : this.shapes ){
            s.updateDepth( depthCnt );
            depthCnt -= 1 ;
        }
   }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.update();
        /* set canvas area */
        Dimension dim = getSize();
        /*設定背景*/
        g.setColor(new Color(35, 37, 37));
        g.fillRect(0, 0, dim.width, dim.height);
        /* set painting color */
        g.setColor(Color.white);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1));

        //選擇模式的操作
        if(modeNow!=null && modeNow.strModeType.equals("select")) {
            draggingPaint(g, new Color(80,180 , 255, 60), 1);
            if (!dragLock) {
                draggingPaint(g, new Color(35, 37, 37), 1);
                reverseDragLock();
            }
        }

        if(tempLine!=null){
            System.out.println("KKKKKKKKTYHDFGHDFGHFGHJFGHJFGH");
            tempLine.show(g);
        }
//        //畫線模式的操作
//        if(modeNow!=null && (   modeNow.strModeType.equals("associate")||
//                                modeNow.strModeType.equals("composite")||
//                                modeNow.strModeType.equals("general"))
//        ) {
//            System.out.println("FFFFFFFFFF");
//            g.setColor(Color.white);
//            linkingPainting(mouse_start_x,mouse_start_y,move_x,move_y,g);
//            if (!dragLock) {
//                g.setColor(Color.white);
//                linkingPainting(mouse_start_x,mouse_start_y,move_x,move_y,g);
//                reverseDragLock();
//            }
//        }



//        System.out.println("Shape個數："+shapes.size());
        //對每個shape做事
        if(shapes.size()!=0){
            for(BasicShape s:shapes){
                s.draw(g);
//                System.out.println(s.objName+"("+s.getX1()+","+s.getY1()+")");
            }
        }
        if(lines.size()!=0){
            for (BasicLine line:lines){
                line.show(g);
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
