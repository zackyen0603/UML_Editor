package UML_Mode;

import UML_Object.BasicOBJ;
import UML_Object.BasicShape;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class SelectMode extends BaseMode {

    private int mouse_start_x , mouse_start_y ;
    private int mouse_end_x , mouse_end_y ;
    private boolean hasSelected = false ;
    private BasicShape movingNow = null ;
    public List<BasicShape> selectedItem = new ArrayList<BasicShape>();
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
        selectedItem.clear();
        //單選or複選選擇
        int selectedCount = 0 ;
        for (BasicShape selectedShape : canvas.shapes) {
            if(selectedShape.isSelected){
                selectedCount += 1 ;
            }
        }
        System.out.println("Selected Item Count:"+selectedCount);


        //移動點選的形狀
        if(movingNow!=null){
            movingNow.move(e.getX()-mouse_end_x, e.getY()-mouse_end_y);
            canvas.repaint();
        }

        mouse_end_x = e.getX() ;
        mouse_end_y = e.getY() ;
//        Graphics g = canvas.getGraphics();
//        g.setColor(Color.red);
//        move_x = e.getX() ;
//        move_y = e.getY() ;
        System.out.println("Mouse: "+e.getX()+","+e.getY());

        if(!hasSelected) {
            //建立選取範圍
            canvas.setDragPoint(mouse_start_x, mouse_start_y, e.getX(), e.getY());
            this.selectRangeCalculator(mouse_start_x, mouse_start_y, e.getX(), e.getY());
            //更新畫布
            if (canvas.modeNow.strModeType.equals("select")) {
                canvas.repaint();
            }
            //檢查選取區域交集
            for (BasicShape s : canvas.shapes) {
                boolean isIntersected = intersect(selectRange, s.getX1(), s.getY1(), s.width, s.height);
                System.out.println("\t" + s.objName + ": " + isIntersected + " Depth: " + s.depth);
                System.out.println("\t{" + s.getX1() + "," + s.getY1() + "} " + s.width + s.height + "/" + s.getX2() + s.getY2());
                if (isIntersected) {
                    s.isSelected = true;
                } else {
                    s.isSelected = false;
                }
            }
        }
        else{
            canvas.reverseDragLock();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.mouse_start_x = e.getX() ;
        this.mouse_start_y = e.getY() ;
        this.mouse_end_x   = e.getX() ;
        this.mouse_end_y   = e.getY() ;

        canvas.singleSelectedShape = null ;
        for(BasicShape selectedShape:canvas.shapes){
            selectedShape.isSelected = false ;
            if(selectedShape.pointInside(new Point(e.getX(),e.getY()))){
                this.movingNow = selectedShape ;
                hasSelected = true ;
            }
        }
        if(movingNow!=null){
            movingNow.isSelected = true ;
        }
        canvas.repaint();

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        movingNow = null ;
        this.mouse_end_x   = e.getX() ;
        this.mouse_end_y   = e.getY() ;
        canvas.reverseDragLock() ;
        canvas.repaint();
        hasSelected = false ;

        for (BasicShape selectedShape : canvas.shapes) {
            if(selectedShape.isSelected){
                selectedItem.add(selectedShape);
            }
        }
        if(selectedItem.size()==1){

            canvas.singleSelectedShape = selectedItem.get(0) ;
        }

        System.out.println("RTETETETETET:"+selectedItem.size());
    }


}
