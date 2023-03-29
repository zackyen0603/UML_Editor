package UML_Object;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Group extends BasicShape{

    List<BasicShape> shapeList = new ArrayList<BasicShape>();
    public Group(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public Group(List<BasicShape> list) {
        super(0,0,0,0);
        int boundX1 = Integer.MAX_VALUE, boundY1 = Integer.MAX_VALUE , boundX2 = Integer.MIN_VALUE , boundY2 = Integer.MIN_VALUE ;
        for(BasicShape shape:list){
            if(shape.x1<boundX1) boundX1 = shape.x1 ;
            if(shape.y1<boundY1) boundY1 = shape.y1 ;
            if(shape.x2>boundX2) boundX2 = shape.x2 ;
            if(shape.y2>boundY2) boundY2 = shape.y2 ;
            shapeList.add(shape);
        }
        this.x1 = boundX1 ; this.y1 = boundY1 ;
        this.x2 = boundX2 ; this.y2 = boundY2 ;
        this.width = x2 - x1 ;
        this.height = y2 - y1 ;
        this.objName = "Group" ;
        initPorts();


    }

    public void move(int dx , int dy){
        x1 += dx ; y1 += dy ;
        x2 += dx ; y2 += dy ;
        for(Port p :ports){
            p.move(dx,dy);
        }
        for(BasicShape shape:shapeList){
            shape.move(dx, dy);
        }
        updateDrawPoint(ports,10);
    };

    @Override
    public void draw(Graphics g) {
        if(isSelected) {
            g.drawRect(x1, y1, width, height);
            draw4Ports(g);
        }
    }
}
