package UML_Object;

import java.awt.*;

public class LineAssociation extends BasicLine{
    public LineAssociation(){

    };
    public LineAssociation(Port p1 , Port p2){
        super(p1,p2);
    };

    @Override
    public void draw(Graphics g) {
        System.out.println("assoPaint: "+x1+"/"+y1+"/"+x2+"/"+y2);
        g.drawLine(x1, y1, x2, y2);
    }
}
