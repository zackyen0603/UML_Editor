package UML_Object;

import java.awt.*;

public class ShapeClass extends BasicShape{

    public ShapeClass(int x, int y){
        super(x,y,100,150);
        this.objName = "Class Name" ;

    }


    @Override
    public void draw(Graphics g){
        //在畫布中有無被選中
        if(isSelected) {
            g.setColor(Color.blue);
            draw4Ports(g,10);
        }
        else{
            g.setColor(Color.white);
        }
        g.drawRect(x1, y1, width, height);
//        System.out.println("W/D:"+width+"/"+height);

        int portion = height ;
        //class name
        g.drawLine(x1, y1 + portion/4, x2, y1 + portion/4);
        g.drawLine(x1, y1 + portion/4 + 3*portion/8 , x2, y1 + portion/4 + 3*portion/8);

        // find the width for the specified string.
        int stringWidth = g.getFontMetrics(font).stringWidth(objName);
        double empty = (Math.abs(x1-x2) - stringWidth)/2;
        g.setFont(font);
        g.drawString(objName, x1 + (int)empty, y1 + 25);
//        System.out.println("ssssss");
    }
}
