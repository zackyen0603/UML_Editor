package UML_Object;

import java.awt.*;

public abstract class BasicShape extends BasicOBJ{


    public  boolean isGroupObject = false ;
    protected Font font = new Font(Font.MONOSPACED, Font.BOLD, 14);
    public int width ,height ;
    public String objName ;

    Port[] ports = null ;

    public BasicShape(int x , int y ,int width, int height){
        this.x1 = x ;
        this.y1 = y ;
        this.width = width ;
        this.height = height ;
        this.x2 = this.x1 + this.width;
        this.y2 = this.y1 + this.height;
//        this.initPorts();
    }

    public void move(int dx , int dy){
        x1 += dx ; y1 += dy ;
        x2 += dx ; y2 += dy ;
        for(Port p :ports){
            p.move(dx,dy);
        }
        updateDrawPoint(ports,10);
    }

    protected void initPorts(){
        int squareSize = 10 ;
        int middle_x = (x1 + x2) / 2 ;
        int middle_y = (y1 + y2) / 2 ;

        //North:0 ,West:1 ,East:2 , South:3
        Port northPort  = new Port(middle_x,y1,squareSize,squareSize);
        Port westPort   = new Port(x1,middle_y,squareSize,squareSize);
        Port eastPort   = new Port(x2,middle_y,squareSize,squareSize);
        Port southPort  = new Port(middle_x,y2,squareSize,squareSize);
        ports = new Port[]{northPort,westPort,eastPort,southPort} ;
        updateDrawPoint(ports,squareSize);
    }
    public void updateDrawPoint(Port[] ports,int squareSize){
        ports[0].setDrawPoint(-squareSize/2,-squareSize);
        ports[1].setDrawPoint(-squareSize,-squareSize/2);
        ports[2].setDrawPoint(0,-squareSize/2);
        ports[3].setDrawPoint(-squareSize/2,0);

    }

    protected void draw4Ports(Graphics g){
        for(Port p:ports){
            p.draw(g);
        }
    }

    public Port nearestPort(Point p){
        Port retPort = null ;
        double nearestDist = Double.MAX_VALUE ;
        for(Port port:ports){
            if(port.pointDistance(p)<nearestDist){
                nearestDist = port.pointDistance(p);
                retPort = port ;
            }
        }
        return retPort ;
    }

    //回傳0代表此點不在範圍中，1:北,2:西,3:東,4:南
    public boolean pointInside(Point p){
        return ( p.x >= this.x1 && p.x <= this.x2  &&
                 p.y >= this.y1 && p.y <= this.y2  );
    }

    @Override
    public abstract void draw(Graphics g) ;
}
