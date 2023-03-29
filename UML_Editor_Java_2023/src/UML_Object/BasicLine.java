package UML_Object;

import java.awt.*;

public abstract class BasicLine extends BasicOBJ{

    Port[] connectedPort = null ;

    public BasicLine(){}
    public BasicLine(Port p1 , Port p2){
        this.x1 = p1.x1 ; this.y1 = p1.y1 ;
        this.x2 = p2.x1 ; this.y2 = p2.y1 ;
        connectedPort = new Port[]{p1,p2};
    }

    public void setLine(Port p1,Port p2){
        connectedPort = new Port[]{p1,p2};
        this.x1 = p1.x1 ; this.y1 = p1.y1 ;
        this.x2 = p2.x2 ; this.y2 = p2.y2 ;
    }

    private void updateLinePosition(){
        this.x1 = connectedPort[0].x1 ; this.y1 = connectedPort[0].y1 ;
        this.x2 = connectedPort[1].x1 ; this.y2 = connectedPort[1].y1 ;

    }

    public void show(Graphics g){
        updateLinePosition();
        g.setColor(Color.white);
        this.draw(g);
        g.setColor(Color.white);


    }

    @Override
    public abstract void draw(Graphics g);
}
