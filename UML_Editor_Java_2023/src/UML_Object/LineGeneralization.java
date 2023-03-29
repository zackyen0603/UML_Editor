package UML_Object;

import java.awt.*;

public class LineGeneralization extends BasicLine{
    public LineGeneralization(Port p1 , Port p2) {
        super(p1, p2);
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(this.x1, this.y1, this.x2, this.y2);

        int x1 = this.x1;
        int y1 = this.y1;
        int x2 = this.x2;
        int y2 = this.y2;
        int dx = x2 - x1;
        int dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
//        int len = (int) Math.sqrt(dx*dx + dy*dy);

        int triangleWidth = 15;
        int triangleHeight = 15;

        Polygon triangle = new Polygon();
        triangle.addPoint(x2, y2 );
        triangle.addPoint((int)(x2 - triangleWidth * Math.cos(angle - Math.PI/4)), (int)(y2 - triangleHeight * Math.sin(angle - Math.PI/4)));
        triangle.addPoint((int)(x2 - triangleWidth * Math.cos(angle + Math.PI/4)), (int)(y2 - triangleHeight * Math.sin(angle + Math.PI/4)));

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.fill(triangle);

    }
}
