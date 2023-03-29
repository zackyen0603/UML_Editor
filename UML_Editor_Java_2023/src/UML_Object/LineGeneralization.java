package UML_Object;

import java.awt.*;

public class LineGeneralization extends BasicLine{
    public LineGeneralization(int x , int y){

    };

    @Override
    public void draw(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
    }
}
