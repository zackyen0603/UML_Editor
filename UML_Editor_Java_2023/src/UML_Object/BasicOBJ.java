package UML_Object;

public abstract class BasicOBJ {
    protected int x1 ,y1 ,x2 , y2 ;
    protected int depth ;
    public boolean isGrouped = false ;

    public int getX1() {
        return x1;
    }
    public int getX2() {
        return x2;
    }
    public int getY1() {
        return y1;
    }
    public int getY2() {
        return y2;
    }

    public abstract void draw();
    public void move(int x , int y){
        x2 = x2 + x1 - x ;
        y2 = y2 + y1 - y ;
        x1 = x ; y1 = y ;
        return ;
    };


}
