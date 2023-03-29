package UML_Object;

import java.awt.*;

public class LineAssociation extends BasicLine{
    public LineAssociation(){

    };
    public LineAssociation(int x1 ,int y1, int x2 , int y2){
        super(x1, y1, x2, y2);
    };

    @Override
    public void draw(Graphics g) {
        System.out.println("assoPaint: "+x1+"/"+y1+"/"+x2+"/"+y2);
        g.drawLine(x1, y1, x2, y2);
    }
}
