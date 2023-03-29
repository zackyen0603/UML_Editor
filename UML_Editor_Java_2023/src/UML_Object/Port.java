package UML_Object;

import java.awt.*;

public class Port extends BasicShape{

    private int draw_x , draw_y ;

    public Port(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void setDrawPoint(int x, int y){
        this.draw_x = this.x1 + x ;
        this.draw_y = this.y1 + y ;

    }


    public void move(int x , int y){
        x2 += x ; y2 += y ;
        x1 += x ; y1 += y ;
    };

    public double pointDistance(Point p){
        int xDifferent = Math.abs(x1-p.x) ;
        int yDifferent = Math.abs(y1-p.y) ;
        return Math.sqrt(xDifferent*xDifferent+yDifferent*yDifferent) ;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(draw_x,draw_y,width,height);
        g.setColor(Color.WHITE);
        g.fillRect(draw_x,draw_y,width,height);
        g.setColor(Color.BLUE);
    }
}
