package UML_Mode;

import UML_Object.*;

import java.awt.*;

public class ObjectFactory implements FactoryInterface{

    @Override
    public BasicShape createShape(String shapeType, Point p) {
        if(shapeType.equals("class")){
            return new ShapeClass(p.x, p.y);
        }
        else if (shapeType.equals("usecase")) {
            return new ShapeUseCase(p.x,p.y) ;
        }
        return null;
    }

    @Override
    public BasicLine createLine(String lineType, Point p) {
        return null;
    }
}
