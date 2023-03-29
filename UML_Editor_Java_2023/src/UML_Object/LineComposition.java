package UML_Object;

import java.awt.*;

public class LineComposition extends BasicLine{
    public LineComposition(Port p1 , Port p2) {
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
        int len = (int) Math.sqrt(dx*dx + dy*dy);

        int diamondWidth = 15;
        int diamondHeight = 15;

        Polygon diamond = new Polygon();
        diamond.addPoint(x2, y2 );
        diamond.addPoint((int)(x2 - diamondWidth * Math.cos(angle - Math.PI/4)), (int)(y2 - diamondHeight * Math.sin(angle - Math.PI/4)));
        diamond.addPoint(x2 - (int)(23* Math.cos(angle)), y2- (int)(23* Math.sin(angle)));
        diamond.addPoint((int)(x2 - diamondWidth * Math.cos(angle + Math.PI/4)), (int)(y2 - diamondHeight * Math.sin(angle + Math.PI/4)));

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.draw(diamond);
    }
}
