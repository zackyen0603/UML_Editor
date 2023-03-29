package UML_Object;

import java.awt.*;

public abstract class BasicOBJ {
    public int x1 ,y1 ,x2 , y2 ;
    public int depth ;
    public boolean isGrouped = false ;
    public boolean isSelected = false ;

    public int getX1() {
        return x1;
    }
    public int getX2() {
        return x2;
    }
    public int getY1() {
        return y1;
    }
    public int getY2() {
        return y2;
    }

    public abstract void draw(Graphics g);
    public void move(int x , int y){
        x2 = x2 + x ;
        y2 = y2 + y ;
        x1 += x ; y1 += y ;
        return ;
    };

    public void updateDepth(int depth){
        this.depth = depth ;
    }


}
