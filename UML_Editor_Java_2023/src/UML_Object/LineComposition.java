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
        g2d.fill(diamond);

//        int h = 10 , w = 10 ;
//
//        // �T���Ϊ��I, �Ҽ{�u������
//        int dx = x2 - x1, dy = y2 - y1;
//        double D = Math.sqrt(dx*dx + dy*dy);
//        double xm = D - w, xn = xm, ym = h, yn = -h, x;
//        double sin = dy/D, cos = dx/D;
//
//        x = xm*cos - ym*sin + x1;
//        ym = xm*sin + ym*cos + y1;
//        xm = x;
//
//        x = xn*cos - yn*sin + x1;
//        yn = xn*sin + yn*cos + y1;
//        xn = x;
//
//        // ���I������X�u�W���I, �T���Ϊ��T���I�P�o���I�s�u�Y���@�ӵ٧�
//        double xq = (h*2/D)*x1 + ((D-h*2)/D)*x2;
//        double yq = (h*2/D)*y1 + ((D-h*2)/D)*y2;
//
//        int[] xPoints = {x2, (int) xm, (int) xq, (int) xn};
//        int[] yPoints = {y2, (int) ym, (int) yq, (int) yn};
//
//        g.fillPolygon(xPoints, yPoints, 4);


    }
}
