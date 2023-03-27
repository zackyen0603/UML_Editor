package UML_Object;

import java.awt.*;

public abstract class BasicShape extends BasicOBJ{

    protected Font font = new Font(Font.MONOSPACED, Font.BOLD, 14);
    protected int width ,height ;
    public String objName ;

    public BasicShape(int x , int y ,int width, int height){
        this.x1 = x ;
        this.y1 = y ;
        this.width = width ;
        this.height = height ;
        this.x2 = this.x1 + this.width;
        this.y2 = this.y1 + this.height;
    };

    //回傳0代表此點不在範圍中，1:北,2:西,3:東,4:南
    public boolean pointInside(BasicShape shape ,Point p){
        int mid_x = ( shape.x1 + shape.x2 ) / 2 ;
        int mid_y = ( shape.y1 + shape.y2 ) / 2 ;
        if( shape.x1<p.x&&shape.x2>p.x&&shape.y1<p.y&&p.y<shape.y2 ){
            return true ;
        }
        else {
            return false;
        }
    }

    @Override
    public abstract void draw(Graphics g) ;
}
