package UML_Object;

import java.awt.*;

public class ShapeUseCase extends BasicShape{
    public ShapeUseCase(int x, int y){
        super(x,y,150,100);
        objName = "Use Case Name" ;
        initPorts();

    }

    @Override
    public void draw(Graphics g) {
        //在畫布中有無被選中
        if(isSelected) {
            g.setColor(Color.darkGray);
            g.fillOval(x1, y1, width, height);
            g.setColor(Color.blue);
            draw4Ports(g);
        }
        else{
            g.setColor(Color.black);
            g.fillOval(x1, y1, width, height);
            g.setColor(Color.white);
        }
        g.drawOval(x1, y1, width, height);

        int stringWidth = g.getFontMetrics(font).stringWidth(objName);
        double empty = (float)(Math.abs(x1-x2) - stringWidth)/2;
        g.setFont(font);
        g.drawString(objName, x1 + (int)empty, y1 + 50);

    }
}
