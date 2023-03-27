package UML_Object;

import java.awt.*;

public class ShapeUseCase extends BasicShape{
    public ShapeUseCase(int x, int y){
        super(x,y,150,100);
        objName = "Use Case Name" ;

    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(x1, y1, width, height);

        // find the width for the specified string.
        int stringWidth = g.getFontMetrics(font).stringWidth(objName);
        double empty = (Math.abs(x1-x2) - stringWidth)/2;
        g.setFont(font);
        g.drawString(objName, x1 + (int)empty, y1 + 50);

    }
}
