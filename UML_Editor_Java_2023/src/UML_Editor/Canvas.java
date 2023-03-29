package UML_Editor;

import UML_Mode.*;
import UML_Object.BasicLine;
import UML_Object.BasicShape;
import UML_Object.Group;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class Canvas extends JPanel {
    public BaseMode modeNow = null ;
    public List<BasicShape> shapes = new ArrayList<>() ;
    public List<BasicLine> lines = new ArrayList<>() ;
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
                break;
            }
        }
        repaint();

    }

    public void setModeNow(String modeNow){
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
            g.setColor(color);
        }
        else g.clearRect( originX, originY , w, h );
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
            tempLine.show(g);
        }
        //對每個shape做事
        if(shapes.size()!=0){
            for(BasicShape s:shapes){
                s.draw(g);
            }
        }
        if(lines.size()!=0){
            for (BasicLine line:lines){
                line.show(g);
            }
        }
    }
}
