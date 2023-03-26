package UML_Object;

public abstract class BasicShape extends BasicOBJ{
    protected int width ,height ;
    public String objName ;

    public BasicShape(int x , int y ,int width, int height){
        this.x1 = x ;
        this.y1 = y ;
        this.x2 = this.x1 + this.width;
        this.y2 = this.y1 + this.height;
    };
    @Override
    public void draw() {

    }
}
