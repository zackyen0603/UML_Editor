package UML_Object;

import java.awt.*;

public class LineGeneralization extends BasicLine{
    public LineGeneralization(Port p1 , Port p2) {
        super(p1, p2);
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
        Point startPoint = new Point(x1,y1);
        Point endPoint = new Point(x2,y2);
        double angle = Math.atan2(endPoint.y - startPoint.y, endPoint.x - startPoint.x);
        int arrowLength = 15;
        int x1 = (int) (endPoint.x - arrowLength * Math.cos(angle - Math.PI / 6));
        int y1 = (int) (endPoint.y - arrowLength * Math.sin(angle - Math.PI / 6));
        g.drawLine(endPoint.x, endPoint.y, x1, y1);
        int x2 = (int) (endPoint.x - arrowLength * Math.cos(angle + Math.PI / 6));
        int y2 = (int) (endPoint.y - arrowLength * Math.sin(angle + Math.PI / 6));
        g.drawLine(endPoint.x, endPoint.y, x2, y2);
//        g.dispose();


    }
}
