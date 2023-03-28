package UML_Mode;

import UML_Object.BasicShape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectMode extends BaseMode {

    private int mouse_start_x , mouse_start_y ;
//    private int move_x , move_y ;

    public SelectMode(String str) {
        super(str);
    }

    private Rectangle selectRange = null ;
    private void selectRangeCalculator(int x1 ,int y1 ,int x2 ,int y2){
        int originX = Math.min(x1,x2);
        int originY = Math.min(y1,y2);
        int h = Math.abs(y1-y2) ;
        int w = Math.abs(x1-x2) ;
        this.selectRange = new Rectangle(originX,originY,w,h);

    }

    public boolean intersect(Rectangle selectRange,int x ,int y , int width , int height) {
        //只要有碰到就算的code
//        return !(selectRange.x + selectRange.width < x || x + width < selectRange.x ||
//                selectRange.y + selectRange.height < y || y + height < selectRange.y);
        //全包住才算的code
        return  (   (selectRange.x + selectRange.width > x+width  &&  selectRange.x < x   ) &&
                (selectRange.y + selectRange.height > y+height &&  selectRange.y < y ) );
    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        Graphics g = canvas.getGraphics();
//        g.setColor(Color.red);
//        move_x = e.getX() ;
//        move_y = e.getY() ;
        System.out.println("Mouse: "+e.getX()+","+e.getY());


        canvas.setDragPoint(mouse_start_x,mouse_start_y,e.getX(),e.getY());
        this.selectRangeCalculator(mouse_start_x,mouse_start_y,e.getX(),e.getY());


        if (canvas.modeNow.strModeType.equals("select")) {
            canvas.repaint();
        }

        //檢查選取區域交集
//        System.out.println("Check Interset");
        for(BasicShape s : canvas.shapes){
            boolean isIntersected = intersect(selectRange,s.getX1(),s.getY1(),s.width,s.height) ;

//            System.out.println("\tSELECT{"+selectRange.x+","+selectRange.y+"}"+selectRange.width+selectRange.height);
            System.out.println("\t"+s.objName+": "+ isIntersected);
            System.out.println("\t{"+s.getX1()+","+s.getY1()+"} "+s.width+s.height);
            if(isIntersected){
                s.isSelected = true ;
            }
            else{
                s.isSelected = false ;
            }
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
