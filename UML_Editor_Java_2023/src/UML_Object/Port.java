package UML_Object;

import java.awt.*;

public class Port extends BasicShape{

    private int draw_x , draw_y ;

    public Port(int x, int y, int width, int height) {
        super(x, y, width, height);
//        super.initPorts();
    }

    public void setDrawPoint(int x, int y){
        this.draw_x = this.x1 + x ;
        this.draw_y = this.y1 + y ;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(draw_x,draw_y,width,height);
        g.setColor(Color.WHITE);
        g.fillRect(draw_x,draw_y,width,height);
        g.setColor(Color.BLUE);
    }
}
