package UML_Object;

import java.awt.*;

public abstract class BasicLine extends BasicOBJ{

    Port[] connectedPort = null ;

    public BasicLine(){}
    public BasicLine(int x1 ,int y1, int x2 , int y2){
        this.x1 = x1 ; this.y1 = y1 ;
        this.x2 = x2 ; this.y2 = y2 ;
    }

    public void setLine(Port p1,Port p2){
        connectedPort = new Port[]{p1,p2};
        this.x1 = p1.x1 ; this.y1 = p1.y1 ;
        this.x2 = p2.x2 ; this.y2 = p2.y2 ;
    }

    public void show(Graphics g){
        System.out.println("SHOW");
        g.setColor(Color.red);
        this.draw(g);
        g.setColor(Color.white);

    }

    @Override
    public abstract void draw(Graphics g);
}
